package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import enums.GlobalData;
import pageObjects.LoginPage;
import utility.ControlFunctions;
import static stepDefinitions.Hooks.*;

import java.util.Map;

import javax.management.RuntimeErrorException;

import com.cucumber.listener.Reporter;

public class AwardPageSteps {
	
	TestContext testContext;
		
	
	//ConfigFileReader ConfigFileReader= new ConfigFileReader();
	 
	public AwardPageSteps(TestContext context) {
		 testContext = context;
		 
		
	 }
	 
	 @Then("^click on search magnifier in Award main page$")
	    public void click_on_search_magnifier_in_award_main_page() throws Throwable {
		 Thread.sleep(5000);
		 controlFunctions.click(awardPage.btn_SearchAwards);
		 Thread.sleep(5000);
	        
	    }

	    @Then("^click on upload button in Award main page$")
	    public void click_on_upload_button_in_award_main_page() throws Throwable {
	    	 Thread.sleep(5000);
	    	 try
	    	 {
			 controlFunctions.click(awardPage.btn_UploadAwards);
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 try
	    		 {
	    			 Thread.sleep(5000);
	    			 controlFunctions.javaScriptclick(awardPage.btn_UploadAwards);
	    			 
	    		 }
	    		 catch(Exception e1)
	    		 {
	    			 e1.printStackTrace();
	    		 }
	    	 }
			 Thread.sleep(5000);
	        
	    }

	    @Then("^click to upload Award or VS Template$")
	    public void click_to_upload_award_or_vs_template() throws Throwable {
	    	Thread.sleep(2000);
			 controlFunctions.click(awardPage.btn_UploadAwardVSTemplate);
			 Thread.sleep(5000);
	        
	    }

	    @Then("^Enter unique End Customer Quoted MPN in Award file$")
	    public void enter_unique_end_customer_quoted_mpn_in_award_file(DataTable userData) throws Throwable {
	    	
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	String sFilePath  =data.get("FilePath");
	    	String sFileName=data.get("FileName");
	    	String sEndCustomerQuotedMPN = controlFunctions.calculateUniqueValue("test");
	    	excelUtilities.SetTemplateFileData(sFilePath, sFileName, sEndCustomerQuotedMPN, 2, "End Customer Quoted MPN", 1, "End Customer Award Upload");
	    	//(String sFilePath,String sfileName,String sData, int sRow,String colName,int sHeaderRow, String sheetName)
	    	
	    			
	    			
	    }

	    @Then("^change column value to verify validation message$")
	    public void change_column_value_to_verify_validation_message(DataTable userData) throws Throwable {
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	String sFilePath  =data.get("FilePath");
	    	String sFileName=data.get("FileName");
	    	String	sColumnName = data.get("ColumnName");
	    	String	sColumnValue = data.get("ColumnValue");
	    	
	    	if(sColumnName.equals("DGS File Name"))
	    	{
	    		sColumnValue = (String) testContext.scenarioContext.getContext(GlobalData.DGSFileName);
	    		
	    	}
	    	
	    	excelUtilities.SetTemplateFileData(sFilePath, sFileName, sColumnValue, 2,sColumnName, 1, "End Customer Award Upload");
	       
	    }
	    
	    @Then("^verify validation message$")
	    public void verify_validation_message(DataTable userData) throws Throwable {
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	controlFunctions.verifyElementPresent(awardPage.Message_AwardValidation(data.get("ValidationMessage")));
	    	Thread.sleep(2000);     
	    }
	    
	    
	    
	    
	    @Then("^click to upload DGS File$")
	    public void verify_validation_messagethen_click_to_upload_dgs_file() throws Throwable {
	    	Thread.sleep(2000);
	    	
	    	String sDGSFileName = controlFunctions.CreateRandomFile();
	    	testContext.scenarioContext.setContext(GlobalData.DGSFileName, sDGSFileName);
			 controlFunctions.click(awardPage.btn_UploadDGSFile);
			 Thread.sleep(5000);
	        
	    }

	    @Then("^click Submit button to Submit Award$")
	    public void click_submit_button_to_submit_award() throws Throwable {
	    	Thread.sleep(10000);
	    	try
	    	{
			 controlFunctions.click(awardPage.btn_SubmitAward);
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    			Thread.sleep(10000);
	    		 controlFunctions.javaScriptclick(awardPage.btn_SubmitAward);
	    		}
	    		catch(Exception e1)
	    		{
	    			
	    			e1.printStackTrace();
	    		}
	    		
	    	}
			 Thread.sleep(5000);
	    	
	        
	    }

	    @Then("^Save and select Award ID$")
	    public void save_and_select_award_id() throws Throwable {
	    	Thread.sleep(10000);
	    	String sAwardId = controlFunctions.getText(awardPage.btn_AwardFirstLine);
	    	
	    	String sAwardId1[] = new String[2];
	    	sAwardId1 = sAwardId.split("-");
	    	String sFinalAwardID = sAwardId1[0];
	    	System.out.println("Final Award id is "+sFinalAwardID);
	    	
	    	testContext.scenarioContext.setContext(GlobalData.AwardID, sFinalAwardID);
	    	
	    	try
	    	{
			 controlFunctions.click(awardPage.btn_AwardFirstLine);
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    		 controlFunctions.javaScriptclick(awardPage.btn_AwardFirstLine);
	    		}
	    		catch(Exception e1)
	    		{
	    			
	    			e1.printStackTrace();
	    		}
	    		
	    	}
			 Thread.sleep(5000);

	        
	    }

	    @Then("^click Launch Supplier Validation$")
	    public void click_launch_supplier_validation() throws Throwable {

	    
	    	Thread.sleep(10000);
	    	try
	    	{
			 controlFunctions.click(awardPage.btn_LaunchSupplierValidation);
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    		 controlFunctions.javaScriptclick(awardPage.btn_LaunchSupplierValidation);
	    		}
	    		catch(Exception e1)
	    		{
	    			
	    			e1.printStackTrace();
	    		}
	    		
	    	}
			 Thread.sleep(5000);
	    	

	    }

	    @Then("^select first line at grid$")
	    public void select_first_line_at_grid() throws Throwable {
	    Thread.sleep(2000);
	    	try
	    	{
			 controlFunctions.click(awardPage.btn_AwardFirstLine);
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    		 controlFunctions.javaScriptclick(awardPage.btn_AwardFirstLine);
	    		}
	    		catch(Exception e1)
	    		{
	    			
	    			e1.printStackTrace();
	    		}
	    		
	    	}
			 Thread.sleep(5000);

	        
	    }

	    @Then("^click VS Template Export Button$")
	    public void click_vs_template_export_button() throws Throwable {
	    	Thread.sleep(5000);
	    	try
	    	{
			 controlFunctions.click(awardPage.btn_VSTemplateExport);
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    		 controlFunctions.javaScriptclick(awardPage.btn_VSTemplateExport);
	    		}
	    		catch(Exception e1)
	    		{
	    			
	    			e1.printStackTrace();
	    		}
	    		
	    	}
			 Thread.sleep(5000);


	        
	    }

	    @Then("^Enter award template values in VS Template$")
	    public void enter_award_template_values_in_vs_template(DataTable userData) throws Throwable {
	    	Thread.sleep(15000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	String sFilePath  =data.get("FilePath");
	    	String sFileName=data.get("FileName");
	    	int sHeaderRow =Integer.parseInt(data.get("HeaderRow"));
	    	int sRowNumber =Integer.parseInt(data.get("RowNumber"));
	    	String sSheetName = data.get("SheetName");

	    	
	    	//Manufacturer Part Number per Supplier (full MPN - Packaging Type)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "test20210319T164416", sRowNumber,"Manufacturer Part Number per Supplier (full MPN - Packaging Type)", sHeaderRow, sSheetName);
	    	
	    	
	    	//Quoted Price
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "12", sRowNumber,"Quoted Price", sHeaderRow, sSheetName);
	    	
	    	//Currency
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "INR", sRowNumber,"Currency", sHeaderRow, sSheetName);
	    	
	    	//Price Terms
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "Delivery Base", sRowNumber,"Price Terms", sHeaderRow, sSheetName);
	    	
	    	//Effective Date (YYYY-MM-DD)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "2022-05-05", sRowNumber,"Effective Date (YYYY-MM-DD)", sHeaderRow, sSheetName);
	    	
	    	//Expiration Date (YYYY-MM-DD)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "2026-05-05", sRowNumber,"Expiration Date (YYYY-MM-DD)", sHeaderRow, sSheetName);
	    	
	    	//UOM
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "ea - Each", sRowNumber,"UOM", sHeaderRow,sSheetName);
	    	
	    	
	    	//Mfg Lead time (Working Days)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "5", sRowNumber,"Mfg Lead time (Working Days)", sHeaderRow, sSheetName);
	    	
	    	//Transit Time (Working Days)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "5", sRowNumber,"Transit Time (Working Days)", sHeaderRow, sSheetName);
	    	
	    	//Total Lead Time (Working Days)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "10", sRowNumber,"Total Lead Time (Working Days)", sHeaderRow, sSheetName);
	    	
	    	
	    	//Order Quantity Multiple (OQM)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "30", sRowNumber,"Order Quantity Multiple (OQM)", sHeaderRow,sSheetName);
	    	
	    	//Order Quantity Multiple (OQM)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "90", sRowNumber,"Minimum Order Quantity (MOQ)", sHeaderRow,sSheetName);
	    	
	    	//Product Type
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "STD", sRowNumber,"Product Type", sHeaderRow,sSheetName);
	    	
	    	//Incoterm 2010
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "DAT", sRowNumber,"Incoterm 2010", sHeaderRow,sSheetName);
	    	
	    	//Named Place
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "India", sRowNumber,"Named Place", sHeaderRow, sSheetName);
	    	
	    	//Country of Origin
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "India", sRowNumber,"Country of Origin", sHeaderRow,sSheetName);
	    	
	    	
	    	//Reschedule Window (Working Days)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "10", sRowNumber,"Reschedule Window (Working Days)", sHeaderRow,sSheetName);
	    	
	    	//Cancellation Window (Working Days)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "20", sRowNumber,"Cancellation Window (Working Days)", sHeaderRow,sSheetName);
	    	
	    	//Cancellation Window (Working Days)
	    	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "2019-05-05", sRowNumber,"Date of Last Update (YYYY-MM-DD)", sHeaderRow,sSheetName);
	    	
	    	//Cancellation Window (Working Days)
	    	String sDownloadedFileName=	excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, "Bid", sRowNumber,"Status", sHeaderRow,sSheetName);
	    	
	    	testContext.scenarioContext.setContext(GlobalData.FileName,sDownloadedFileName);
	        
	    }

	    @Then("^click on Award ID Line$")
	    public void click_on_award_id_line(DataTable userData) throws Throwable {
	    	
	    	Thread.sleep(10000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	String sAwardID;
	    	
	    	sAwardID = data.get("AwardID").toString();
	    	if(sAwardID.equals(""))
	    	{
	    	 sAwardID = (String) testContext.scenarioContext.getContext(GlobalData.AwardID);
	    	 System.out.println("sAwardID is "+sAwardID);
	    	}
	    	
	    	
	    	Thread.sleep(2000);
	    	try
	    	{
			 controlFunctions.click(awardPage.AwardID(sAwardID));
	    	}
	    	catch(Exception e)
	    	{
	    		try
	    		{
	    		 controlFunctions.javaScriptclick(awardPage.AwardID(sAwardID));
	    		}
	    		catch(Exception e1)
	    		{
	    			
	    			e1.printStackTrace();
	    			throw new RuntimeException("Unable to click Award ID");
	    		}
	    		
	    	}
			 Thread.sleep(5000);
	    	
	    	
	        
	    }
	    
	    
	    
	    
	    
	    @Then("^verify header level validation message$")
	    public void verify_header_level_validation_message(DataTable userData) throws Throwable {
	    	
	    	
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	//controlFunctions.verifyElementPresent(awardPage.Message_AwardValidation(data.get("ValidationMessage")));
	    	
	    	controlFunctions.verifyElementPresent(awardPage.Message_Header_Award_ValidationMessage(data.get("ValidationMessage")));
	    	Thread.sleep(2000);
	      
	    }
	    
	    
	    @Then("^change downloaded file column value$")
	    public void change_downloaded_file_column_value(DataTable userData) throws Throwable {
	    	Thread.sleep(5000);
	    	Map<String, String> data = userData.asMap(String.class, String.class);
	    	
//	    	|FileName|VS_Template_Report|
//	    	|FilePath|C:\\POC\\CommandCenterPhase2Regression\\downloadedfiles|
//	    	|ColumnName|Encrypted Ref ID|
//	    	|ColumnValue| |
//	    	|HeaderRow|1|
//	    	|RowNumber|2|
//	    	|SheetName|Validation Sheet|
	    	
	    	String sFileName = data.get("FileName");
	    	String sFilePath = data.get("FilePath");
	    	String sColumnName = data.get("ColumnName");
	    	String sColumnValue = data.get("ColumnValue");
	    	int sHeaderRow =Integer.parseInt(data.get("HeaderRow"));
	    	int sRowNumber =Integer.parseInt(data.get("RowNumber"));
	    	String sSheetName =data.get("SheetName");
	    	
	    	if(sFileName.equals(""))
	    	{
	    		sFileName =testContext.scenarioContext.getContext(GlobalData.FileName).toString();
	    	}
	    	
	    	String sDownloadedFileName = excelUtilities.SetDatainDownloadedFIle(sFilePath, sFileName, sColumnValue, sRowNumber,sColumnName, sHeaderRow,sSheetName);
	    	
	    	testContext.scenarioContext.setContext(GlobalData.FileName, sDownloadedFileName);
	    }
	    
	    
	    
	  }
