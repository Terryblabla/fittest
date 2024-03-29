package eu.fittest.fbk.efsm2ct.flexdrv;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import com.thoughtworks.selenium.FlashSelenium;
import com.thoughtworks.selenium.Selenium;

import eu.fittest.fbk.efsm2ct.flexdrv.logging.LoggerManager;

public class FlashApplication extends FlashSelenium {

	
	
	private static final Logger log = Logger.getLogger(LoggerManager.LOGGER);
	private static final String AUTOMATION_LOADER = "AutomationLoader";

	private Level level = Level.FINE;

	public FlashApplication(Selenium selenium) {
		super(selenium, AUTOMATION_LOADER);
		level=Level.parse(System.getProperty(FlexDriver.WARNINGLEVEL_PROPERTY, level.toString()));
	}

	public String invoke(String objectID, String method, String... args) {
		return invoke(1, 1000, objectID, method, args);
	}

	public String invoke(int tries, int delay, String objectID, String method, String... args) {

	    String testObjectResult = null ;
        String invokeResult = null ;
		
		while (tries > 0) {

			tries--;
			
			log("calling TestObject: " + objectID);
			testObjectResult = call("TestObject", objectID);
			log("result: " + testObjectResult);
			if("true".equals(testObjectResult) )
			{
				String[] arguments = new String[args.length+2];
				arguments[0] = objectID; 
				arguments[1] = method;
				System.arraycopy(args, 0, arguments, 2, args.length);
				log("invoking: " + Arrays.asList(arguments));
                invokeResult = call("InvokeAndCheck",  arguments) ;
				log("result:" + invokeResult);
                System.err.println(">> InvokeAndCheck(" +  objectID + "," + method + ",...) returns : " + invokeResult) ;
                if ("OK".equals(invokeResult)) {
                    String exc = call("GetUException") ;
                    if (exc.equals("")) {
                      // Invoke OK, and no exception thrown by handlers
                      return invokeResult ;
                    }
                    else {
                      Assert.fail("Invoke(" + objectID + "," + method + ",..) throws an exception: " + exc) ;
                    }
                   
                }
			}
			
			if (tries > 0) {
				try {
					log.log(level,"wait before retrying: " + delay);
					Thread.sleep(delay);
				} catch (InterruptedException e) { // ignore interrupts
				}
			}
		}
		// Assert.fail("Could not find object with id: "+objectID);
		log.log(level,"Could not find object with id: " + objectID + ", or it has no " + method + " event.");
        if ("false".equals(testObjectResult)) 
            throw new IllegalArgumentException("Object " 
                + objectID
                + " does not exists.") ;
                
        throw new IllegalArgumentException("Could not execute Invoke(" 
                + objectID
                + "," + method
                + ",..) : " + invokeResult) ;

	}
	
	public void savelog(String fname) {
       String log = call("LoggerGetLog", new String[0]) ;
	   // begin by urueda
	   if (log != null) {
		   System.out.println("Will save log to: " + fname);         
		   try {
			  FileWriter out = new FileWriter(fname);
			  out.write(log) ;
			  out.close() ;
		  } catch(Exception e) { System.err.println("Failed to pull the log, or to write it to a file: " + e) ; } 		
		}
		else {
			System.out.println("Test case produced null log, error?");
		}
		// end by urueda             
    }

	private void log(String msg) {
		log.fine(Thread.currentThread() + " " + msg);
	}
}
