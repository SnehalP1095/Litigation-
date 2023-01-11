package litigationManagement;

import static litigationPerformer.performerPOM.clicktype1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licensePerformer.LiPerformerPOM;
import litigationPerformer.performerPOM;
import performer.OverduePOM;

public class CFOMethod {
	
	   private static List<WebElement> elementsList = null;
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
		
		public static XSSFSheet ReadExcel() throws IOException
		{
			//String workingDir = System.getProperty("user.dir");
			fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\ashitosh\\ComplianceLatest\\ComplianceLatest\\TestData\\LitigationSheet.xlsx");
			
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
			return sheet;
		}
		public static void DashBoardFilter(WebDriver driver,ExtentTest test, String type) throws InterruptedException
		{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("window.scrollBy(0,800)");
	       	
	       	Thread.sleep(5000);
			performerPOM.clickDashboardLocFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardLocFilter1(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter1(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardTypeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardTypeFilter1(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardDeptFilter(driver).click();
				
			Thread.sleep(6000);
			performerPOM.clickDashboardDeptFilter1(driver).click();
			
			Thread.sleep(6000);
			performerPOM.clickDashboardstatusFilter(driver).click();
			
			Thread.sleep(6000);
			performerPOM.clickDashboardstatusFilter1(driver).click();
			
	        Thread.sleep(6000);
			performerPOM.clickDashboardRiskFilter(driver).click();
			
	        Thread.sleep(6000);
			performerPOM.clickDashboardRiskFilter1(driver).click();
			
		    Thread.sleep(5000);
			performerPOM.clickDashboardApplyBtn(driver).click();
			
		    Thread.sleep(5000);
			performerPOM.clickDashboardClearBtn(driver).click();
			
			test.log(LogStatus.PASS,"DashBoard Filter Work Successfully");
			
			}
		public static void CaseNoticeStageGraph(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("window.scrollBy(0,1000)");
			
	       	Thread.sleep(2000);
		
	       	int	open = Integer.parseInt(performerPOM.clickCaseNoticeStageHearingGraph(driver).getText());	//Reading Notice Open count.
		    performerPOM.clickCaseNoticeStageHearingGraph(driver).click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph(driver).click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph(driver).click();
			
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.selectAgeFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2(driver).click();
			
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item1 = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton(driver).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
			
	   }	
		
		public static void CaseNoticeTypeGraph(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
		{
			//perofmerPOM.CaseNoticeTypeSummaryGraph(driver).click();
			
			
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("window.scrollBy(0,1000)");
			
	       	Thread.sleep(2000);
		
	       	int	open = Integer.parseInt(performerPOM.CaseNoticeTypeSummaryGraph1(driver).getText());	//Reading Notice Open count.
		    performerPOM.CaseNoticeTypeSummaryGraph1(driver).click();						//Clicking on 'Open' notice
		    
		    
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph(driver).click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph(driver).click();
			
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.selectAgeFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2(driver).click();
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item1 = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton(driver).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
			
	   }	
		
		public static void RiskSummaryGraph(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("window.scrollBy(0,1500)");
			
	       	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.RiskSummaryGraph1(driver).getText());	//Reading Notice Open count.
		    performerPOM.RiskSummaryGraph1(driver).click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph(driver).click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.selectAgeFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2(driver).click();
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item1 = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton(driver).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
			
		}
		
	   public static void DepartmentSummaryGraph(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("window.scrollBy(0,1500)");
			
	       	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.DepartmentSummaryGraph1(driver).getText());	//Reading Notice Open count.
		    performerPOM.DepartmentSummaryGraph1(driver).click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph(driver).click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(7000);
			performerPOM.selectAgeFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2(driver).click();
			
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item1 = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton(driver).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
			
			
		}
	   public static void LocationSummaryGraph(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	      	js.executeScript("window.scrollBy(0,1800)");
			
	      	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.LocationSummaryGraph(driver).getText());	//Reading Notice Open count.
		    performerPOM.LocationSummaryGraph(driver).click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph(driver).click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.selectAgeFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2(driver).click();
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item1 = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton(driver).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
			
	}
	   
	   public static void CategorySummaryGraph(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	      	js.executeScript("window.scrollBy(0,2000)");
			
	      	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.CategorySummaryGraph(driver).getText());	//Reading Notice Open count.
		    performerPOM.CategorySummaryGraph(driver).click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	      	
	      	
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(2000);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(2000);
			performerPOM.clickCaseNoticeStageHearingExport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph(driver).click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.selectAgeFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2(driver).click();
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item1 = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton(driver).click();
			
			
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose(driver).click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
		}
	   static void perform(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type, String noticeCategory) throws InterruptedException, IOException
		{
		   
			
			WebDriverWait wait1 = new WebDriverWait(driver, 300);
			progress(driver);
			
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
			js.executeScript("window.scrollBy(0,-700)");
			
			Thread.sleep(4000);
			clickNewNotice(driver);
			
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(3000);
			clickDated(driver);

			Thread.sleep(3000);
			clickFinancialYear(driver);

//			Thread.sleep(3000);
//			clickRefNo(driver);

			Thread.sleep(3000);
			selectNoticeType(driver,type);

			Thread.sleep(3000);
			clickAct(driver);

			Thread.sleep(3000);
			clickOpponentcfo(driver);

			Thread.sleep(3000);
			selectCategory(driver,noticeCategory);

			Thread.sleep(3000);
			clickNoticeTitle(driver);

			Thread.sleep(3000);
			clickNoticeDescription(driver);

			Thread.sleep(3000);
			selectLocation(driver);

			Thread.sleep(3000);
			clickDepartment(driver);

			Thread.sleep(3000);
			clickOwner(driver);

			Thread.sleep(3000);
            selectRisk(driver);

			Thread.sleep(3000);
            selectNoticeRecipetDate(driver);
            
            Thread.sleep(3000);
            clickInternalUser(driver);
            
//  		    Thread.sleep(3000);
//    		performerPOM.clickAdditionalOwnerCfo(driver); 
//    		
//    		 Thread.sleep(3000);
//     		 performerPOM.selectAdditionalOwnerCfo(driver); 

            Thread.sleep(3000);
    		performerPOM.selectNoticeUploadDocument(driver); 
    		
       		
       		Thread.sleep(3000);
    		OverduePOM.clickSaveButton(driver).click();		
    		
    		Thread.sleep(1000);
    		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage(driver)));
    		
    		Thread.sleep(2000);
    		String msg = performerPOM.readMessage(driver).getText();		//Reading Message appeared after save button
    		int flag = 0;
    		if(msg.equalsIgnoreCase("Notice Created Successfully."))
    		{
    			test.log(LogStatus.PASS, "Message displayed = "+msg);
    			flag = 1;
    		}
    		else
    		{
    			test.log(LogStatus.FAIL, "Message displayed = "+msg);
    		}
    		
    		WebElement ele1 = null;
    		WebElement ele2 = null;
    		WebElement ele3 = null;
    		WebElement ele4 = null;
    		
    		if(flag == 1)
    		{
    			try
    			{
    				Thread.sleep(3000);
    				ele1 = wait1.until(ExpectedConditions.visibilityOf(performerPOM.clickLinkNotice(driver)));
    				ele2 = performerPOM.clickViewDoc(driver);
    				ele3 = performerPOM.clickSendMail(driver);
    				ele4 = performerPOM.clickEditNotice(driver);
    			}
    			catch(Exception e)
    			{
    				
    			}
    			
    			if(ele1 != null && ele2 != null && ele3 != null && ele4 != null)
    			{
    				test.log(LogStatus.PASS, "Icons displayed are :- Link Notice, View Document, Send Mail with Document, Edit Notice");
    			}
    			else
    			{
    				test.log(LogStatus.FAIL, "All icons are not displayed.");
    			}
    		}
    	
    		Thread.sleep(3000);
    		driver.switchTo().parentFrame();
    		performerPOM.clickClose(driver).click();//Clicking on 'Close'
    		
    		
    		Thread.sleep(1000);
    		CFOcountPOM.readTotalItems1(driver).click();
    		String item = CFOcountPOM.readTotalItems1(driver).getText();
    		String[] bits = item.split(" ");								//Splitting the String
    		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
    		int count1 = 0;
    		if(compliancesCount.equalsIgnoreCase("to"))
    		{
    			Thread.sleep(2000);
    			item = CFOcountPOM.readTotalItems1(driver).getText();
    			bits = item.split(" ");								//Splitting the String
    			compliancesCount = bits[bits.length - 2];
    		}
    		count1 = Integer.parseInt(compliancesCount);
    		
    		if(count1 > gridRecords)
    		{
    			test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice.");
    			test.log(LogStatus.INFO, "Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
    		}
    		else
    		{
    			test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice.");
    			test.log(LogStatus.INFO, "Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
    		}
    		
    		Thread.sleep(1000);
    		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
    		
    		Thread.sleep(500);
    		//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
    		int open1 = 0;
    		if(type.equalsIgnoreCase("Notice - Open"))
    		{
    			open1 = Integer.parseInt(performerPOM.clickNoticeOpen(driver).getText());	//Reading Notice Open count.
    		}
    		else
    		{
    			open1 = Integer.parseInt(performerPOM.clickNoticeClosed(driver).getText());	//Reading Notice Open count.
    		}
    		
    		if(open1 > open)
    		{
    			test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
    		}
    		else
    		{
    			test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
    		}
    		
    		
    	}
    		
    	
    		
			
		
	   
	   public  static void clickNewNotice(WebDriver driver) throws InterruptedException 
		  {
				Thread.sleep(3000);
				performerPOM.clickNew(driver).click();	//Clicking on 'New' button
           }
				
		public static void clickDated(WebDriver driver)
		{
		performerPOM.clickDated(driver).click();					//Clicking on 'Dated' button
		OverduePOM.selectLastMonth(driver).click();					//Clicking last month arrow.
		OverduePOM.selectDate3(driver).click();	//Clicking particular date.
		}
		
		public static void clickFinancialYear(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		performerPOM.clickFinancialYear(driver).click();			//Clicking on 'Financial Year' drop down.
		elementsList = performerPOM.chooseDropDownOption(driver);
		elementsList.get(10).click();								//Clicking third option
		performerPOM.clickFinancialYear(driver).click();			//Clicking on 'Financial Year' drop down.
      }
		
		public static void clickRefNo(WebDriver driver) throws InterruptedException, IOException
		{
			
		Thread.sleep(500);
		Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String refno = c1.getStringCellValue();
		performerPOM.clickRefNo(driver).clear();
		performerPOM.clickRefNo(driver).sendKeys(refno);			//Writing 'Reference No'
		}
		
		public static void selectNoticeType(WebDriver driver, String noticeType) 
		{
			WebElement type = performerPOM.clickNoticeType(driver);
			type.click();
			
			performerPOM.chooseNoticeType(driver).click(); 
			
		}
		public static void clickOpponent(WebDriver driver, String noticeType) 
		{
	
			
			performerPOM.clickOpponentcfo(driver).click(); 
			
		}
		
		public static void clickAct(WebDriver driver) throws InterruptedException
		{
		   Thread.sleep(300);
		   progress(driver);
	       XSSFRow row0 = sheet.getRow(6);						//Selected 0th index row (First row)
		   XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		   int actNo = (int) c1.getNumericCellValue();
		   performerPOM.clickAct(driver).click();						//Clicking on 'Act' drop down.
		   elementsList = performerPOM.chooseAct(driver);
		   elementsList.get(3).click();							//Selecting particular act no
		   performerPOM.clickAct(driver).click();						//Clicking on 'Act' drop down.
		}
		 public static void clickOpponentcfo(WebDriver driver) throws InterruptedException
		   {
	           Thread.sleep(300);
	           Row row0 = sheet.getRow(7);						//Selected 0th index row (First row)
	           Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
	            String Opponent = c1.getStringCellValue();
             performerPOM.clickOpponentcfo(driver).sendKeys(Opponent);
		   }
	
			public static void selectCategory(WebDriver driver,String noticeCategory) 
			{
				WebElement Category =  performerPOM.clickNoticeCategory(driver);
				Category.click();
				 performerPOM.chooseCategory(driver).click();
			}
			
			public static void clickNoticeTitle(WebDriver driver) throws InterruptedException
			{
			  Thread.sleep(300);
			  XSSFRow row0 = sheet.getRow(8);						//Selected 0th index row (First row)
			  XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			  String title = c1.getStringCellValue();
			  performerPOM.clickNoticeTitle(driver).sendKeys(title);		//Writing 'Notice Title'
			}
			public static void clickNoticeDescription(WebDriver driver) throws InterruptedException
			{
			Thread.sleep(300);
			XSSFRow row0 = sheet.getRow(9);						//Selected 0th index row (First row)
			XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			String desc = c1.getStringCellValue();
			performerPOM.clickNoticeDescription(driver).sendKeys(desc);	//Writing 'Notice Description'
			Thread.sleep(300);		
			performerPOM.clickNoticeDescription(driver).sendKeys(Keys.PAGE_DOWN);
	        }
			public static void selectLocation(WebDriver driver) throws InterruptedException
			{
			Thread.sleep(7000);
			performerPOM.clickLocation(driver).click();					//Clicking on Location drop down
			Thread.sleep(3000);
			//performerPOM.clickPlus(driver).click();
			performerPOM.selectLocationCfo(driver).click();;
			//elementsList.get(2).click();								//Selecting third visible location
			}
			public static void clickDepartment(WebDriver driver) throws InterruptedException
			{
			
			performerPOM.clickDeptCfo(driver).click();					//Clicking on 'Department' drop down
			performerPOM.selectDeptCfo(driver).click();	//Writing 'Department' name
			}
			public static void clickOwner(WebDriver driver) throws InterruptedException
			{
			
			performerPOM.clickOwnerCfo(driver).click();					//Clicking on 'Owner' drop down
			performerPOM.selectOwnerCfo(driver).click();	//Writing 'Owner' name
			}
			public static void selectRisk(WebDriver driver) throws InterruptedException
			{

			  performerPOM.clickRisk(driver).click();							//Clicking on 'Risk' drop down.
			  Thread.sleep(500);
			  performerPOM.selectRisk(driver).click();						//Selecting second option 'High' risk.
	        }
			public  static void selectNoticeRecipetDate(WebDriver driver)
		      {
		    	 	
		          WebElement openDate= performerPOM.selectNoticeRecipetDate(driver);
		          openDate.sendKeys("30-09-2021");
		        
		      }
			
			public static void clickInternalUser(WebDriver driver) throws InterruptedException
			{
			Thread.sleep(300);
			XSSFRow row0 = sheet.getRow(10);						//Selected 0th index row (First row)
			XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			int internalUserNo = (int) c1.getNumericCellValue();
			performerPOM.clickInternalUser(driver).click();						//Clicking on 'Internal User' drop down.
			elementsList = performerPOM.chooseInternalUser(driver);
			elementsList.get(internalUserNo).click();							//Selecting particular user no
			performerPOM.clickInternalUser(driver).click();	//Clicking on 'Internal User' drop down.
			}
			
			
	public static void NoticeOpen(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
		{
			
			
			int sheetNo = 8;
		    if(login.equalsIgnoreCase("cfo"))
		    {
		    	sheetNo = 8;
		    }
		   
			
			Thread.sleep(3000);
			int open = CountExcel(driver, test, "Notice - Open");
			
			Thread.sleep(3000);
			performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)");
			
			Thread.sleep(5000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int gridRecords = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				gridRecords = 0;
			}
			else
			{
				gridRecords = Integer.parseInt(compliancesCount);
			}
			
			sheet = workbook.getSheetAt(sheetNo);
			
			perform(driver, test, sheet, open, gridRecords, "Notice - Open",compliancesCount);
		}
	
	
    	static void NoticeDocument(WebDriver driver, ExtentTest test) throws InterruptedException
       	{
    		WebDriverWait wait = new WebDriverWait(driver, 50);
             
    		Thread.sleep(1000);
    		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
    		
	        Thread.sleep(3000);
			performerPOM.clickNoticeOpen(driver).click();//click edit notice
	     
	        Thread.sleep(3000);
			performerPOM.clickEditNotice(driver).click();//click edit notice
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
	        
	        performerPOM.clickNoticeDocument(driver).click();     //click notice document
	        performerPOM.clickNewDocument(driver).click();        //click new document button
	
	        Thread.sleep(1000);
           	driver.switchTo().frame("IFrameManageDocument");
           	performerPOM.selectDocumentType(driver);
          	Thread.sleep(3000);
	        performerPOM.chooseDocumentType(driver);
	        Thread.sleep(1000);
	        performerPOM.selectUploadDocument(driver); 
	        Thread.sleep(1000);
         	performerPOM.clickUploadDocument(driver).click(); 
	
	
         	Thread.sleep(1000);
         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg(driver)));
	
        	Thread.sleep(3000);
	        String msg= performerPOM.readDocMsg(driver).getText();		//Reading Message appeared after save button
	       
         	if(msg.equalsIgnoreCase("Document(s) uploaded successfully"))
         	{
	        	test.log(LogStatus.PASS, "Message displayed = "+msg);
	         
	        }
	      else
	        {
		       test.log(LogStatus.FAIL, "Message displayed = "+msg);
	        }
	
	        Thread.sleep(1000);
	        performerPOM.clickClosedDocument(driver).click(); 
	        
	        driver.switchTo().parentFrame();
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentDownloadcfo(driver).click();
	        
	        test.log(LogStatus.PASS, "Document download succssesfully");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentViewcfo(driver).click();
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentViewClosepopupcfo(driver).click();
	        
	        test.log(LogStatus.PASS, "Document View popup open  succssesfully");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentdeletecfo(driver).click();
	        
	        Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);
	        
	 		
	        // Accepting alert		
	        alert.accept();	
	        
	       
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharecfo(driver).click();
	        
	        Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert1 = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage1= driver.switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, alertMessage1);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage1);
	        
	     // Accepting alert		
	        alert.accept();	
	        
	        
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentshareemailcfo(driver).sendKeys("admin@gmail.com");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharecontactnocfo(driver).sendKeys("5768798045");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharesavecfo(driver).click();
	        
	        
	        Thread.sleep(3000);
	        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo(driver).getText();		//Reading Message appeared after save button
	       
         	if(msg1.equalsIgnoreCase("Document shared successfully."))
         	{
	        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
	         
	        }
	      else
	        {
		       test.log(LogStatus.FAIL, "Message displayed = "+msg1);
	        }
	        
	        
	        driver.switchTo().parentFrame();
	        Thread.sleep(3000);
	        performerPOM. clickNoticeDocumentshareclosepopupcfo(driver).click();
	        
	        driver.switchTo().parentFrame();
	        
	        
	        
       }
    	
    	 public  static void TaskActivtity(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
			{
    		 
    		       XSSFSheet sheet = ReadExcel();
				   WebDriverWait wait = new WebDriverWait(driver, 60);

				   
				   Thread.sleep(1000);
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				  Thread.sleep(1000);
				  performerPOM.clickTaskorActivity(driver).click();
				  Thread.sleep(1000);
				  performerPOM.clickNewTask(driver).click(); 
				 
				  
				  
				Thread.sleep(3000);
				Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				String title = c1.getStringCellValue();
				performerPOM.clickTaskTitle(driver).sendKeys(title);	//Writing 'Task Title'
				
				Thread.sleep(3000);
				row0 = sheet.getRow(13);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickTaskDesc(driver).sendKeys(desc);		//Writing 'Task Description'
				
				Thread.sleep(3000);
				performerPOM.clickDueDate(driver).click();				//Clicking on 'Due Date' text box
				OverduePOM.selectNextMonth(driver).click();
				OverduePOM.selectDate(driver).click();					//Selecting particular date.
				
				Thread.sleep(500);
				Actions action = new Actions(driver);
//				action.moveToElement(performerPOM.clickPriority(driver)).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
				
				Thread.sleep(500);
				row0 = sheet.getRow(14);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String outcome = c1.getStringCellValue();
				performerPOM.clickExpOutcome(driver).sendKeys(outcome);	//Writing 'Expected Outcome'
				
				Thread.sleep(500);
				row0 = sheet.getRow(15);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String internalUser = c1.getStringCellValue();
				performerPOM.clickInternalUser2(driver).click();
				//performerPOM.selectInternalUser2(driver).click();
				performerPOM.selectInternalUser2(driver).sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
				
	
				
				Thread.sleep(1000);
				row0 = sheet.getRow(16);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String externalUser = c1.getStringCellValue();
				try
				{
					Thread.sleep(300);
					performerPOM.clickExternalUser(driver).click();
					Thread.sleep(500);
					action.moveToElement(performerPOM.clickSearchExternalUser(driver)).sendKeys(externalUser, Keys.ENTER).perform();
				}
				catch(Exception e)
				{
					
				}
			
				Thread.sleep(2000);
				row0 = sheet.getRow(17);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String remark = c1.getStringCellValue();
				performerPOM.clickRemark(driver).sendKeys(remark);		//Writing 'Remark'
				
				//Thread.sleep(300);
				//String workingDir = System.getProperty("user.dir");
				//performerPOM.clickUpload(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
				
				Thread.sleep(3000);
				OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
				
				Thread.sleep(300);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg(driver)));
				
				Thread.sleep(300);
				String msg = performerPOM.readTaskMsg(driver).getText();
				String msg1 = performerPOM.readTaskMsg1(driver).getText();
				if(msg.contains("Task Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Task Saved Successfully.");
				}
				
				else if(msg.contains("Task with same title already exists."))
				{
					test.log(LogStatus.FAIL, "Task with same title already exists.");
				}
				
				Thread.sleep(3000);
				performerPOM.clickNoticeEditTaskcfo(driver).click();
				
				performerPOM.clickTaskTitle(driver).clear();
				
				Thread.sleep(3000);
				Row row1 = sheet.getRow(18);								//Selected 0th index row (First row)
				Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
				String title1 = c2.getStringCellValue();
				performerPOM.clickTaskTitle(driver).sendKeys(title1);	//Writing 'Task Title'
				
				Thread.sleep(3000);
				OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
				
				Thread.sleep(300);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg(driver)));
				
				Thread.sleep(300);
				String msg2 = performerPOM.readTaskMsg(driver).getText();
		
				if(msg2.contains("Task Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Task Saved Successfully.");
				}
				
				else if(msg2.contains("Task with same title already exists."))
				{
					test.log(LogStatus.FAIL, "Task with same title already exists.");
				}
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo(driver).click();
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo(driver).click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo1(driver).click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskcmtResponsecfo(driver).sendKeys("Automate Test");
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskSaveResponsecfo(driver).click();
				
				
				
				test.log(LogStatus.PASS,"Task Response Saved Successfully.");
				
				driver.switchTo().parentFrame();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskCloseResponsecfo(driver).click();
				
                Thread.sleep(3000);
				performerPOM.clickNoticeTaskClosecfo(driver).click();
				
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = driver.switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= driver.switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);
			        
			     // Accepting alert		
			        alert.accept();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskdeletecfo(driver).click();
				
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert1 = driver.switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage1= driver.switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage1);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage1);
			        
			     // Accepting alert		
			        alert1.accept();
		
			}
    	 
     static void Response(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
			   WebDriverWait wait = new WebDriverWait(driver, 60);
			   
			   XSSFSheet sheet = ReadExcel();
			  
		
			   
			   driver.switchTo().parentFrame();
			   
			           Thread.sleep(1000);
			           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			           Thread.sleep(3000);
					  performerPOM. clickResponse(driver).click();
					  Thread.sleep(3000);
					  performerPOM. clickNewResponse(driver).click();
					  Thread.sleep(3000);
					  performerPOM. selectSentNotice(driver);
					  Thread.sleep(3000);
					  performerPOM. selectReplyDueDate(driver);
					  Thread.sleep(3000);
					  performerPOM. selectRespondedDate(driver);
				
					 		 
					  Thread.sleep(500);
					  Row row1 = sheet.getRow(20);								//Selected 0th index row (First row)
					  Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
					  String DeliveryMode= c2.getStringCellValue();
					  performerPOM.clickDeliveryMode(driver).click();
					  performerPOM.selectDeliveryMode(driver).sendKeys(DeliveryMode);
					  
					  
					  Thread.sleep(500);
					  Row row0 = sheet.getRow(21);								//Selected 0th index row (First row)
					  Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
					  String CourierCompany= c1.getStringCellValue();
					  performerPOM.clickCourierCompany(driver).sendKeys(CourierCompany);
						 
					  Thread.sleep(500);
						Row row2 = sheet.getRow(22);								//Selected 0th index row (First row)
						Cell c3 = row2.getCell(1);								//Selected cell (0 row,1 column)
						String RefNo= c3.getStringCellValue();
						performerPOM.RefTrackingNo(driver).sendKeys(RefNo);
							 
						Thread.sleep(500);
						Row row3 = sheet.getRow(23);								//Selected 0th index row (First row)
						Cell c4 = row3.getCell(1);								//Selected cell (0 row,1 column)
						String Description= c4.getStringCellValue();
						 performerPOM.Description(driver).sendKeys(Description);
						 
						 Thread.sleep(3000);
						 performerPOM.clickNoticeResponseDocUploadtcfo(driver);
							
						 JavascriptExecutor jse=(JavascriptExecutor)driver;
						 jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse(driver));
						  //performerPOM.clickSaveResponse(driver).click();
							
							Thread.sleep(1000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg(driver)));
								
							Thread.sleep(500);
							String msg3 = performerPOM.readResponseMsg(driver).getText();		//Reading Message appeared after save button
							
							if(msg3.equalsIgnoreCase("Response Details Saved Successfully."))
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg3);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg3);
								}
							Thread.sleep(3000);
							performerPOM.clickNoticeEditResponsecfo(driver).click();
							
							performerPOM.clickCourierCompany(driver).clear();
							  Thread.sleep(500);
							  Row row4 = sheet.getRow(21);								//Selected 0th index row (First row)
							  Cell c5 = row4.getCell(1);								//Selected cell (0 row,1 column)
							  String CourierCompany1= c5.getStringCellValue();
							  performerPOM.clickCourierCompany(driver).sendKeys(CourierCompany1);
							  
							  Thread.sleep(3000);
							 performerPOM.clickNoticeResponseDocUploadtcfo(driver);
							
							  
							  jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse(driver));
							  
							  Thread.sleep(1000);
								wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg(driver)));
									
								Thread.sleep(500);
								String msg4 = performerPOM.readResponseMsg(driver).getText();		//Reading Message appeared after save button
								
								if(msg3.equalsIgnoreCase("Response Details Saved Successfully."))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg4);
									
								}
									else
									{
										test.log(LogStatus.FAIL, "Message displayed = "+msg4);
									}
								
								Thread.sleep(4000);
								performerPOM.clickNoticeDownloadResponsecfo(driver).click();
								
								//test.log(LogStatus.PASS, "Document download succssesfully");
								
								Thread.sleep(4000);
								performerPOM.clickNoticeViewResponsecfo(driver).click();
								
								Thread.sleep(6000);
								performerPOM.clickNoticeclosePopupResponsecfo(driver).click();
								
								test.log(LogStatus.PASS, "Document view popup open succssesfully");
								
								Thread.sleep(4000);
								performerPOM.clickNoticeDeleteResponsecfo(driver).click();
								
								 Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert1 = driver.switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= driver.switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage1);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage1);
							        
							     // Accepting alert		
							        alert1.accept();
							        
							        driver.switchTo().parentFrame();
							
							
			       }
    	
    	 static void PaymentLog(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
    		 
    		 
    		   WebDriverWait wait = new WebDriverWait(driver, 60);
			   
			   XSSFSheet sheet = ReadExcel();
			  
			     
			     driver.switchTo().parentFrame();
			     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			     
			     Thread.sleep(3000);
			    performerPOM.clickStatusPayments(driver).click();			//Clicking on 'Status/Payments'
			
			    Thread.sleep(1000);
				performerPOM.clickInvoiceNo(driver).sendKeys("56784");
				
				
				Thread.sleep(3000);
				Row r5 = sheet.getRow(30);
				Cell c5 = r5.getCell(1);
				String PaymentType = c5.getStringCellValue();
				performerPOM.clickPaymentType(driver).click();
				performerPOM.selectPaymentType(driver).sendKeys(PaymentType,Keys.ENTER);
//				List<WebElement> PaymentType1= driver.findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
//				PaymentType1.get(2).click();
					
				Thread.sleep(3000);
				performerPOM.clickAmount(driver).sendKeys("5000");
				
				Thread.sleep(6000);
				performerPOM.clickNoticeStatusPaymentUploadtcfo(driver);
			
				Thread.sleep(300);
				performerPOM.clickSavePaymentLog(driver).click();
				

				
				 WebDriverWait wait1 = new WebDriverWait(driver, 300);
				 wait1.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg(driver)));
					
					Thread.sleep(500);
					String msg4 = performerPOM.readPymentmsg(driver).getText();		//Reading Message appeared after save button
				
					if(msg4.equalsIgnoreCase("Payment Details Saved Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg4);
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg4);
					}
					
					Thread.sleep(3000);
					performerPOM.clickNoticeViewPaymentDoccfo(driver).click();
					
					Thread.sleep(3000);
					performerPOM.clickNoticeclosePaymentDocpopupcfo(driver).click();
					
					
					
					if(msg4.equalsIgnoreCase("Payment Document popup open successfully"))
					{
						test.log(LogStatus.PASS, "Payment Document popup open successfully");
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Payment Document popup does not open successfully");
					}
					
					Thread.sleep(3000);
					performerPOM.clickNoticeEditPaymentcfo(driver).click();
					
					performerPOM.clickInvoiceNo(driver).clear();
					 Thread.sleep(3000);
				    performerPOM.clickInvoiceNo(driver).sendKeys("Invoice No 578");
				    
				    Thread.sleep(6000);
					performerPOM.clickNoticeStatusPaymentUploadtcfo(driver);
				    
				    Thread.sleep(3000);
					performerPOM.clickSavePaymentLog(driver).click();
					
					 Thread.sleep(3000);
					performerPOM.clickNoticeDeletePaymentcfo(driver).click();
					
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert1 = driver.switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage1= driver.switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage1);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage1);
				        
				     // Accepting alert		
				        alert1.accept();
				        
				        Thread.sleep(500);
						String msg5 = performerPOM.readPymentmsg(driver).getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase("Payment Details Deleted Successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg5);
						}
				        
				        Thread.sleep(3000);
				        performerPOM.clickNoticeDownloadPaymentcfo(driver).click();
				        
				        test.log(LogStatus.PASS, "Payment Document Download Successfully.");
						
					
				    
				    	 driver.switchTo().parentFrame();
				 		performerPOM.clickClose(driver).click();//Clicking on 'Close'
				
			}
    	 
    	  static void ExternalLawyer(WebDriver driver,ExtentTest test) throws InterruptedException
          {
        	  
    		         WebDriverWait wait = new WebDriverWait(driver, 300);
		   
			          Thread.sleep(1000);
			          
			          driver.switchTo().parentFrame();
			          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
        	          
    			       Thread.sleep(3000);
    				   performerPOM. clickExternalLawyerRating(driver).click();
    				   

    				   
    				  Thread.sleep(3000);
    				  performerPOM.selectExternalLawyerRating(driver);
    				   Thread.sleep(3000);
    				   performerPOM.clickNewCriteria(driver).click();
    				   Thread.sleep(3000);
    				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
    				   performerPOM.clickCriteria(driver).sendKeys("Test Test New");
    				   Thread.sleep(3000);
    				   performerPOM.clickSaveCriteria(driver).click();
    				   Thread.sleep(3000);
    				   driver.switchTo().parentFrame();
    				   performerPOM.clickclosecriteria(driver).click();
    				   Thread.sleep(3000);
    				   performerPOM. clickstar(driver).click();
    			       Thread.sleep(3000);
    				   performerPOM. clickstar1(driver).click();
    				   Thread.sleep(3000);
    				   performerPOM. clickSaveRating(driver).click();
    				   
    				   
    			   	  Thread.sleep(1000);
    				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg(driver)));
    							
    					Thread.sleep(500);
    					String msg5 = performerPOM.readRatingmsg(driver).getText();		//Reading Message appeared after save button
    					int flag5= 0;
    					if(msg5.equalsIgnoreCase("Rating Saved Successfully."))
    						{
    								test.log(LogStatus.PASS, "Message displayed = "+msg5);
    								flag5 = 1;
    						}
    					else
    						{
    								test.log(LogStatus.FAIL, "Message displayed = "+msg5);
    						}
    				   
    		  }	   
    	  static void AuditLog(WebDriver driver, ExtentTest test) throws InterruptedException
  		  {
    		  
    		  WebDriverWait wait = new WebDriverWait(driver, 300);
		       
		   
		          Thread.sleep(1000);
		          
		          driver.switchTo().parentFrame();
		          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
    		  
  		              Thread.sleep(3000);
  		               performerPOM. clickAuditLog(driver).click();
  		                 Thread.sleep(3000);
  		                 performerPOM.clickExport(driver).click();		   
  		                 Thread.sleep(3000);
  		                  driver.switchTo().parentFrame();
  		                  performerPOM.clickclosebutton(driver).click();
  		
  		                  Thread.sleep(1000);
  		                  performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
  		                  JavascriptExecutor js = (JavascriptExecutor) driver;
  		                  js.executeScript("window.scrollBy(0,700)");
  		                  
  		                  test.log(LogStatus.PASS,"Export report download sucssesfully ");
  		 } 
    	
	
		
		static int CountExcel(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			progress(driver);
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
			
			
			int open = 0;
			if(type.equalsIgnoreCase("Notice - Open"))
			{
				open = Integer.parseInt(performerPOM.clickNoticeOpen(driver).getText());	//Reading Notice Open count.
				performerPOM.clickNoticeOpen(driver).click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Notice - Closed"))
			{
				open = Integer.parseInt(performerPOM.clickNoticeClosed(driver).getText());	//Reading Notice Closed count.
				performerPOM.clickNoticeClosed(driver).click();						//Clicking on 'Closed' notice
			}
			else if(type.equalsIgnoreCase("Case - Open"))
			{
				open = Integer.parseInt(performerPOM.clickCaseOpencfo(driver).getText());	//Reading Case Open count.
				performerPOM.clickCaseOpencfo(driver).click();						//Clicking on 'Open' Case
			}
			else if(type.equalsIgnoreCase("Case - Closed"))
			{
				open = Integer.parseInt(performerPOM.clickCaseClosed(driver).getText());	//Reading Case Open count.
				performerPOM.clickCaseClosed(driver).click();						//Clicking on 'Open' Case
			}
			else if(type.equalsIgnoreCase("Task - Open"))
			{
				open = Integer.parseInt(performerPOM.clickTaskOpen(driver).getText());	//Reading Case Open count.
				performerPOM.clickTaskOpen(driver).click();						//Clicking on 'Open' Case
			}
			
			else if(type.equalsIgnoreCase("Task - Closed"))
			{
				open = Integer.parseInt(performerPOM.clickTaskClosed(driver).getText());	//Reading Case Open count.
				performerPOM.clickTaskClosed(driver).click();						//Clicking on 'Open' Case
			}
			
			
			
			
			Thread.sleep(500);
			progress(driver);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			try
			{
				performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
			Thread.sleep(7000);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.INFO, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				String records =c1.getStringCellValue();
				int SheetRecords = 0;
				int flag = 0;
				try
				{
					SheetRecords = Integer.parseInt(records);
					flag = 1;
				}
				catch(Exception e)
				{
					
				}
				
//				if(flag == 0)
//				{
//					row = sheet.getRow(no-1);
//					c1 = row.getCell(0);
//					records = c1.getStringCellValue();
//					SheetRecords = Integer.parseInt(records);
//				}
				fis.close();
				
				if(count1 == SheetRecords)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count1+" | Total records from Report = "+SheetRecords);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.INFO, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+SheetRecords);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			return open;
		
			
			
			
		}
		public static void CaseOpen(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
		{
			
			Thread.sleep(1000);
    		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
			int sheetNo = 8;
		    if(login.equalsIgnoreCase("cfo"))
		    {
		    	sheetNo = 8;
		    }
			
//			Thread.sleep(500);
//			performerPOM. clickCaseOpencfo(driver).click();
			
			int open = CountExcel(driver, test, "Case - Open");
			
			
			Thread.sleep(500);
			performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)");
			
			Thread.sleep(300);
			CFOcountPOM.readTotalItems1(driver).click();
			String item = CFOcountPOM.readTotalItems1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int gridRecords = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				gridRecords = 0;
			}
			else
			{
				gridRecords = Integer.parseInt(compliancesCount);
			}
			
			sheet = workbook.getSheetAt(sheetNo);
			
			perform1(driver, test, sheet, open, gridRecords, "Case - Open");
		}
		static void perform1(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
			
			
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		//	CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
			js.executeScript("window.scrollBy(0,-700)");
			
			Thread.sleep(3000);
			clickNewCase(driver);
			
			Thread.sleep(3000);
			clickCaseskip(driver);
			
			progress(driver);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(1000);
			selectCaseType(driver);
			Thread.sleep(3000);
			clickDated1(driver);
			Thread.sleep(3000);
			clickFinanicialYear(driver);
			Thread.sleep(3000);
			clickRefNo1(driver);
			Thread.sleep(3000);
			clickInternalCaseNo(driver);
			Thread.sleep(3000);
			clickCaseTitle(driver);
			Thread.sleep(3000);
			clickCaseAct(driver);
			Thread.sleep(3000);
			clickUnderSection(driver);
			Thread.sleep(3000);
			clickSearchCaseCategory(driver);
			Thread.sleep(3000);
			clickCaseBudget(driver);
			Thread.sleep(3000);
			clickCaseOpponent(driver);
//			Thread.sleep(3000);
//			clickCaseOppLawyer(driver);
			Thread.sleep(3000);
			clickCaseCourt(driver);
			Thread.sleep(3000);
			clickCaseDescription(driver);
			Thread.sleep(3000);
			selectCaseLocation(driver);
			Thread.sleep(3000);
			clickCaseDepartment(driver);
			Thread.sleep(3000);
			clickCaseOwner(driver);
			Thread.sleep(3000);
			clickCaseRisk(driver);
			Thread.sleep(3000);
			clickCaseInternalUser(driver);
			
			Thread.sleep(3000);
			OverduePOM.clickSaveButton(driver).click();						//Clicking on 'Save'button.
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage1(driver)));
			
			Thread.sleep(500);
			String msg = performerPOM.readMessage1(driver).getText();		//Reading Message appeared after save button
			int flag = 0;
			if(msg.equalsIgnoreCase("Case Created Successfully."))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				flag = 1;
			}
		else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
		
			WebElement ele1 = null;
			WebElement ele2 = null;
			WebElement ele3 = null;
			WebElement ele4 = null;
			
			if(flag == 1)
			{
				try
				{
					Thread.sleep(700);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickEditCase(driver)));
					ele1 = performerPOM.clickLinkCase(driver);
					ele2 = performerPOM.clickViewDoc(driver);
					ele3 = performerPOM.clickSendMail1(driver);
				ele4 = performerPOM.clickEditCase(driver);
				}
				catch(Exception e)
				{
					
				}
				
				if(ele1 != null && ele2 != null && ele3 != null && ele4 != null)
				{
					test.log(LogStatus.PASS, "Icons displayed are :- Link Notice, View Document, Send Mail with Document, Edit Notice");
				}
				else
				{
					test.log(LogStatus.FAIL, "All icons are not displayed.");
				}
			}
		
			driver.switchTo().parentFrame();
			performerPOM.clickClose(driver).click();			//Clicking on 'Close'
			
			Thread.sleep(500);
			performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			js.executeScript("window.scrollBy(0,700)");
			
			
			Thread.sleep(1000);
			performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
			js.executeScript("window.scrollBy(0,700)");

	      Thread.sleep(1000);
	      CFOcountPOM.readTotalItems1(driver).click();
	      String item = CFOcountPOM.readTotalItems1(driver).getText();
	      String[] bits = item.split(" ");								//Splitting the String
	      String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	      int count1 = 0;
	      if(compliancesCount.equalsIgnoreCase("to"))
	     {
	        Thread.sleep(2000);
	        item = CFOcountPOM.readTotalItems1(driver).getText();
	         bits = item.split(" ");								//Splitting the String
	        compliancesCount = bits[bits.length - 2];
	     }
	       count1 = Integer.parseInt(compliancesCount);

	     if(count1 > gridRecords)
	     {
	       test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case.");
	       test.log(LogStatus.INFO, "Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
	     }
	     else
	     {
	        test.log(LogStatus.FAIL, "Total Case Count doesn't increased in grid after adding New Case.");
	        test.log(LogStatus.INFO, "Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
	     }

	       Thread.sleep(500);
	       OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'

	 
	       
	       
	       Thread.sleep(500);
	     //  wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
	       int open1 = Integer.parseInt(performerPOM.clickCaseOpencfo(driver).getText());	//Reading Notice Open count.
	       
	   	Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
		
		if(type.equalsIgnoreCase("Case - Open"))
		{
			open1 = Integer.parseInt(performerPOM.clickCaseOpencfo(driver).getText());	//Reading Notice Open count.
		}
		else
		{
			open1 = Integer.parseInt(performerPOM.clickCaseClosed(driver).getText());	//Reading Notice Open count.
		}

	       if(open1 > open)
	       {
	          test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
	       }
	       else
	      {
	          test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
	       }
	     }

	
			  public  static void clickNewCase(WebDriver driver) throws InterruptedException 
			  {
					Thread.sleep(3000);
					performerPOM.clickNew(driver).click();	//Clicking on 'New' button

	           }
			  public  static void clickCaseskip(WebDriver driver) throws InterruptedException 
			  {
					Thread.sleep(3000);
					
					performerPOM.clickCaseskipfo(driver).click();
	           }
			  public static void selectCaseType(WebDriver driver) 
				{
					WebElement type = performerPOM.clickCaseType1(driver);
					type.click();
					
					performerPOM.chooseCaseType(driver).click(); 
					
				}
			  
			
			  public  static void clickDated1(WebDriver driver) throws InterruptedException 
			  {
			      performerPOM.clickCaseDate(driver).click();					//Clicking on 'Dated' button
			      OverduePOM.selectLastMonth(driver).click();					//Clicking last month arrow.
			      OverduePOM.selectDate3(driver).click();						//Clicking particular date.
			  }
			
			  public  static void clickFinanicialYear(WebDriver driver) throws InterruptedException 
			  {
			      Thread.sleep(300);
			      performerPOM.clickFinancialYear(driver).click();			//Clicking on 'Financial Year' drop down.
			      elementsList = performerPOM.clickFinanceSearchCheckbox(driver);
			      elementsList=performerPOM.chooseDropDownOption(driver);
			      elementsList.get(10).click();								//Clicking third option
			      performerPOM.clickFinancialYear(driver).click();			//Clicking on 'Financial Year' drop down.
			  }
			
			

				
			  public  static void clickRefNo1(WebDriver driver) throws InterruptedException 
			  {
			       Thread.sleep(3000);
			       Row row0 = sheet.getRow(34);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      String refno = c1.getStringCellValue();
			      performerPOM.clickRefNo(driver).sendKeys(refno);			//Writing 'Court Case No'
			  }
				
			  public  static void clickInternalCaseNo(WebDriver driver) throws InterruptedException 
			  {
			       Thread.sleep(3000);
			      Row row0 = sheet.getRow(35);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String caseNo = c1.getStringCellValue();
			       performerPOM.clickInternalCaseNo(driver).sendKeys(caseNo);	//Writing 'Court Case No'
			  }
			  public  static void clickCaseTitle(WebDriver driver) throws InterruptedException 
			  {
			       Thread.sleep(3000);
			       Row row0 = sheet.getRow(36);								//Selected 0th index row (First row)
			       Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      String title = c1.getStringCellValue();
			       performerPOM.clickNoticeTitle(driver).sendKeys(title);		//Writing 'Case Title'
			  }

		 	
			  public  static void clickCaseAct(WebDriver driver) throws InterruptedException 
			  {
	   	      Thread.sleep(3000);
		         Row row0 = sheet.getRow(37);								//Selected 0th index row (First row)
		         Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
	 	          int actNo = (int) c1.getNumericCellValue();
			     performerPOM.clickAct(driver).click();						//Clicking on 'Act' drop down.
//		       //	elementsList = performerPOM.chooseAct(driver);
			    elementsList = performerPOM.chooseAct1(driver);
		        elementsList.get(2).click();							//Selecting particular act no
			     performerPOM.clickAct(driver).click();	                  //Clicking on 'Act' drop down.
			  }
			  
			  public  static void clickUnderSection(WebDriver driver) throws InterruptedException 
			  { 
			     Thread.sleep(3000);
			     Row row0 = sheet.getRow(38);								//Selected 0th index row (First row)
			     Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			     String underSection = c1.getStringCellValue();
			      performerPOM.clickUnderSection(driver).sendKeys(underSection);	//Writing 'Under section'
			  }
			  public  static void clickSearchCaseCategory(WebDriver driver) throws InterruptedException 
			  { 
			     Thread.sleep(3000);
			     Row row0 = sheet.getRow(39);								//Selected 0th index row (First row)
			    Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			    String caseType = c1.getStringCellValue();
			    performerPOM.clickCaseCategory(driver).click();
			    performerPOM.clickSearchCaseCategory(driver).sendKeys(caseType, Keys.ENTER);	//Writing 'Case Type'
			  }
			  public  static void clickCaseBudget(WebDriver driver) throws InterruptedException 
			  {
			      Thread.sleep(3000);
			     Row row0 = sheet.getRow(40);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      int caseBudget = (int) c1.getNumericCellValue();
			     performerPOM.clickCaseBudget(driver).sendKeys(caseBudget+"");
			  }
			
			  public  static void clickCaseOpponent(WebDriver driver) throws InterruptedException 
			  {
			     Thread.sleep(3000);
			     Row row0 = sheet.getRow(41);						//Selected 0th index row (First row)
			     Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			      String opponent = c1.getStringCellValue();
			     performerPOM.clickOpponentcfo(driver).sendKeys(opponent);	
			  }

			  public  static void clickCaseOppLawyer(WebDriver driver) throws InterruptedException 
			  {
		          Thread.sleep(3000);
			      Row row0 = sheet.getRow(42);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String oppoLawyer = c1.getStringCellValue();
			       performerPOM.clickOppLawyer(driver).click();				//Clicking on 'Opponent'
			       performerPOM.clickSearchBox1(driver).sendKeys(oppoLawyer);	//Writing 'Opposition Lawyer' name
			       Thread.sleep(300);
			        performerPOM.clickSelectAll3(driver).click();
			        performerPOM.clickOppLawyer(driver).click();
			  }
			  public  static void clickCaseCourt(WebDriver driver) throws InterruptedException 
			  {
			         Thread.sleep(3000);
			        Row row0 = sheet.getRow(43);								//Selected 0th index row (First row)
			         Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String court = c1.getStringCellValue();
			       performerPOM.clickCourt(driver).click();
			       performerPOM.clickSearchCourt(driver).sendKeys(court, Keys.ENTER);
			  }
			
			
		
			  public  static void clickCaseDescription(WebDriver driver) throws InterruptedException 
			  {
			        Thread.sleep(3000);
			       Row row0 = sheet.getRow(44);							//Selected 0th index row (First row)
			       Cell  c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       String casedesc = c1.getStringCellValue();
			      performerPOM.clickNoticeDescription(driver).sendKeys(casedesc);
			  }
			  
			  public static void selectCaseLocation(WebDriver driver) throws InterruptedException
				{
				Thread.sleep(7000);
				performerPOM.clickLocation(driver).click();					//Clicking on Location drop down
				Thread.sleep(3000);
				//performerPOM.clickPlus(driver).click();
				performerPOM.selectLocationCfo(driver).click();;
				//elementsList.get(2).click();								//Selecting third visible location
				}
				public static void clickCaseDepartment(WebDriver driver) throws InterruptedException
				{
				
				performerPOM.clickDeptCfo(driver).click();					//Clicking on 'Department' drop down
				performerPOM.selectDeptCfo(driver).click();	//Writing 'Department' name
				}
				public static void clickCaseOwner(WebDriver driver) throws InterruptedException
				{
				
				performerPOM.clickOwnerCfo(driver).click();					//Clicking on 'Owner' drop down
				performerPOM.selectOwnerCfo(driver).click();	//Writing 'Owner' name
				}
			  
			  
			  
			  

			 public  static void clickCaseRisk(WebDriver driver) throws InterruptedException 
			  { 
			    Thread.sleep(3000);
			    performerPOM.clickWinningProspect1(driver).click();
		 	   Thread.sleep(100);
		       performerPOM.selectRisk1(driver).click();			//Selecting 'Medium' Winning Prospect'
			  }
			
		 public  static void clickCaseInternalUser(WebDriver driver) throws InterruptedException 
			  { 
			       Thread.sleep(3000);
		            Row row0 = sheet.getRow(46);						//Selected 0th index row (First row)
			       Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			       int internalUserNo = (int) c1.getNumericCellValue();
			      performerPOM.clickInternalUser(driver).click();						//Clicking on 'Internal User' drop down.
			      elementsList = performerPOM.chooseInternalUser1(driver);
			       elementsList.get(internalUserNo).click();							//Selecting particular user no
			      performerPOM.clickInternalUser(driver).click();						//Clicking on 'Internal User' drop down.
			  }
		 
		 static void Document(WebDriver driver,ExtentTest test) throws InterruptedException
			{
	           			
			
	          WebDriverWait wait = new WebDriverWait(driver, 50);
	          

		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo(driver).click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice(driver).click();//click edit notice
				
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			  performerPOM.clickNoticeDocument(driver).click();     //click notice document
			  performerPOM.clickNewDocument(driver).click();        //click new document button
			
	 
				Thread.sleep(1000);
				driver.switchTo().frame("IFrameManageDocument");
				performerPOM.selectDocumentType(driver);
				Thread.sleep(3000);
				performerPOM.chooseDocumentType(driver);
				Thread.sleep(1000);
				performerPOM.selectUploadDocument(driver); 
				Thread.sleep(1000);
				performerPOM.clickUploadDocument(driver).click(); 
			
			
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg(driver)));
			
			  Thread.sleep(500);
			  String msg=performerPOM.readDocMsg(driver).getText();		//Reading Message appeared after save button
			  int flag = 0;
			  if(msg.equalsIgnoreCase("Document(s) uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 flag = 1;
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			
			  Thread.sleep(1000);
			  performerPOM.clickClosedDocument(driver).click(); 
			  Thread.sleep(3000);
			  
			  driver.switchTo().parentFrame();
			    Thread.sleep(3000);
		        performerPOM.clickCaseDownloadDocumentcfo(driver).click();
		        
		        test.log(LogStatus.PASS, "Document download succssesfully");
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentViewcfo(driver).click();
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentViewClosepopupcfo(driver).click();
		        
		        test.log(LogStatus.PASS, "Document View popup open  succssesfully");
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentdeletecfo(driver).click();
		        
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert = driver.switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage= driver.switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage);
		        
		 		
		        // Accepting alert		
		        alert.accept();	
		        
		       
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentsharecfo(driver).click();
		        
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = driver.switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage1= driver.switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert		
		        alert.accept();	
		        
		        
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentshareemailcfo(driver).sendKeys("admin@gmail.com");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharecontactnocfo(driver).sendKeys("5768798045");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharesavecfo(driver).click();
		        
		        
		        Thread.sleep(3000);
		        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo(driver).getText();		//Reading Message appeared after save button
		       
	         	if(msg1.equalsIgnoreCase("Document shared successfully."))
	         	{
		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		         
		        }
		      else
		        {
			       test.log(LogStatus.FAIL, "Message displayed = "+msg1);
		        }
		        
		        
		        driver.switchTo().parentFrame();
		        Thread.sleep(3000);
		        performerPOM. clickNoticeDocumentshareclosepopupcfo(driver).click();
		        
		        driver.switchTo().parentFrame();
		 }
		 
		 static void TaskActivity1(WebDriver driver, ExtentTest test,XSSFWorkbook workbook ) throws InterruptedException, IOException
			{
			    WebDriverWait wait=new WebDriverWait(driver,20);
			    
			    
		       XSSFSheet sheet=ReadExcel();

		      
			    Thread.sleep(3000);
			   
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    Thread.sleep(3000);
			    performerPOM.clickCaseTask(driver).click();
//			    Thread.sleep(300);
//			    performerPOM.clickCaseNewTask(driver).click(); 
//			    Thread.sleep(5000);
//			    performerPOM.clickHearingDate(driver).sendKeys("5-2-2023");
//			    Thread.sleep(3000);
//			    performerPOM.clickSaveHearingDatecfo(driver).click();
//			  
//			  
//				Thread.sleep(6000);
//				Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
//				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
//				String title = c1.getStringCellValue();
//				performerPOM.clickTaskTitle(driver).sendKeys(title);	//Writing 'Task Title'
//				
//				Thread.sleep(5000);
//				row0 = sheet.getRow(13);									//Selected 0th index row (First row)
//				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//				String desc = c1.getStringCellValue();
//				performerPOM.clickTaskDesc(driver).sendKeys(desc);		//Writing 'Task Description'
//				
//				
//				Thread.sleep(1000);
//				performerPOM.clickDueDate(driver).click();				//Clicking on 'Due Date' text box
//				OverduePOM.selectNextMonth(driver).click();
//				OverduePOM.selectDate(driver).click();					//Selecting particular date.
//				
//				Thread.sleep(1000);
//				Actions action = new Actions(driver);
////				action.moveToElement(performerPOM.clickPriority(driver)).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
//				
//				
//				Thread.sleep(1000);
//				row0 = sheet.getRow(14);									//Selected 0th index row (First row)
//				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//				String outcome = c1.getStringCellValue();
//				performerPOM.clickExpOutcome(driver).sendKeys(outcome);	//Writing 'Expected Outcome'
//				
//				
//				Thread.sleep(1000);
//				row0 = sheet.getRow(15);									//Selected 0th index row (First row)
//				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//				String internalUser = c1.getStringCellValue();
//				performerPOM.clickInternalUser3(driver).click();
//				//performerPOM.selectInternalUser2(driver).click();
//				performerPOM.selectInternalUser3(driver).sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
//				
//				Thread.sleep(1000);
//				row0 = sheet.getRow(16);									//Selected 0th index row (First row)
//				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//				String externalUser = c1.getStringCellValue();
//				try
//				{
//					Thread.sleep(300);
//					performerPOM.clickExternalUser(driver).click();
//					Thread.sleep(500);
//					action.moveToElement(performerPOM.clickSearchExternalUser(driver)).sendKeys(externalUser, Keys.ENTER).perform();
//				}
//				catch(Exception e)
//				{
//					
//				}
//				Thread.sleep(5000);
//				row0 = sheet.getRow(17);									//Selected 0th index row (First row)
//				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
//				String remark = c1.getStringCellValue();
//				performerPOM.clickRemark(driver).sendKeys(remark);		//Writing 'Remark'
//             	Thread.sleep(1000);
//				OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
//				
//				
//				Thread.sleep(300);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg(driver)));
//				
//				Thread.sleep(300);
//				String msg = performerPOM.readTaskMsg(driver).getText();
//				String msg1 = performerPOM.readTaskMsg1(driver).getText();
//				if(msg.contains("Task Saved Successfully."))
//				{
//					test.log(LogStatus.PASS, "Task Saved Successfully.");
//				}
//				
//				else if(msg.contains("Task with same title already exists."))
//				{
//					test.log(LogStatus.FAIL, "Task with same title already exists.");
//				}
				
				Thread.sleep(3000);
				performerPOM.clickNoticeEditTaskcfo(driver).click();
				
				Thread.sleep(3000);
				performerPOM.clickTaskTitle(driver).clear();
				
				Thread.sleep(3000);
				performerPOM.clickTaskTitle(driver).sendKeys("New Task 5 jan");	//Writing 'Task Title'
				
				Thread.sleep(3000);
				OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
				
//				Thread.sleep(300);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg(driver)));
				
//				Thread.sleep(300);
//				String msg2 = performerPOM.readTaskMsg(driver).getText();
//		
//				if(msg2.contains("Task Saved Successfully."))
//				{
//					test.log(LogStatus.PASS, "Task Saved Successfully.");
//				}
//				
//				else if(msg2.contains("Task with same title already exists."))
//				{
//					test.log(LogStatus.FAIL, "Task with same title already exists.");
//				}
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo1(driver).click();
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo(driver).click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo1(driver).click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskcmtResponsecfo(driver).sendKeys("Automate Test");
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskSaveResponsecfo(driver).click();
				
				
				
				test.log(LogStatus.PASS,"Task Response Saved Successfully.");
				
				driver.switchTo().parentFrame();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskCloseResponsecfo(driver).click();
				
                Thread.sleep(3000);
				performerPOM.clickNoticeTaskClosecfo1(driver).click();
				
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = driver.switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= driver.switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);
			        
			     // Accepting alert		
			        alert.accept();
				
			
				
			}
		 
		 static void CaseHearing(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
			       WebDriverWait wait=new WebDriverWait(driver,20);
			       XSSFSheet sheet=ReadExcel();
			       
			     
				   performerPOM.clickCaseHearing(driver).click();
//					Thread.sleep(3000);
//					performerPOM.clickNewCaseHearing(driver).click();
					
					
					
//					Thread.sleep(300);
//					Row row0 = sheet.getRow(35);					//Selected 0th index row (First row)
//					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//					int HearingDate = (int) c1.getNumericCellValue();
//					performerPOM.clickCaseHearingDate(driver).sendKeys(HearingDate+"");	//Writing 'HearingDate'
					
//					performerPOM.clickCaseHearingDate(driver).sendKeys("7-1-2023");	//Writing 'HearingDate'
//					
//				
//				    Thread.sleep(3000);
//				    performerPOM.clickSaveCaseHearingDate(driver).click();
//				
//					
//					Thread.sleep(2000);
//					Row row1 = sheet.getRow(50);									//Selected 0th index row (First row)
//					Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
//					String HearingDescription = c2.getStringCellValue();
//					performerPOM.clickCaseHearingDecsri(driver).sendKeys(HearingDescription);		//Writing 'HearingDescription'
//					
//				   
//					Thread.sleep(3000);
//				    performerPOM.clickSaveCaseHearing(driver).click();
				    
				    Thread.sleep(3000);
				    performerPOM.clickCaseHearingcfo(driver).click();
				    
				    
				    Thread.sleep(3000);
				    performerPOM.clickEditCaseHearingcfo(driver).click();
				    
				    Thread.sleep(3000);
				    performerPOM.clickCaseHearingDecsri(driver).clear();
				    Thread.sleep(3000);
				    performerPOM.clickCaseHearingDecsri(driver).sendKeys("Case Hearing 5 jan 2023");		//Writing 'HearingDescription'
				    
				    Thread.sleep(3000);
				    performerPOM.clickSaveCaseHearing(driver).click();
				    
				    test.log(LogStatus.PASS,"Hearing Details Saved Successfully.");
				    
				    Thread.sleep(3000);
				    performerPOM.clickDeleteCaseHearingcfo(driver).click();
				    
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert = driver.switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage= driver.switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);
				        
				     // Accepting alert		
				        alert.accept();
				    
				    
			} 
		 
			static void CaseOrder(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				 XSSFSheet sheet=ReadExcel();
				 
				
				 Thread.sleep(5000);
				 performerPOM.clickCaseOrder(driver).click();
//				 Thread.sleep(6000);
//				 performerPOM.clickNewCaseOrder(driver).click();
//				 Thread.sleep(6000);
//				 performerPOM. clickCaseOrderDate(driver).sendKeys("5-1-2023");
//				 Thread.sleep(3000);
//				 performerPOM.clickOrderPanel(driver).click();
//				 Thread.sleep(3000);
//				 performerPOM. clickCaseOrderType(driver).click();
//				 Thread.sleep(3000);
//				 performerPOM.selectCaseOrderType(driver).click();
//				
//				 
//				 
//					
//					Thread.sleep(300);
//					Row row0 = sheet.getRow(53);					//Selected 0th index row (First row)
//					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//					int OrderTitle = (int) c1.getNumericCellValue();
//					performerPOM.clickCaseOrderTitle(driver).sendKeys(OrderTitle+"");	//Writing 'HearingDate'
//					
//	 
//				 Thread.sleep(2000);
//				 Row row2 = sheet.getRow(54);									//Selected 0th index row (First row)
//				 Cell c2 = row2.getCell(1);									//Selected cell (0 row,1 column)
//				 String OrderDecri = c2.getStringCellValue();
//				 performerPOM.clickCaseOrderDecri(driver).sendKeys(OrderDecri);     //click oder description
//				
//
//				 Thread.sleep(3000);
//				 performerPOM.clickSaveCaseOrder(driver).click();
				 
				 
				 Thread.sleep(3000);
				 performerPOM.clickEditCaseOrdercfo(driver).click();
				 
				 performerPOM.clickCaseOrderTitle(driver).clear();
				 
				 performerPOM.clickCaseOrderTitle(driver).sendKeys("Order no 56");
				 
				 performerPOM.clickCaseOrderDecri(driver).clear();
				 
				 performerPOM.clickCaseOrderDecri(driver).sendKeys("order as on 5 jan 23");     //click oder description
				 
				 Thread.sleep(3000);
				 performerPOM.clickSaveCaseOrder(driver).click();
				 
				 
				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg(driver)));
					
					Thread.sleep(500);
					String msg3 = performerPOM.readResponseMsg(driver).getText();		//Reading Message appeared after save button
					int flag3 = 0;
					if(msg3.equalsIgnoreCase("Order Details Saved Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg3);
						flag3 = 1;
					}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg3);
						}
				 
				 Thread.sleep(3000);
				 performerPOM.clickDownloadCaseOrdercfo(driver).click();
				 
				
			      test.log(LogStatus.PASS, "Case Document Download Successfully");
			         
			        
		     	 Thread.sleep(3000);
				 performerPOM.clickViewCaseOrdercfo(driver).click();
				 
				 Thread.sleep(6000);
			     performerPOM.clickNoticeDocumentViewClosepopupcfo(driver).click();
			     
			     test.log(LogStatus.PASS,"Case View Document Popup Open Successfully");
			     
			     Thread.sleep(3000);
			     performerPOM.clickDeleteCaseOrdercfo(driver).click();
			     
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = driver.switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= driver.switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);
			        
			     // Accepting alert		
			        alert.accept();
				 
			}	 
			
			   static void StatusPayment(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			      {	
			    	       WebDriverWait wait=new WebDriverWait(driver,50);
			      
			    	       XSSFSheet sheet=ReadExcel();
			    	       
			    	    
			    	       
			               performerPOM.clickCaseStatusPayments(driver).click();		//Clicking on 'Status/Payments'
							
//							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus(driver)));
////							
//							Thread.sleep(3000);
//							Row row0 = sheet.getRow(58);					//Selected 0th index row (First row)
//							Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//							int InvoiceNo = (int) c1.getNumericCellValue();
//							performerPOM.clickCaseInvoiceNo1(driver).sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
//							
//						    
//						
//							
//							
//							
//							Thread.sleep(4000);
//							performerPOM.clickPaymentTyp1(driver);
//							List<WebElement> PaymentType1= driver.findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
//							PaymentType1.get(2).click();
//							
//							
//							Thread.sleep(10000);
//                            performerPOM.clickAmount1(driver).sendKeys("9000");	//Writing 'Amount'
//						
//				
//							Thread.sleep(3000);
//							performerPOM.clickSavePaymentLog1(driver).click();
//							
//							
//							   Thread.sleep(500);
//								String msg5 = performerPOM.readPymentmsg(driver).getText();		//Reading Message appeared after save button
//							
//								if(msg5.equalsIgnoreCase("Payment Details Deleted Successfully."))
//								{
//									test.log(LogStatus.PASS, "Message displayed = "+msg5);
//								
//								}
//								else
//								{
//									test.log(LogStatus.FAIL, "Message displayed = "+msg5);
//								}
//						        
							
							
							Thread.sleep(3000);
							performerPOM.clickViewPaymentDoccfo(driver).click();
							
							Thread.sleep(3000);
							performerPOM.clickNoticeclosePaymentDocpopupcfo(driver).click();
							
							test.log(LogStatus.PASS, "Payment Document popup open successfully");
							
							
						
							Thread.sleep(3000);
							performerPOM.clickEditPaymentDoccfo(driver).click();
							
							Thread.sleep(3000);
							performerPOM.clickCaseInvoiceNo1(driver).clear();
							 Thread.sleep(3000);
						    performerPOM.clickCaseInvoiceNo1(driver).sendKeys("Invoice No 578");
						    
						    Thread.sleep(6000);
							performerPOM.clickCaseStatusPaymentUploadtcfo(driver);
						    

							Thread.sleep(3000);
							performerPOM.clickSavePaymentLog1(driver).click();
							
							  Thread.sleep(500);
								String msg5 = performerPOM.readPymentmsg(driver).getText();		//Reading Message appeared after save button
							
								if(msg5.equalsIgnoreCase("Payment Details Saved Successfully."))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg5);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg5);
								}
							
							
							
							
							Thread.sleep(3000);
							performerPOM.clickDeletePaymentDoccfo1(driver).click();
							
							 Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 = driver.switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1= driver.switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);
						        
						     // Accepting alert		
						        alert1.accept();
						        
						        Thread.sleep(500);
								String msg6 = performerPOM.readPymentmsg(driver).getText();		//Reading Message appeared after save button
							
								if(msg6.equalsIgnoreCase("Payment Details Deleted Successfully."))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg6);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg6);
								}
						        
						        
							
							
							
						
			      }
			   static void CaseExternalLawyer(WebDriver driver,ExtentTest test) throws InterruptedException, IOException
			      {
				               
			    	           WebDriverWait wait=new WebDriverWait(driver,50);
							  Thread.sleep(3000);
							   performerPOM. clickExternalLawyerRating1(driver).click();
							   
//							   Thread.sleep(4000);
//							   performerPOM.selectCaseExternalLawyer(driver);
							   
							  Thread.sleep(3000);
							  performerPOM.selectExternalLawyerRating(driver);
							   Thread.sleep(3000);
							   performerPOM.clickNewCriteria(driver).click();
							   Thread.sleep(3000);
							   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
							   performerPOM.clickCriteria(driver).sendKeys("Test Automate  New");
							   Thread.sleep(3000);
							   performerPOM.clickSaveCriteria(driver).click();
							   Thread.sleep(3000);
							   driver.switchTo().parentFrame();
							   performerPOM.clickclosecriteria(driver).click();
							   Thread.sleep(3000);
							   performerPOM. clickstar(driver).click();
						       Thread.sleep(3000);
							   performerPOM. clickstar1(driver).click();
							   Thread.sleep(3000);
							   performerPOM. clickSaveRating(driver).click();
							   
							   
						   	  Thread.sleep(1000);
							 wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg(driver)));
										
								Thread.sleep(500);
								String msg5 = performerPOM.readRatingmsg(driver).getText();		//Reading Message appeared after save button
								int flag5= 0;
								if(msg5.equalsIgnoreCase("Rating Saved Successfully."))
									{
											test.log(LogStatus.PASS, "Message displayed = "+msg5);
											flag5 = 1;
									}
								else
									{
											test.log(LogStatus.FAIL, "Message displayed = "+msg5);
									}
							   
					  }	   
				   
			      static void Auditlog(WebDriver driver,ExtentTest test) throws InterruptedException
			      {
							   Thread.sleep(3000);
							   performerPOM. clickAuditLog(driver).click();
							   Thread.sleep(3000);
							   performerPOM.clickExport(driver).click();		   
							   Thread.sleep(3000);
							   driver.switchTo().parentFrame();
							   performerPOM.clickclosebutton(driver).click();
							   
							   test.log(LogStatus.PASS,"Audit Detail Report Download successfully");
			      }	 
			      
			  	public static void LinkDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(driver, 180);
					progress(driver);
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
					if(type.equals("Notice"))
					{
						performerPOM.clickNoticeOpen(driver).click();							//Clicking on 'Open' notice
					}
					else if(type.equals("Case"))
					{
						performerPOM.clickCaseOpencfo(driver).click();								//Clicking on 'Open' case
					}
					
					progress(driver);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport(driver)));
					
					Thread.sleep(400);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)");
					
					Thread.sleep(1500);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));
					//performerPOM.GridLoad(driver).click();
					elementsList = performerPOM.clickAction(driver);			//Getting all action buttons.
					js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
					
					Thread.sleep(600);
					elementsList = performerPOM.clickAction(driver);			//Getting all action buttons.
					elementsList.get(0).click();								//Clicking on first action button.
					
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame		
					if(type.equals("Notice"))
					{
						performerPOM.clickLinkNotice(driver).click();			//Clicking on Link Notice icon
						
						Thread.sleep(300);
						progress(driver);
						
						Thread.sleep(300);
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCheckBox(driver)));	//Waiting for Checkbox to get visible.
						
						Thread.sleep(3000);
						performerPOM.clickCheckBox(driver).click();			//CLicking on first checkbox
					}
					else if(type.equals("Case"))
					{
						performerPOM.clickLinkCase(driver).click();			//Clicking on Link Notice icon
						
						Thread.sleep(300);
						progress(driver);
						
						Thread.sleep(300);
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCaseCheckBox(driver)));	//Waiting for Checkbox to get visible.

						
						Thread.sleep(300);
						performerPOM.clickCaseCheckBox(driver).click();		//CLicking on first checkbox
					}
					
					Thread.sleep(300);
					if(type.equals("Case"))
					{
						performerPOM.clickApply(driver).sendKeys(Keys.PAGE_DOWN);
					}
					else
					{
						performerPOM.clickApply1(driver).sendKeys(Keys.PAGE_DOWN);
					}
					
					Thread.sleep(300);
					performerPOM.clickSave(driver).click();				//Clicking on Save button.
					
					Thread.sleep(300);
					progress(driver);
					
					Thread.sleep(500);
					try
					{
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.readMsg(driver)));
					}
					catch(Exception e)
					{
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.readMsg(driver)));
					}
					Thread.sleep(300);
					String msg = performerPOM.readMsg(driver).getText();
					if(msg.contains("Linked Successfully"))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg);
					}
					
					
					if(type.equals("Notice"))
					{
						performerPOM.clickClosePopup(driver).click();
						
						Thread.sleep(300);
						performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_DOWN);
						
						
						

					}
					else if(type.equals("Case"))
					{
						performerPOM.clickClosePopupCase(driver).click();
						
						Thread.sleep(300);
						performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_DOWN);


					}

						
						

					if(type.equals("Notice"))
					{
						performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_UP);
					}
					else if(type.equals("Case"))
					{
						performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_UP);
					}
					
					
					Thread.sleep(300);
					driver.switchTo().parentFrame();
					performerPOM.clickClose(driver).click();
					
			
					
					Thread.sleep(500);
				
					OverduePOM.clickDashboard(driver).click();
					}
				
			  	
			  	public static void AdvancedSearchWorkspace(WebDriver driver,ExtentTest test) throws InterruptedException
				{
					Thread.sleep(3000);
					performerPOM.clickMyWorkspace(driver).click();
					
					Thread.sleep(3000);
					performerPOM.clickCaseNotice1(driver).click();
					
					WebDriverWait wait=new WebDriverWait(driver,30);
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
					
					Thread.sleep(5000);
					
					performerPOM.AdvancedSearchReports(driver).click();
					
				//-------------------------------------------Notice--------------------------------------------------
					
					Thread.sleep(4000);
					performerPOM.startDate(driver).sendKeys("05/4/2022");
					
					Thread.sleep(4000);
					performerPOM.endDate(driver).sendKeys("05/7/2022");
					
					Thread.sleep(4000);
					performerPOM.clickApplyButton(driver).click();
					
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
					
					
					Thread.sleep(5000);
					performerPOM.clickExportAdavanced(driver).click();
					test.log(LogStatus.PASS, "File downloaded successfully.");
					
					
					Thread.sleep(4000);
					performerPOM.clickeditButton(driver).click();
					
					test.log(LogStatus.PASS,"edit notice details icon open successfully");
					
					
					Thread.sleep(5000);
					performerPOM.Actionclosepopup(driver).click();
					
					

				      //-------------------------------------------Case--------------------------------------------------
						Thread.sleep(4000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						Thread.sleep(4000);
						performerPOM.clickTypeDropdown1(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(4000);
						performerPOM.selectTypeCase1(driver).click();
						
						Thread.sleep(4000);
						performerPOM.clickApplyButton(driver).click();
						
						Thread.sleep(3000);
						performerPOM.clickExportAdavanced(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "File downloaded successfully.");
					
						Thread.sleep(4000);
						performerPOM.clickeditButton(driver).click();
						
						test.log(LogStatus.PASS,"edit case details icon open successfully");
						
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup(driver).click();
						
						
						
			          //-------------------------------------------Task--------------------------------------------------
							Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						
						Thread.sleep(5000);
						performerPOM.clickTypeDropdown1(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(5000);
						performerPOM.selectTypeTask1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "File downloaded successfully.");
						
						Thread.sleep(5000);
						performerPOM.viewTaskDetails1(driver).click();	
						test.log(LogStatus.PASS, "Show details Task popup open successfully.");
						
						Thread.sleep(6000);
						performerPOM.ActioncloseTaskpopup(driver).click();
						
						Thread.sleep(500);
						OverduePOM.clickDashboard(driver).click();
					        
				}
			  	
			  	public static void WorkspaceFilter(WebDriver driver,ExtentTest test) throws InterruptedException
				{
					WebDriverWait wait=new WebDriverWait(driver,20);
					Thread.sleep(5000);
					performerPOM.clickMyWorkspace(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickCaseNotice1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clicklocationFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickLocationFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickLocationFiltercfo(driver).click();
					
					
					Thread.sleep(5000);
					performerPOM.clickDepartmentFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDepartFiltercfo(driver).click();
					
//					Thread.sleep(5000);
//					performerPOM.clickFinancialYear2(driver).click();
//					
//					Thread.sleep(5000);
//					performerPOM.clickFinancialYear3(driver).click();
					
					
//		         	Thread.sleep(5000);
//					performerPOM.clickCalenderYear2(driver).click();
//					
//					Thread.sleep(5000);
//					performerPOM.clickCalenderYear3(driver).click();
	
					
			     	Thread.sleep(5000);
					performerPOM.clickstatus(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickstatus1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickcategory(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickCategoryFiltercfo(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickType1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTypeFiltercfo(driver).click();
					
					test.log(LogStatus.PASS, "My Workspace = Notice Filters Work Successfully");
					
					Thread.sleep(5000);
					performerPOM.clickDropdown(driver).click();
					
					Thread.sleep(5000);
					performerPOM.selectTypeCase(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickcategory(driver).click();
					
					
					Thread.sleep(5000);
					performerPOM.clickCategoryFiltercfo1(driver).click();
					
					test.log(LogStatus.PASS, "My Workspace = Case  Filters Work Successfully");
					

					Thread.sleep(5000);
					performerPOM.selectApplyBtn(driver).click();
					
					Thread.sleep(7000);
					performerPOM.clickDropdown(driver).click();
					
					Thread.sleep(7000);
					performerPOM.selectTypeTask(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskLocFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickLocationFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskLocFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskPriorityFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskPriorityFiltercfo(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskStatusFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskStatusFiltercfo(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskPeriodFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickTaskPeriodFilter1(driver).click();
					
					
					Thread.sleep(6000);
					performerPOM.clearButton(driver).click();
					
					test.log(LogStatus.PASS, "My Workspace = Task Filters Work Successfully");
					
					Thread.sleep(5000);
					performerPOM.clickMyWorkspace(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickCaseHearing1(driver).click();
					
					
					Thread.sleep(5000);
					performerPOM.clickSearchFilter(driver).sendKeys("ASL Training 2021");
					
					Thread.sleep(5000);
					performerPOM.clearButton(driver).click();
					
					
					Thread.sleep(5000);
					performerPOM.CaseHearingView(driver).click();
					
					Thread.sleep(5000);
					performerPOM.CaseHearingPopupClose(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clearButton(driver).click();
					test.log(LogStatus.PASS, "My Workspace = Case Hearing Filters Work Successfully");
					}
			  	
				public static void DocumentFilter(WebDriver driver,ExtentTest test, String type) throws InterruptedException
				{
					WebDriverWait wait=new WebDriverWait(driver,20);
						progress(driver);
					
					//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
					performerPOM.clickMyDocument(driver).click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument(driver).click();	                    //Clicking on 'My Document'
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
					
					Thread.sleep(7000);
					performerPOM.clickDocStatusFilter(driver).click();
					
					Thread.sleep(8000);
					performerPOM.clickDocStatusFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTypeFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTypeFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocLocFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickLocationFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocLocFilter2(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocDeptFilter(driver).click();
					
					Thread.sleep(7000);
					performerPOM.clickDocDeptFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clearButton(driver).click();
					test.log(LogStatus.PASS, "My Document = Case Filters Work Successfully");
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
					
					Thread.sleep(7000);
					performerPOM.clickDocDropdownFilter(driver).click();
					
					Thread.sleep(3000);
					performerPOM.selectTypeCase(driver).click();
					
					Thread.sleep(7000);
					performerPOM.clickDocStatusFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocStatusFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTypeFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTypeFilter2(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocLocFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickLocationFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocLocFilter3(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocDeptFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocDeptFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clearButton(driver).click();
					
					
					test.log(LogStatus.PASS, "My Document = Notice Filters Work Successfully");
					
					Thread.sleep(7000);
					performerPOM.clickDocDropdownFilter(driver).click();
					
					Thread.sleep(8000);
					performerPOM.selectTypeTask(driver).click();
					
					Thread.sleep(6000);
					performerPOM.clickDocStatusFilter(driver).click();
					
					Thread.sleep(6000);
					performerPOM.clickDocStatusFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTaskPriorityFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTaskPriorityFilter2(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocLocFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickLocationFilter1(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocLocFilter2(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTaskFilter(driver).click();
					
					Thread.sleep(5000);
					performerPOM.clickDocTaskFilter1(driver).click();
					
					
					Thread.sleep(5000);
					performerPOM.clearButton(driver).click();
					
					test.log(LogStatus.PASS, "My Document = Task Filters Work Successfully");
					
					}	
			  	
				public static void MyDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(driver, 60);
					progress(driver);
					
					//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
					performerPOM.clickMyDocument(driver).click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument(driver).click();	                    //Clicking on 'My Document'
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
					
					//--------------------------------Case----------------------------------
					       Thread.sleep(4000);
					       performerPOM.clickDownloadDocument(driver).click();	
					       Thread.sleep(4000);
					       performerPOM.clickViewDocument(driver).click();	
					       Thread.sleep(3000);
					       performerPOM.clickcloseViewDocument(driver).click();
						
					       Thread.sleep(3000);
					       test.log(LogStatus.PASS, "Document  View Successfully.");
					       test.log(LogStatus.PASS, "Document  Downloaded Successfully.");
							
							//driver.navigate().refresh();
				
					//--------------------------------Notice----------------------------------
			 
					       Thread.sleep(5000);
						    JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("window.scrollBy(500,0)");
							Thread.sleep(3000);
							performerPOM.clickTypeDropdown(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
							Thread.sleep(6000);
							performerPOM.selectTypeCase(driver).click();					//Selecting 'Case' option.
							 Thread.sleep(4000);
						       performerPOM.clickDownloadDocument(driver).click();	
						       Thread.sleep(4000);
						       performerPOM.clickViewDocument(driver).click();	
						       Thread.sleep(4000);
						       performerPOM.clickcloseViewDocument(driver).click();
						       
						       Thread.sleep(3000);
						       test.log(LogStatus.PASS, "Document view Successfully.");
						       test.log(LogStatus.PASS, "Document Downloaded Successfully.");
								//driver.navigate().refresh();
											
			          ////--------------------------------Task----------------------------------
							
						    
							Thread.sleep(5000);
							performerPOM.clickTypeDropdown(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
							Thread.sleep(5000);
							performerPOM.selectTypeTask(driver).click();					//Selecting 'Task' option.
							
							 Thread.sleep(4000);
						     performerPOM.clickDownloadDocument(driver).click();	
						     Thread.sleep(5000);
						     performerPOM.clickViewDocument(driver).click();	
						     Thread.sleep(3000);
						     performerPOM.clickcloseViewDocument(driver).click();

						     Thread.sleep(1000);
						     test.log(LogStatus.PASS, "Document view Successfully.");
						     test.log(LogStatus.PASS, "Document  Downloaded Successfully.");
						     
						     driver.navigate().refresh();
						       
						       Thread.sleep(1000);
							   OverduePOM.clickDashboard(driver).click();				//Clicking on 'My Dashboard'
						     
						    
				}   
				
				 public static void AdvancedSearchDocument(WebDriver driver, ExtentTest test) throws InterruptedException, IOException
				   {
						 		WebDriverWait wait = new WebDriverWait(driver, 60);
						 		progress(driver);
						 		
						 		//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
						 		performerPOM.clickMyDocument(driver).click();					//Clicking on 'My Document'
						 		performerPOM.clickmyDocument(driver).click();	                    //Clicking on 'My Document'
						 		
						 		Thread.sleep(3000);
						 		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						 		
							  //--------------------------------Case----------------------------------
								
							 Thread.sleep(3000);
							 performerPOM.AdvancedSearchReports(driver).click();
						      Thread.sleep(4000);
						       performerPOM.clickDownloadDocument1(driver).click();	
						       Thread.sleep(4000);
						       performerPOM.clickViewDocument1(driver).click();	
						       Thread.sleep(10000);
						       performerPOM.clickcloseViewDocument1(driver).click();
							
						       Thread.sleep(3000);
						       test.log(LogStatus.PASS, "Advanced Search-Document  View Successfully.");
						       test.log(LogStatus.PASS, "Advanced Search-Document  Downloaded Successfully.");
								
							
					
								//--------------------------------Notice----------------------------------
				 
								
								Thread.sleep(5000);
								performerPOM.clickTypeDropdown2(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
								Thread.sleep(5000);
								performerPOM.selectTypeCase2(driver).click();					//Selecting 'Case' option.
								 Thread.sleep(4000);
							       performerPOM.clickDownloadDocument1(driver).click();	
							       Thread.sleep(4000);
							       performerPOM.clickViewDocument1(driver).click();	
							       Thread.sleep(10000);
							       performerPOM.clickcloseViewDocument1(driver).click();
							       
							       Thread.sleep(3000);
							       test.log(LogStatus.PASS, "Advanced Search-Document view Successfully.");
							       test.log(LogStatus.PASS, "Advanced Search-Document Downloaded Successfully.");
									
												
				               ////--------------------------------Task----------------------------------
								
							   
								Thread.sleep(5000);
								performerPOM.clickTypeDropdown2(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
								Thread.sleep(5000);
								performerPOM.selectTypeTask2(driver).click();					//Selecting 'Task' option.
								
								 Thread.sleep(4000);
							     performerPOM.clickDownloadDocument1(driver).click();	
							     Thread.sleep(4000);
							     performerPOM.clickViewDocument1(driver).click();	
							     Thread.sleep(10000);
							     performerPOM.clickcloseViewDocument1(driver).click();

							     Thread.sleep(1000);
							     test.log(LogStatus.PASS, "Advanced Search-Document view Successfully.");
							     test.log(LogStatus.PASS, "Advanced Search-Document  Downloaded Successfully.");
							     
						         driver.navigate().refresh();
						       
						       Thread.sleep(1000);
							   OverduePOM.clickDashboard(driver).click();				//Clicking on 'My Dashboard'
				}
				 
				 public static void ReportFilter(WebDriver driver,ExtentTest test) throws InterruptedException
					{
						WebDriverWait wait=new WebDriverWait(driver,20);
							
						progress(driver);
						
					
						performerPOM.clickMyReports(driver).click();					//Clicking on 'My Reports'
						
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						
						Thread.sleep(7000);
						performerPOM.clickReportStatusFilter(driver).click();
						
						Thread.sleep(7000);
						performerPOM.clickReportStatusFilter1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportDeptFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportDeptFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportTypeFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportTypeFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportCategoryFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportCategoryFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportLocFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickLocationFilter1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportLocFiltercfo(driver).click();
						
//						Thread.sleep(5000);
//						performerPOM.clickReportFYFilter(driver).click();
//						
//						Thread.sleep(5000);
//						performerPOM.clickReportFYFilter1(driver).click();
						
//						Thread.sleep(7000);
//						performerPOM.clickReportCYFilter(driver).click();
//						
//						Thread.sleep(7000);
//						performerPOM.clickReportCYFilter1(driver).click();
						
						Thread.sleep(3000);
						performerPOM.clearButton(driver).click();
						test.log(LogStatus.PASS,"My Report = Notice Filter Work successfully");
						
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table 
						
						Thread.sleep(7000);
						performerPOM.clickTypeDropdown(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						
						Thread.sleep(7000);
						performerPOM.selectTypeCase(driver).click();	
						
						Thread.sleep(7000);
						performerPOM.clickReportStatusFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportStatusFilter1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportDeptFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportDeptFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportTypeFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportTypeFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportCategoryFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportCategoryFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportLocFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickLocationFilter1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportLocFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportFYFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportFYFilter1(driver).click();
						
//						Thread.sleep(5000);
//						performerPOM.clickReportCYFilter(driver).click();
//						
//						Thread.sleep(5000);
//						performerPOM.clickReportCYFilter1(driver).click();
						
						Thread.sleep(4000);
						performerPOM.clearButton(driver).click();
						test.log(LogStatus.PASS,"My Report =Case Filter Work successfully");
						
						
						Thread.sleep(5000);
						performerPOM.clickTypeDropdown(driver).click();	
						
						Thread.sleep(5000);
						performerPOM.selectTypeTask(driver).click();
						
//						Thread.sleep(5000);
//						performerPOM.clickReportLocFilter(driver).click();
//						
//						Thread.sleep(5000);
//						performerPOM.clickLocationFilter1(driver).click();
//						
//						Thread.sleep(5000);
//						performerPOM.clickReportLocFiltercfo(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportprioFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportprioFilter1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportstatusFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportstatusFilter1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportFilter(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickReportFilter1(driver).click();
						Thread.sleep(4000);
						performerPOM.clearButton(driver).click();
						
						test.log(LogStatus.PASS, "My Report = Task Filters Work Successfully");
						
						Thread.sleep(500);
						OverduePOM.clickDashboard(driver).click();
						
				  }
				 static void Report(WebDriver driver, ExtentTest test, int count1, String type) throws InterruptedException, IOException
					{
						Thread.sleep(700);
						File dir = new File("C://Users//Admin//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
						Thread.sleep(300);
						performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
						
						Thread.sleep(6000);
						File dir1 = new File("C://Users//Admin//Downloads");
						File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
						
						if(dirContents.length < allFilesNew.length)
						{
							test.log(LogStatus.PASS, "File Downloaded Successfully.");
							
							File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
						    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
						    {
						       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
						       {
						           lastModifiedFile = allFilesNew[i];
						       }
						    }
							
							Thread.sleep(3000);
							fis = new FileInputStream(lastModifiedFile);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
							int no = sheet.getLastRowNum();
							int SheetRecords = 0;
							for(int i = 0; i <= 5; i++)
							{
								Row row = sheet.getRow(no-i);
								Cell c1 = row.getCell(0);
								String records = c1.getStringCellValue();
								if(records.equals("") || records.equals(null))
								{
									
								}
								else
								{
									SheetRecords = Integer.parseInt(records);
									break;
								}
							}
							fis.close();
							
							if(count1 == SheetRecords)
							{
								test.log(LogStatus.PASS, type+" - No of records displayed matches to no of records in Excel Sheet.");
								test.log(LogStatus.INFO, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
							}
							else
							{
								test.log(LogStatus.FAIL, type+" - No of records displayed doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.INFO, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, type+" - File doesn't downloaded successfully.");
						}
					}
				 
				 public static void MyReports(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait(driver, 60);
						progress(driver);
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
						performerPOM.clickMyReports(driver).click();					//Clicking on 'My Reports'
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						//--------------------------------Notice----------------------------------
						
						Thread.sleep(2000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickExcelReport(driver).sendKeys(Keys.END);
						js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1(driver));
						
						Thread.sleep(3000);
						CFOcountPOM.readTotalItems1(driver).click();
						String item = CFOcountPOM.readTotalItems1(driver).getText();
						String[] bits = item.split(" ");								//Splitting the String
						if(bits.length < 2)
						{
							performerPOM.clickExcelReport(driver).sendKeys(Keys.END);
							Thread.sleep(3000);
							item = CFOcountPOM.readTotalItems1(driver).getText();
							bits = item.split(" ");									//Splitting the String
						}
						String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						int count1 = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							Thread.sleep(3000);
							item = CFOcountPOM.readTotalItems1(driver).getText();
							bits = item.split(" ");										//Splitting the String
							compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
						}
						else if(compliancesCount.equalsIgnoreCase("to"))
						{
							count1 = 0;
						}
						else
						{
							count1 = Integer.parseInt(compliancesCount);
						}
						Thread.sleep(500);
						Report(driver, test, count1, "Notice");

//						Thread.sleep(10000);
//						performerPOM.viewNoticeDetails1(driver).click();
//						test.log(LogStatus.PASS, "Show details Notice popup open successfully.");
//						
//						
//						Thread.sleep(5000);
//						performerPOM.Actionclosepopup1(driver).click();
//						
//						Thread.sleep(5000);
//						performerPOM.showResponseDetailIcon1(driver).click();
//						test.log(LogStatus.PASS, "Show response details Notice  popup open successfully.");
//						
//						Thread.sleep(5000);
//						performerPOM.Actionclosepopup1(driver).click();
						
						driver.navigate().refresh();
						
						//--------------------------------Case----------------------------------
						
						Thread.sleep(1500);
						js.executeScript("window.scrollBy(500,0)");
						
						performerPOM.clickTypeDropdown(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(3000);
						performerPOM.selectTypeCase(driver).click();					//Selecting 'Case' option.
						
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						Thread.sleep(500);
						performerPOM.clickExcelReport(driver).sendKeys(Keys.END);
						js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.clickNextPage1(driver));
						js.executeScript("window.scrollBy(0,500)");
						
						Thread.sleep(1000);
						item = CFOcountPOM.readTotalItems1(driver).getText();
						bits = item.split(" ");									//Splitting the String
						if(bits.length < 2)
						{
							performerPOM.clickExcelReport(driver).sendKeys(Keys.END);
							Thread.sleep(300);
							item = CFOcountPOM.readTotalItems1(driver).getText();
							bits = item.split(" ");									//Splitting the String
							
						}
						compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						count1 = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							Thread.sleep(2500);
							item = CFOcountPOM.readTotalItems1(driver).getText();
							bits = item.split(" ");										//Splitting the String
							compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
						}
						else if(compliancesCount.equalsIgnoreCase("to"))
						{
							count1 = 0;
						}
						else
						{
							count1 = Integer.parseInt(compliancesCount);
						}
						
						
						
//						
//						Thread.sleep(5000);
//						performerPOM.viewNoticeDetails1(driver).click();
//						test.log(LogStatus.PASS, "Show details Case popup open successfully.");
//						
//						Thread.sleep(5000);
//						performerPOM.Actionclosepopup1(driver).click();
//						
//						Thread.sleep(5000);
//						performerPOM.showResponseDetailIcon1(driver).click();
//						test.log(LogStatus.PASS, "Show response details Case popup open successfully.");
//						
//						Thread.sleep(5000);
//						performerPOM.Actionclosepopup1(driver).click();
						
						Thread.sleep(500);
						Report(driver, test, count1, "Case");
						
						driver.navigate().refresh();

						//--------------------------------Task----------------------------------
						
						Thread.sleep(1500);
						js.executeScript("window.scrollBy(500,0)");
						
						performerPOM.clickTypeDropdown(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(300);
						performerPOM.selectTypeTask(driver).click();					//Selecting 'Task' option.
						
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						Thread.sleep(500);
						performerPOM.clickExcelReport(driver).sendKeys(Keys.END);
						js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1(driver));
						
						Thread.sleep(1000);
						item = CFOcountPOM.readTotalItems1(driver).getText();
						bits = item.split(" ");								//Splitting the String
						if(bits.length < 2)
						{
							performerPOM.clickExcelReport(driver).sendKeys(Keys.END);
							Thread.sleep(300);
							item = CFOcountPOM.readTotalItems1(driver).getText();
							bits = item.split(" ");									//Splitting the String
							
						}
						compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						count1 = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							count1 = 0;
						}
						else
						{
							count1 = Integer.parseInt(compliancesCount);
						}
//						
//						Thread.sleep(5000);
//						performerPOM.viewTaskDetails(driver).click();	
//						test.log(LogStatus.PASS, "Show details Task popup open successfully.");
//						
//						Thread.sleep(5000);
//						performerPOM.ActioncloseTaskpopup(driver).click();
						
						Thread.sleep(500);
						Report(driver, test, count1, "Task");
						
						
					}

					public static void AdvancedSearchReport(WebDriver driver,ExtentTest test) throws InterruptedException
					{
						WebDriverWait wait=new WebDriverWait(driver,180);
						
						Thread.sleep(500);
				        performerPOM.clickMyReports(driver).click();					//Clicking on 'My Reports'
				        
				        
				        Thread.sleep(500);
				        performerPOM.clickExcelReport1(driver).click();
				        test.log(LogStatus.PASS, "Usage Report downloaded successfully.");
						
						Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						Thread.sleep(5000);
						
						performerPOM.AdvancedSearchReports(driver).click();
						
					//-------------------------------------------Notice--------------------------------------------------
						
						Thread.sleep(4000);
						performerPOM.startDate(driver).sendKeys("05/01/2022");
						
						Thread.sleep(4000);
						performerPOM.endDate(driver).sendKeys("05/04/2022");
						
						Thread.sleep(4000);
						performerPOM.clickApplyButton(driver).click();
						
						
						Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						
						Thread.sleep(5000);
						performerPOM.clickExportAdavanced(driver).click();
						test.log(LogStatus.PASS, "File downloaded successfully.");
						
						
						Thread.sleep(5000);
						performerPOM.viewNoticeDetails(driver).click();
						test.log(LogStatus.PASS, "Show details notice popup open successfully.");
						
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup(driver).click();
						
						Thread.sleep(5000);
						performerPOM.showResponseDetailIcon(driver).click();
						test.log(LogStatus.PASS, "Show response details notice popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup(driver).click();
						
					//-------------------------------------------Case--------------------------------------------------
						Thread.sleep(4000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						Thread.sleep(4000);
						performerPOM.clickTypeDropdown1(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(4000);
						performerPOM.selectTypeCase1(driver).click();
						
						Thread.sleep(3000);
						performerPOM.clickExportAdavanced(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "File downloaded successfully.");
					
						Thread.sleep(5000);
						performerPOM.viewNoticeDetails(driver).click();
						test.log(LogStatus.PASS, "Show details case popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup(driver).click();
						
						Thread.sleep(5000);
						performerPOM.showResponseDetailIcon(driver).click();
						test.log(LogStatus.PASS, "Show response details Case popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup(driver).click();
						
					//-------------------------------------------Task--------------------------------------------------
							Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
						
						
						Thread.sleep(8000);
						performerPOM.clickTypeDropdown1(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(8000);
						performerPOM.selectTypeTask1(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "File downloaded successfully.");
						
						
						Thread.sleep(5000);
						performerPOM.viewTaskDetails(driver).click();	
						test.log(LogStatus.PASS, "Show details Task popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.ActioncloseTaskpopup(driver).click();
						
						Thread.sleep(500);
						OverduePOM.clickDashboard(driver).click();
					}
					public static void MoreReport(WebDriver driver, ExtentTest test) throws InterruptedException
					{
						
						WebDriverWait wait = new WebDriverWait(driver, 180);
						
						Thread.sleep(3000);
						performerPOM.clickMyReports(driver).click();
						
						Thread.sleep(5000);
						performerPOM.clickMoreReports(driver).click();
						//--------------------------------Case Report------------------------------------------
						Thread.sleep(3000);
						performerPOM.clicklocationFilterReports(driver).click();
						
						Thread.sleep(3000);
						performerPOM.selectlocationFilterReportscfo(driver).click();
						
						Thread.sleep(3000);
						performerPOM.FromDateReports(driver).sendKeys("01-12-2022");
						
//						Thread.sleep(3000);
//						performerPOM.selectFromDate(driver).click();
						
						Thread.sleep(3000);
						performerPOM.ToDateReports(driver).sendKeys("21-12-2022");
						
//						Thread.sleep(3000);
//						performerPOM.selectToDate(driver).click();
						
						
						//--------------------------MIS Report------------------------------
						
					    Thread.sleep(100);
						File dir = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.MISReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "MIS Report downloaded successfully.");
						
						
					    //--------------------------closed Cases Reports------------------------------
						
						Thread.sleep(100);
						File dir1 = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.closedCasesReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "closed Cases Reports downloaded successfully.");
						
						
					    //--------------------------Ext LawyerPerformance Reports------------------------------
						
						Thread.sleep(100);
						File dir2 = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.ExtLawyerPerformanceReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Ext Lawyer Performance Reports downloaded successfully.");
						
						
						//--------------------------Budget Reports-----------------------------------
						
						
						Thread.sleep(100);
						File dir3 = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.BudgetReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Budget Reports downloaded successfully.");
						
						
						//--------------------------Lawyer Details Reports------------------------------
						
						
						
						Thread.sleep(100);
						File dir4 = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.LawyerDetailsReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Lawyer Details Reports downloaded successfully.");
						
						//--------------------------Case Payment Reports------------------------------
						
						
						Thread.sleep(100);
						File dir5 = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.CasePaymentReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case Payment Reports downloaded successfully.");

						
					//--------------------------Case Hearing Reports------------------------------
						
						
						Thread.sleep(100);
						File dir6 = new File("C://Users//Admin//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.CaseHearingReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case Hearing Reports downloaded successfully.");

						
						//--------------------------CourtCaseReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir7 = new File("C://Users//Admin//Downloads");
					 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.CourtCaseReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Court Case Reports downloaded successfully.");

						
						//--------------------------CourtOrderReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir8 = new File("C://Users//Admin//Downloads");
					 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.CourtOrderReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Court Order Reports downloaded successfully.");
						
						
						//-------------------------CourtDoumentReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir9 = new File("C://Users//Admin//Downloads");
					 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.CourtDoumentReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Court Doument Reports downloaded successfully.");
						
						//-------------------------noticeCovertedToCaseReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir10 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.noticeCovertedToCaseReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "notice Coverted To Case Reports downloaded successfully.");
					
						
						//-------------------------AllReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir11 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.AllReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "All Reports downloaded successfully.");
					
						
					
						//----------------------------------------Notice Report------------------------------------------------
						
						Thread.sleep(3000);
						performerPOM.clickNoticeReport(driver).click();
						
						
						Thread.sleep(3000);
						performerPOM.clicklocationFilterReports(driver).click();
						
						Thread.sleep(3000);
						performerPOM.selectlocationFilterReportscfo(driver).click();
						
						Thread.sleep(3000);
						performerPOM.FromDateReports(driver).sendKeys("01-12-2022");
						
//						Thread.sleep(3000);
//						performerPOM.selectFromDate(driver).click();
						
						Thread.sleep(3000);
						performerPOM.ToDateReports(driver).sendKeys("21-12-2022");
						
						//------------------------MISReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir15 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.MISReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "MIS Reports downloaded successfully.");
						
						
						//------------------------closedCasesReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir20 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.closedCasesReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "closed Cases Reports downloaded successfully.");
						
						
						
					
						//------------------------MISReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir19 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.MISReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "MIS All Reports downloaded successfully.");
						
						
						//------------------------ExtLawyerPerformanceReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir18 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.ExtLawyerPerformanceReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Ext Lawyer Performance Reports downloaded successfully.");
						
						
						
						
						//------------------------BudgetReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir17 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.BudgetReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Budget Reports downloaded successfully.");
						
						
						
						
						//------------------------clickNoticePaymentReport------------------------------
						
						
						 Thread.sleep(100);
						 File dir16 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.LawyerDetailsReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Lawyer Details downloaded successfully.");
						
						
						//------------------------clickNoticePaymentReport------------------------------
						
						
						 Thread.sleep(100);
						 File dir13 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.clickNoticePaymentReport(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice Payment Report downloaded successfully.");
						
						
						
						//------------------------clickNoticeResponseReport------------------------------
						
						
						 Thread.sleep(100);
						 File dir14 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.clickNoticeResponseReport(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice Response Report downloaded successfully.");
						
							
						
						
						//-------------------------AllReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir12 = new File("C://Users//Admin//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.AllReports(driver).click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, " All Report downloaded successfully.");
						
						
						Thread.sleep(500);
						OverduePOM.clickDashboard(driver).click();
						
					}

					
				
				
						 
				
		
}
