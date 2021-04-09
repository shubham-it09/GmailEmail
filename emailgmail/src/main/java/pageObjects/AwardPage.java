package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AwardPage {
	WebElement element;
	public AwardPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);     
	 }
	 @FindBy(how = How.XPATH, using = "//a/div[@id='menu-logotype']")
	 public WebElement btn_Home;
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='SearchAwardReq']")
	 public WebElement btn_SearchAwards;
	 	 
	 public WebElement dropDown_Value(String sDropDownName,String sDropDownNameValue)
	 {

		 element = btn_Home.findElement(By.xpath("//td[contains(text(),'"+sDropDownName+"')]/following::select[1]/option[contains(text(),'"+sDropDownNameValue+"')]"));
		 return element;
	 }
	 
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='Upload_Award']")
	 public WebElement btn_UploadAwards;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='btnUploadDGS']")
	 public WebElement btn_UploadDGSFile;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='btnUpload']")
	 public WebElement btn_UploadAwardVSTemplate;
	 
	 
	 public WebElement Message_AwardValidation(String sMessage)
	 {

		 element = btn_Home.findElement(By.xpath("//td[contains(text(),'"+sMessage+"')]"));
		 return element;
	 }	 
	 public WebElement Message_Header_Award_ValidationMessage(String sMessage)
	 {

		 element = btn_Home.findElement(By.xpath("//li[contains(text(),'"+sMessage+"')]"));
		 return element;
	 }
	 
	 @FindBy(how = How.XPATH, using = "//tr[1]/td[contains(text(),'AW000')]")
	 public WebElement btn_AwardFirstLine;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='btnAwardVSTemplateExport']")
	 public WebElement btn_VSTemplateExport;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id='SubmitButtonAwardPopup']")
	 public WebElement btn_SubmitAward;
	 
	 @FindBy(how = How.XPATH, using = "//tr[1]/td[contains(text(),'AW00')][1]")
	 public WebElement Line_FirstAwardLine;
	 
	 @FindBy(how = How.XPATH, using = "//a[@id = 'btnSupplierValidation']")
	 public WebElement btn_LaunchSupplierValidation;
	 
	 
	 public WebElement AwardID(String sAwardId)
	 {

		 element = btn_Home.findElement(By.xpath("//tr/td[contains(text(),'"+sAwardId+"')]"));
		 return element;
	 }	 
	 
}
