package cucumber;

import java.awt.TextComponent;

import org.openqa.selenium.WebDriver;

import managers.PageObjectManager;
import managers.WebDriverManager;
import utility.ControlFunctions;
import utility.ExcelUtilities;


//This class have all the objects thaose are used in whole execution. This class is implemented for Pico container concept
//That means the objects which should be same for complete flow of execution
public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ControlFunctions controlFunctions;
	private ExcelUtilities excelUtilities;
	 public ScenarioContext scenarioContext;
	 public WebDriver driver;

	public TestContext(){
		webDriverManager = new WebDriverManager();
		driver =webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		controlFunctions = new ControlFunctions(driver);
		scenarioContext = new ScenarioContext();
		excelUtilities = new  ExcelUtilities();
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ControlFunctions controlFunctions() {
		return controlFunctions;
	}
	 public ScenarioContext getScenarioContext() {
		 return scenarioContext;
	 }
	 
	 public ExcelUtilities excelUtilities() {
			return excelUtilities;
		}

}
