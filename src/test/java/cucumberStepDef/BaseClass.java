package cucumberStepDef;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;



import cucumberPageObjects.customerPageObjects;
import cucumberPageObjects.loginPageObjects;
import cucumberPageObjects.searchPageObjects;

public class BaseClass {
       
	public   WebDriver  driver;
    public    loginPageObjects lpo;
    public    customerPageObjects cpo;
    public    searchPageObjects spo;
    public static Logger logger;
    public static Properties configpro;
    
     // created for generating random string for  unique email   
    
    public static String randomstring() {
    	String generateString1= RandomStringUtils.randomAlphabetic(5);
    	return generateString1;
    }
}

