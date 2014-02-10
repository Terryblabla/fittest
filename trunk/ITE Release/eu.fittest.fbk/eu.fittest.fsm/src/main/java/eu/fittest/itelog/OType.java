//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.10 at 12:49:09 PM CET 
//


package eu.fittest.itelog;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fd" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="O" type="{}OType"/>
 *                   &lt;element name="V" type="{}VType"/>
 *                 &lt;/choice>
 *                 &lt;attribute name="n" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ty" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OType", propOrder = {
    "fd"
})
public class OType {

    @XmlElement(required = true)
    protected List<OType.Fd> fd;
    @XmlAttribute
    protected String ty;

    /**
     * Gets the value of the fd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OType.Fd }
     * 
     * 
     */
    public List<OType.Fd> getFd() {
        if (fd == null) {
            fd = new ArrayList<OType.Fd>();
        }
        return this.fd;
    }

    /**
     * Gets the value of the ty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTy() {
        return ty;
    }

    /**
     * Sets the value of the ty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTy(String value) {
        this.ty = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="O" type="{}OType"/>
     *         &lt;element name="V" type="{}VType"/>
     *       &lt;/choice>
     *       &lt;attribute name="n" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "o",
        "v"
    })
    public static class Fd {

        @XmlElement(name = "O")
        protected OType o;
        @XmlElement(name = "V")
        protected VType v;
        @XmlAttribute
        protected String n;

        /**
         * Gets the value of the o property.
         * 
         * @return
         *     possible object is
         *     {@link OType }
         *     
         */
        public OType getO() {
            return o;
        }

        /**
         * Sets the value of the o property.
         * 
         * @param value
         *     allowed object is
         *     {@link OType }
         *     
         */
        public void setO(OType value) {
            this.o = value;
        }

        /**
         * Gets the value of the v property.
         * 
         * @return
         *     possible object is
         *     {@link VType }
         *     
         */
        public VType getV() {
            return v;
        }

        /**
         * Sets the value of the v property.
         * 
         * @param value
         *     allowed object is
         *     {@link VType }
         *     
         */
        public void setV(VType value) {
            this.v = value;
        }

        /**
         * Gets the value of the n property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getN() {
            return n;
        }

        /**
         * Sets the value of the n property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setN(String value) {
            this.n = value;
        }

    }

}
