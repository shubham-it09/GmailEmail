package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Forecast {
	WebElement element;
	public Forecast(WebDriver driver) {
	     PageFactory.initElements(driver, this);     
	 }
	
	
	 @FindBy(how = How.XPATH, using = "//a/div[@id='menu-logotype']")
	 public WebElement btn_Home;
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='btnSearchForecast']")
	 public WebElement btn_SearchForeCast;
	 	 
	 public WebElement dropDown_Value(String sDropDownName,String sDropDownNameValue)
	 {

		 element = btn_Home.findElement(By.xpath("//td[contains(text(),'"+sDropDownName+"')]/following::select[1]/option[contains(text(),'"+sDropDownNameValue+"')]"));
		 return element;
	 }
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='btnimport']")
	 public WebElement btn_Import;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='SubmitButtonForecastPopup']")
	 public WebElement btn_SubmitForeCast;
	 
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='ProcessAction']")
	 public WebElement btn_ProcessAction;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='SelectCustomer']")
	 public WebElement btn_SelectCustomer;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='btnUpload']")
	 public WebElement btn_ForecastUpload;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='SelectQuoteCustomer']")
	 public WebElement btn_SelectQuoteCustomer;
	 
	 //div[contains(text(),\' Forecast line(s) imported and saved successfully in
	 
	 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Forecast line(s) imported and saved successfully in')]")
	 public WebElement msg_ForecastSubmissionConfirmation;
	 
	 
	 public WebElement label_ForecastNumber(String sForeCastNumber)
	 {

		 element = btn_Home.findElement(By.xpath("//td[contains(text(),'"+sForeCastNumber+"')]"));
		 return element;
	 }
	 
}
