package utility;


import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle.Control;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.cucumber.listener.Reporter;


import cucumber.TestContext;


// This class contains all wrapper functions of selenium
public class ControlFunctions
{
	WebDriver driver;
	TestContext testContext;
	WebElement element;
	  
	public ControlFunctions(WebDriver driver) {
	this.driver = driver;
	 }
	public void click(WebElement element)
	{
		element.click();
		
	}
	
	public void Refresh()
	{
		driver.navigate().refresh();
		
		
	}
	
	public void switchToFrame(WebElement element)
	{
		//wait(element);
				driver.switchTo().frame(element);
		
	}
	
	public void switchToDefaultContent()
	{
		//wait(element);
				driver.switchTo().defaultContent();
		
	}
	
	public void doubleclick(WebElement element)
	{
		Actions actions = new Actions(driver);
		
		actions.doubleClick(element).perform();
		
	}
	public void verifyElementPresent(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	public boolean verifyElementVisiible(WebElement element)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
//	public void verifyElementNotPresent(WebElement element)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		
//		//wait.until(ExpectedConditions.visibilityOf(element));
//		if(element.getSize())
//		{
//			
//		}
//		
//	}
	public void verifyStringMatch(String text1, String text2) throws Exception
	{
		if(text1.contains(text2))
		{
			Reporter.addStepLog("url is same as expected");
		}
		else
		{
			throw new Exception("URL does not match");
		}
		
	}
	public void Entertext(WebElement element, String sText) throws InterruptedException
	{
		//wait(element);	
		element.clear();
		element.sendKeys(sText);
		//element.sendKeys(Keys.);
		Thread.sleep(3000);
		
	}
	
	public String getURL()
	{
		String url=driver.getCurrentUrl();
		
		return url;
	}
	
	public void movetoAnotherWindow()
	{
		ArrayList<String > tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
	
	public void EditTextBox(WebElement element, String sText) throws InterruptedException
	{
//		Actions action = new Actions(driver);
//		action.click(element).sendKeys(Keys.CONTROL).sendKeys("a");
		//wait(element);	
	//	element.clear();
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		element.sendKeys(sText);
		//element.sendKeys(Keys.);
		Thread.sleep(3000);
		
	}
	public void JavaScriptEntertext(WebElement element, String sText) throws InterruptedException
	{
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].value='"+sText+"';", element);
		
		Thread.sleep(3000);
		
	}
	public void SelectDataFromDropDown(WebElement element, String sText)
	{
		//wait(element);
		Select select = new Select(element);
		select.selectByVisibleText(sText);		
	}
	
	public void SelectDataFromDropDownUsingJavaScriptExecutor(WebElement element, String sText) throws InterruptedException
	{
		//wait(element);`
		Entertext(element, sText);
		Thread.sleep(10000);
		WebElement element1=driver.findElement(By.xpath("//option[contains(@value,'"+sText+"')]"));
		Thread.sleep(5000);
//		//javaScriptclick(element);
//		//click(element);
		String text = element1.getAttribute("value").toString();
		System.out.println("text is "+text);
		WebElement element2 = driver.findElement(By.xpath("//option[contains(@value,'"+text+"')]"));
		element2.click();
////		
////		Actions builder  = new Actions(driver);
////		Action seriesOfActions = (Action) builder.keyDown(Keys.chord(Keys.ENTER));
////		seriesOfActions.perform();
//		
//		//element.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
//		element2.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		//element.sendKeys(Keys.ENTER);
//		
//		//Keys.ENTER
//		System.out.println("keys are pressed");
//		Thread.sleep(15000);
//		
//		//click_mouseover(element2);
//	//		JavaScriptEntertext(element2, text);
//	//Entertext(element2, text);
//	Thread.sleep(5000);
		
	}
	public void SetDropdownValueUsingJavaScriptExecutor(WebElement element, String sValue) throws InterruptedException
	{
		//wait(element);
		//javaScriptclick(element);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].value='"+sValue+"';", element);
		Thread.sleep(2000);		
	}
	public String getText(WebElement element)
	{
		//wait(element);
		String sText;
		sText = element.getText();	
		return sText;	
	}
	public void javaScriptclick(WebElement element)
	{
		 //wait(element);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", element);
		 
	}
	
	public void EnterTextAndPressEnter(WebElement element,String sValue) throws InterruptedException
	{
		 //wait(element);
		 Entertext(element, sValue);
		 Thread.sleep(5000);
		 
		 element.sendKeys(Keys.ARROW_DOWN);
		 
		Thread.sleep(2000);
		 element.sendKeys(Keys.ENTER);	 
		 Thread.sleep(2000);
		 
	}
	
	
	public void PressESC() throws InterruptedException
	{
		
		
		Thread.sleep(2000); 
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		 
			 
	}
	
	public int RandomNumber(int number)
	{
		Random random = new Random();
		int randomNumber = random.nextInt(number);
		System.out.println("random "+randomNumber);
		return randomNumber;
	}
	public String calculateUniqueValue(String sValue)
	{
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  	  
		   String sTime = now.toString();
		   sTime = sTime.replace("-", "");
		   sTime = sTime.replace(":", "");
		   System.out.println("unique value is "+sTime); 		   
		   String[] sFinalValue = sTime.split("\\.");
		   sTime = sFinalValue[0];
		   System.out.println("values is "+sTime);
//		   for(String s : sFinalValue)
//		   {
//			   System.out.println("values is "+s);
//		   }
		   sValue = sValue +sTime;
		return sValue;
	}
	
	public void input_DropDown_SelectValue(String sLabelName,String sValue) throws InterruptedException 
	{
		System.out.println("Inside input dropdown");
		element = driver.findElement(By.xpath("//tr/td[contains(text(),'"+sLabelName+"')]/following-sibling::td/div//mat-select/div/div[@class='mat-select-arrow-wrapper']"));
		javaScriptclick(element);
		System.out.println("Dropdown arrow clicked");
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("//span[@class='mat-option-text' and text()='"+sValue+"']"));
		javaScriptclick(element);
		System.out.println("Value is selected");
		
		
	}
	
	public void UploadFile(String sFilePath, String sFileName) throws InterruptedException
	{
		Thread.sleep(1000);
		try {

			String sAutoItPath = "configs\\File Upload.exe";

			String[] run =new String[3];
			run[0] = sAutoItPath;

//			run[1]= "C:\\POC\\GDPNSPOCHappyPath\\src\\test\\UploadFiles";
//			run[2] = "test.xlsx";
			
			
			run[1]= sFilePath;
			run[2] =sFileName;
			
			System.out.println("file paths is "+run[1]);
			System.out.println("file name is "+run[2]);
			
			Runtime.getRuntime().exec(run);
			Thread.sleep(6000);

			System.out.println("in attach function");
		} catch (IOException e) {e.printStackTrace();}

		Thread.sleep(4000);
	}
	
	
	public void selectMultipleElements(List<WebElement> elements, int number) throws InterruptedException 
	{
		//List<WebElement> elements=element.fi
		
		int numberOfElements = elements.size();
		int i=1;;
			for (WebElement webElement : elements) {
				if(i<=number)
				{
					//webElement.click();
					javaScriptclick(webElement);
					System.out.println("element clicked "+i);
					i++;
				}
			}
		
		
	}
	
	
	public void click_mouseover(WebElement element) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,60);
				
		//wait.until(ExpectedConditions.element(element));
    	Thread.sleep(5000);
        mouseover(element);
        element.click();
    }

	public void mouseover(WebElement element) {
		Actions mouseover = new Actions(driver);
		mouseover.moveToElement(element).build().perform();
	}
	
	public void ClickMultipleElements(List<WebElement> elements) throws InterruptedException 
	{
		//List<WebElement> elements=element.fi
		
		int numberOfElements = elements.size();
		System.out.println("number of close are "+numberOfElements);
		int i=1;;
			for (WebElement webElement : elements) {
				try
				{
				if(i<=numberOfElements)
				{
					javaScriptclick(webElement);
					System.out.println("element clicked "+i);
					i++;
				}
				}
				catch(Exception e)
				{
					
				}
			}
		
		
	}
	
	 public void chkRole(WebElement element)
	 {
		
		List<WebElement> elements;
		
		elements = element.findElements(By.xpath("//input"));
		
		
		for (WebElement webElement : elements)
		{
			System.out.println("text is "+webElement.getText());
		}
		
	
		
	 }
	 //date format should be yyyy-mm-dd
	 public void JavaScriptEnterDate(WebElement element, String sText) throws InterruptedException
		{
			//wait(element);	
			//element.sendKeys(sText);
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].ng-reflect-model='"+sText+"';", element);
			//element.sendKeys(Keys.);
			Thread.sleep(3000);
			
			
			
		}
	 
	 
		//Send data in format yyyy-mm-dd
	/*	public void DatTimePicker(WebElement element, String sFromToDate,String sDate) throws InterruptedException
		{
			
			
			// List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
			 // Expected Date, Month and Year
			
			// boolean dateNotFound;
			 
			//CommonFunctions.driv.findElement(By.id("OfferFromDate")).click();
			//CommonFunctions.driv.findElement(By.xpath("//td/input[contains(@id,'"+sFromToDate+"')]")).click();
			click(element);
			Thread.sleep(5000);
			 String[] sSplitDate = sDate.split("-");
			 String sMonth = sSplitDate[1];
			 String sYear = sSplitDate[0];
			 String sDay = sSplitDate[2];
			 System.out.println("Monts is "+sMonth);
			 System.out.println("date  is "+sDay);
			 System.out.println("year is "+sYear);
			 switch (sMonth) {
				case "01":
					sMonth = "January";
					break;
				case "02":
					sMonth ="February";
					break;
					
				case "03":
					sMonth = "March";
					break;
					
				case "04":
					sMonth = "April";
					break;
					
				case "05":
					sMonth = "May";
					break;
					
				case "06":
					sMonth = "June";
					break;
					
				case "07":
					sMonth = "July";
					break;
					
				case "08":
					sMonth = "August";
					break;
					
				case "09":
					sMonth = "September";
					break;
					
				case "10":
					sMonth = "October";
					break;
					
				case "11":
					sMonth = "November";
					break;
					
				case "12":
					sMonth = "November";
					break;	
				default:
					break;
				}				
			 System.out.println("After switch month is :"+sMonth);
			String sAppMonth =  " ";
			
			
			String sAppYear =  " ";
			
			Thread.sleep(3000);
			 //Selection of year
			while(!(sYear.equalsIgnoreCase(sAppYear)))
			{
				//Thread.sleep(2000);
				
				sAppYear = CommonFunctions.driv.findElement(By.xpath("//div/span[contains(@class,'ui-datepicker-year')]")).getText();
				if(!(sYear.equalsIgnoreCase(sAppYear)))
				{
					CommonFunctions.driv.findElement(By.xpath("//div/a[contains(@title,'Next')]/span")).click();
									
				}
				
			}
			//Selection of month
			System.out.println("sAppYear becomes : "+sAppYear);
			while(!(sMonth.equalsIgnoreCase(sAppMonth)))
			{
				
				sAppMonth = CommonFunctions.driv.findElement(By.xpath("//div/span[contains(@class,'ui-datepicker-month')]")).getText();
				if(!(sMonth.equalsIgnoreCase(sAppMonth)))
				{
					CommonFunctions.driv.findElement(By.xpath("//div/a[contains(@title,'Next')]/span")).click();
					
				}
						
			}
			System.out.println("sAppMonth in while loop is "+sAppMonth);
			//Now click on date
			CommonFunctions.driv.findElement(By.xpath("//tr/td[contains(@data-handler,'selectDay')]/a[contains(text(),'"+sDay+"')]")).click();
			return true;
		}*/
	public void wait(WebElement element1)
	{
		try
		{
		System.out.println("inside wait");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element1));
				
		}
		catch(Exception e)
		{
			
		}		
	}
	
	public String getTodaysDate()
	{
		Format f = new SimpleDateFormat("YYYY-MM-d");
		String strDate = f.format(new Date());
		System.out.println("Current Date = "+strDate);
		
		return strDate;
	}
	
	public String getElementProperty(WebElement element, String sPropertyName)
	{
		String sProperyValue;
		
		sProperyValue = element.getAttribute(sPropertyName).toString();
		
		return sProperyValue;
	}
	
	
	public String getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
	      SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
	      System.out.println("Today's date and time = "+simpleformat.format(cal.getTime()));
	      // displaying date
	      Format f = new SimpleDateFormat("MM/dd/yy");
	      String strDate = f.format(new Date());
	      System.out.println("Current Date = "+strDate);
	      return strDate; 
	      
		
	}
	
	public String getCurrentDay()
	{
		Calendar cal = Calendar.getInstance();
	      SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
	      System.out.println("Today's date and time = "+simpleformat.format(cal.getTime()));
	      // displaying date
	      Format f = new SimpleDateFormat("MM/dd/yy");
	      String strDate = f.format(new Date());
	      System.out.println("Current Date = "+strDate);      
	      Format sDayFormat =  new SimpleDateFormat("dd");
	      String sDay = sDayFormat.format(new Date());
	      int sDay1 =  Integer.parseInt(sDay);
	     // String sDay2=""+sDay1;
//	      if(sDay1<10)
//	      {
//	    	  sDay1 = 10; 
//	      }
	      sDay = sDay1+"";
	      System.out.println("day is "+sDay );
	      return sDay;       		
	}
	
	public String getFutureDate(int month)
	{
		  Calendar cal = Calendar.getInstance();
	      SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
	      System.out.println("Today's date and time = "+simpleformat.format(cal.getTime()));
	      // displaying date
	      Format f = new SimpleDateFormat("MM/dd/yy");
	      String strDate = f.format(new Date());
	      System.out.println("Current Date = "+strDate);
	      
	      Format sMonthFormat =  new SimpleDateFormat("MM");
	      String sMonth = sMonthFormat.format(new Date());
	      System.out.println("month is "+sMonth );
	      
	      Format sYearFormat =  new SimpleDateFormat("YYYY");
	      String sYear = sYearFormat.format(new Date());
	      System.out.println("year is "+sYear );
	      int sYear1 =  Integer.parseInt(sYear);
	      
	      Format sDayFormat =  new SimpleDateFormat("dd");
	      String sDay = sDayFormat.format(new Date());
	      System.out.println("day is "+sDay );
	      int sDay1 =  Integer.parseInt(sDay);
	      
	      
	     int sMonth1 = Integer.parseInt(sMonth);
	    //sMonth1=11;
	     int sMonth2 = sMonth1;
	    //sMonth2 = 13;
	     sMonth1 = sMonth1+month;
	     System.out.println("month is "+sMonth1);
	     
	     String sFinalMonth = "";
	     if(sMonth1<10)
	     {
	    	 sFinalMonth = "0" +sMonth1;
	    	 System.out.println("month name in condition "+sFinalMonth);
	     }     
	     if(sMonth2>=10)
	     {
	    	 sYear1 = sYear1+1;
	    	 if(sMonth2==10)
	    	 {
	    		 sMonth1 = 01;
	    		 sFinalMonth =  "0" +sMonth1;
	    	 }
	    	 else if(sMonth2 ==11)
	    	 {
	    		 sMonth1 = 02; 
	    		 sFinalMonth =  "0" +sMonth1;
	    	 }
	    	 else if(sMonth2 ==12)
	    	 {
	    		 sMonth1 = 03; 
	    		 sFinalMonth =  "0" +sMonth1;
	    	 }
	    	 
	    	 else
	    	 {
	    		 sFinalMonth = "0" +sMonth1;
	    	 }
	     }
    
	  //  String sfinalDate =  sFinalMonth+"/"+sDay+"/"+sYear1; 
	    
	    String sfinalDate =  sYear1+"-"+sFinalMonth+"-"+sDay; 
	    System.out.println("final date is "+sfinalDate);
	     return sfinalDate; 
		
	}
	public String CreateRandomFile() throws IOException
	{
		String sFileName = calculateUniqueValue("test");
		String sFilePath = "C:\\POC\\CommandCenterPhase2Regression\\downloadedfiles";
		sFileName = sFileName+".txt";
		String sPath = sFilePath +"\\"+sFileName;
		try {
		File myObj = new File(sPath);
		 if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		}
		catch (IOException e) {
		      System.out.println("File not created");
		      e.printStackTrace();		}
		return sFileName;
		
	}
		
}
