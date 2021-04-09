package managers;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DriverType;
import enums.EnvironmentType;
import dataProvider.*;


//The purpose of this class is to initialize the web driver 
public class WebDriverManager {
	private WebDriver driver;
	
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    ConfigFileReader configFileReader = new ConfigFileReader();
	public WebDriverManager() {
		driverType = configFileReader.getBrowser();
		environmentType = configFileReader.getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		driver.get(configFileReader.getApplicationUrl());
		return driver;
	}

	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME :  
//        	ChromeOptions options = new ChromeOptions();
//        	options.addArguments("incognito");
//        	String downloadFilepath = "C:\\POC\\CommandCenterPhase2Regression\\downloadedfiles";
//        	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//    		chromePrefs.put("profile.default_content_settings.popups", 0);
//    		chromePrefs.put("download.default_directory", downloadFilepath);
//    		options.setExperimentalOption("prefs", chromePrefs);
        	
        	System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
        	driver = new ChromeDriver();   	
        	//driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
		//driver.close();
		driver.quit();
	}

}
