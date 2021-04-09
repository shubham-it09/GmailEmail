package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObjects {
	WebElement element;
	public CommonPageObjects(WebDriver driver) {
	     PageFactory.initElements(driver, this);     
	 }
	
	 @FindBy(how = How.XPATH, using = "//label[contains(text(),'Suite')]/following-sibling::label[contains(text(),'Name')]/following-sibling::input")
	 public WebElement txtbx_SuiteName;
	 
		 
	 @FindBy(how = How.XPATH, using = "//button/i/following-sibling::span[contains(text(),'Create This Suite')]")
	 public WebElement btn_CreateNewSuite;
	 
	 @FindBy(how = How.XPATH, using = "//label[contains(text(),'Family Type')]/following-sibling::mat-select/div/div/div")
	 public WebElement drpDwn_MasterFamilyType;
	 
	 
	 public WebElement option_MasterFamilyType(String MasterFamilyType)
	 {
		 
		//mat-option/span[contains(text(),'Process')]
		 element = drpDwn_MasterFamilyType.findElement(By.xpath("//mat-option/span[contains(text(),'"+MasterFamilyType+"')]"));
		 return element;
	 }

	 
	 @FindBy(how = How.XPATH, using = "//a/div[@id='menu-logotype']")
	 public WebElement btn_Home;
	 public WebElement btn_Module(String sModuleName)
	 {

		 element = btn_Home.findElement(By.xpath("//span[contains(text(), '"+sModuleName+"')]/preceding-sibling::a/img"));
		 return element;
	 }

	 public WebElement btn_Tab(String sTabName)
	 {

		 element = btn_Home.findElement(By.xpath("//a[contains(text(),'"+sTabName+"')]"));
		 return element;
	 }
	//th[@data-title='Line #']/ancestor::tr[1]/following-sibling::tr/th/span/span/span/input[@data-text-field='Award_Line_Number']
	 
	 public WebElement txtBx_Filter(String sColumnName)
	 {
		// element =  btn_Home.findElement(By.xpath("//th[@data-title='"+sColumnName+"']"));
		 
		 element= btn_Home.findElement(By.xpath("//th[contains(@data-title,'"+sColumnName+"')]"));
		 String sAttribute = element.getAttribute("data-field");
		 
		 System.out.println("attribute value is "+sAttribute);
		 
		 element = btn_Home.findElement(By.xpath("//tr/th/span/span/span/input[@data-text-field='"+sAttribute+"']"));
		 return element;
	 }
	 
	 public WebElement label_ColumnName(String sColumnName)
	 {
		// element =  btn_Home.findElement(By.xpath("//th[@data-title='"+sColumnName+"']"));
		 
		 element= btn_Home.findElement(By.xpath("//th[contains(@data-title,'"+sColumnName+"')]"));
		 return element;
	 }
	 
	 public WebElement btn_Header(String sButtonname)
	 {

		 element = btn_Home.findElement(By.xpath("//div[contains(@class,'top-icon')]/div/a/div[contains(text(),'"+sButtonname+"')]"));
		 return element;
	 }
	 
	 
	 public WebElement dropdown_Name(String sDropDownName)
	 {

		 element = btn_Home.findElement(By.xpath("//td[contains(text(),'"+sDropDownName+"')]/following::select[1]"));
		 return element;
	 }
	 
	 public WebElement dropDown_Value(String sDropDownName,String sDropDownNameValue)
	 {

		 element = btn_Home.findElement(By.xpath("//td[contains(text(),'"+sDropDownName+"')]/following::select[1]/option[contains(text(),'"+sDropDownNameValue+"')]"));
		 return element;
	 }
	 
	 public WebElement dropdown_NamePopup(String sDropDownName)
	 {

		 element = btn_Home.findElement(By.xpath("//span[contains(text(),'"+sDropDownName+"')]/ancestor::td[1]/following-sibling::td/select"));
		 return element;
	 }
	 
	 public WebElement dropDown_ValuePopup(String sDropDownName,String sDropDownNameValue)
	 {

		 element = btn_Home.findElement(By.xpath("//span[contains(text(),'"+sDropDownName+"')]/ancestor::td[1]/following-sibling::td/select/option[contains(text(),'"+sDropDownNameValue+"')]"));
		 return element;
	 }

	 
	 @FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Ok')]")
	 public WebElement btn_Ok;
	 
}
