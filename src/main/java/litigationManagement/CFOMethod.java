package litigationManagement;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

			Thread.sleep(3000);
			clickRefNo(driver);

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
			
		}
	   
	   public  static void clickNewNotice(WebDriver driver) throws InterruptedException 
		  {
				Thread.sleep(3000);
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
//				js.executeScript("window.scrollBy(0,-700)");
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
			return open;
		}
}
