package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hooks.Hooks;


public class DriverSetup { 
    
    private static WebDriver driver;
    
    public static WebDriver getWebDriver() {   
	
    	//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		Hooks.driver = driver;
	    return driver;

	}
}