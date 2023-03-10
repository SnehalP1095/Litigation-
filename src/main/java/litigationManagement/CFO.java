package litigationManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import litigationPerformer.MethodsPOM;


public class CFO {
	
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
			sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
			return sheet;
		}
		
		@BeforeTest
	
		void setBrowser() throws Exception
		{
			String workingDir = System.getProperty("user.dir");
			extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCFO.html",true);
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
			Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
			String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
			
			Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
			Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
			String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
			
			driver = login.Login.UserLogin(uname,password,"cfo");		//Method of Login class to login user.
			
			test.log(LogStatus.PASS, "Test Passed.");
			extent.endTest(test);
			extent.flush();
		}
		
//		 @Test(priority = 2)
			void DashBoardFilter() throws InterruptedException, IOException
			{
				test = extent.startTest("All Filters verification");
				test.log(LogStatus.INFO, "Test Initiated");
				
				CFOMethod.DashBoardFilter(driver, test, "Cfo-");
				
				extent.endTest(test);
				extent.flush();
			}
		
//		@Test(priority = 3)
		void CaseNoticeStageGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Notice Stage Graph Count Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.CaseNoticeStageGraph(driver, test,"cfo -");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 4)
		void CaseNoticeTypeGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Notice Type Graph Count Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.CaseNoticeTypeGraph(driver, test,"cfo -");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 5)
		void RiskSummaryGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Graph Count Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.RiskSummaryGraph(driver, test,"cfo -");
			
			extent.endTest(test);
			extent.flush();
		}

  //    @Test(priority = 6)
        void DepartmentSummaryGraph() throws InterruptedException, IOException
        {
	       test = extent.startTest("Department Graph Count Verification");
	       test.log(LogStatus.INFO, "Test Initiated");
	
	       CFOMethod.DepartmentSummaryGraph(driver, test,"cfo -");
	
	       extent.endTest(test);
	       extent.flush();
        }
//       @Test(priority = 7)
        void LocationSummaryGraph() throws InterruptedException, IOException
        {
	       test = extent.startTest("Location Graph Count Verification");
	       test.log(LogStatus.INFO, "Test Initiated");
	
	       CFOMethod.LocationSummaryGraph(driver, test,"cfo -");
	
	       extent.endTest(test);
	       extent.flush();
        }
       
 //      @Test(priority = 8)
        void CategorySummaryGraph() throws InterruptedException, IOException
        {
	       test = extent.startTest("Category Graph Count Verification");
	       test.log(LogStatus.INFO, "Test Initiated");
	
	       CFOMethod.CategorySummaryGraph(driver, test,"cfo -");
	
	       extent.endTest(test);
	       extent.flush();
        }
        
  
 //      @Test(priority = 9)
		void WorkspaceFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Workspace-All Filters verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.WorkspaceFilter(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
    	
   	@Test(priority = 10)
    	void NoticeOpen() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice - Open Count verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.NoticeOpen(driver, test, workbook, "CFO -");
    		
    		extent.endTest(test);
    		extent.flush();
    	}
 //   	 @Test(priority =11)
     	void CaseOpen() throws InterruptedException, IOException
     	{
     		test = extent.startTest("Case - Open Count verification");
     		test.log(LogStatus.INFO, "Test Initiated");
     		
     		CFOMethod.CaseOpen(driver, test, workbook, "CFO -");
     		
     		extent.endTest(test);
     		extent.flush();
     	}
  //    	@Test(priority = 12)
    			void TaskOpen() throws InterruptedException, IOException
    			{
    				test = extent.startTest("Task - Open Count verification");
    				test.log(LogStatus.INFO, "Test Initiated");
    				
    				CFOMethod.TaskOpen(driver, test, workbook, "CFO");
    				
    				extent.endTest(test);
    				extent.flush();
    			}
      	
   // 	@Test(priority = 13)
    	void NoticeClosed() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice - Closed Count verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.NoticeClosed(driver, test, workbook, "Company Admin");
    		
    		extent.endTest(test);
    		extent.flush();
    	}
  //  	@Test(priority = 14)
    	void CaseClose() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Closed Count verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.CaseClosed(driver, test, workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
 // 	@Test(priority =15)
		void LinkNotice() throws InterruptedException, IOException
		{
			test = extent.startTest("Link Notice Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.LinkDocument(driver, test, workbook, "Notice");
			
			extent.endTest(test);
			extent.flush();
		}
    	
  //  	@Test(priority = 16)
		void LinkCase() throws InterruptedException, IOException
		{
			test = extent.startTest("Link Case Verification");
		test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.LinkDocument(driver, test, workbook, "Case");
		
		extent.endTest(test);
			extent.flush();
		}
	 	
	   
//	   	@Test(priority = 17)
    	void CloseNotice() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Close Notice Count verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.CloseNoticeCase(driver, test, workbook,"Notice");
    		
    		extent.endTest(test);
    		extent.flush();
    	}
	//		@Test(priority = 18)
			void CloseCase() throws InterruptedException, IOException
			{
			test = extent.startTest("Close Case Count Verification");
				test.log(LogStatus.INFO, "Test Initiated");
				
				CFOMethod.CloseNoticeCase(driver, test, workbook,"Case");
				
			extent.endTest(test);
				extent.flush();
			}
	  
//			@Test(priority = 19)
			void TaskClosed() throws InterruptedException, IOException
			{
				test = extent.startTest("Task - Closed Count verification");
				test.log(LogStatus.INFO, "Test Initiated");
				
				CFOMethod.TaskClosed(driver, test, workbook, "CFO");
				
				extent.endTest(test);
				extent.flush();
			}
    	
    
		
		
	
//    	@Test(priority = 11)
    	void NoticeDocument() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Document verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.NoticeDocument(driver, test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
 //   	@Test(priority = 12)
    	void NoticeTaskActivity() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice TaskActivtiy verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.TaskActivtity(driver, test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//   	@Test(priority = 13)
    	void NoticeResponse() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Response verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.Response(driver, test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
    	
 //   	@Test(priority = 14)
    	void NoticePayment() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Payment verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.PaymentLog(driver,test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
 //   	@Test(priority = 15)
    	void NoticeExternalLawyer() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Lawyer verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.ExternalLawyer(driver, test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
 //  	@Test(priority = 16)
    	void NoticeAuditLog() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Audit Log verification");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.AuditLog(driver, test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
 
    	
    	
   
    	

		
		
//		@Test(priority =24)
    	void CaseDocument() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Document Tab");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.Document(driver, test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//		@Test(priority =25)
    	void CaseTaskActivity() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Task/Activty Tab");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.TaskActivity1(driver, test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//		@Test(priority =26)
    	void CaseHearingcfo() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - CaseHearing Tab");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.CaseHearing(driver, test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//		@Test(priority =27)
    	void CaseOrder() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Case Order Tab");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.CaseOrder(driver, test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//		@Test(priority =28)
    	void CaseStatusPayment() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Status/Payment Tab");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.StatusPayment(driver, test,workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//		@Test(priority =29)
    	void CaseExternalLawyerRating() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - External Lawyer Rating");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.CaseExternalLawyer(driver, test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
//		@Test(priority =30)
    	void CaseAuditLog() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Audit Log Tab");
    		test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.Auditlog(driver, test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
    

		
	
//		@Test(priority = 31)
		void AdvancedSearch() throws InterruptedException, IOException
		{
			test = extent.startTest("Workspace-Advanced Search Reports excel  verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.AdvancedSearchWorkspace(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}

		
		
		 
//		@Test(priority = 34)
		void DocumentFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document- All Filters verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.DocumentFilter(driver, test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 35)
			void MyDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Download and View Document");
				test.log(LogStatus.INFO, "Test Initiated");
				
				CFOMethod.MyDocument(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
		
//		@Test(priority = 36)
		void AdvancedSearchDoc() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document(Advanced search) -Download and View Document");
			test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.AdvancedSearchDocument(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
//		 @Test(priority = 37)
			void ReportFilter() throws InterruptedException, IOException
			{
				test = extent.startTest("My Report - All Filters verification");
				test.log(LogStatus.INFO, "Test Initiated");
				
				CFOMethod.ReportFilter(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
//			@Test(priority = 38)
				void MyReports() throws InterruptedException, IOException
				{
					test = extent.startTest("Reports -excel count verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.MyReports(driver, test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
//	           @Test(priority = 39)
				void AdvancedSearchreport() throws InterruptedException, IOException
				{
					test = extent.startTest("Advanced SearchReports excel  verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.AdvancedSearchReport(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
//				@Test(priority = 40)
				void MoreReports() throws InterruptedException, IOException
				{
					test = extent.startTest("More Report-Reports excel  verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.MoreReport(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
				
//				@Test(priority = 41)
				void MyReminder() throws InterruptedException, IOException
				{
					test = extent.startTest("My Reminder verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.MyReminder(driver, test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
				
//				@Test(priority = 42)
				void ImportUtility() throws InterruptedException, IOException
				{
					test = extent.startTest("Import Utility verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.ImportUtility(driver,test);
					extent.endTest(test);
					extent.flush();
				}
				
//				@Test(priority = 2)
				void Masters() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Legal Entity  verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.LegalEntity(driver, test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
//				@Test(priority = 2)
				void Masters1() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Law Firm verification");
					test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.LawFirm(driver, test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	
			
		
		 
		


		

		


	
//			@AfterMethod()	
//			
//			void chromeclose() throws InterruptedException
//			{
//				Thread.sleep(5000);
//			  driver.close();
//			}

}
