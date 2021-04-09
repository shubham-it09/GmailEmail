package stepDefinitions;
 
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataProvider.ConfigFileReader;
import pageObjects.AwardPage;
import pageObjects.CommonPageObjects;
import pageObjects.Forecast;
import pageObjects.LoginPage;
import utility.ControlFunctions;
import utility.ExcelUtilities;
import cucumber.api.Scenario;

 
public class Hooks {
 
 static TestContext testContext;
 static ControlFunctions controlFunctions;
 static LoginPage loginPage;
 static ConfigFileReader ConfigFileReader;
 static CommonPageObjects commonPageObjects; 
 static ExcelUtilities excelUtilities;;
 static AwardPage awardPage;
 static Forecast forecastPage;
 public Hooks(TestContext context) {
 testContext = context; 
 }
 
 @Before
 public void BeforeSteps() {

	 Reporter.assignAuthor("CommandCenterRegressionPhase2 - Shubham Pandey"); 
	 
	 
	 System.out.println("inside @before method initializing all the objects");
	 controlFunctions = testContext.controlFunctions();
	 loginPage=  testContext.getPageObjectManager().loginPage();
	 ConfigFileReader= new ConfigFileReader();
	 commonPageObjects = testContext.getPageObjectManager().commonPageObjects();
	 awardPage = testContext.getPageObjectManager().awardPage();
	 excelUtilities = testContext.getPageObjectManager().excelUtilities();
	 forecastPage = testContext.getPageObjectManager().forecast();
	
 }
 @After(order = 1)
 public void afterScenario(Scenario scenario) {
	 
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	 try {
	 //This takes a screenshot from the driver at save it to the specified location
	 File sourcePath = ((TakesScreenshot) testContext.driver).getScreenshotAs(OutputType.FILE);
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 File destinationPath = new File("target\\cucumber-reports\\screenshots\\"+screenshotName +".png");
	 
	 //Copy taken screenshot from source location to destination location
	 Files.copy(sourcePath, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 	 
	 } catch (IOException e) {
	 } 
	 }
	 
 }
 @After(order = 0)
 public void AfterSteps() throws InterruptedException {
 //testContext.getWebDriverManager().closeDriver();
	 
	ExcelUtilities.deletefile("","");
 }
 
 
 
}