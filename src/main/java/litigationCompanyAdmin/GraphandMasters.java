package litigationCompanyAdmin;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licensePerformer.LiPerformerPOM;
import litigationPerformer.performerPOM;
import performer.OverduePOM;

public class GraphandMasters {
	
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
	

	public static void progress(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void Graph(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		final WebDriver WebDriver = null;

		
		    Thread.sleep(500);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
//		     CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
		     js.executeScript("window.scrollBy(0,700)");
		
		
		    Thread.sleep(3000);
		       
		    String string_Compliances =performerPOM.caseNoticeSummaryGraph(driver).getText();		//Storing old value of Statutory overdue.
		    int CaseNoticeDas = Integer.parseInt(string_Compliances);
		    performerPOM.caseNoticeSummaryGraph(driver).click();
		    
		    
		    
		    
		    WebDriverWait wait=new WebDriverWait (driver,300); 
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		    
		  // performerPOM.TableLoad(driver);
		    
//		    Thread.sleep(3000);
//		    performerPOM.caseNoticeSummaryGraphExport(driver).sendKeys(Keys.PAGE_DOWN);
//		    
		  
			Thread.sleep(300);
		
			js.executeScript("window.scrollBy(0,700)");
			Thread.sleep(3000);
			 performerPOM.readTotalItemsD(driver).click();					//Clicking on total items count
			Thread.sleep(500);
     		String item = performerPOM.readTotalItemsD(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int ComcountGrid = Integer.parseInt(compliancesCount);
		
			if(CaseNoticeDas == ComcountGrid)
			{
				test.log(LogStatus.PASS, "Number of Case/Notice grid matches to Dashboard Case/Notice Count.");
				test.log(LogStatus.INFO, "No of Case/Notice in the grid = "+ComcountGrid+" | Dashboard Case/Notice  Count = "+CaseNoticeDas);
			}
			else
			{
				test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Overdue Count.");
				test.log(LogStatus.INFO, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliance");

			}
			
			Thread.sleep(300);
			driver.switchTo().parentFrame();
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
		
//			Thread.sleep(500);
//			OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard
		
		
 }	
	
	public static void Masters(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
		performerPOM.clickMasters(driver).click();
		
		Thread.sleep(300);
		performerPOM.clickMastersMenu(driver).click();
		
		
		Thread.sleep(300);
		performerPOM.chooseMasterLegalEntity(driver).click();
		
		
//		Thread.sleep(300);
//		performerPOM.newLawFirm(driver).click();
		
		performerPOM.addLegalEntity(driver).click();
		

		Thread.sleep(500);
		Row row0 = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String legalEntity= c1.getStringCellValue();
	    performerPOM.legalEntityName(driver).sendKeys(legalEntity);
	    
	    Thread.sleep(3000);
	    performerPOM.clickUnitType(driver).click();
	    Thread.sleep(3000);
	    performerPOM.chooseUnitType(driver).click();
	    Thread.sleep(3000);
	    performerPOM.clickLegalEntityType(driver).click();
		Thread.sleep(3000);
		performerPOM.chooseLegalEntityType(driver).click();
	    

		Thread.sleep(500);
		Row row = sheet.getRow(10);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String address= c.getStringCellValue();
	    performerPOM.clickAddressLine(driver).sendKeys(address);
	    
	    Thread.sleep(3000);
	    performerPOM.clickState1(driver).click();
	    
	    Thread.sleep(3000);
	    performerPOM.chooseState1(driver).click();
	    
	    Thread.sleep(3000);
	    performerPOM.clickCity(driver).click();
	    
	   
	    Thread.sleep(3000);
		
		Row row2 = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		String contact= c2.getStringCellValue();
	    performerPOM.clickContactPerson(driver).sendKeys(contact);
	    
	    Thread.sleep(3000);
	  	Row row3 = sheet.getRow(12);						//Selected 0th index row (First row)
	  	Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
	  	String email= c3.getStringCellValue();
	  	 performerPOM.clickEmail(driver).sendKeys(email);
	   
	  	 Thread.sleep(3000);
	    performerPOM.clickSaveLegalEntity(driver).click();
	    
	    
	    
	    
	    
//		Thread.sleep(300);
//		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew2(driver)));
//		performerPOM.clickAddNew2(driver).click();
//		
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
//		
//		Thread.sleep(300);
//		performerPOM.clickCaseNoticeType(driver).sendKeys("New Admin2");
//		
//		Thread.sleep(300);
//		performerPOM.clickSave(driver).click();				//Clicking on Save button.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMesg(driver)));
		String msg = performerPOM.readMesg(driver).getText();
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, " Message Displayed - "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, " Message Displayed - "+msg);
		}
		
		Thread.sleep(300);
		driver.switchTo().parentFrame();
		
		Thread.sleep(300);
		performerPOM.clickClose2(driver).click();
		
		Thread.sleep(300);
		OverduePOM.clickDashboard(driver).click();
	}

}
