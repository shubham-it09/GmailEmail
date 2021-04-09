package managers;
import pageObjects.*;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import utility.*;


public class PageObjectManager {
		//Equator Code
	LoginPage loginPage;
	ControlFunctions controlFunctions;
	private WebDriver driver;
	CommonPageObjects commonPageObjects;
	Forecast forecast;
	AwardPage awardPage;
	ExcelUtilities excelUtilities;
	
	
	//This class is to initialize the page objects that will be used till whole execution
	//The purpose is to create only one reference per execution
	public PageObjectManager(WebDriver driver) {
		 this.driver = driver;
		 }

	public LoginPage loginPage(){
		 
		 return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
		 
		 }

	public ControlFunctions controlFunctions(){
		 	
		return (controlFunctions == null) ? controlFunctions = new ControlFunctions(driver) : controlFunctions;
		 
		 }
	
	public CommonPageObjects commonPageObjects()
	{
		return (commonPageObjects == null) ? commonPageObjects = new CommonPageObjects(driver) : commonPageObjects;
		 
    }

	
	public Forecast forecast()
	{
		return (forecast == null) ? forecast = new Forecast(driver) : forecast;
		 
    }
	
	public AwardPage awardPage()
	{
		return (forecast == null) ? awardPage = new AwardPage(driver) : awardPage;
		 
    }
	
	public ExcelUtilities excelUtilities()
	{
		return (excelUtilities == null) ? excelUtilities = new ExcelUtilities() : excelUtilities;
		 
    }
	//ExcelUtilities excelUtilities;
}
