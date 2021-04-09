package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;

public class LoginPage {
	public WebElement element;
	public LoginPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);     
	 }
	
	
	@FindAll(@FindBy(how = How.XPATH, using = "//li[2]/a[contains(text(),'Sign in')]"))
	 public List<WebElement> btnn_SignIn;
	
	 @FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	 public WebElement btn_Next;
	  
	 @FindBy(how = How.XPATH, using = "//input[@autocomplete='username']")
	 public WebElement txtbx_UserName;
	 
	 @FindBy(how = How.XPATH, using = "//input[@aria-label='Enter your password']")
	 public WebElement txtbx_Password;
	 //Enter your password
	 
	 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Confirm your recovery email')]")
	 public WebElement link_COnfirmRecMail;
	 
	 
	
	 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Get a verification code at')]")
	 public WebElement link_getverificationcode;
	 
	 
	 //aria-label="Enter recovery email address"
	 
	 @FindBy(how = How.XPATH, using = "//input[@aria-label='Enter recovery email address']")
	 public WebElement txtbx_RecoveryEmail;
	 
	 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Compose')]")
	 public WebElement btn_Compose;
	 
	 @FindBy(how = How.XPATH, using = "//textarea[@name='to']")
	 public WebElement txtbx_ToEmail;
	
	 
	 @FindBy(how = How.XPATH, using = "//input[@aria-label='Subject']")
	 public WebElement txtbx_Subject;
	 
	
	 
	 @FindBy(how = How.XPATH, using = "//div[@aria-label='Message Body']")
	 public WebElement txtbx_MessageBody;
	 
	 
	 @FindBy(how = How.XPATH, using = "//div[text()='Send']")
	 public WebElement btn_Send;
	 
	 
	 
	 
	
	
	 
	 @FindBy(how = How.XPATH, using = "//td[contains(text(),'GBSE - EES - Team Leader')]/following-sibling::td/label/input/following-sibling::span")
	 public WebElement radio_EESTeamLeader;
	 
	 @FindBy(how = How.XPATH, using = "//div/a[contains(text(),'Logout')]")
	 public WebElement btn_LogOut;
	 
	 @FindBy(how = How.XPATH, using = "//button[contains(text(),'Advanced')]")
	 public WebElement btn_Advance;
	 
	 @FindBy(how = How.XPATH, using = "//a[contains(text(),'Proceed to sacnte')]")
	 public WebElement btn_Link;
	
}
