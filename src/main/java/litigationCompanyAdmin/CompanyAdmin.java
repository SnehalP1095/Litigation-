package litigationCompanyAdmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationPerformer.MethodPOM1;
import litigationPerformer.MethodsPOM;

public class CompanyAdmin 
{
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\ashitosh\\ComplianceLatest\\ComplianceLatest\\TestData\\LitigationSheet.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCompanyAdmin.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Litigation Logging In - Company Admin");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}

	

//	@Test(priority = 2)
//	void CaseNoticeStageGraph() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Case Notice Stage Graph Count Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CaseNoticeStageGraph(driver, test,"Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
////	
//	@Test(priority = 3)
//	void CaseNoticeTypeGraph() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Case Notice Type Graph Count Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CaseNoticeTypeGraph(driver, test,"Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	@Test(priority = 4)
//	
//	void RiskSummaryGraph() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Risk Summary Graph Count Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.RiskSummaryGraph(driver, test,"Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//    @Test(priority = 5)
//	
//	void DepartmentSummaryGraph() throws InterruptedException, IOException
//	{
//		test = extent.startTest(" Department Summary Graph Count Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.DepartmentSummaryGraph(driver, test,"Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//  @Test(priority = 6)
//	
//	void LocationSummaryGraph() throws InterruptedException, IOException
//	{
//		test = extent.startTest(" Location Summary Graph Count Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.LocationSummaryGraph(driver, test,"Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//    @Test(priority = 7)
//	
//  	void CategorySummaryGraph() throws InterruptedException, IOException
//  	{
//  		test = extent.startTest(" Category Summary Graph Count Verification");
//  		test.log(LogStatus.INFO, "Test Initiated");
//  		
//  		MethodsPOM.CategorySummaryGraph(driver, test,"Company Admin");
//  		
//  		extent.endTest(test);
//  		extent.flush();
//  	}
  	
	
//	@Test(priority = 3)
//	void Masters() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Masters - Case/Notice  verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.Masters(driver, test, workbook,"Performer");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
	
	
	
	
//
//	@Test(priority = 2)
//	void CaseHearing() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Case Hearing Count Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CaseHearing(driver, test,"Performer","Company admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 3)
//	void HearingCalender() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Case Hearing Calender Verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.HearingCalender(driver, test,"Performer","Company admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	
	
	
//	
//	
//	@Test(priority = 3)
//	void ImportUtility() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Import Utility verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.ImportUtility(driver,test);
//		extent.endTest(test);
//		extent.flush();
//	}
//	@Test(priority = 4)
//	void NoticeOpen() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Notice - Open Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		litigationPerformer.MethodsPOM.NoticeOpen(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 5)
//	void NoticeClosed() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Notice - Closed Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		litigationPerformer.MethodsPOM.NoticeClosed(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 6)               //(enabled = false)	//(priority = 3)	//****** Add New Case -> 'Entity/Branch' dropdown doesn't have any locations.
//	void CaseOpen() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Case - Open Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CaseOpen(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 7)
//	void CaseClose() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Case - Closed Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CaseClosed(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 8)
//	void TaskOpen() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Task - Open Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.TaskOpen(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 9)
//	void TaskClosed() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Task - Closed Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.TaskClosed(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
	
//	@Test(priority = 10)
//	void LinkNotice() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Link Notice verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.LinkDocument(driver, test, workbook, "Notice");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 11)
//	void LinkCase() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Link Case verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.LinkDocument(driver, test, workbook, "Case");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 12)
//	void CloseNotice() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Close Notice Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CloseNoticeCase(driver, test, workbook,"Notice");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 13)
//	void CloseCase() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Close Case Count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.CloseNoticeCase(driver, test, workbook,"Case");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	 
//	@Test(priority = 2)
//	void MyDocument() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Download and View Document");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.MyDocument(driver, test, workbook, "Performer");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//	
//	@Test(priority = 2)
//	void AdvancedSearchDoc() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Download and View Document");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.AdvancedSearchDocument(driver, test, workbook, "Performer");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
//
//	@Test(priority = 14)
//	void MyReports() throws InterruptedException, IOException
//	{
//		test = extent.startTest("Reports -excel count verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.MyReports(driver, test, workbook, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
    
//	@Test(priority = 15)
//	void MoreReports() throws InterruptedException, IOException
//	{
//		test = extent.startTest("More Report-Reports excel  verification");
//		test.log(LogStatus.INFO, "Test Initiated");
//		
//		MethodsPOM.MoreReport(driver, test, "Company Admin");
//		
//		extent.endTest(test);
//		extent.flush();
//	}
    @Test(priority = 16)
	void AdvancedSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Advanced SearchReports excel  verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodPOM1.AdvancedSearch(driver, test, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}
    
    
	
	@Test(priority = 17)
	void MyReminder() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.MyReminder(driver, test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	

}
