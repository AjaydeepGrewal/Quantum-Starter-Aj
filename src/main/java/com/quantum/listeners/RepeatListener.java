package com.quantum.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.quantum.utils.DriverUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RepeatListener implements IAnnotationTransformer {

	 @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        // TODO Auto-generated method stub
		 	int repeatCount = Integer.parseInt((String) ConfigurationManager.getBundle().getProperty("driver.repeat"));
		 	annotation.setInvocationCount(repeatCount);
	    }

}
