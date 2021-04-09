package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import enums.GlobalData;

public class ExcelUtilities {
	
	
	TestContext testContext;
	FileInputStream fis;
	FileOutputStream fos;
	HSSFWorkbook workbook;
	HSSFSheet sheet = null;
	Row row = null;
	Cell cell = null;
	String xlFilePath;
	ScenarioContext scenarioContext = new ScenarioContext();
	  
	public ExcelUtilities() {
		
		
	 }


	public void SetTemplateFileData(String sFilePath,String sfileName,String sData, int sRow,String colName,int sHeaderRow, String sheetName) throws IOException
	{
		XSSFWorkbook workbook;
		XSSFSheet sheet = null;
		Row row = null;
		Cell cell = null;	
		String sTempFileName;
		String sDownloadedFileName = null;		
		File folder = new File(sFilePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				sTempFileName = listOfFiles[i].getName();
				if(sTempFileName.equals(sfileName)) {
					sDownloadedFileName = sTempFileName;
					System.out.println("File name inside if "+sDownloadedFileName);
					//GlobalVariable.sFileName = sDownloadedFileName;
				}
			} else if (listOfFiles[i].isDirectory()) {
			System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

		sFilePath = sFilePath +"\\" +sDownloadedFileName;
		fis = new FileInputStream(sFilePath);
		workbook = new XSSFWorkbook(fis);
		//	sheetName="Quote Approval"
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(sHeaderRow);
		
		int col_Num = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				col_Num = i;

				System.out.println("colnum is " +i);
				System.out.println("colName "+colName);
			}
		}

		sheet.autoSizeColumn(col_Num);
		//row = sheet.getRow(rowNum - 1);
		//sRow = 10
		row = sheet.getRow(sRow);
		if(row==null)
			row = sheet.createRow(sRow - 1);

		cell = row.getCell(col_Num);
		if(cell == null)
			cell = row.createCell(col_Num);

		cell.setCellValue(sData);
		//xlFilePath = "C:\\Users\\punspand\\Desktop\\CommandCenter\\downloads\\202006125307_Offered Parts.xls"
		fos = new FileOutputStream(sFilePath);
		workbook.write(fos);
		fos.close();
	}

	
	public String SetDatainDownloadedFIle(String sFilePath,String sfileName,String sData, int sRow,String colName,int sHeaderRow, String sheetName) throws IOException, InterruptedException
	{
		
		XSSFWorkbook workbook;
		XSSFSheet sheet = null;
		Row row = null;
		Cell cell = null;	
		String sTempFileName;
		String sDownloadedFileName = null;		
		File folder = new File(sFilePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				sTempFileName = listOfFiles[i].getName();
				if(sTempFileName.contains(sfileName)) {
					sDownloadedFileName = sTempFileName;
					System.out.println("File name inside if "+sDownloadedFileName);
			
				}
			} else if (listOfFiles[i].isDirectory()) {
			System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

		sFilePath = sFilePath +"\\" +sDownloadedFileName;
		fis = new FileInputStream(sFilePath);
		workbook = new XSSFWorkbook(fis);
		//	sheetName="Quote Approval"
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(sHeaderRow);


		//sData = "Approved"
		int col_Num = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				col_Num = i;

				System.out.println("colnum is " +i);
				System.out.println("colName "+colName);
			}
		}

		sheet.autoSizeColumn(col_Num);
		//row = sheet.getRow(rowNum - 1);
		//sRow = 10
		row = sheet.getRow(sRow);
		if(row==null)
			row = sheet.createRow(sRow - 1);

		cell = row.getCell(col_Num);
		if(cell == null)
			cell = row.createCell(col_Num);

		cell.setCellValue(sData);
		//xlFilePath = "C:\\Users\\punspand\\Desktop\\CommandCenter\\downloads\\202006125307_Offered Parts.xls"
		fos = new FileOutputStream(sFilePath);
		workbook.write(fos);
		fis.close();
		fos.close();
		
		return sDownloadedFileName;
		
	}	
		
	
	
	public static void deletefile(String sfilePath, String sFileName) throws InterruptedException
	{
		System.out.println("in delete file function");
		
		Thread.sleep(10000);
		try
		{
		
		String directoryName = "C:\\POC\\CommandCenterPhase2Regression\\downloadedfiles";
		File directory = new File(directoryName);
		File[] files = directory.listFiles();
	
		for(int i=0;i<files.length;i++)
		{
			System.out.println("file name is "+files[i].getName());
			files[i].delete();
		}
		}
		catch(Exception e)
		{
			
		}
		
}
	
		
}
	
	
	

