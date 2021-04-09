package stepDefinitions;

import java.util.ArrayList;
import java.util.Map;

import javax.management.RuntimeErrorException;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import dataProvider.ConfigFileReader;
import enums.GlobalData;
import pageObjects.CommonPageObjects;
import pageObjects.Forecast;
import utility.ControlFunctions;
import static stepDefinitions.Hooks.*;

public class ForeCastPageSteps {
	TestContext testContext;


public ForeCastPageSteps(TestContext context) {
	 testContext = context;

}

@Then("^click on search magnifier in forecast main page$")
public void click_on_search_magnifier_in_forecast_main_page() throws InterruptedException {
	
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_SearchForeCast);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_SearchForeCast);
		}
		catch(Exception e1) {
		
			System.out.println("Search button not clicked");
			e1.printStackTrace();
			
		}
		
	}
	Thread.sleep(10000);    
}


@Then("^click on Import Button$")
public void click_on_import_button() throws InterruptedException {
	
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_Import);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_Import);
		}
		catch(Exception e1) {
		
			System.out.println("import button not clicked");
			e1.printStackTrace();
			
		}
		
	}
    
}  


@Then("^click CustomerBP ellipse$")
public void click_CustomerBP_ellipse() throws InterruptedException {
	
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_SelectCustomer);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_SelectCustomer);
		}
		catch(Exception e1) {
		
			System.out.println("Select customer ellipse not clicked");
			e1.printStackTrace();
			
		}
		
	}
    
}  
//click on forecast template Upload button
@Then("^click on forecast template Upload button$")
public void click_on_forecast_template_Upload_button() throws InterruptedException {
	
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_ForecastUpload);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_ForecastUpload);
		}
		catch(Exception e1) {
		
			System.out.println("Forecast template upload button not clicked");
			e1.printStackTrace();
			
		}
		
	}
    
}  
@Then("^click Select button at CustomerSelection popup$")
public void click_Select_button_at_CustomerSelection_popup() throws InterruptedException {
	
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_SelectQuoteCustomer);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_SelectQuoteCustomer);
		}
		catch(Exception e1) {
		
			System.out.println("Select button ant customer selection popup is not clicked");
			e1.printStackTrace();
			
		}
		
	}
    
}


@Then("^click on Submit Forecast button$")
public void click_on_submit_forecast_button() throws InterruptedException {
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_SubmitForeCast);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_SubmitForeCast);
		}
		catch(Exception e1) {
		
			System.out.println("Submit forecast button s not clicked");
			e1.printStackTrace();
			
		}
		
	}
	
  
}

@Then("^Save ForeCastID$")
public void save_forecastid() throws InterruptedException {
	
	
	String sAwardMessage = controlFunctions.getText(forecastPage.msg_ForecastSubmissionConfirmation);
	

			String[] sText = sAwardMessage.split(" ");

			int ilength = sText.length;

			ilength = (ilength - 1);

			String sForecastNumber = sText[ilength];

			System.out.println("Forecast number is "+ sForecastNumber);
			
			testContext.scenarioContext.setContext(GlobalData.ForeCastID, sForecastNumber);
    
}

@Then("^Search ForecastNumber using filter$")
public void Search_ForecastNumber_using_filter(DataTable userData) throws InterruptedException {
	
	Map<String, String> data = userData.asMap(String.class, String.class);
	
	
	String sForecastNumber = data.get("ForeCastNumber");
	if(sForecastNumber.equals(""))
			{
			sForecastNumber = testContext.scenarioContext.getContext(GlobalData.ForeCastID).toString();
			System.out.println("saved forecast number in global data is"+sForecastNumber);
			}
	try
	{
	controlFunctions.EnterTextAndPressEnter(commonPageObjects.txtBx_Filter("Forecast Number"), sForecastNumber);
		
	}
	catch(Exception e)
	{
		System.out.println("Forecast number is not enetered in column or could not be found");
		e.printStackTrace();
	}
	
	Thread.sleep(5000);   
}




@Then("^Select Forecast Number$")
public void Select_Foprecast_number(DataTable userData) throws InterruptedException {
	
	Map<String, String> data = userData.asMap(String.class, String.class);
	
	
	String sForecastNumber = data.get("ForeCastNumber");
	if(sForecastNumber.equals(""))
			{
			sForecastNumber = testContext.scenarioContext.getContext(GlobalData.ForeCastID).toString();
			System.out.println("saved forecast number in global data is"+sForecastNumber);
			}
	try
	{
	controlFunctions.click(forecastPage.label_ForecastNumber(sForecastNumber));
		
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.label_ForecastNumber(sForecastNumber));
		}
		
		catch(Exception e1)
		{
		System.out.println("Forecast number is not clicked");
		e.printStackTrace();
		}
	}
	
	Thread.sleep(5000);   
}

@Then("^click on Process Action button$")
public void click_on_Process_Action_button() throws InterruptedException {
	Thread.sleep(2000);
	try
	{
	controlFunctions.click(forecastPage.btn_ProcessAction);
	}
	catch(Exception e)
	{
		try
		{
			controlFunctions.javaScriptclick(forecastPage.btn_ProcessAction);
		}
		catch(Exception e1) {
		
			System.out.println("Process Action button  not clicked");
			e1.printStackTrace();
			
		}
		
	}
	
  
}

}
