package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

import pageObjects.LoginPage;
import utility.ControlFunctions;
import static stepDefinitions.Hooks.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

public class LoginPageSteps {
	
	TestContext testContext;
	WebElement element;
	 
	public LoginPageSteps(TestContext context) {
		 testContext = context;
		 
		
	 }
	
	
	 @Then("^click sigin button$")
	    public void click_sigin_button() throws InterruptedException 
	 	{	
		 Thread.sleep(10000);
		 List<WebElement> elements = loginPage.btnn_SignIn;
		 WebElement btn_SignIn = elements.get(1);
		 controlFunctions.click(btn_SignIn);

		 Thread.sleep(5000);		
		  	}
	 
	 
	 
	 @Then("^Enter UserName$")
	    public void enter_username() throws Throwable {
		 Thread.sleep(5000);
		 String sUsername =ConfigFileReader.getCredentials().get(0);
		 controlFunctions.Entertext(loginPage.txtbx_UserName, sUsername);
	        
	    }

	    @Then("^click Next button$")
	    public void click_next_button() throws Throwable {
	    	Thread.sleep(2000);
	    	try
	    	{
	    	controlFunctions.click(loginPage.btn_Next);
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    		controlFunctions.javaScriptclick(loginPage.btn_Next);
	    		}
	    		catch(Exception e1)
	    		{
	    			e1.printStackTrace();
	    		}
	    	}
	    	
	    }
	    
	    
	    
	    //Then Confirm Recovery Email
	    
	    @Then("^Confirm Recovery Email$")
	    public void Confirm_Recovery_Email() throws Throwable {
	    	Thread.sleep(5000);
	    	
	    	//String sPassword = ConfigFileReader.getCredentials().get(1);
	    	controlFunctions.click(loginPage.link_COnfirmRecMail);
	    	
	    	Thread.sleep(2000);
	    	controlFunctions.Entertext(loginPage.txtbx_RecoveryEmail, "shubham.urs@gmail.com");
	    	
	    	Thread.sleep(2000);
	    	controlFunctions.click(loginPage.link_getverificationcode);
	    	
	    	//link_getverificationcode
	    	Thread.sleep(20000);
	        
	        
	    }

	    @Then("^Enter Password$")
	    public void enter_password() throws Throwable {
	    	Thread.sleep(5000);
	    	
	    	String sPassword = ConfigFileReader.getCredentials().get(1);
	    	controlFunctions.Entertext(loginPage.txtbx_Password, sPassword);
	        
	        
	    }
	    
	    @Then("^click Compose button$")
	    public void click_compose_button() throws Throwable {
	    	Thread.sleep(20000);

	    	
	    	//String sPassword = ConfigFileReader.getCredentials().get(1);
	    	controlFunctions.click(loginPage.btn_Compose);
	    	
	        
	    }

	    @Then("^Enter To Email ID$")
	    public void enter_to_email_id(DataTable userData) throws Throwable {
Thread.sleep(5000);
Map<String, String> data = userData.asMap(String.class, String.class);
	    	
	    	controlFunctions.Entertext(loginPage.txtbx_ToEmail, data.get("Email"));
	        
	    }

	    @Then("^Enter Subject$")
	    public void enter_subject(DataTable userData) throws Throwable {
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	controlFunctions.Entertext(loginPage.txtbx_Subject, data.get("Subject"));
	    	
	    	
	        
	    }

	    @Then("^Enter Body$")
	    public void enter_body(DataTable userData) throws Throwable {
	    	
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	controlFunctions.Entertext(loginPage.txtbx_MessageBody, data.get("Message"));
	    	
	    	//txtbx_MessageBody
	        
	    }
	    
	    @Then("^click Send button$")
	    public void click_send_button() throws Throwable {
	        Thread.sleep(2000);
	        controlFunctions.click(loginPage.btn_Send);
	    }

	   
	  }
