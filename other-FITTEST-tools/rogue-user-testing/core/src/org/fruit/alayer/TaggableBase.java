/**************************************************************************************
*  Copyright (c) 2013, Universitat Politecnica de Valencia. All rights reserved.      *
*  This program and the accompanying materials are made available under the terms     *
*  of the 3-Clause BSD License which accompanies this distribution, and is available  *
*  at http://www.opensource.org/licenses/BSD-3-Clause. The research leading to these  *
*  results has received funding from the European Community`s Seventh Framework       *
*  Programme (FP7/2007-2013) under the grant agreement  FP7-257574 FITTEST.           *
**************************************************************************************/

/**
 *  @author Sebastian Bauersfeld
 */
package org.fruit.alayer;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.fruit.Assert;
import org.fruit.Util;

public class TaggableBase implements Taggable, Serializable {
	private static final long serialVersionUID = 3941511707954247582L;
	private Map<Tag<?>, Object> tagValues = Util.newHashMap();
	boolean allFetched;
	
	public final <T> T get(Tag<T> tag) throws NoSuchTagException {
		T ret = get(tag, null);
		if(ret == null)
			throw new NoSuchTagException(tag);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public final <T> T get(Tag<T> tag, T defaultValue) {
		Assert.notNull(tag);
		T ret = (T) tagValues.get(tag);
		if(ret == null && !allFetched && !tagValues.containsKey(tag)){
			ret = fetch(tag);
			tagValues.put(tag, ret);
		}
		return ret == null ? defaultValue : ret;
	}

	public final Iterable<Tag<?>> tags() {
		Set<Tag<?>> ret =new HashSet<Tag<?>>();
		
		if(!allFetched){
			for(Tag<?> t : tagDomain())
				get(t, null);
			allFetched = true;
		}
		
		for(Tag<?> t : tagValues.keySet()){
			if(tagValues.get(t) != null)
				ret.add(t);
		}
		return ret;
	}

	protected <T> T fetch(Tag<T> tag){ return null; }
	protected Set<Tag<?>> tagDomain(){ return Collections.emptySet(); }

	public <T> void set(Tag<T> tag, T value) {
		Assert.notNull(tag, value);
		Assert.isTrue(tag.type().isInstance(value), "Value not of type required by this tag!");
		tagValues.put(tag, value);
	}

	public void remove(Tag<?> tag) { tagValues.put(Assert.notNull(tag), null); }
}
