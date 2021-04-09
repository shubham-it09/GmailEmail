package stepDefinitions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import javax.management.RuntimeErrorException;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import dataProvider.ConfigFileReader;
import enums.GlobalData;
import net.bytebuddy.implementation.bytecode.Throw;
import pageObjects.CommonPageObjects;
import utility.ControlFunctions;
import static stepDefinitions.Hooks.*;

public class CommonPageSteps {
	TestContext testContext;
//	//Equator Code
//ControlFunctions controlFunctions;
//ConfigFileReader ConfigFileReader= new ConfigFileReader();
//CommonPageObjects commonPageObjects; 

public CommonPageSteps(TestContext context) {
	 testContext = context;
//	 controlFunctions = testContext.controlFunctions();
//	 commonPageObjects = testContext.getPageObjectManager().commonPageObjects();
	 
}

@Then("^click on Module$")
public void click_on_module(DataTable userData) throws InterruptedException {
	
	Thread.sleep(5000);
	
	Map<String, String> data = userData.asMap(String.class, String.class);
	try
	{
	controlFunctions.click(commonPageObjects.btn_Module(data.get("ModuleName")));
	}
	catch(Exception e)
	{
		Thread.sleep(15000);
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.btn_Module(data.get("ModuleName")));
		}
		catch(Exception e1)
		{
			System.out.println("Module  "+data.get("ModuleName")+" not clicked");
			e1.printStackTrace();
		}
		
	}
	Thread.sleep(5000);
	
	
    
}

@Then("^click on tab$")
public void click_on_tab(DataTable userData) throws InterruptedException {

	Map<String, String> data = userData.asMap(String.class, String.class);
	try
	{
	controlFunctions.click(commonPageObjects.btn_Tab(data.get("TabName")));
	}
	catch(Exception e)
	{
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.btn_Tab(data.get("TabName")));
		}
		catch (Exception e1) {
			
			
			System.out.println("module name not clicked "+data.get("TabName"));
			e1.printStackTrace();
			
		}
	}
	
	Thread.sleep(5000);  
}

@Then("^Apply Filter in column$")
public void apply_filter_in_column(DataTable userData) throws InterruptedException {
	
	Map<String, String> data = userData.asMap(String.class, String.class);
	try
	{
	controlFunctions.EnterTextAndPressEnter(commonPageObjects.txtBx_Filter(data.get("ColumnName")), data.get("DataToFilter"));
		
	}
	catch(Exception e)
	{
		System.out.println("Data is not entered in "+data.get("ColumnName"));
		e.printStackTrace();
	}
	
	Thread.sleep(5000);   
}
//Search ForecastNumber using filter





//Then Select Forecast Number


@Then("^click on buttons on header$")
public void click_on_buttons_on_header(DataTable userData) throws InterruptedException {
	Thread.sleep(10000);
	
	Map<String, String> data = userData.asMap(String.class, String.class);
	try
	{
	controlFunctions.click(commonPageObjects.btn_Header(data.get("ButtonName")));
	}
	catch(Exception e)
	{
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.btn_Header(data.get("ButtonName")));
		}
		catch(Exception e1)
		{
			
			System.out.println("Header button  "+data.get("ButtonName")+" not clicked");
			e.printStackTrace();
			//throw new RuntimeException
			
			
		}
		
	}
	Thread.sleep(5000);
   
}

@Then("^Verify column names in Grid$")
public void verify_column_names_in_grid(DataTable userData) throws InterruptedException 
{
	Thread.sleep(20000);
	Map<String, String> data = userData.asMap(String.class, String.class);
//	ArrayList<String > sDataFromApp = new ArrayList<String>();
	String []columnNameList = data.get("ColumnNames").split(":");	
	for (String sColumnName : columnNameList)
	{
		System.out.println("column name is "+sColumnName);
		controlFunctions.verifyElementPresent(commonPageObjects.label_ColumnName(sColumnName));
	}
   
}

@Then("^select values from dropdown at main grid$")
public void select_values_from_dropdown_at_main_grid(DataTable userData) throws InterruptedException
{
	
	Thread.sleep(5000);
	Map<String, String> data = userData.asMap(String.class, String.class);
	try
	{
	controlFunctions.click(commonPageObjects.dropdown_Name(data.get("DropDownName")));
	}
	catch(Exception e)
	{
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.dropdown_Name(data.get("DropDownName")));
		}
		catch(Exception e1)
		{
			System.out.println("Dropdown button  "+data.get("DropDownName")+" not clicked");
			e1.printStackTrace();
		}
		
	}
	Thread.sleep(2000);
	
	try
	{
	controlFunctions.click(commonPageObjects.dropDown_Value(data.get("DropDownName"),data.get("DropDownValue")));
	}
	catch(Exception e)
	{
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.dropDown_Value(data.get("DropDownName"),data.get("DropDownValue")));
		}
		catch(Exception e1)
		{
			
			System.out.println("Dropdown button  "+data.get("dropDown_Value")+" not selected");
			e.printStackTrace();
		
		}
		
	}
  
}


@Then("^select values from dropdown at popup$")
public void select_values_from_dropdown_at_popup(DataTable userData) throws InterruptedException {
	Thread.sleep(5000);
	Map<String, String> data = userData.asMap(String.class, String.class);
	try
	{
	controlFunctions.click(commonPageObjects.dropdown_NamePopup(data.get("DropDownName")));
	}
	catch(Exception e)
	{
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.dropdown_NamePopup(data.get("DropDownName")));
		}
		catch(Exception e1)
		{
			
			System.out.println("Dropdown button  "+data.get("DropDownName")+" not clicked");
			e.printStackTrace();
		
			
			
		}
		
	}
	Thread.sleep(4000);
	
	try
	{
	controlFunctions.click(commonPageObjects.dropDown_ValuePopup(data.get("DropDownName"),data.get("DropDownValue")));
	}
	catch(Exception e)
	{
		try
		{
		controlFunctions.javaScriptclick(commonPageObjects.dropDown_ValuePopup(data.get("DropDownName"),data.get("DropDownValue")));
		}
		catch(Exception e1)
		{
		
			
			

			System.out.println("\"Dropdown button  \"+data.get(\"dropDown_Value\")+\" not selected\"");
			e.printStackTrace();
		
		}
		
	}
}
@Then("^Upload file based on modulename$")
public void upload_file_based_on_modulename(DataTable userData) throws InterruptedException {
	
	Thread.sleep(5000);
	Map<String, String> data = userData.asMap(String.class, String.class);
	String sAutoItPath = "C:\\POC\\CommandCenterPhase2Regression\\autoitscripts\\File Upload.exe";
	String sModuleName = data.get("ModuleName");
	String sFileName = data.get("FileName");
	if(sFileName.equals(""))
	{
	System.out.println("take global file name");
	sFileName = testContext.scenarioContext.getContext(GlobalData.FileName).toString();
	System.out.println("global file name is "+sFileName);
	}	
	if(sFileName.equals("DGS"))
	{
	System.out.println("take DGS name");
	sFileName = testContext.scenarioContext.getContext(GlobalData.DGSFileName).toString();
	System.out.println("DGS name is "+sFileName);
	}
	String sFilePath = "";
	try
	{
	sModuleName = sModuleName.toLowerCase();
	if(sModuleName.equals(""))
	{
		sFilePath = data.get("FilePath");
		System.out.println("File path will be same as given" +sFilePath);
		
	}
	else
	{
		sFilePath = "C:\\POC\\CommandCenterPhase2Regression\\uploadfiles\\"+sModuleName;
	}
	String[] run =new String[3];
	run[0] = sAutoItPath;
	run[1]= sFilePath;
	run[2] = sFileName;
	Runtime.getRuntime().exec(run);
	Thread.sleep(6000);
	}
	
	catch(Exception e)
	{
		
		System.out.println("Please give module name or file path correctly " +sModuleName+" path is "+sFilePath);
		e.printStackTrace();
		
	}
	Thread.sleep(10000);
}


@Then("^cick ok button on the Popup$")
public void cick_ok_ok_button_on_the_popup() throws InterruptedException {
	
	
Thread.sleep(10000);
	
	
	try
	{
	controlFunctions.click(commonPageObjects.btn_Ok);
	}
	catch(Exception e)
	{
		Thread.sleep(15000);
		try
		{
			Thread.sleep(10000);
		controlFunctions.javaScriptclick(commonPageObjects.btn_Ok);
		}
		catch(Exception e1)
		{
			System.out.println("Ok button not clicked");
			e1.printStackTrace();
		}
		
	}
	Thread.sleep(5000);
    
}
}
