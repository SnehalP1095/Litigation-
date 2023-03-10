package litigationPerformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Key;
import com.google.inject.internal.BytecodeGen.Visibility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licensePerformer.LiPerformerPOM;
import performer.OverduePOM;

public class MethodsPOM 
{
	


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
		sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	static void perform(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type, String noticeCategory) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebDriverWait wait1 = new WebDriverWait(driver, 300);
		progress(driver);
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
		js.executeScript("window.scrollBy(0,-700)");
		
		Thread.sleep(4000);
		clickNewNotice(driver);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		
		clickDated(driver);
		clickFinancialYear(driver);
		clickRefNo(driver);
		selectNoticeType(driver,type);
		Thread.sleep(300);
		clickAct(driver);
		Thread.sleep(6000);
		//clickOpponentcfo(driver);
		selectOpponent(driver,type);
		Thread.sleep(300);
		selectCategory(driver, noticeCategory);
		clickNoticeTitle(driver);
		Thread.sleep(3000);
		clickNoticeDescription(driver);
		Thread.sleep(7000);
		selectLocation(driver);
		Thread.sleep(10000);
		clickDepartment(driver);
		//clickJurisdiction(driver);
		//Thread.sleep(3000);
		clickNoticeTerm(driver);
		clickOwner(driver);
		clickNoticeBudget(driver);
		clickClaimedAmount(driver);
		clickState(driver);
		clickProvisionalAmount(driver);
		clickProtestMoney(driver);
		selectRisk(driver);
		Thread.sleep(500);
		performerPOM.clickPotentialImpactRadio(driver).click();			//Clicking on 'Monetary' radio button
		Thread.sleep(400);
		performerPOM.clickMonetary(driver).sendKeys("Automation1232");
		Thread.sleep(3000);
		clickLawFirm(driver);
		 Thread.sleep(3000);
		selectNoticeRecipetDate(driver);
		 Thread.sleep(3000);
		clickInternalUser(driver);
		 Thread.sleep(5000);
		clickLawyer(driver);
        Thread.sleep(3000);
		performerPOM.selectNoticeUploadDocument(driver); 
		Thread.sleep(3000);
		OverduePOM.clickSaveButton(driver).click();						//Clicking on 'Save'button.
										
////		progress(driver);
////		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
//	
		
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage(driver)));
		
		Thread.sleep(500);
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
				ele1 = performerPOM.clickLinkNotice(driver);
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
	
		driver.switchTo().parentFrame();
		performerPOM.clickClose(driver).click();//Clicking on 'Close'
		
		Thread.sleep(3000);
		performerPOM.clickEditNotice(driver).click();//click edit notice
		Thread.sleep(300);
		
	

		
		NoticeDocument(driver, test);
		TaskActivtity(driver,  test, sheet,  open,gridRecords,  type); 
		Response(driver, test,  sheet, open,gridRecords,  type);
		PaymentLog(driver,test,  sheet, open,  gridRecords, type);
		 ExternalLawyerRating(driver, test);
		 AuditLog(driver);
			
				
            
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
		
		Thread.sleep(500);
		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
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
		
		public static void clickRefNo(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(500);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String refno = c1.getStringCellValue();
		performerPOM.clickRefNo(driver).sendKeys(refno);			//Writing 'Reference No'
		}
		
		public static void selectNoticeType(WebDriver driver, String noticeType) 
		{
			WebElement type = performerPOM.clickNoticeType(driver);
			type.click();
			
			performerPOM.chooseNoticeType(driver).click(); 
			
			
//			List<WebElement> options = performerPOM.chooseNoticeType(driver); 
//
//			for (WebElement option : options)
//			{   
//				
//			    if (option.getText().equals("Inward"))
//			    {
//			        option.click(); // click the desired option
//			        break;
//			    }
//			} 
		}
		
//		performerPOM.clickNoticeType(driver).click();
//		performerPOM.clickSearch(driver).sendKeys(noticeType, Keys.ENTER);	//Writing 'Notice Type'
		
	//	Thread.sleep(300);
	//	progress(driver);
		
		public static void clickAct(WebDriver driver) throws InterruptedException
		{
		   Thread.sleep(300);
		   progress(driver);
	       XSSFRow row0 = sheet.getRow(2);						//Selected 0th index row (First row)
		   XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		   int actNo = (int) c1.getNumericCellValue();
		   performerPOM.clickAct(driver).click();						//Clicking on 'Act' drop down.
		   elementsList = performerPOM.chooseAct(driver);
		   elementsList.get(3).click();							//Selecting particular act no
		   performerPOM.clickAct(driver).click();						//Clicking on 'Act' drop down.
		}
		

		
////		Thread.sleep(300);
////		row0 = sheet.getRow(3);						//Selected 0th index row (First row)
////		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
////		String underSection = c1.getStringCellValue();
////	performerPOM.clickUnderSection(driver).sendKeys(underSection);	//Writing 'Under section'
//		
		 public static void clickOpponentcfo(WebDriver driver) throws InterruptedException
		   {
	           Thread.sleep(300);
	           Row row0 = sheet.getRow(4);						//Selected 0th index row (First row)
	           Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
	            String Opponent = c1.getStringCellValue();
               performerPOM.clickOpponentcfo(driver).sendKeys(Opponent);
		   }
//		Thread.sleep(300);
//		row0 = sheet.getRow(4);						//Selected 0th index row (First row)
//		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//		String category = c1.getStringCellValue();
//		performerPOM.clickNoticeCategory(driver).click();					//Clicking on 'Category'
//		performerPOM.clickSearch(driver).sendKeys(category);
		
	   public static void selectOpponent(WebDriver driver) throws InterruptedException
	   {
		  Thread.sleep(300);
		   Row row1 = sheet.getRow(4);						//Selected 0th index row (First row)
		   Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		   String opponent = c1.getStringCellValue();
		   selectOpponent(driver,opponent);
	    }
	   
	   public  static void selectOpponent(WebDriver driver,String opponentName) {
			
			WebElement Opponent = performerPOM.clickOpponent(driver);
			Opponent.click();
			
			performerPOM.chooseOpponent(driver).click(); 
//
//			for (WebElement option : options)
//			{   
//				
//			    if (option.getText().equals("Abcde"))
//			    {
//			        option.click(); // click the desired option
//			        break;
//			    }
//			} 
		
		}
	   
		public static void selectCategory(WebDriver driver,String noticeCategory) 
		{
			WebElement Category =  performerPOM.clickNoticeCategory(driver);
			Category.click();
			 performerPOM.chooseCategory(driver).click();
			 
//			for (WebElement option : options)
//			{
//			    if (option.getText().equals("Admin"))
//			    {
//			        option.click(); // click the desired option
//			        break;
//			    }
//			} 
			
			
		}
	   
	//	performerPOM.clickOpponent(driver).click();					//Clicking on 'Opponent'
//		performerPOM.chooseOpponent(driver).stream().filter(option -> option.getText().equals("Abcde")).toList().get(0).click();	//Writing 'Opponent' name
//		Thread.sleep(300);
//		performerPOM.clickSelectAll(driver).click();
//		performerPOM.clickOpponent(driver).click();
	
//		String Category = c1.getStringCellValue();
//		selectCategory(driver, Category);
//		Thread.sleep(300);
//		performerPOM.clickNoticeCategory(driver).click();
//		performerPOM.chooseCategory(driver);	
		
//		Thread.sleep(300);
//		row0 = sheet.getRow(5);						//Selected 0th index row (First row)
//		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//		String oppoLawyer = c1.getStringCellValue();
//		performerPOM.clickOppLawyer(driver).click();				//Clicking on 'Opponent'
//		performerPOM.clickSearch2(driver).sendKeys(oppoLawyer);		//Writing 'Opposition Lawyer' name
//		Thread.sleep(300);
//		performerPOM.clickSelectAll1(driver).click();
//		performerPOM.clickOppLawyer(driver).click();
		
		
		public static void clickNoticeTitle(WebDriver driver) throws InterruptedException
		{
		  Thread.sleep(300);
		  XSSFRow row0 = sheet.getRow(6);						//Selected 0th index row (First row)
		  XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		  String title = c1.getStringCellValue();
		  performerPOM.clickNoticeTitle(driver).sendKeys(title);		//Writing 'Notice Title'
		}
		
		public static void clickNoticeDescription(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(7);						//Selected 0th index row (First row)
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
		elementsList = performerPOM.selectLocation(driver);
		elementsList.get(2).click();								//Selecting third visible location
		}
		
//		Thread.sleep(300);
//		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickDated(driver)));
//		wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickLocation(driver)));
		
	//	performerPOM.clickNoticeDescription(driver).sendKeys(Keys.PAGE_DOWN);
		
		public static void clickJurisdiction(WebDriver driver) throws InterruptedException
		{
		 Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(8);						//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String jurisdiction = c1.getStringCellValue();
		performerPOM.clickJurisdiction(driver).click();					//Clicking on 'Jurisdiction' drop down
		Thread.sleep(600);
		performerPOM.clickSearch3(driver).sendKeys(jurisdiction, Keys.ENTER);	//Writing 'Jurisdiction' name
		
		}
		
		public static void clickDepartment(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(1000);
		Row row0 = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String dept = c1.getStringCellValue();
		performerPOM.clickDepartment(driver).click();					//Clicking on 'Department' drop down
		performerPOM.clickSearch4(driver).sendKeys(dept, Keys.ENTER);	//Writing 'Department' name
		}
		
		public static void clickContactDept(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(10);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String ContactDept = c1.getStringCellValue();
		performerPOM.clickContactDept(driver).click();					//Clicking on 'Contact Person of Department' drop down
		performerPOM.clickSearch5(driver).sendKeys(ContactDept, Keys.ENTER);	//Writing 'Contact Person' name
		
		}
		
		public static void clickNoticeTerm(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		Row row0 = sheet.getRow(11);					//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int noticeTerm = (int) c1.getNumericCellValue();
		performerPOM.clickNoticeTerm(driver).sendKeys(noticeTerm+"");		//Writing 'Notice Term'
		}
		
		public static void clickOwner(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(12);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String owner = c1.getStringCellValue();
		performerPOM.clickOwner(driver).click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearch6(driver).sendKeys(owner, Keys.ENTER);	//Writing 'Owner' name
		}
		
		public static void selectRisk(WebDriver driver) throws InterruptedException
		{
//		Thread.sleep(300);
//		performerPOM.clickWinningProspect(driver).click();
		//Thread.sleep(100);
	//	performerPOM.selectRisk(driver).click();	          //Selecting 'Medium' Winning Prospect'
		Thread.sleep(500);
		performerPOM.clickRisk(driver).click();							//Clicking on 'Risk' drop down.
		Thread.sleep(500);
		performerPOM.selectRisk(driver).click();						//Selecting second option 'High' risk.
	
		
		}
		
		public static void clickNoticeBudget(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(13);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int noticeBudget = (int) c1.getNumericCellValue();
		performerPOM.clickNoticeBudget(driver).sendKeys(noticeBudget+"");	//Writing 'Notice Budget'
		
		}
		
		public static void clickClaimedAmount(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(14);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int claimedAmount = (int) c1.getNumericCellValue();
		performerPOM.clickClaimedAmount(driver).sendKeys(claimedAmount+"");	//Writing 'Claimed Amount'
		
		}
		
		public static void clickState(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(15);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String state = c1.getStringCellValue();
		performerPOM.clickState(driver).click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearchState(driver).sendKeys(state, Keys.ENTER);	//Writing 'State' name
		}
		
		public static void clickProbableAmount(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(16);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int probAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProbableAmount(driver).sendKeys(probAmount+"");	//Writing 'Probable Amount'
		}
		
		public static void clickProvisionalAmount(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		Row row0 = sheet.getRow(17);					//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int provAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProvisionalAmount(driver).sendKeys(provAmount+"");	//Writing 'Provisional Amount'
		}
		
		public static void clickProtestMoney(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(18);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int protestAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProtestMoney(driver).sendKeys(protestAmount+"");	//Writing 'Protest Amount'
		Thread.sleep(500);
		performerPOM.clickProtestMoney(driver).sendKeys(Keys.PAGE_DOWN);
		}

//		Thread.sleep(500);
//		performerPOM.clickPotentialImpactRadio(driver).click();			//Clicking on 'Monetary' radio button
//		
//		Thread.sleep(400);
//		performerPOM.clickMonetary(driver).sendKeys("Automation123");
		
		public static void clickLawFirm(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(19);					//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String lawFirm = c1.getStringCellValue();
		performerPOM.clickLawFirm(driver).click();		//Clicking on 'Law Firm' drop down.
		performerPOM.chooseLawFirm(driver).sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
		}
		
		//selectNoticeRecipetDate(driver);
		
		
//		Thread.sleep(300);
//		progress(driver);
		
		
		public  static void selectNoticeRecipetDate(WebDriver driver)
	      {
	    	 	
	          WebElement openDate= performerPOM.selectNoticeRecipetDate(driver);
	          openDate.sendKeys("30-09-2021");
	        
	      }
		public static void clickInternalUser(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(20);						//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int internalUserNo = (int) c1.getNumericCellValue();
		performerPOM.clickInternalUser(driver).click();						//Clicking on 'Internal User' drop down.
		elementsList = performerPOM.chooseInternalUser(driver);
		elementsList.get(internalUserNo).click();							//Selecting particular user no
		performerPOM.clickInternalUser(driver).click();	//Clicking on 'Internal User' drop down.
		}
		
		public static void clickLawyer(WebDriver driver) throws InterruptedException
		{
		Thread.sleep(300);
		XSSFRow row0 = sheet.getRow(21);						//Selected 0th index row (First row)
		XSSFCell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int lawyerNo = (int) c1.getNumericCellValue();
		performerPOM.clickLawyer(driver).click();						//Clicking on 'Lawyer' drop down.
		elementsList = performerPOM.chooseLawyer(driver);
		elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
		performerPOM.clickLawyer(driver).click();		//Clicking on 'Lawyer' drop down.
		}
		
		static void NoticeDocument(WebDriver driver, ExtentTest test) throws InterruptedException
		{
			
			WebDriverWait wait=new WebDriverWait(driver,300); 
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
		int flag = 0;
		if(msg.equalsIgnoreCase("Document(s) uploaded successfully."))
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
    }
		
		
	 public  static void TaskActivtity(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
			{
				  WebDriverWait wait = new WebDriverWait(driver, 60);
				
				   Thread.sleep(1000);
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				  Thread.sleep(1000);
				  performerPOM.clickTaskorActivity(driver).click();
				  Thread.sleep(1000);
				  performerPOM.clickNewTask(driver).click(); 
				 
				  
				  
				Thread.sleep(3000);
				Row row0 = sheet.getRow(26);								//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				String title = c1.getStringCellValue();
				performerPOM.clickTaskTitle(driver).sendKeys(title);	//Writing 'Task Title'
				
				Thread.sleep(3000);
				row0 = sheet.getRow(27);									//Selected 0th index row (First row)
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
				row0 = sheet.getRow(28);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String outcome = c1.getStringCellValue();
				performerPOM.clickExpOutcome(driver).sendKeys(outcome);	//Writing 'Expected Outcome'
				
				Thread.sleep(500);
				row0 = sheet.getRow(29);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String internalUser = c1.getStringCellValue();
				performerPOM.clickInternalUser2(driver).click();
				//performerPOM.selectInternalUser2(driver).click();
				performerPOM.selectInternalUser2(driver).sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
				
	
				
				Thread.sleep(1000);
				row0 = sheet.getRow(30);									//Selected 0th index row (First row)
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
				row0 = sheet.getRow(31);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String remark = c1.getStringCellValue();
				performerPOM.clickRemark(driver).sendKeys(remark);		//Writing 'Remark'
				
				//Thread.sleep(300);
				//String workingDir = System.getProperty("user.dir");
				//performerPOM.clickUpload(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
				
				Thread.sleep(3000);
				OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
				
//				Thread.sleep(300);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg(driver)));
//				
//				Thread.sleep(300);
//				String msg = performerPOM.readTaskMsg(driver).getText();
//				if(msg.contains("Task Saved Successfully."))
//				{
//					test.log(LogStatus.PASS, "Task Saved Successfully.");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "Task didn't saved successfully.");
//				}
//				
				
			}
		   
  static void Response(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
			{
			   WebDriverWait wait = new WebDriverWait(driver, 60);
//
			   
				   
				    // Thread.sleep(3000);
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
					  Row row1 = sheet.getRow(34);								//Selected 0th index row (First row)
					  Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
					  String DeliveryMode= c2.getStringCellValue();
					  performerPOM.clickDeliveryMode(driver).click();
					  performerPOM.selectDeliveryMode(driver).sendKeys(DeliveryMode);
					  
					  
					  Thread.sleep(500);
					  Row row0 = sheet.getRow(35);								//Selected 0th index row (First row)
					  Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
					  String CourierCompany= c1.getStringCellValue();
					  performerPOM.clickCourierCompany(driver).sendKeys(CourierCompany);
						 
					  Thread.sleep(500);
						Row row2 = sheet.getRow(36);								//Selected 0th index row (First row)
						Cell c3 = row2.getCell(1);								//Selected cell (0 row,1 column)
						String RefNo= c3.getStringCellValue();
						performerPOM.RefTrackingNo(driver).sendKeys(RefNo);
							 
						Thread.sleep(500);
						Row row3 = sheet.getRow(37);								//Selected 0th index row (First row)
						Cell c4 = row3.getCell(1);								//Selected cell (0 row,1 column)
						String Description= c4.getStringCellValue();
						 performerPOM.Description(driver).sendKeys(Description);
							
						  JavascriptExecutor jse=(JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse(driver));
						  //performerPOM.clickSaveResponse(driver).click();
							
							 Thread.sleep(1000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg(driver)));
								
							Thread.sleep(500);
							String msg3 = performerPOM.readResponseMsg(driver).getText();		//Reading Message appeared after save button
							int flag3 = 0;
							if(msg3.equalsIgnoreCase("Response Details Saved Successfully."))
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg3);
								flag3 = 1;
							}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg3);
								}
							
			       }
	   static void PaymentLog(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
			{
			   performerPOM.clickStatusPayments(driver).click();			//Clicking on 'Status/Payments'
			
//			   WebDriverWait wait = new WebDriverWait(driver, 300);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus(driver)));
//				performerPOM.clickNoticeStatus(driver).click();				//Clicking on 'Notice Status' drop down.
//				Thread.sleep(300);
//				performerPOM.clickClosedStatus(driver).click();				//Selecting 'Closed' option from drop down.
//				
//				Thread.sleep(300);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate(driver)));
//				performerPOM.clickCloseDate(driver).click();				//Clicking on 'Closed Date' date box
//				OverduePOM.selectLastMonth(driver).click();					//Getting last month
//				OverduePOM.selectDate2(driver).click();						//Selecting particular date.
//				
//				Thread.sleep(300);
//				performerPOM.clickNoticeResult(driver).click();
//				performerPOM.clickSelectResult(driver).sendKeys("In Progress", Keys.ENTER);
//				
//				Thread.sleep(300);
//				Row r1 = sheet.getRow(40);
//				Cell c1 = r1.getCell(1);
//				String remark = c1.getStringCellValue();
//				performerPOM.clickRemark1(driver).sendKeys(remark);
//				
//				Thread.sleep(300);
//				r1 = sheet.getRow(41);
//				c1 = r1.getCell(1);
//				String CaseNo = c1.getStringCellValue();
//				performerPOM.clickCourtCaseNo(driver).sendKeys(CaseNo);
//				
//				Thread.sleep(300);
//				performerPOM.clickSaveConvertCase(driver).click();	
			
							
				Thread.sleep(300);
//				Row r4 = sheet.getRow(44);
//				Cell c4 = r4.getCell(1);
//				String InvoiceNo = c4.getStringCellValue();
				performerPOM.clickInvoiceNo(driver).sendKeys("48579");
				
				
				Thread.sleep(3000);
//				Row r5 = sheet.getRow(45);
//				Cell c5 = r5.getCell(1);
//				String PaymentType = c5.getStringCellValue();
				performerPOM.clickPaymentType(driver).click();
//				performerPOM.selectPaymentType(driver).sendKeys(PaymentType,Keys.ENTER);
				List<WebElement> PaymentType1= driver.findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
				PaymentType1.get(2).click();
					
				Thread.sleep(5000);
//				Row r6 = sheet.getRow(46);
//				Cell c6 = r6.getCell(1);
//				String Amount = c6.getStringCellValue();
	
				performerPOM.clickAmount(driver).sendKeys("7000");
			
				Thread.sleep(300);
				performerPOM.clickSavePaymentLog(driver).click();
				

				 // Thread.sleep(1000);
				  WebDriverWait wait1 = new WebDriverWait(driver, 300);
				 wait1.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg(driver)));
					
					Thread.sleep(500);
					String msg4 = performerPOM.readPymentmsg(driver).getText();		//Reading Message appeared after save button
					int flag4= 0;
					if(msg4.equalsIgnoreCase("Payment Details Saved Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg4);
						flag4 = 1;
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg4);
					}
				
				
			 
			}
		
		
	static void ExternalLawyerRating(WebDriver driver, ExtentTest test) throws InterruptedException
		{
			
			 WebDriverWait wait = new WebDriverWait(driver, 100);
		  Thread.sleep(3000);
		   performerPOM. clickExternalLawyerRating(driver).click();
		   Thread.sleep(3000);
		   performerPOM.selectExternalLawyerRating(driver);
		   
		
		   Thread.sleep(3000);
		   performerPOM.clickNewCriteria(driver).click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
		   performerPOM.clickCriteria(driver).sendKeys(" Rating New Automate Test	`	`	");
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
		   
		   
	static void AuditLog(WebDriver driver) throws InterruptedException
		{
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
		}
		
		
	static void perform1(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebDriverWait wait1 = new WebDriverWait(driver, 300);
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
		js.executeScript("window.scrollBy(0,-700)");
		performerPOM.clickNew(driver).click();						//Clicking on 'New' button
		
		progress(driver);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		performerPOM.clickCaseDate(driver).click();					//Clicking on 'Dated' button
		OverduePOM.selectLastMonth(driver).click();					//Clicking last month arrow.
		OverduePOM.selectDate3(driver).click();						//Clicking particular date.
	
		Thread.sleep(300);
		Row row1 = sheet.getRow(0);								//Selected 0th index row (First row)
		Cell c2 = row1.getCell(1);	
		String caseType1 = c2.getStringCellValue();
		selectCaseType(driver,caseType1);

		
		Thread.sleep(300);
		performerPOM.clickFinancialYear(driver).click();			//Clicking on 'Financial Year' drop down.
		elementsList = performerPOM.clickFinanceSearchCheckbox(driver);
		elementsList=performerPOM.chooseDropDownOption(driver);
		elementsList.get(10).click();								//Clicking third option
		performerPOM.clickFinancialYear(driver).click();			//Clicking on 'Financial Year' drop down.

			
		
		Thread.sleep(3000);
		Row row0 = sheet.getRow(0);								//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String refno = c1.getStringCellValue();
		performerPOM.clickRefNo(driver).sendKeys(refno);			//Writing 'Court Case No'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(1);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String caseNo = c1.getStringCellValue();
		performerPOM.clickInternalCaseNo(driver).sendKeys(caseNo);	//Writing 'Court Case No'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(2);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String title = c1.getStringCellValue();
		performerPOM.clickNoticeTitle(driver).sendKeys(title);		//Writing 'Case Title'
		
		Thread.sleep(300);
		progress(driver);
		
	
		Thread.sleep(3000);
	     row0 = sheet.getRow(3);								//Selected 0th index row (First row)
	    c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
 	    int actNo = (int) c1.getNumericCellValue();
		performerPOM.clickAct(driver).click();						//Clicking on 'Act' drop down.
//	//	elementsList = performerPOM.chooseAct(driver);
		elementsList = performerPOM.chooseAct1(driver);
	elementsList.get(3).click();							//Selecting particular act no
		performerPOM.clickAct(driver).click();	                  //Clicking on 'Act' drop down.
		
		Thread.sleep(3000);
		row0 = sheet.getRow(4);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String underSection = c1.getStringCellValue();
		performerPOM.clickUnderSection(driver).sendKeys(underSection);	//Writing 'Under section'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(5);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String caseType = c1.getStringCellValue();
		performerPOM.clickCaseCategory(driver).click();
		performerPOM.clickSearchCaseCategory(driver).sendKeys(caseType, Keys.ENTER);	//Writing 'Case Type'
		
		Thread.sleep(500);
		progress(driver);
		
		Thread.sleep(3000);
		row0 = sheet.getRow(6);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		int caseBudget = (int) c1.getNumericCellValue();
		performerPOM.clickCaseBudget(driver).sendKeys(caseBudget+"");
		
		

		Thread.sleep(3000);
		row0 = sheet.getRow(7);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String opponent = c1.getStringCellValue();
		
		selectOpponent(driver, opponent);
		
		performerPOM.clickOpponent(driver).click();	
		
////		Thread.sleep(300);
////		row0 = sheet.getRow(7);								//Selected 0th index row (First row)
////		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
////		String opponent = c1.getStringCellValue();
////		performerPOM.clickOpponent(driver).click();					//Clicking on 'Opponent'
////		performerPOM.clickSearchBox(driver).sendKeys(opponent);		//Writing 'Opponent' name
////		Thread.sleep(300);
////		selectOpponent(driver, opponent);
////		performerPOM.clickSelectAll2(driver).click();
////		performerPOM.clickOpponent(driver).click();
//		
////		Select Actdropdown = new Select(performerPOM.clickOpponent(driver));
////		Actdropdown.selectByVisibleText("abc opponent");
////		
//		
	Thread.sleep(3000);
		
		row0 = sheet.getRow(8);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String oppoLawyer = c1.getStringCellValue();
		performerPOM.clickOppLawyer(driver).click();				//Clicking on 'Opponent'
		performerPOM.clickSearchBox1(driver).sendKeys(oppoLawyer);	//Writing 'Opposition Lawyer' name
		Thread.sleep(300);
		performerPOM.clickSelectAll3(driver).click();
		performerPOM.clickOppLawyer(driver).click();
		
		Thread.sleep(3000);
		row0 = sheet.getRow(9);								//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String court = c1.getStringCellValue();
		performerPOM.clickCourt(driver).click();
		performerPOM.clickSearchCourt(driver).sendKeys(court, Keys.ENTER);
		
		Thread.sleep(3000);
		row0 = sheet.getRow(10);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String judge = c1.getStringCellValue();
		performerPOM.clickJudge(driver).sendKeys(judge);
		
		Thread.sleep(3000);		
		performerPOM.clickCaseBudget(driver).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(3000);
		row0 = sheet.getRow(11);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String caseDesc = c1.getStringCellValue();
		performerPOM.clickNoticeDescription(driver).sendKeys(caseDesc);
		
		Thread.sleep(5000);
		performerPOM.clickLocation(driver).click();					//Clicking on Location drop down
		//performerPOM.clickPlus(driver).click();
		Thread.sleep(3000);
		elementsList = performerPOM.selectLocation(driver);
		elementsList.get(2).click();								//Selecting third visible location
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseDate(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCaseDate(driver)));
		
		Thread.sleep(700);
		js.executeScript("window.scrollBy(0,600)");
		
////		Thread.sleep(300);
////		row0 = sheet.getRow(12);							//Selected 0th index row (First row)
////		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
////		String jurisdiction = c1.getStringCellValue();
////		performerPOM.clickJurisdiction(driver).click();					//Clicking on 'Jurisdiction' drop down
////		Thread.sleep(600);
////		performerPOM.clickSearch3(driver).sendKeys(jurisdiction, Keys.ENTER);	//Writing 'Jurisdiction' name
////		
//		
		
		Thread.sleep(8000);
		row0 = sheet.getRow(13);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String dept = c1.getStringCellValue();
		performerPOM.clickDepartment(driver).click();					//Clicking on 'Department' drop down
		performerPOM.clickSearch4(driver).sendKeys(dept, Keys.ENTER);	//Writing 'Department' name
		
///		Thread.sleep(300);
///		performerPOM.clickLocation(driver).click();					//Clicking on Location drop down
///		//performerPOM.clickPlus(driver).click();
///		Thread.sleep(300);
//	/	elementsList = performerPOM.selectLocation(driver);
///		elementsList.get(2).click();								//Selecting third visible location
//	/	
		
		Thread.sleep(3000);
		row0 = sheet.getRow(14);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String ContactDept = c1.getStringCellValue();
		performerPOM.clickContactDept(driver).click();					//Clicking on 'Contact Person of Department' drop down
		performerPOM.clickSearch5(driver).sendKeys(ContactDept, Keys.ENTER);	//Writing 'Contact Person' name
		
		Thread.sleep(3000);
		row0 = sheet.getRow(15);							//Selected 0th index row (First row)
		c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String owner = c1.getStringCellValue();
		performerPOM.clickOwner(driver).click();					//Clicking on 'Owner' drop down
	  performerPOM.clickSearch6(driver).sendKeys(owner, Keys.ENTER);	//Writing 'Owner' name
		
		Thread.sleep(3000);
		performerPOM.clickWinningProspect1(driver).click();
		Thread.sleep(100);
	performerPOM.selectRisk1(driver).click();			//Selecting 'Medium' Winning Prospect'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(16);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int claimedAmount = (int) c1.getNumericCellValue();
		performerPOM.clickClaimedAmount(driver).sendKeys(claimedAmount+"");	//Writing 'Claimed Amount'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(17);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int probAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProbableAmount(driver).sendKeys(probAmount+"");	//Writing 'Probable Amount'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(18);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int provAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProvisionalAmount(driver).sendKeys(provAmount+"");	//Writing 'Provisional Amount'
		
		Thread.sleep(3000);
		row0 = sheet.getRow(19);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int protestAmount = (int) c1.getNumericCellValue();
		performerPOM.clickProtestMoney(driver).sendKeys(protestAmount+"");	//Writing 'Protest Amount'
		
		Thread.sleep(3000);
		performerPOM.clickProtestMoney(driver).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(3000);
		performerPOM.clickPotentialImpactRadio(driver).click();			//Clicking on 'Monetary' radio button
		
		Thread.sleep(3000);
		performerPOM.clickMonetary(driver).sendKeys("Automation123");
		
		
		Thread.sleep(3000);
		row0 = sheet.getRow(20);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String state = c1.getStringCellValue();
		performerPOM.clickState(driver).click();					//Clicking on 'Owner' drop down
		performerPOM.clickSearchState(driver).sendKeys(state, Keys.ENTER);	//Writing 'State' name
	
		
		Thread.sleep(3000);
		row0 = sheet.getRow(21);					//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String lawFirm = c1.getStringCellValue();
		performerPOM.clickLawFirm(driver).click();		//Clicking on 'Law Firm' drop down.
		performerPOM.chooseLawFirm(driver).sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
		
		Thread.sleep(300);
		progress(driver);
//	/	
//	/	Thread.sleep(500);
///		performerPOM.clickRisk(driver).click();							//Clicking on 'Risk' drop down.
///		Thread.sleep(300);
///		performerPOM.selectRisk2(driver).click();						//Selecting second option 'High' risk.
	
		
		Thread.sleep(3000);
	    row0 = sheet.getRow(22);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int internalUserNo = (int) c1.getNumericCellValue();
		performerPOM.clickInternalUser(driver).click();						//Clicking on 'Internal User' drop down.
		elementsList = performerPOM.chooseInternalUser1(driver);
		elementsList.get(internalUserNo).click();							//Selecting particular user no
		performerPOM.clickInternalUser(driver).click();						//Clicking on 'Internal User' drop down.
		
		Thread.sleep(3000);
		row0 = sheet.getRow(23);						//Selected 0th index row (First row)
		c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int lawyerNo = (int) c1.getNumericCellValue();
		performerPOM.clickLawyer(driver).click();						//Clicking on 'Lawyer' drop down.
		elementsList = performerPOM.chooseLawyer(driver);
		elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
		performerPOM.clickLawyer(driver).click();						//Clicking on 'Lawyer' drop down.
		
		Thread.sleep(3000);
		OverduePOM.clickSaveButton(driver).click();						//Clicking on 'Save'button.
		
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOf(performerPOM.readMessage1(driver)));
		
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
		
		  Thread.sleep(3000);
		  performerPOM.clickEditNotice(driver).click();//click edit case
		  Thread.sleep(3000);
		   Document(driver,test);
		   Thread.sleep(300);
		  TaskActivity1(driver,test,sheet, open, gridRecords,type);
		  Thread.sleep(300);
		  CaseHearing(driver,test, sheet,open,gridRecords,type);
		  Thread.sleep(300);
		 CaseOrder(driver,test,  sheet,open, gridRecords,type);
		  //Thread.sleep(300);
		//  AdvocateBill(driver);
		  Thread.sleep(300);
		  StatusPayment(driver,test,  sheet,open, gridRecords,type);
		 // Thread.sleep(300);
	     //  ExternalLawyer(driver,test);
		   Thread.sleep(300);
		   Auditlog(driver);
		
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
       wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
       int open1 = Integer.parseInt(performerPOM.clickCaseOpen(driver).getText());	//Reading Notice Open count.

       if(open1 > open)
       {
          test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
       }
       else
      {
          test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
       }
     }

		

		static void Document(WebDriver driver,ExtentTest test) throws InterruptedException
		{
           			
		
          WebDriverWait wait = new WebDriverWait(driver, 50);
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
		  if(msg.equalsIgnoreCase("Document(s) uploaded successfully."))
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
	 }
		
		static void TaskActivity1(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
		{
		    WebDriverWait wait=new WebDriverWait(driver,20);
		    Thread.sleep(3000);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		    Thread.sleep(3000);
		    performerPOM.clickCaseTask(driver).click();
		    Thread.sleep(300);
		    performerPOM.clickCaseNewTask(driver).click(); 
		    Thread.sleep(5000);
		    performerPOM.clickHearingDate(driver).sendKeys("14-8-2022");
		    Thread.sleep(3000);
		    performerPOM.clickSaveHearingDate(driver).click();
		  
		  
			Thread.sleep(5000);
			Row row0 = sheet.getRow(27);								//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			String title = c1.getStringCellValue();
			performerPOM.clickTaskTitle(driver).sendKeys(title);	//Writing 'Task Title'
			
			Thread.sleep(5000);
			row0 = sheet.getRow(28);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String desc = c1.getStringCellValue();
			performerPOM.clickTaskDesc(driver).sendKeys(desc);		//Writing 'Task Description'
			
			
			Thread.sleep(1000);
			performerPOM.clickDueDate(driver).click();				//Clicking on 'Due Date' text box
			OverduePOM.selectNextMonth(driver).click();
			OverduePOM.selectDate(driver).click();					//Selecting particular date.
			
			Thread.sleep(1000);
			Actions action = new Actions(driver);
//			action.moveToElement(performerPOM.clickPriority(driver)).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
			
			
			Thread.sleep(1000);
			 row0 = sheet.getRow(29);									//Selected 0th index row (First row)
			 c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String outcome = c1.getStringCellValue();
			performerPOM.clickExpOutcome(driver).sendKeys(outcome);	//Writing 'Expected Outcome'
			
			
			
			Thread.sleep(1000);
			row0 = sheet.getRow(30);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String internalUser = c1.getStringCellValue();
			performerPOM.clickInternalUser3(driver).click();
			//performerPOM.selectInternalUser2(driver).click();
			performerPOM.selectInternalUser3(driver).sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
			
			Thread.sleep(1000);
			row0 = sheet.getRow(31);									//Selected 0th index row (First row)
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
			row0 = sheet.getRow(32);									//Selected 0th index row (First row)
			c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
			String remark = c1.getStringCellValue();
			performerPOM.clickRemark(driver).sendKeys(remark);		//Writing 'Remark'
			
		    
			
			Thread.sleep(300);
			OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
			
//			Thread.sleep(300);
//			wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg(driver)));
//			
//			Thread.sleep(300);
//			String msg = performerPOM.readTaskMsg(driver).getText();
//			if(msg.contains("Task Saved Successfully."))
//			{
//				test.log(LogStatus.PASS, "Task Saved Successfully.");
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "Task didn't saved successfully.");
//			}
			
		}
	

	
		static void CaseHearing(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
		{
			   performerPOM.clickCaseHearing(driver).click();
				Thread.sleep(3000);
				performerPOM.clickNewCaseHearing(driver).click();
				
				
				
//				Thread.sleep(300);
//				Row row0 = sheet.getRow(35);					//Selected 0th index row (First row)
//				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//				int HearingDate = (int) c1.getNumericCellValue();
//				performerPOM.clickCaseHearingDate(driver).sendKeys(HearingDate+"");	//Writing 'HearingDate'
//				
				performerPOM.clickCaseHearingDate(driver).sendKeys("10-1-2023");	//Writing 'HearingDate'
				
			
			    Thread.sleep(3000);
			    performerPOM.clickSaveCaseHearingDate(driver).click();
			
				
				Thread.sleep(2000);
				Row row1 = sheet.getRow(35);									//Selected 0th index row (First row)
				Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
				String HearingDescription = c2.getStringCellValue();
				performerPOM.clickCaseHearingDecsri(driver).sendKeys(HearingDescription);		//Writing 'HearingDescription'
				
			   
				Thread.sleep(3000);
			    performerPOM.clickSaveCaseHearing(driver).click();
		} 
			 
		static void CaseOrder(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
		{
			 Thread.sleep(3000);
			 performerPOM.clickCaseOrder(driver).click();
			 Thread.sleep(6000);
			 performerPOM.clickNewCaseOrder(driver).click();
			 Thread.sleep(3000);
			 performerPOM. clickCaseOrderDate(driver).sendKeys("15-1-2023");
			 Thread.sleep(3000);
			 performerPOM.clickOrderPanel(driver).click();
			 Thread.sleep(3000);
			 performerPOM. clickCaseOrderType(driver).click();
			 Thread.sleep(3000);
			 performerPOM.selectCaseOrderType(driver).click();
			
			 
			 
				
				Thread.sleep(300);
				Row row0 = sheet.getRow(39);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int OrderTitle = (int) c1.getNumericCellValue();
				performerPOM.clickCaseOrderTitle(driver).sendKeys(OrderTitle+"");	//Writing 'HearingDate'
				
//		     Thread.sleep(2000);
//			 Row row1 = sheet.getRow(40);									//Selected 0th index row (First row)
//			 Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
//			 String OrderTitle = c2.getStringCellValue();
//			 performerPOM.clickCaseOrderTitle(driver).sendKeys(OrderTitle);   //click order title
//			 
			 Thread.sleep(2000);
			 Row row2 = sheet.getRow(40);									//Selected 0th index row (First row)
			 Cell c2 = row2.getCell(1);									//Selected cell (0 row,1 column)
			 String OrderDecri = c2.getStringCellValue();
			 performerPOM.clickCaseOrderDecri(driver).sendKeys(OrderDecri);     //click oder description
			

			 Thread.sleep(3000);
			 performerPOM.clickSaveCaseOrder(driver).click();
		}	 
			 
		static void AdvocateBill(WebDriver driver) throws InterruptedException
		{
		      Thread.sleep(3000);
			 performerPOM.clickAdvocateBill(driver).click();
			 Thread.sleep(3000);
			 performerPOM. clickNewAdvocateBill(driver).click();
			 Thread.sleep(3000);
		     performerPOM. clickInvoiceNum(driver).sendKeys("657");
			 Thread.sleep(3000);
			 performerPOM. clickInvoiceDate(driver).sendKeys("16-11-2022");
			 Thread.sleep(3000);
			 performerPOM.clickAdvocateBillPanel(driver).click();
			 Thread.sleep(3000);
			 performerPOM. clickInvoiceAmount(driver).sendKeys("30000");
//			 Thread.sleep(3000);
//			 performerPOM.clickLawFirm1(driver).click();
//			 Thread.sleep(3000);
//		      performerPOM.selectLawFirm1(driver);
		     Thread.sleep(3000);
			 performerPOM.clickApprover1(driver).click();
			 Thread.sleep(3000);
		     performerPOM.selectApprover1(driver);
			 Thread.sleep(3000);
			 performerPOM.clickApprover2(driver).click();
		     Thread.sleep(3000);
			 performerPOM.selectApprover2(driver);
			 Thread.sleep(3000);
			 performerPOM.clickSaveAdvocateBill(driver).click();
			 
      }

      static void StatusPayment(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
      {	
    	       WebDriverWait wait=new WebDriverWait(driver,50);
      
               performerPOM.clickCaseStatusPayments(driver).click();		//Clicking on 'Status/Payments'
				
				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus(driver)));
//				
//				performerPOM.clickCaseStage(driver).click();
//				Thread.sleep(300);
//				performerPOM.selectCaseStage(driver).sendKeys("Hearing", Keys.ENTER);
//				
//				Thread.sleep(300);
//				performerPOM.clickCaseStatus(driver).click();				//Clicking on 'Case Status' drop down.
//				Thread.sleep(300);
//				performerPOM.clickCaseStatusClose(driver).click();			//Selecting 'Closed' option from drop down.
//				
//				Thread.sleep(300);
//				wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate(driver)));
//				performerPOM.clickCaseCloseDate(driver).click();				//Clicking on 'Closed Date' date box
//				OverduePOM.selectLastMonth(driver).click();					//Getting last month
//				OverduePOM.selectDate2(driver).click();						//Selecting particular date.
//				
//				Thread.sleep(300);
//				performerPOM.clickCaseResult(driver).click();
//				performerPOM.clickSelectCaseResult(driver).sendKeys("In Progress", Keys.ENTER);
//				
//				Thread.sleep(300);
//				performerPOM.clickRemark1(driver).sendKeys("Automation Testing");
//				
//				Thread.sleep(300);
//				performerPOM.clickSave1(driver).click();
//			 
				
				Thread.sleep(3000);
				Row row0 = sheet.getRow(52);					//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int InvoiceNo = (int) c1.getNumericCellValue();
				performerPOM.clickCaseInvoiceNo1(driver).sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
				
			    
				Thread.sleep(5000);
				performerPOM.clickPaymentTyp1(driver);
				List<WebElement> PaymentType1= driver.findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
				PaymentType1.get(1).click();
				
				
				Thread.sleep(10000);
//				Row row1 = sheet.getRow(54);					//Selected 0th index row (First row)
//				Cell c2 = row1.getCell(1);						//Selected cell (0 row,1 column)
//				int Amount = (int) c2.getNumericCellValue();
//				performerPOM.clickAmount1(driver).sendKeys(Amount+"");	//Writing 'Amount'
				performerPOM.clickAmount1(driver).sendKeys("5000");	//Writing 'Amount'
			
	
				Thread.sleep(3000);
				performerPOM.clickSavePaymentLog1(driver).click();
			
      }
      

      static void ExternalLawyer(WebDriver driver,ExtentTest test) throws InterruptedException
      {
    	  
    	           WebDriverWait wait=new WebDriverWait(driver,50);
				  Thread.sleep(3000);
				   performerPOM. clickExternalLawyerRating1(driver).click();
				   
//				   Thread.sleep(4000);
//				   performerPOM.selectCaseExternalLawyer(driver);
				   
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
	   
      static void Auditlog(WebDriver driver) throws InterruptedException
      {
				   Thread.sleep(3000);
				   performerPOM. clickAuditLog(driver).click();
				   Thread.sleep(3000);
				   performerPOM.clickExport(driver).click();		   
				   Thread.sleep(3000);
				   driver.switchTo().parentFrame();
				   performerPOM.clickclosebutton(driver).click();
      }	 
			 
	
	static void TaskAdd(WebDriver driver, ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.UP);
		js.executeScript("window.scrollBy(0,-700)");
		performerPOM.clickAddNewTask(driver).click();				//Clicking on 'New' button
		
		progress(driver);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
		
//		
//		Thread.sleep(300);
//		performerPOM.clickDueDate(driver).click();				//Clicking on 'Due Date' text box
//		OverduePOM.selectNextMonth(driver).click();
//		OverduePOM.selectDate(driver).click();					//Selecting particular date.
//		
		Thread.sleep(500);
		Row row0 = sheet.getRow(0);								//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		String title = c1.getStringCellValue();
		performerPOM.clickTaskTitle(driver).sendKeys(title);	//Writing 'Task Title'
		
		Thread.sleep(300);
		row0 = sheet.getRow(1);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String desc = c1.getStringCellValue();
		performerPOM.clickTaskDesc(driver).sendKeys(desc);		//Writing 'Task Description'
		
		Thread.sleep(300);
		performerPOM.clickDueDate(driver).click();				//Clicking on 'Due Date' text box
		OverduePOM.selectNextMonth(driver).click();
		OverduePOM.selectDate(driver).click();					//Selecting particular date.
		
		Thread.sleep(300);
		Actions action = new Actions(driver);
		action.moveToElement(performerPOM.clickPriority(driver)).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
		
		Thread.sleep(300);
		row0 = sheet.getRow(2);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String outcome = c1.getStringCellValue();
		performerPOM.clickExpOutcome(driver).sendKeys(outcome);	//Writing 'Expected Outcome'
		
		Thread.sleep(300);
		row0 = sheet.getRow(3);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String internalUser = c1.getStringCellValue();
		performerPOM.clickInternalUser1(driver).click();
		performerPOM.clickSearchInternalUser1(driver).sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
		
		Thread.sleep(1000);
		row0 = sheet.getRow(4);									//Selected 0th index row (First row)
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
		row0 = sheet.getRow(5);									//Selected 0th index row (First row)
		c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
		String remark = c1.getStringCellValue();
		performerPOM.clickRemark(driver).sendKeys(remark);		//Writing 'Remark'
		
		//Thread.sleep(300);
		//String workingDir = System.getProperty("user.dir");
		//performerPOM.clickUpload(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
		
		Thread.sleep(300);
		OverduePOM.clickSaveButton(driver).click();				//Clicking on 'Save' button.
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage(driver)));
		
		Thread.sleep(300);
		String msg = performerPOM.clickMessage(driver).getText();
		if(msg.contains("Task Saved Successfully."))
		{
			test.log(LogStatus.PASS, "Task Saved Successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Task didn't saved successfully.");
		}
		
		driver.switchTo().parentFrame();
		performerPOM.clickClose1(driver).click();			//Clicking on 'Close'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport(driver)));
		
		Thread.sleep(300);
		performerPOM.clickStatusDropDown(driver).click();		//Clicking on 'Status drop down.
		Thread.sleep(500);
		//performerPOM.selectStatusDropDown(driver).click();		//Selecting 'Pending/Open' status
		
		Thread.sleep(500);
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
			test.log(LogStatus.PASS, "Total Task Count increased in grid after adding New Task.");
			test.log(LogStatus.INFO, "Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Task Count doesn't increased in grid after adding New Task.");
			test.log(LogStatus.INFO, "Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskOpen(driver)));
		int open1 = Integer.parseInt(performerPOM.clickTaskOpen(driver).getText());	//Reading Notice Open count.
		
		if(open1 > open)
		{
			test.log(LogStatus.PASS, type+" Dashboard Count Increased.");
			test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increased.");
			test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
		}
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
			open = Integer.parseInt(performerPOM.clickCaseOpen(driver).getText());	//Reading Case Open count.
			performerPOM.clickCaseOpen(driver).click();						//Clicking on 'Open' Case
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
			
//			if(flag == 0)
//			{
//				row = sheet.getRow(no-1);
//				c1 = row.getCell(0);
//				records = c1.getStringCellValue();
//				SheetRecords = Integer.parseInt(records);
//			}
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
	
	public static void NoticeOpen(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		int sheetNo = 0;
	    if(login.equalsIgnoreCase("Performer"))
	    {
	    	sheetNo = 1;
	    }
	    else if(login.equalsIgnoreCase("Company Admin"))
	    {
	    	sheetNo = 5;
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
	
	public static void NoticeClosed(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		CountExcel(driver, test, "Notice - Closed");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew(driver)));
		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
	}
	
	public static void CaseOpen(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		int sheetNo = 0;
	    if(login.equalsIgnoreCase("Performer"))
	    {
	    	sheetNo = 2;
	    }
	    else if(login.equalsIgnoreCase("Company Admin"))
	    {
	    	sheetNo = 6;
	    }
		
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
	
	public static void CaseClosed(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		CountExcel(driver, test, "Case - Closed");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew(driver)));
		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
	}
	
	public static void TaskOpen(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		int sheetNo = 0;
	    if(login.equalsIgnoreCase("Performer"))
	    {
	    	sheetNo = 3;
	    }
	    else if(login.equalsIgnoreCase("Company Admin"))
	    {
	    	sheetNo = 7;
	    }
	    
	//  performerPOM.clickTaskOpen(driver).click();
		int open = CountExcel(driver, test, "Task - Open");
		
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
		
		TaskAdd(driver, test, sheet, open, gridRecords, "Task - Open");
	}
	
	public static void TaskClosed(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		CountExcel(driver, test, "Task - Closed");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNewTask(driver)));
		OverduePOM.clickDashboard(driver).click();			//Clicking on 'Dashboard'
	}
	
	public static void LinkDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
		if(type.equals("Notice"))
		{
			performerPOM.clickNoticeOpen(driver).click();							//Clicking on 'Open' notice
		}
		else if(type.equals("Case"))
		{
			performerPOM.clickCaseOpen(driver).click();								//Clicking on 'Open' case
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
		
		String refNo = null;
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame		
		if(type.equals("Notice"))
		{
			performerPOM.clickLinkNotice(driver).click();			//Clicking on Link Notice icon
			
			Thread.sleep(300);
			progress(driver);
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCheckBox(driver)));	//Waiting for Checkbox to get visible.
			refNo = performerPOM.readRef(driver).getText();			//Reading ref no.
			
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
			refNo = performerPOM.readCaseRef(driver).getText();			//Reading ref no.
			
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
		
		int flag = 0;
		int n = 0;
		if(type.equals("Notice"))
		{
			performerPOM.clickClosePopup(driver).click();
			
			Thread.sleep(300);
			performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_DOWN);
			performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_DOWN);
			performerPOM.clickLinkNotice(driver).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(300);
			elementsList = performerPOM.readRef1(driver);
			n = elementsList.size();
			
			if(n > 0)
			{
				for(int i = 0; i < n; i++)
				{
					String ref = elementsList.get(i).getText();
					if(refNo.equalsIgnoreCase(ref))
					{
						flag = 1;
						break;
					}
				}
			}
		}
		else if(type.equals("Case"))
		{
			performerPOM.clickClosePopupCase(driver).click();
			
			Thread.sleep(300);
			performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_DOWN);
			performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_DOWN);
			performerPOM.clickLinkCase(driver).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(300);
			elementsList = performerPOM.readCaseRef1(driver);
			n = elementsList.size();
			
			if(n > 0)
			{
				for(int i = 0; i < n; i++)
				{
					String ref = elementsList.get(i).getText();
					if(refNo.equalsIgnoreCase(ref))
					{
						flag = 1;
						break;
					}
				}
			}
		}
		
		if(flag == 1)
		{
			test.log(LogStatus.PASS, "Linked "+type+" displayed in "+type+" Summary. Reference No = "+refNo);
		}
		else
		{
			test.log(LogStatus.FAIL, "Linked "+type+" doesn't displayed in "+type+" Summary. Reference No = "+refNo);
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
	
	public static void CloseNoticeCase(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
		int closed = 0;
		int open = 0;
		int caseOpen = 0;
		if(type.equals("Notice"))
		{
			closed = Integer.parseInt(performerPOM.clickNoticeClosed(driver).getText());	//Reading Notice Closed count.
			open = Integer.parseInt(performerPOM.clickNoticeOpen(driver).getText());		//Reading Notice Open count.
			caseOpen = Integer.parseInt(performerPOM.clickCaseOpen(driver).getText());
			
			performerPOM.clickNoticeOpen(driver).click();									//Clicking on 'Open' notice
		}
		else if(type.equals("Case"))
		{
			open = Integer.parseInt(performerPOM.clickCaseOpen(driver).getText());			//Reading Case Open count.
			closed = Integer.parseInt(performerPOM.clickCaseClosed(driver).getText());		//Reading Case Closed count.
			
			performerPOM.clickCaseOpen(driver).click();										//Clicking on 'Open' case
		}
		else if(type.equals("Task"))
		{
			open = Integer.parseInt(performerPOM.clickTaskOpen(driver).getText());			//Reading Task Open count.
			closed = Integer.parseInt(performerPOM.clickTaskClosed(driver).getText());		//Reading Task Closed count.
			
			performerPOM.clickTaskOpen(driver).click();										//Clicking on 'Open' task
		}
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport(driver)));	//Waiting until visibility of Excel Report button.
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		performerPOM.GridLoad(driver).click();
		elementsList = performerPOM.clickAction(driver);			//Getting all action buttons.
		js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
		
		Thread.sleep(500);
		elementsList = performerPOM.clickAction(driver);			//Getting all action buttons.
		elementsList.get(0).click();								//Clicking on first action button.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame
		
		Thread.sleep(300);
		if(type.equals("Notice"))
		{
			sheet = workbook.getSheetAt(1);
			
			performerPOM.clickStatusPayments(driver).click();			//Clicking on 'Status/Payments'
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus(driver)));
			performerPOM.clickNoticeStatus(driver).click();				//Clicking on 'Notice Status' drop down.
			Thread.sleep(300);
			performerPOM.clickClosedStatus(driver).click();				//Selecting 'Closed' option from drop down.
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate(driver)));
			performerPOM.clickCloseDate(driver).click();				//Clicking on 'Closed Date' date box
			OverduePOM.selectLastMonth(driver).click();					//Getting last month
			OverduePOM.selectDate2(driver).click();						//Selecting particular date.
			
			Thread.sleep(300);
			performerPOM.clickNoticeResult(driver).click();
			performerPOM.clickSelectResult(driver).sendKeys("In Progress", Keys.ENTER);
			
			
			Thread.sleep(300);
			Row r1 = sheet.getRow(40);
			Cell c1 = r1.getCell(1);
			String remark = c1.getStringCellValue();
			performerPOM.clickRemark1(driver).sendKeys(remark);
			
			Thread.sleep(300);
			r1 = sheet.getRow(41);
			c1 = r1.getCell(1);
			String CaseNo = c1.getStringCellValue();
			performerPOM.clickCourtCaseNo(driver).sendKeys(CaseNo);
			
			Thread.sleep(300);
			performerPOM.clickSaveConvertCase(driver).click();	
			
//			Thread.sleep(300);
//		Row r1 = sheet.getRow(25);
//			Cell c1 = r1.getCell(1);
//			String remark = c1.getStringCellValue();
//			performerPOM.clickRemark1(driver).sendKeys(remark);
//			
//			Thread.sleep(300);
//			r1 = sheet.getRow(26);
//			c1 = r1.getCell(1);
//			String CaseNo = c1.getStringCellValue();
//			performerPOM.clickCourtCaseNo(driver).sendKeys(CaseNo);
//			
//			Thread.sleep(300);
//			performerPOM.clickSaveConvertCase(driver).click();
		}
		else if(type.equals("Case"))
		{
			performerPOM.clickCaseStatusPayments(driver).click();		//Clicking on 'Status/Payments'
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus(driver)));
			
			performerPOM.clickCaseStage(driver).click();
			Thread.sleep(300);
			performerPOM.selectCaseStage(driver).sendKeys("Hearing", Keys.ENTER);
			
			Thread.sleep(300);
			performerPOM.clickCaseStatus(driver).click();				//Clicking on 'Case Status' drop down.
			Thread.sleep(300);
			performerPOM.clickCaseStatusClose(driver).click();			//Selecting 'Closed' option from drop down.
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate(driver)));
			performerPOM.clickCaseCloseDate(driver).click();				//Clicking on 'Closed Date' date box
			OverduePOM.selectLastMonth(driver).click();					//Getting last month
			OverduePOM.selectDate2(driver).click();						//Selecting particular date.
			
			Thread.sleep(300);
			performerPOM.clickCaseResult(driver).click();
			performerPOM.clickSelectCaseResult(driver).sendKeys("In Progress", Keys.ENTER);
			
			Thread.sleep(300);
			performerPOM.clickRemark1(driver).sendKeys("Automation Testing");
			
			Thread.sleep(300);
			performerPOM.clickSave1(driver).click();
		}
		else if(type.equals("Task"))
		{
			
		}
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2(driver)));
		String msg = performerPOM.readMessage2(driver).getText();
		
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed - "+msg);
		}
		else if(msg.contains("already exist"))
		{
			test.log(LogStatus.SKIP, "Message displayed - "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - "+msg);
		}
		
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		
		Thread.sleep(3000);
		performerPOM.clickClose(driver).click();
		
		Thread.sleep(5000);
		OverduePOM.clickDashboard(driver).click();
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));
		int closed1 = 0;
		int open1 = 0;
		int caseOpen1 = 0;
		if(type.equals("Notice"))
		{
			closed1 = Integer.parseInt(performerPOM.clickNoticeClosed(driver).getText());	//Reading Notice Open count.
			open1 = Integer.parseInt(performerPOM.clickNoticeOpen(driver).getText());		//Reading Notice Open count.
			caseOpen1 = Integer.parseInt(performerPOM.clickCaseOpen(driver).getText());
			
			if(open > open1 && closed1 > closed && caseOpen1 > caseOpen)
			{
				test.log(LogStatus.PASS, "Notice-Closed count increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Notice-Open count decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
				test.log(LogStatus.PASS, "Case-Open count increased.");
				test.log(LogStatus.INFO, "Old Count = "+caseOpen+" | New Count = "+caseOpen1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Notice-Closed count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.FAIL, "Notice-Open count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
				test.log(LogStatus.FAIL, "Case-Open count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+caseOpen+" | New Count = "+caseOpen1);
			}
		}
		else if(type.equals("Case"))
		{
			open1 = Integer.parseInt(performerPOM.clickCaseOpen(driver).getText());			//Reading Case Open count.
			closed1 = Integer.parseInt(performerPOM.clickCaseClosed(driver).getText());		//Reading Case Closed count.
			
			if(open > open1 && closed1 > closed)
			{
				test.log(LogStatus.PASS, "Case-Closed count increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Case-Open count decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Case-Closed count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.FAIL, "Case-Open count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
		}
		else if(type.equals("Task"))
		{
			open1 = Integer.parseInt(performerPOM.clickTaskOpen(driver).getText());			//Reading Task Open count.
			closed1 = Integer.parseInt(performerPOM.clickTaskClosed(driver).getText());		//Reading Task Closed count.
			
			if(open > open1 && closed1 > closed)
			{
				test.log(LogStatus.PASS, "Task-Closed count increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Task-Open count decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
			else
			{
				test.log(LogStatus.PASS, "Task-Closed count doesn't increased.");
				test.log(LogStatus.INFO, "Old Count = "+closed+" | New Count = "+closed1);
				test.log(LogStatus.PASS, "Task-Open count doesn't decreased.");
				test.log(LogStatus.INFO, "Old Count = "+open+" | New Count = "+open1);
			}
		}
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
	
	 
	public static void MyDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
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
				Thread.sleep(5000);
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
			     
      public static void AdvancedSearchDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
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
	 
					
					Thread.sleep(8000);
					performerPOM.clickTypeDropdown2(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(8000);
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
					
				   
					Thread.sleep(8000);
					performerPOM.clickTypeDropdown2(driver).click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(8000);
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
	
	
	
	public static void MyReports(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
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

//		Thread.sleep(10000);
//		performerPOM.viewNoticeDetails1(driver).click();
//		test.log(LogStatus.PASS, "Show details Notice popup open successfully.");
//		
//		
//		Thread.sleep(5000);
//		performerPOM.Actionclosepopup1(driver).click();
//		
//		Thread.sleep(5000);
//		performerPOM.showResponseDetailIcon1(driver).click();
//		test.log(LogStatus.PASS, "Show response details Notice  popup open successfully.");
//		
//		Thread.sleep(5000);
//		performerPOM.Actionclosepopup1(driver).click();
//		
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
//		Thread.sleep(5000);
//		performerPOM.viewNoticeDetails1(driver).click();
//		test.log(LogStatus.PASS, "Show details Case popup open successfully.");
//		
//		Thread.sleep(5000);
//		performerPOM.Actionclosepopup1(driver).click();
//		
//		Thread.sleep(5000);
//		performerPOM.showResponseDetailIcon1(driver).click();
//		test.log(LogStatus.PASS, "Show response details Case popup open successfully.");
//		
//		Thread.sleep(5000);
//		performerPOM.Actionclosepopup1(driver).click();
//		
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
//		Thread.sleep(5000);
//		performerPOM.viewTaskDetails(driver).click();	
//		test.log(LogStatus.PASS, "Show details Task popup open successfully.");
//		
//		Thread.sleep(5000);
//		performerPOM.ActioncloseTaskpopup(driver).click();
		
		Thread.sleep(500);
		Report(driver, test, count1, "Task");
		
		
	}
	
	
	public static void MoreReport(WebDriver driver, ExtentTest test, String type) throws InterruptedException
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
		performerPOM.selectlocationFilterReports(driver).click();
		
		Thread.sleep(3000);
		performerPOM.FromDateReports(driver).sendKeys("01-12-2022");
		
//		Thread.sleep(3000);
//		performerPOM.selectFromDate(driver).click();
		
		Thread.sleep(3000);
		performerPOM.ToDateReports(driver).sendKeys("21-12-2022");
		
//		Thread.sleep(3000);
//		performerPOM.selectToDate(driver).click();
		
		
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
		performerPOM.selectlocationFilterReports(driver).click();
		
		Thread.sleep(3000);
		performerPOM.FromDateReports(driver).sendKeys("01-12-2022");
		
//		Thread.sleep(3000);
//		performerPOM.selectFromDate(driver).click();
		
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
		
		
	}

	static void NewReminder(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1(driver)));
		performerPOM.clickAddNew1(driver).click();		//Clicking on 'Add New' button.
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickType(driver)));
		Actions action = new Actions(driver);
		
		if(type.equalsIgnoreCase("Notice"))
		{
			action.moveToElement(performerPOM.clickType(driver)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		}
		else if(type.equalsIgnoreCase("Task"))
		{
			action.moveToElement(performerPOM.clickType(driver)).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
		}
		
		Thread.sleep(2000);
		action.moveToElement(performerPOM.clickTitle(driver)).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
		
		Thread.sleep(3000);
		performerPOM.clickReminderText(driver).sendKeys("Automation Testing reminder msg.");
		
		Thread.sleep(3000);
		performerPOM.clickDescription(driver).sendKeys("Automation reminder descriptio new.");
		
		Thread.sleep(3000);
		performerPOM.clickRemark2(driver).sendKeys("Automation reminder remark new.");
		
		Thread.sleep(3000);
		performerPOM.clickDate(driver).click();
		Thread.sleep(3000);
		OverduePOM.selectNextMonth(driver).click();
		OverduePOM.selectDate(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickSave(driver).click();				//Clicking on Save button.
		
		Thread.sleep(500);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg1(driver)));
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg1(driver)));
		}
		Thread.sleep(3000);
		String msg = performerPOM.readMsg1(driver).getText();
		if(msg.contains("Successfully"))
		{
			test.log(LogStatus.PASS, type+" Message Displayed - "+msg);
		}
		else if(msg.contains("already exists"))
		{
			test.log(LogStatus.PASS, type+" Message Displayed - "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" Message Displayed - "+msg);
		}
		
		Thread.sleep(300);
		driver.switchTo().parentFrame();
		
		Thread.sleep(300);
		performerPOM.clickCloseReminder(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickEditReminder(driver).click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		
		
         Actions action1 = new Actions(driver);
		
		if(type.equalsIgnoreCase("Notice"))
		{
			action1.moveToElement(performerPOM.clickType(driver)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		}
		else if(type.equalsIgnoreCase("Task"))
		{
			action1.moveToElement(performerPOM.clickType(driver)).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
		}
		
		Thread.sleep(2000);
		action1.moveToElement(performerPOM.clickTitle(driver)).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
		
		Thread.sleep(3000);
		performerPOM.clickReminderText(driver).clear();
		
		Thread.sleep(3000);
		performerPOM.clickReminderText(driver).sendKeys("Automation Testing reminder msg.");
		
		Thread.sleep(3000);
		performerPOM.clickDate(driver).click();
		Thread.sleep(3000);
		OverduePOM.selectNextMonth(driver).click();
		OverduePOM.selectDate(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickSave(driver).click();				//Clicking on Save button.
		
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg2(driver)));
		
		Thread.sleep(500);
		String msg5 = performerPOM.readMsg2(driver).getText();		//Reading Message appeared after save button
		int flag5= 0;
		if(msg5.equalsIgnoreCase("Reminder Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg5);
			flag5 = 1;
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg5);
		}
		

		Thread.sleep(300);
		driver.switchTo().parentFrame();
		
		Thread.sleep(300);
		performerPOM.clickCloseReminder(driver).click();
		
		Thread.sleep(300);
		performerPOM.clickDeleteReminder(driver).click();
		
		 Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();	
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        		
	        // Accepting alert		
	        alert.accept();		
	}
	
	public static void MyReminder(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
		performerPOM.clickMyReminder(driver).click();					//Clicking on 'My Reports'
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.CheckRecordsTable(driver)));	//Wait until records table gets visible.
		
		NewReminder(driver, test, "Case");
		
		NewReminder(driver, test, "Notice");
		
		NewReminder(driver, test, "Task");
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
	}
		
//	public static void Masters(WebDriver driver, ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
//	{
//		XSSFSheet sheet = ReadExcel();
//		WebDriverWait wait = new WebDriverWait(driver, 180);
//		progress(driver);
//		
//		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
//	
//		Thread.sleep(3000);
//		LegalEntity(driver,test);
//		Thread.sleep(5000);
//		LawFirm(driver,test);
//		Thread.sleep(5000);
//		User(driver,test);
//		Thread.sleep(5000);
//     	Opponent(driver,test);
//		Thread.sleep(5000);
//		Court(driver,test);
//		Thread.sleep(5000);
//		PaymentType(driver,test);
//	
//		Thread.sleep(5000);
//		customParameter(driver,test);
//		Thread.sleep(5000);
//		CaseStage(driver,test);
//		Thread.sleep(5000);
//		DocumentType(driver,test);
//		Thread.sleep(5000);
//		RatingCriteria(driver,test);
//		Thread.sleep(5000);
//		PageAuthorization(driver,test);
//		Thread.sleep(5000);
//		NoticeStage(driver,test);
//		Thread.sleep(5000);
//		UserReassignment(driver,test);
////		Thread.sleep(5000);
////		MailAuthorization(driver);
////		Thread.sleep(3000);
////		CaseNoticeType(driver,test);
//		
//		
//	   Thread.sleep(6000);
//		OverduePOM.clickDashboard(driver).click();
//	}	
	public static void LegalEntity(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
		
		XSSFSheet sheet = ReadExcel();
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
		
		 performerPOM.clickMasters(driver).click();
	     Thread.sleep(300);
		 performerPOM.chooseMasterLegalEntity(driver).click();
		 Thread.sleep(300);
		 performerPOM.addLegalEntity(driver).click();
		

		Thread.sleep(5000);
		Row row0 = sheet.getRow(10);						//Selected 0th index row (First row)
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
	    

		Thread.sleep(1000);
		Row row = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String address= c.getStringCellValue();
	    performerPOM.clickAddressLine(driver).sendKeys(address);
		
	    Thread.sleep(3000);
	    performerPOM.clickState1(driver).click();
	    
	    Thread.sleep(3000);
	    performerPOM.chooseState1(driver).click();
	    
	    Thread.sleep(5000);
	    performerPOM.clickCity(driver).click();
	    
	    Thread.sleep(5000);
	    performerPOM.chooseCity(driver).click();
	    
	   
	    Thread.sleep(4000);
		
		Row row2 = sheet.getRow(12);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		String contact= c2.getStringCellValue();
	    performerPOM.clickContactPerson(driver).sendKeys(contact+"");
	    
	    Thread.sleep(3000);
	  	Row row3 = sheet.getRow(13);						//Selected 0th index row (First row)
	  	Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
	  	String email= c3.getStringCellValue();
	  	 performerPOM.clickEmail(driver).sendKeys(email);
	   
	   	Thread.sleep(3000);
	    performerPOM.clickSaveLegalEntity(driver).click();
	    
	    Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400)");
		
	    WebDriverWait wait1=new WebDriverWait(driver,30);
	    Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(performerPOM.readlegalmsg(driver)));
					
		Thread.sleep(500);
		String msg5 = performerPOM.readlegalmsg(driver).getText();		//Reading Message appeared after save button
		int flag5= 0;
		if(msg5.equalsIgnoreCase("Branch Added Successfully."))
			{
						test.log(LogStatus.PASS, "Legal Entity-Branch Added Successfully.");
						flag5 = 1;
			}
		else
			{
						test.log(LogStatus.FAIL, "Legal Entity-Customer branch name already exists");
			}
		   
			Thread.sleep(3000);
			performerPOM.clickcloseLegalEntity(driver).click();
			    
		    Thread.sleep(3000);  
			performerPOM.editLegalEntity(driver).click();  
			  
			Thread.sleep(3000);  
		    performerPOM.legalEntityName(driver).clear();
			  
		    Thread.sleep(5000);
			Row row4 = sheet.getRow(14);						//Selected 0th index row (First row)
		    Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
		    String NamelegalEntity= c4.getStringCellValue();
		    performerPOM.legalEntityName(driver).sendKeys(NamelegalEntity);
			    
			Thread.sleep(5000);
			performerPOM.clickSaveLegalEntity(driver).click();
			    
			 Thread.sleep(5000);
			 String msg6 = performerPOM.readlegalmsg(driver).getText();		//Reading Message appeared after save button
			 int flag6= 0;
			 if(msg6.equalsIgnoreCase("Branch Updated Successfully."))
			 {
					test.log(LogStatus.PASS, "Legal Entity-Branch Updated Successfully.");
					flag6 = 1;
			 }
			 else
				{
					test.log(LogStatus.FAIL, "Legal Entity-Customer branch name already exists");
				}
			    
			 Thread.sleep(5000);
			 performerPOM.clickcloseLegalEntity(driver).click();
			 
			 Thread.sleep(5000);
			 performerPOM.clickLegalEntityFilter(driver).sendKeys("sneha", Keys.ENTER);
			 
			 Thread.sleep(5000);
			 performerPOM.clickLegalEntityFilter(driver).clear();
			 
				test.log(LogStatus.PASS,"Legal Entity Filter Work Successfully");
			    
			    
	 }
  public static void LawFirm(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
  {
	  
	  XSSFSheet sheet = ReadExcel();
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
		
		//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen(driver)));	//Wait until 'Notice-Open' count get visible
		
	  
	    Thread.sleep(3000);
	    performerPOM.clickMasters(driver).click();
	  //  Thread.sleep(3000);
		//performerPOM.clickMastersMenu(driver).click();
	     Thread.sleep(5000);
	    performerPOM.chooseMasterLawFirm(driver).click();
	    Thread.sleep(3000);
		performerPOM.newLawFirm(driver).click();
		
		Thread.sleep(3000);
		Row row4 = sheet.getRow(16);						//Selected 0th index row (First row)
		Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
		String name= c4.getStringCellValue();
		performerPOM.nameLawFirm(driver).sendKeys(name);
	    
		
		Thread.sleep(3000);
	    Row row5 = sheet.getRow(17);						//Selected 0th index row (First row)
		Cell c5 = row5.getCell(1);						//Selected cell (0 row,1 column)
		String email1= c5.getStringCellValue();
		performerPOM.Email(driver).sendKeys(email1);
		
		

		Thread.sleep(3000);
		progress(driver);
		Thread.sleep(3000);
		Row row6 = sheet.getRow(18);						//Selected 0th index row (First row)
		Cell c6 = row6.getCell(1);						//Selected cell (0 row,1 column)
		int contactno = (int) c6.getNumericCellValue();
	    performerPOM.contactNo(driver).sendKeys(contactno+" ");
	    
	   	Thread.sleep(3000);
		performerPOM.clickSaveLawFirm(driver).click();
		
	    
		Thread.sleep(3000);
		String msg5 = performerPOM.ReadLawFirmMsg(driver).getText();		//Reading Message appeared after save button
		int flag5= 0;
		if(msg5.equalsIgnoreCase("Law Firm Details Saved Successfully."))
			{
					test.log(LogStatus.PASS, "Law Firm- Law Firm Details Saved Successfully.");
					flag5 = 1;
			}
		else
			{
					test.log(LogStatus.FAIL, "Law Firm- User with Same Email already Exists. ");
			}
		
			
		Thread.sleep(3000);
		performerPOM.clickCloseButton(driver).click();
		
		Thread.sleep(3000);
		performerPOM.editLawFirm(driver).click();
		
		Thread.sleep(3000);
		performerPOM.nameLawFirm(driver).clear();
		
		Thread.sleep(3000);
		Row row12 = sheet.getRow(22);						//Selected 0th index row (First row)
		Cell c12 = row12.getCell(1);						//Selected cell (0 row,1 column)
		String LawFirmname= c12.getStringCellValue();
		performerPOM.nameLawFirm(driver).sendKeys(LawFirmname);
		
		Thread.sleep(3000);
		performerPOM.Email(driver).clear();
		Thread.sleep(3000);
	    Row row13 = sheet.getRow(17);						//Selected 0th index row (First row)
		Cell c13 = row5.getCell(1);						//Selected cell (0 row,1 column)
		String email2= c13.getStringCellValue();
		performerPOM.Email(driver).sendKeys(email2);
		
		Thread.sleep(3000);
		 performerPOM.contactNo(driver).clear();

		Thread.sleep(3000);
		progress(driver);
		Thread.sleep(3000);
		Row row14 = sheet.getRow(18);						//Selected 0th index row (First row)
		Cell c14 = row14.getCell(1);						//Selected cell (0 row,1 column)
		int editcontactno = (int) c14.getNumericCellValue();
	    performerPOM.contactNo(driver).sendKeys(editcontactno+"");
		
		Thread.sleep(3000);
		performerPOM.clickSaveLawFirm(driver).click();
		
		
		String msg6 = performerPOM.ReadLawFirmMsg(driver).getText();		//Reading Message appeared after save button
		int flag6= 0;
		if(msg6.equalsIgnoreCase("Details Updated Successfully."))
			{
					test.log(LogStatus.PASS, "Law Firm=- Details Updated Successfully.");
					flag5 = 1;
			}
		else
			{
					test.log(LogStatus.FAIL, "User -User with Same Email already Exists. ");
			}
		
			
		Thread.sleep(3000);
		performerPOM.clickCloseButton(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickAddNewLawyer(driver).click();
		
		Thread.sleep(3000);
		Row row7 = sheet.getRow(19);						//Selected 0th index row (First row)
		Cell c7 = row7.getCell(1);						//Selected cell (0 row,1 column)
		String firstname= c7.getStringCellValue();
		performerPOM.clickLawyerName(driver).sendKeys(firstname);
		
		Thread.sleep(3000);
		Row row8 = sheet.getRow(20);						//Selected 0th index row (First row)
		Cell c8 = row8.getCell(1);						//Selected cell (0 row,1 column)
		String lastname= c8.getStringCellValue();
		performerPOM.clickLawyerLastName(driver).sendKeys(lastname);
		

		Thread.sleep(3000);
		Row row9 = sheet.getRow(21);						//Selected 0th index row (First row)
		Cell c9 = row9.getCell(1);						//Selected cell (0 row,1 column)
		String Designation= c9.getStringCellValue();
		performerPOM.clickLawyerDesignation(driver).sendKeys(Designation);
		
		
		Thread.sleep(3000);
		Row row10 = sheet.getRow(17);						//Selected 0th index row (First row)
		Cell c10 = row10.getCell(1);						//Selected cell (0 row,1 column)
		String email3= c10.getStringCellValue();
		performerPOM.clickLawyerEmail(driver).sendKeys(email3);
		
	   	Thread.sleep(3000);
		Row row11 = sheet.getRow(18);						//Selected 0th index row (First row)
		Cell c11 = row11.getCell(1);						//Selected cell (0 row,1 column)
		int contactno1= (int)c11.getNumericCellValue();
		performerPOM.clickLawyerContactNo(driver).sendKeys(contactno1+"");
	    
		Thread.sleep(3000);
		performerPOM.clickLawyerDepartment(driver).click();
		Thread.sleep(3000);
		performerPOM.selectLawyerDepartment(driver).click();
		Thread.sleep(4000);
		performerPOM.clickLawyerRole(driver).click();
		Thread.sleep(4000);
		performerPOM.selectLawyerRole(driver).click();
		Thread.sleep(5000);
		performerPOM.saveLawyer(driver).click();
		
		String msg7 = performerPOM.readLawyerMsg(driver).getText();		//Reading Message appeared after save button
		int flag7= 0;
		if(msg7.equalsIgnoreCase("Lawyer Details Saved Successfully."))
			{
					test.log(LogStatus.PASS, "Lawyer- Lawyer Details Saved Successfully.");
					flag7 = 1;
			}
		else
			{
					test.log(LogStatus.FAIL, "Lawyer- User with Same Email already Exists. ");
			}
			
		Thread.sleep(5000);
		performerPOM.closeLawyer(driver).click();
		
		
		Thread.sleep(5000);
		performerPOM.clickLawFirmFilter(driver).sendKeys("Advocate Anupam",Keys.ENTER);
		Thread.sleep(5000);
		performerPOM.clickLawFirmFilter(driver).clear();
		
		test.log(LogStatus.PASS,"Law Firm Filter Work Successfully");
		
		
	}	
	
 public static void User(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
	 
	    XSSFSheet sheet = ReadExcel();
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
	
	    Thread.sleep(1000);
	    performerPOM.clickMasters(driver).click();
//	    Thread.sleep(3000);
//		performerPOM.clickMastersMenu(driver).click();
        Thread.sleep(3000);
	     performerPOM.clickUserMaster(driver).click();
		 Thread.sleep(3000);
		 performerPOM.clickAddNewUser(driver).click();
		 
		 
	      Thread.sleep(4000);
		  Row row12 = sheet.getRow(24);						//Selected 0th index row (First row)
		  Cell c12 = row12.getCell(1);						//Selected cell (0 row,1 column)
		  String firstname1= c12.getStringCellValue();
		  performerPOM.clickUserName(driver).sendKeys(firstname1);
			
			Thread.sleep(4000);
			Row row13 = sheet.getRow(25);						//Selected 0th index row (First row)
			Cell c13 = row13.getCell(1);						//Selected cell (0 row,1 column)
			String lastname1= c13.getStringCellValue();
			performerPOM.clickUserLastName(driver).sendKeys(lastname1);
			

			Thread.sleep(4000);
			Row row14 = sheet.getRow(26);						//Selected 0th index row (First row)
			Cell c14 = row14.getCell(1);						//Selected cell (0 row,1 column)
			String Designation1= c14.getStringCellValue();
			performerPOM.clickUserDesignation(driver).sendKeys(Designation1);
			
			
			Thread.sleep(4000);
			Row row15 = sheet.getRow(27);						//Selected 0th index row (First row)
		   Cell c15 = row15.getCell(1);						//Selected cell (0 row,1 column)
			String email3= c15.getStringCellValue();
			performerPOM.clickUserEmail(driver).sendKeys(email3);
			
			
			
     		Thread.sleep(4000);
			Row row16 = sheet.getRow(28);						//Selected 0th index row (First row)
			Cell c16 = row16.getCell(1);						//Selected cell (0 row,1 column)
			int contactno2= (int)c16.getNumericCellValue();
			 performerPOM.clickUserContactNo(driver).sendKeys(contactno2+"");
		    
		 

		 Thread.sleep(4000);
		 performerPOM.clickUserDepartment(driver).click();
		  Thread.sleep(4000);
		 performerPOM.selectUserDepartment(driver).click();
		  Thread.sleep(4000);
		 performerPOM.clickUserRole(driver).click();
		  Thread.sleep(4000);
		 performerPOM.selectUserRole(driver).click();
		 Thread.sleep(4000);
		 performerPOM.saveUser(driver).click();
		 
		   Thread.sleep(500);
		  
			String msg = performerPOM.UserReadMsg(driver).getText();
			if(msg.contains("Details Updated Successfully."))
			{
				test.log(LogStatus.PASS,"User -Details Updated Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL,"User- User with Same Email already Exists.");
			}
		  
		  Thread.sleep(3000);
			 performerPOM.closeUser(driver).click();
		  
		 Thread.sleep(3000);
		 performerPOM.editUser(driver).click();
		 
		 Thread.sleep(3000);
		 performerPOM.UserAddress(driver).clear();
		 
		 Thread.sleep(3000);
		 Row row17 = sheet.getRow(29);						//Selected 0th index row (First row)
		 Cell c17 = row17.getCell(1);						//Selected cell (0 row,1 column)
	     String address= c17.getStringCellValue();
	     performerPOM.UserAddress(driver).sendKeys(address);
	     
	     Thread.sleep(3000);
		 performerPOM.saveUser(driver).click();
	     
		 
		 
		 Thread.sleep(3000);
		 String msg1 = performerPOM.UserReadMsg(driver).getText();
			if(msg1.contains("Details Updated Successfully."))
			{
				test.log(LogStatus.PASS, "Update User-Details Updated Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Update User-User with Same Email already Exists.");
			}
		 
		  Thread.sleep(4000);
		  performerPOM.closeUser(driver).click();
		 
		  Thread.sleep(4000);
		  performerPOM.UserDeleted(driver).click();
		  
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
	        
	        Thread.sleep(5000);
	        String alertMessage1=driver.switchTo().alert().getText();
	        
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage1);
	        
	        Thread.sleep(2000);
	        // Capturing alert message.    
	         driver.switchTo().alert().accept();		
	         
	         Thread.sleep(5000);
			 performerPOM.clickLegalEntityFilter(driver).sendKeys("Management", Keys.ENTER);
			 
			  Thread.sleep(5000);
				 performerPOM.clickLegalEntityFilter(driver).clear();
			 
			 test.log(LogStatus.PASS, "User Filter work successfully" );
		  	 
	}		 
  public static void Opponent(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
  {
	  
	    XSSFSheet sheet = ReadExcel();
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
	  
	  
		 Thread.sleep(5000);
		 performerPOM.clickMasters(driver).click();
//		 Thread.sleep(3000);
//	     performerPOM.clickMastersMenu(driver).click();
		 Thread.sleep(3000);
	     performerPOM.chooseOpponentMasters(driver).click();
	     Thread.sleep(3000);
	     performerPOM.NewOpponent(driver).click();
	   
		
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
			
		
	    Thread.sleep(3000);
		Row row17 = sheet.getRow(31);						//Selected 0th index row (First row)
		Cell c17 = row17.getCell(1);						//Selected cell (0 row,1 column)
		String opponentname= c17.getStringCellValue();
	    performerPOM.clickOpponentName(driver).sendKeys(opponentname);
	    
	   Thread.sleep(3000);
	   performerPOM.saveOpponent(driver).click();
	   
	   Thread.sleep(3000);
			 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg1.contains("Opponent Details Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Oppoenent- Opponent Details Saved Successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Oppoenent- Opponent with same name already exists.");
				}
	   
	   
	   Thread.sleep(3000);
	   performerPOM.closeOpponent(driver).click();
	   
	   Thread.sleep(3000);
	   performerPOM.editOpponent(driver).click();
	   
	   
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
	   
	   Thread.sleep(3000);
	   performerPOM.clickOpponentName(driver).clear();
	   
	   Thread.sleep(4000);
	 	Row row18 = sheet.getRow(32);						//Selected 0th index row (First row)
	 	Cell c18 = row18.getCell(1);						//Selected cell (0 row,1 column)
	 	String editopponentname= c18.getStringCellValue();
	 	performerPOM.clickOpponentName(driver).sendKeys(editopponentname);
	 	    
	 	   Thread.sleep(3000);
		   performerPOM.saveOpponent(driver).click();
		   
	     Thread.sleep(3000);
			String msg2 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg2.contains("Opponent Details Updated Successfully."))
				{
					test.log(LogStatus.PASS, "Update Opponent -Opponent Details Updated Successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Update Opponent -Opponent with same name already exists.");
				}
		   
	      Thread.sleep(3000);
		   performerPOM.closeOpponent(driver).click();
		   
		   Thread.sleep(3000);
		   performerPOM.deleteOpponent(driver).click();
		   
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
	        
	        Thread.sleep(2000);
	        String alertMessage1=driver.switchTo().alert().getText();
	        
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage1);
	        
	        Thread.sleep(2000);
	        // Capturing alert message.    
	         driver.switchTo().alert().accept();	
	         
	         Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).sendKeys("Civil Opponent",Keys.ENTER);
			   
			 Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).clear();
			 
			 test.log(LogStatus.PASS,"Opponent Filter work successfully");
		   
		   
		   
		   
	   
  } 
  public static void Court(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
   {
	   XSSFSheet sheet = ReadExcel();
		WebDriverWait wait = new WebDriverWait(driver, 180);
		progress(driver);
	 
	   Thread.sleep(3000);
	    performerPOM.clickMasters(driver).click();
		//Thread.sleep(3000);
		//performerPOM.clickMastersMenu(driver).click();
	   Thread.sleep(3000);
	   performerPOM.clickCourtMasters(driver).click();
  /*	   Thread.sleep(3000);
	   performerPOM.clickNewCourt(driver).click();
	   
	   Thread.sleep(4000);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
	 
	   Thread.sleep(4000);
	   Row row18 = sheet.getRow(34);						//Selected 0th index row (First row)
	   Cell c18 = row18.getCell(1);						//Selected cell (0 row,1 column)
	   String courtname= c18.getStringCellValue();
	   performerPOM.clickCourtName(driver).sendKeys(courtname);
	   
	   Thread.sleep(5000);
	   performerPOM.clickCourtType(driver).click();
	   Thread.sleep(5000);
	   performerPOM.selectCourtType(driver).click();
	   Thread.sleep(5000);
	   performerPOM.clickCountry(driver).click();
	   Thread.sleep(5000);
	   performerPOM.selectCountry(driver).click();
	   
       Thread.sleep(3000);
	   performerPOM.saveCourt(driver).click();
	   
	   Thread.sleep(3000);
		 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
			if(msg1.contains("Court Detail Save Successfully."))
			{
				test.log(LogStatus.PASS, "Court -Court Detail Save Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Court-Court Name already exists.");
			}
	    
	   Thread.sleep(4000);
	   performerPOM.closeCourt(driver).click();
	   
	   Thread.sleep(4000);
	   performerPOM.editCourt(driver).click();
	   
	   
	   Thread.sleep(4000);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
	   

	   Thread.sleep(4000);
	   performerPOM.clickCourtName(driver).clear();
	   
	   
	   Thread.sleep(4000);
	   Row row19 = sheet.getRow(35);						//Selected 0th index row (First row)
	   Cell c19 = row19.getCell(1);						//Selected cell (0 row,1 column)
	   String editcourtname= c19.getStringCellValue();
	   performerPOM.clickCourtName(driver).sendKeys(editcourtname);
	   
	   Thread.sleep(5000);
	   performerPOM.clickCourtType(driver).click();
	   Thread.sleep(5000);
	   performerPOM.selectCourtType(driver).click();
	   Thread.sleep(5000);
	   performerPOM.clickCountry(driver).click();
	   Thread.sleep(5000);
	   performerPOM.selectCountry(driver).click();
	   
	   
	   
	   Thread.sleep(4000);
	   performerPOM.saveCourt(driver).click();
	   
	   Thread.sleep(3000);
		 String msg2 = performerPOM.readOppoenentMsg(driver).getText();
			if(msg2.contains("Court Detail Updated Successfully"))
			{
				test.log(LogStatus.PASS, "Update Court-Court Detail Updated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Update Court-Court Name already exists.");
			}
			 Thread.sleep(4000);
			   performerPOM.closeCourt(driver).click();
			   
			   Thread.sleep(3000);
			   performerPOM.deleteCourt(driver).click();
			   
			   
			   
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
		        
		        
		        
		        Thread.sleep(2000);
		        String alertMessage1=driver.switchTo().alert().getText();
		        
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		        
		        Thread.sleep(2000);
		        // Capturing alert message.    
		         driver.switchTo().alert().accept();		*/
			  	 
		        
		        Thread.sleep(3000);
				 performerPOM.clickLawFirmFilter(driver).sendKeys("	Dehl High Court",Keys.ENTER);
				   
				 Thread.sleep(3000);
				 performerPOM.clickLawFirmFilter(driver).clear();
				 
				 test.log(LogStatus.PASS,"Court Filter work successfully");
			   	
			  	 
			   
	}	   
   public static void CaseNoticeType(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
   {
	   XSSFSheet sheet = ReadExcel();
	   
	    WebDriverWait wait=new WebDriverWait(driver,20);  
	    Thread.sleep(3000);
	    performerPOM.clickMasters(driver).click();
		    
		Thread.sleep(3000);
		performerPOM.clickMastersMenu(driver).click();
	   
	/*	Thread.sleep(3000);
		performerPOM.clickCasNoticeType(driver).click();
	    Thread.sleep(3000);
		performerPOM.NewCaseNoticeType(driver).click();
		
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
		Thread.sleep(3000);
		performerPOM.CaseNoticeType(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNoticeType(driver).click();
		
		Thread.sleep(3000);
		performerPOM.CaseNoticeType(driver).click();
		
		Thread.sleep(3000);
		Row row19 = sheet.getRow(37);						//Selected 0th index row (First row)
		Cell c19 = row19.getCell(1);						//Selected cell (0 row,1 column)
		String typename= c19.getStringCellValue();
		performerPOM.TypeName(driver).sendKeys(typename);
	
		Thread.sleep(6000);
		performerPOM.saveCaseNoticeType(driver).click();
		
		 Thread.sleep(3000);
		 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
			if(msg1.contains("Case/Notice Type Saved Successfully."))
			{
				test.log(LogStatus.PASS, " Case/Notice -Case/Notice Type Saved Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Case/Notice -Case/Notice type already exists.");
			}
		
		
		Thread.sleep(3000);
		performerPOM.closeCaseNoticeType(driver).click();
		
//		Thread.sleep(3000);
//		performerPOM.editCaseNoticeType(driver).click();
//		
//		Thread.sleep(3000);
//		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
//		 
//		 
//		    Thread.sleep(3000);
//			performerPOM.CaseNoticeType(driver).click();
//			
//			Thread.sleep(3000);
//			performerPOM.selectCaseNoticeType(driver).click();
//			
//			Thread.sleep(3000);
//			performerPOM.CaseNoticeType(driver).click();
//		 
//			Thread.sleep(3000);
//			performerPOM.TypeName(driver).clear();
//			
//			Thread.sleep(3000);
//			Row row20 = sheet.getRow(38);						//Selected 0th index row (First row)
//			Cell c20 = row20.getCell(1);						//Selected cell (0 row,1 column)
//			String typename1= c20.getStringCellValue();
//			performerPOM.TypeName(driver).sendKeys(typename1);
//			
//			
//			Thread.sleep(6000);
//			performerPOM.saveCaseNoticeType(driver).click();
//			
//			 Thread.sleep(3000);
//			 String msg2 = performerPOM.readOppoenentMsg(driver).getText();
//				if(msg2.contains("Case/Notice Type Updated Successfully."))
//				{
//					test.log(LogStatus.PASS, "Update Case/Notice - Case/Notice Type Updated Successfully.");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "Update Case/Notice - Case/Notice type already exists.");
//				}
//			
//			
//			Thread.sleep(3000);
//			performerPOM.closeCaseNoticeType(driver).click();
			
			Thread.sleep(3000);
			performerPOM.deleteCaseNoticeType(driver).click();
			
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
		        
		        Thread.sleep(2000);
		        String alertMessage1=driver.switchTo().alert().getText();
		        
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		        
		        Thread.sleep(2000);
		        // Capturing alert message.    
		         driver.switchTo().alert().accept(); */
		         
		         Thread.sleep(3000);
				 performerPOM.clickLawFirmFilter(driver).sendKeys("criminal cases",Keys.ENTER);
				   
				 Thread.sleep(3000);
				 performerPOM.clickLawFirmFilter(driver).clear();
				 
				 test.log(LogStatus.PASS,"Case/Notice Type Filter work successfully");
			  	 
	}	
	public static void PaymentType(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
		XSSFSheet sheet = ReadExcel();
		 WebDriverWait wait=new WebDriverWait(driver,20);  
		  Thread.sleep(5000);
		  performerPOM.clickMasters(driver).click();
		  
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickPaymentTypeMasters(driver).click();
          Thread.sleep(4000);
		  performerPOM.clickPaymentTypeNew(driver).click();
		  
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment"));
	   
		  Thread.sleep(3000);
		  Row row20 = sheet.getRow(40);						//Selected 0th index row (First row)
		  Cell c20= row20.getCell(1);						//Selected cell (0 row,1 column)
		  String payment= c20.getStringCellValue();
		   performerPOM.PaymentType(driver).sendKeys(payment);
		   
		   
		  Thread.sleep(4000);
		  performerPOM.savePaymentType(driver).click();
		  

			 Thread.sleep(3000);
			 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg1.contains("Payment Type Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Payment Type -Payment Type Saved Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Payment Type -Payment Type Already Exists");
				}
		   
		   Thread.sleep(4000);
		  performerPOM.closePaymentType(driver).click();
		  
		  
		  Thread.sleep(3000);
		  performerPOM.editPaymentType(driver).click();
		  
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment"));
		   
		  Thread.sleep(3000);
		  performerPOM.PaymentType(driver).clear();
		  Thread.sleep(3000);
		  Row row21 = sheet.getRow(41);						//Selected 0th index row (First row)
		  Cell c21= row21.getCell(1);						//Selected cell (0 row,1 column)
		  String payment1= c21.getStringCellValue();
		   performerPOM.PaymentType(driver).sendKeys(payment1);
		   
		   Thread.sleep(4000);
			  performerPOM.savePaymentType(driver).click();
			  

				 Thread.sleep(3000);
				 String msg2 = performerPOM.readOppoenentMsg(driver).getText();
					if(msg2.contains("Payment Type Updated Successfully"))
					{
						test.log(LogStatus.PASS, "Update Payment Type - Payment Type Updated Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Update Payment Type -Payment Type Already Exists");
					}
			   
			   Thread.sleep(4000);
			  performerPOM.closePaymentType(driver).click();
		   
			  Thread.sleep(4000);
			  performerPOM.deletePaymentType(driver).click();
			  
			  
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
		        
		        Thread.sleep(2000);
		        String alertMessage1=driver.switchTo().alert().getText();
		        
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		        
		        Thread.sleep(2000);
		        // Capturing alert message.    
		         driver.switchTo().alert().accept();		
		         
		         Thread.sleep(3000);
				 performerPOM.clickLawFirmFilter(driver).sendKeys("Case drafting fees",Keys.ENTER);
				 
				 
				Thread.sleep(3000);
				performerPOM.clickApplybtn(driver).click();
				   
				 Thread.sleep(3000);
				 performerPOM.clickLawFirmFilter(driver).clear();
				 
				 
				 
				 test.log(LogStatus.PASS,"Payment Type Filter work successfully");
	 }	  
     public static void customParameter(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	  {
    	 
    	 XSSFSheet sheet = ReadExcel();
		 WebDriverWait wait=new WebDriverWait(driver,20);  
			 
		  Thread.sleep(3000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  Thread.sleep(3000);
		  performerPOM.customParameterMaster(driver).click();
		  Thread.sleep(3000);
		  performerPOM.newCustomParameter(driver).click();
		  
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
		  
		  Thread.sleep(3000);
		  performerPOM.typeCustomParameter(driver).click();
		  Thread.sleep(3000);
		  performerPOM.selectTypeCustomParameter(driver).click();
		  
		  Thread.sleep(3000);
		  Row row21 = sheet.getRow(43);						//Selected 0th index row (First row)
		  Cell c21= row21.getCell(1);						//Selected cell (0 row,1 column)
		  String parameterLable= c21.getStringCellValue();
		  performerPOM.ParameterLabel(driver).sendKeys(parameterLable);
		  
		  Thread.sleep(3000);
		  performerPOM.typeCustomParameter(driver).click();
		  Thread.sleep(3000);
		  performerPOM.saveCustomParameter(driver).click();
		  
		  
		  Thread.sleep(3000);
			 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg1.contains("Custome Field Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Custome Field- Custome Field Saved Successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Custome Field- Custome Field with same name already exists.");
				}
		   
		   
		  Thread.sleep(3000);
		  performerPOM.closeCustomParameter(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.editCustomParameter(driver).click();
		  
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
		  
		  Thread.sleep(3000);
		  performerPOM.ParameterLabel(driver).clear();
		  Thread.sleep(3000);
		  Row row22 = sheet.getRow(44);						//Selected 0th index row (First row)
		  Cell c22= row22.getCell(1);						//Selected cell (0 row,1 column)
		  String parameterLable1= c22.getStringCellValue();
		  performerPOM.ParameterLabel(driver).sendKeys(parameterLable1);
		  
		  
		  Thread.sleep(3000);
		  performerPOM.saveCustomParameter(driver).click();
		  
		  
		  Thread.sleep(3000);
			 String msg2 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg2.contains("Custome Field Updated Successfully."))
				{
					test.log(LogStatus.PASS, "Update Custome Field - Custome Field Updated Successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Update Custome Field-Custome Field with same name already exists.");
				}
		   
		   
		  Thread.sleep(3000);
		  performerPOM.closeCustomParameter(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.deleteCustomParameter(driver).click();
		  
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
	        
	        Thread.sleep(2000);
	        String alertMessage1=driver.switchTo().alert().getText();
	        
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage1);
	        
	        Thread.sleep(2000);
	        // Capturing alert message.    
	         driver.switchTo().alert().accept();	
	        
	        Thread.sleep(6000);
			performerPOM. clickCustomParameterFilter(driver).click();
			
		    Thread.sleep(6000);
			performerPOM. clickCustomParameterFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickApplybtn(driver).click();
				   
		    Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).sendKeys("Test",Keys.ENTER);
				 
			Thread.sleep(3000);
			performerPOM.clickApplybtn(driver).click();
			
			 Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).clear();
	
		    
			 test.log(LogStatus.PASS,"Custom Prameter Filter work successfully");
	}  
     public static void CaseStage(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
     {
    	 XSSFSheet sheet=ReadExcel();
    	 WebDriverWait wait=new WebDriverWait(driver,20);  
    	  Thread.sleep(3000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
    	 performerPOM.caseStageMaster(driver).click();
    	 performerPOM.newCaseStage(driver).click();
    	 
    	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
    	 
    	 Thread.sleep(3000);
		 Row row=sheet.getRow(46);
		 Cell c=row.getCell(1);
		 String casestage=c.getStringCellValue();
    	 performerPOM.clickcaseStage(driver).sendKeys(casestage);
    	 
    	 Thread.sleep(3000);
    	 performerPOM.savecaseStage(driver).click();
    	 
    	 Thread.sleep(3000);
		 String msg1 = performerPOM.readcaseStagemsg(driver).getText();
			if(msg1.contains("Case Stage Type Saved Successfully."))
			{
				test.log(LogStatus.PASS, "Case Stage - Case Stage Type Saved Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Case Stage - Contract type already exists.");
			}
	   
    	 
    	 Thread.sleep(3000);
    	 performerPOM.closecaseStage(driver).click();
    	 
    	 Thread.sleep(3000);
    	 performerPOM.editcaseStage(driver).click();
    	 
    	 
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
    	 
         Thread.sleep(3000);
         performerPOM.clickcaseStage(driver).clear();
 
    	 Thread.sleep(3000);
		 Row row1=sheet.getRow(47);
		 Cell c1=row1.getCell(1);
		 String casestage1=c1.getStringCellValue();
    	 performerPOM.clickcaseStage(driver).sendKeys(casestage1);
    	 
    	 Thread.sleep(3000);
    	 performerPOM.savecaseStage(driver).click();
    	 
    	 Thread.sleep(3000);
		 String msg2 = performerPOM.readcaseStagemsg(driver).getText();
			if(msg2.contains("Case Stage Type Updated Successfully."))
			{
				test.log(LogStatus.PASS, "Update Case Stage -Case Stage Type Updated Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Update Case Stage -Contract type already exists.");
			}
	   
    	 
    	 Thread.sleep(3000);
    	 performerPOM.closecaseStage(driver).click();
    	 
    	 
    	 Thread.sleep(3000);
    	 performerPOM.deletecaseStage(driver).click();
    	 
    	 
		  
		  Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        Thread.sleep(5000);
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();	
	        
	        Thread.sleep(5000);
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        Thread.sleep(5000);	
	        // Accepting alert		
	        driver.switchTo().alert().accept();		
	           
	        Thread.sleep(2000);
	        String alertMessage1=driver.switchTo().alert().getText();
	        
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage1);
	        
	        Thread.sleep(2000);
	        // Capturing alert message.    
	         driver.switchTo().alert().accept();	
	         
	         Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).sendKeys("Defendant's Evidence",Keys.ENTER);
			 
			 Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).clear();
			 
			 test.log(LogStatus.PASS, "Case Stage Filter work successfully");
    	 
  }
     
		  
	  public static void DocumentType(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		  {
		  
		      XSSFSheet sheet=ReadExcel();
		      WebDriverWait wait=new WebDriverWait(driver,20);  
		      Thread.sleep(3000);
		      performerPOM.clickMasters(driver).click();
//		      Thread.sleep(3000);
//		      performerPOM.clickMastersMenu(driver).click();
		      Thread.sleep(3000);
			  performerPOM.DocumentTypeMasters(driver).click();
			  Thread.sleep(3000);
			  performerPOM.NewDocumentType(driver).click();
			  
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
			  
			  Thread.sleep(3000);
			  Row row=sheet.getRow(49);
			  Cell c=row.getCell(1);
			  String doctype=c.getStringCellValue();
			  performerPOM.clickDocumentType(driver).sendKeys(doctype);
			  
			  Thread.sleep(3000);
			  performerPOM. saveDocumentType(driver).click();
			  
			  Thread.sleep(3000);
				 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
					if(msg1.contains("Document Type Added Successfully"))
					{
						test.log(LogStatus.PASS, "Document Type- Document Type Added Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Document Type-Litigation Document-Type already exists.");
					}
              Thread.sleep(3000);
			  performerPOM.closeDocumentType(driver).click();
			  
			  Thread.sleep(3000);
			  performerPOM.editDocumentType(driver).click();
			  
              wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
			  
              Thread.sleep(3000);
              performerPOM.clickDocumentType(driver).clear();
              
			  Thread.sleep(3000);
			  Row row1=sheet.getRow(50);
			  Cell c1=row1.getCell(1);
			  String doctype1=c1.getStringCellValue();
			  performerPOM.clickDocumentType(driver).sendKeys(doctype1);
			  
			  Thread.sleep(3000);
			  performerPOM. saveDocumentType(driver).click();
			  
			  Thread.sleep(3000);
				 String msg2 = performerPOM.readOppoenentMsg(driver).getText();
					if(msg2.contains("Document Type Updated Successfully"))
					{
						test.log(LogStatus.PASS, "Update Document Type-Document Type Updated Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Update Document Type-Litigation Document-Type already exists.");
					}
              Thread.sleep(3000);
			  performerPOM.closeDocumentType(driver).click();
			  
			   Thread.sleep(3000);
			   performerPOM.deleteDocumentType(driver).click();
			   
			   
			   
			   Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert = driver.switchTo().alert();		
		        		
		        Thread.sleep(3000);
		        // Capturing alert message.    
		        String alertMessage= driver.switchTo().alert().getText();	
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage);	
		        
		        Thread.sleep(3000);	
		        // Accepting alert		
		        driver.switchTo().alert().accept();		
		           
		        Thread.sleep(2000);
		        String alertMessage1=driver.switchTo().alert().getText();
		        
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		        
		        Thread.sleep(2000);
		        // Capturing alert message.    
		         driver.switchTo().alert().accept();	
		         
		         Thread.sleep(3000);
				 performerPOM.clickLegalEntityFilter(driver).sendKeys("Customer payment",Keys.ENTER);
				   
			     Thread.sleep(3000);
				 performerPOM.clickLegalEntityFilter(driver).clear(); 
		         
		         test.log(LogStatus.PASS,"Document Type filter working successfully");
			  
			  
			  
			  
		  }
	  
	  public static void RatingCriteria(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	  {
		  XSSFSheet sheet=ReadExcel();
		  WebDriverWait wait=new WebDriverWait(driver,20);  
		  Thread.sleep(3000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  performerPOM.ratingCriteriaMasters(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.NewDocumentType(driver).click();
		  
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
		  
		  Thread.sleep(3000);
		  Row row=sheet.getRow(52);
		  Cell c=row.getCell(1);
		  String criteria=c.getStringCellValue();
		  performerPOM.clickCriteria(driver).sendKeys(criteria);
		  Thread.sleep(3000);
		  performerPOM. saveDocumentType(driver).click();
		  
		  Thread.sleep(3000);
			 String msg1 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg1.contains("Criteria Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Rating Criteria-Criteria Saved Successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Rating Criteria-Criteria already exists.");
				}
		  
		  
		  Thread.sleep(3000);
		  performerPOM.closeDocumentType(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.editcriteria(driver).click();
		  
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
		  
        Thread.sleep(3000);
        performerPOM.clickCriteria(driver).clear();
        
		  Thread.sleep(3000);
		  Row row1=sheet.getRow(53);
		  Cell c1=row1.getCell(1);
		  String criteria1=c1.getStringCellValue();
		  performerPOM.clickCriteria(driver).sendKeys(criteria1);
		  
		  Thread.sleep(3000);
		  performerPOM.saveDocumentType(driver).click();
		  
		  Thread.sleep(3000);
			 String msg2 = performerPOM.readOppoenentMsg(driver).getText();
				if(msg2.contains("Criteria Updated Successfully."))
				{
					test.log(LogStatus.PASS, "Update Rating Criteria- Criteria Updated Successfully.");
				}
				else
				{
					test.log(LogStatus.FAIL, "Update Rating Criteria-Criteria already exists.");
				}
		  
		  
		  Thread.sleep(3000);
		  performerPOM.closeDocumentType(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.deletecriteria(driver).click();
		  
		  
		   Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        Thread.sleep(3000);
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();	
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        Thread.sleep(3000);	
	        // Accepting alert		
	        driver.switchTo().alert().accept();		
	           
	        Thread.sleep(2000);
	        String alertMessage1=driver.switchTo().alert().getText();
	        
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage1);
	        
	        Thread.sleep(2000);
	        // Capturing alert message.    
	         driver.switchTo().alert().accept();	
	         
	         Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).sendKeys("	Financial Ratios",Keys.ENTER);
			 
			 Thread.sleep(3000);
			 performerPOM.clickLawFirmFilter(driver).clear();
			 
			 test.log(LogStatus.PASS, "Rating Criteria Filter working  successfully");
		  
	 }
	  public static void PageAuthorization(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	  {
		  XSSFSheet sheet=ReadExcel();
		  Thread.sleep(3000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM. pageAuthorizationaMasters(driver).click();
		  Thread.sleep(5000);
		  performerPOM.clickUser(driver).click();
		  Thread.sleep(3000);
		  performerPOM.selectUser(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickAddButton(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickUpdateButton(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickDeleteButton(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickViewButton(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clicksaveButton(driver).click();
		  
		  Thread.sleep(3000);
			 String msg1 = performerPOM.readPageAuthoMsg(driver).getText();
		     test.log(LogStatus.PASS, "Page Authorization Saved Successfully.");
	  
	  }
	  public static void NoticeStage(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	  {
		  XSSFSheet sheet=ReadExcel();

		  Thread.sleep(4000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.noticeStageMasters(driver).click();
		  Thread.sleep(3000);
		  performerPOM.addNoticeStage(driver).click();
		  
		  
		  
		  Thread.sleep(3000);
		  Row row=sheet.getRow(55);
		  Cell c=row.getCell(1);
		  String NoticeStage=c.getStringCellValue();
		  performerPOM.clickNoticeStage(driver).sendKeys(NoticeStage);
		  
		  Thread.sleep(3000);
		  performerPOM.updateNoticeStage(driver).click();
		  
		  
		   Thread.sleep(10000);
		   // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        		
	        // Accepting alert		
	        alert.accept();		
	        
	        Thread.sleep(3000);
			  performerPOM.editNoticeStage(driver).click();
			  
		        Thread.sleep(3000);
			  performerPOM.clickNoticeStage(driver).clear();
			  
			  Thread.sleep(3000);
			  Row row1=sheet.getRow(56);
			  Cell c1=row1.getCell(1);
			  String NoticeStage1=c1.getStringCellValue();
			  performerPOM.clickNoticeStage(driver).sendKeys(NoticeStage1);
			 
			  Thread.sleep(3000);
			  performerPOM.updateNoticeStage(driver).click();
			  
			   Thread.sleep(10000);
			  	
		        		
		        // Capturing alert message.    
		        String alertMessage1= driver.switchTo().alert().getText();
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);	
		        
		        		
		        // Accepting alert		
		        alert.accept();	
		        
		        Thread.sleep(3000);
		        performerPOM.deleteNoticeStage(driver).click();
		        
		        
		 	   Thread.sleep(10000);
			 	
		         // Capturing alert message.    
		        String alertMessage2= driver.switchTo().alert().getText();
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage2);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage2);	
		        
		        		
		        // Accepting alert		
		        alert.accept();	
		        
		        Thread.sleep(3000);
				 performerPOM.clickNoticeStageFilter(driver).sendKeys("legal notice",Keys.ENTER);
				 
				 Thread.sleep(3000);
				 performerPOM.clickNoticeStageFilter(driver).clear();
				 
				 test.log(LogStatus.PASS, "Notice Stage Filter working  successfully");
			  
     }
	  
	  public static void UserReassignment(WebDriver driver, ExtentTest test) throws InterruptedException, IOException
	  {
        
		  Thread.sleep(3000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.UserReassignmentMasters(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickUser1(driver).click();
		  Thread.sleep(3000);
		  performerPOM.selectUser1(driver).click();
		  
		 
		  Thread.sleep(3000);
		  performerPOM.clickAssigntoUser(driver).click();
		   Thread.sleep(3000);
		  performerPOM.selectAssigntoUser(driver).click();
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,1000)");
		 
		  Thread.sleep(1000);
		  performerPOM.selectcheckBox(driver).get(1).click();
		  System.out.println("true");
		  	
		  Thread.sleep(3000);
		  performerPOM.clicknotice(driver).click();
		  Thread.sleep(3000);
		  performerPOM.selectNoticeCheckkBox(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickTask(driver).click();
		  Thread.sleep(3000);
		  performerPOM. selectTaskCheckkBox(driver).click();
		 
		  Thread.sleep(3000);
		  performerPOM.clickAssignButoon(driver).click();
	
		
		 
		  Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();	
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        		
	        // Accepting alert		
	        alert.accept();		
	        
	  	  Thread.sleep(4000);
		  performerPOM.clickAutidLog(driver).click();
		  
	  }
	  
	  public static void MailAuthorization(WebDriver driver) throws InterruptedException
	  {
		  Thread.sleep(3000);
		  performerPOM.clickMasters(driver).click();
//		  Thread.sleep(3000);
//		  performerPOM.clickMastersMenu(driver).click();
		  
		  Thread.sleep(3000);
		  performerPOM.MailAuthorizationMasters(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickTypeOfUser(driver).click();
		  Thread.sleep(3000);
		  performerPOM.selectTypeOfUser(driver).click();
		  Thread.sleep(4000);
		  performerPOM.clickRole(driver).click();
		  Thread.sleep(4000);
		  performerPOM.selectRole(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickUsers(driver).click();
		 // Thread.sleep(3000);
		 // performerPOM.clickSearchBoxUser(driver).sendKeys("company admin");
		  
		  Thread.sleep(3000);
		  performerPOM.selectUsers(driver).click();

		  Thread.sleep(3000);
		  performerPOM.clickMailServices(driver).click();
		 // Thread.sleep(3000);
		 // performerPOM.clickSearchBoxMail(driver).sendKeys("Hearings After 2 Days");
		  Thread.sleep(300);
		  performerPOM.selectMailService(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickEnable(driver).click();
		  Thread.sleep(4000);
		  performerPOM.clickExportMail(driver).click();
		  Thread.sleep(3000);
		  performerPOM.clickDisable(driver).click();
	  }
	  
	  
		 

	


		public static void selectCaseType(WebDriver driver,String caseType) {
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//WebElement CaseType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rbCaseInOutType_chosen")));
			WebElement CaseType = performerPOM.clickCaseType1(driver);
			CaseType.click();
			
			performerPOM.chooseCaseType(driver).click();
		}
		public static void ImportUtility(WebDriver driver,ExtentTest test) throws InterruptedException
		{
		
			performerPOM.ClickImportUtility(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseCaseType(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseCaseFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadCaseFile(driver).click();
			
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg(driver)));
			
			Thread.sleep(500);
			String msg5 = performerPOM.readCaseMsg(driver).getText();		//Reading Message appeared after save button
			int flag5= 0;
			if(msg5.equalsIgnoreCase("1 Case Detail(s) Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg5);
				flag5 = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg5);
			}
		
			
			Thread.sleep(3000);
			performerPOM.ClickcaseHearing(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseCaseFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadCaseFile(driver).click();
			
//			
//			WebDriverWait wait1=new WebDriverWait(driver,30);
//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg(driver)));
//			
			Thread.sleep(500);
			String msg6 = performerPOM.readCaseMsg(driver).getText();		//Reading Message appeared after save button
			int flag6= 0;
			if(msg6.equalsIgnoreCase("1 Case Hearing(s) Details Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg6);
				flag6 = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg6);
			}
		
			
			
			Thread.sleep(3000);
			performerPOM.ClickcaseOrder(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseCaseFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadCaseFile(driver).click();
			
			WebDriverWait wait2=new WebDriverWait(driver,30);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg(driver)));
			
			Thread.sleep(500);
			String msg7 = performerPOM.readCaseMsg(driver).getText();		//Reading Message appeared after save button
			int flag7= 0;
			if(msg7.equalsIgnoreCase("1 Case Order(s) Details Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg7);
				flag7 = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg7);
			}
			
			
			Thread.sleep(3000);
			performerPOM.ClickcasePayment(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseCaseFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadCaseFile(driver).click();
			Thread.sleep(3000);
			
			
//			
////			WebDriverWait wait3=new WebDriverWait(driver,30);
////			Thread.sleep(3000);
////			wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg(driver)));
//			
			Thread.sleep(500);
			String msg8 = performerPOM.readCaseMsg(driver).getText();		//Reading Message appeared after save button
			int flag8= 0;
			if(msg8.equalsIgnoreCase("1 Case Payment(s) Details Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg8);
				flag8 = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg8);
			}
			
			
			performerPOM.clickNotice(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseNoticeType(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseNoticeFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadNoticeFile(driver).click();
			
			
			
			Thread.sleep(500);
			String msg = performerPOM.readNoticeMsg(driver).getText();		//Reading Message appeared after save button
			int flag= 0;
			if(msg.equalsIgnoreCase("1 Notice Detail(s) Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				flag = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
			
			Thread.sleep(3000);
			performerPOM.ChooseNoticeResponse(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseNoticeFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadNoticeFile(driver).click();
			
			
			Thread.sleep(500);
			String msg1= performerPOM.readNoticeMsg(driver).getText();		//Reading Message appeared after save button
			int flag1= 0;
			if(msg.equalsIgnoreCase("1 Notice Response Details Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg1);
				flag1 = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg1);
			}
		
//			
			Thread.sleep(3000);
			performerPOM.ChoosePaymentInfo(driver).click();
			Thread.sleep(3000);
			performerPOM.ChooseNoticeFile(driver);
			Thread.sleep(3000);
			performerPOM.UploadNoticeFile(driver).click();
			Thread.sleep(3000);
//			
//				
//			
//			WebDriverWait wait4=new WebDriverWait(driver,30);
//			Thread.sleep(3000);
//			wait1.until(ExpectedConditions.visibilityOf(performerPOM.readNoticeMsg(driver)));
			
			Thread.sleep(500);
			String msg3 = performerPOM.readNoticeMsg(driver).getText();		//Reading Message appeared after save button
			int flag3= 0;
			if(msg3.equalsIgnoreCase("1 Notice Payment(s) Details Uploaded Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg3);
				flag3 = 1;
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg3);
			}
			Thread.sleep(300);
			OverduePOM.clickDashboard(driver).click();
			
			
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
			performerPOM.clickLocationFilter2(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			//performerPOM.clickStatusFilter(driver).click();
			//performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStatusFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter(driver).click();
			
		
			
//			Thread.sleep(4000);
//			performerPOM.selectDepartmentFilter1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType1(driver).click();
			
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectRiskFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.selectAgeFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter1(driver).click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter(driver).click();
				
			
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
		
           	int	open = Integer.parseInt(performerPOM.CaseNoticeTypeSummaryGraph(driver).getText());	//Reading Notice Open count.
		    performerPOM.CaseNoticeTypeSummaryGraph(driver).click();						//Clicking on 'Open' notice
		
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
			performerPOM.clickLocationFilter2(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			//performerPOM.clickStatusFilter(driver).click();
			//performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectStatusFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectDepartmentFilter(driver).click();
			
			//Thread.sleep(3000);
			//performerPOM.selectDepartmentFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickRiskFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectRiskFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectAgeFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCategoryFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCategoryFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCategoryFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectStageFilter(driver).click();
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			
			
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
			
			
			Thread.sleep(2000);
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
		
           	int	open = Integer.parseInt(performerPOM.RiskSummaryGraph(driver).getText());	//Reading Notice Open count.
		    performerPOM.RiskSummaryGraph(driver).click();						//Clicking on 'Open' notice
		
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
			performerPOM.clickLocationFilter2(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice(driver).click();
			//performerPOM.clickStatusFilter(driver).click();
			//performerPOM.selectCaseNotice(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickStatusFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectStatusFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickDepartmentFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectDepartmentFilter(driver).click();
			
//			Thread.sleep(3000);
//			performerPOM.selectDepartmentFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNoticeType1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNoticeType1(driver).click();
			
			
//			Thread.sleep(3000);
//			performerPOM.clickRiskFilter(driver).click();
//			
//			Thread.sleep(3000);
//			performerPOM.selectRiskFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickAgeFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectAgeFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickCategoryFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCategoryFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectCategoryFilter1(driver).click();
			
			Thread.sleep(3000);
			performerPOM.clickStageFilter(driver).click();
			
			Thread.sleep(3000);
			performerPOM.selectStageFilter(driver).click();
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
	
			
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
			
			
			Thread.sleep(2000);
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
	
       	int	open = Integer.parseInt(performerPOM.DepartmentSummaryGraph(driver).getText());	//Reading Notice Open count.
	    performerPOM.DepartmentSummaryGraph(driver).click();						//Clicking on 'Open' notice
	
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
		performerPOM.clickLocationFilter2(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNotice(driver).click();
		//performerPOM.clickStatusFilter(driver).click();
		//performerPOM.selectCaseNotice(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickStatusFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectStatusFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickDepartmentFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectDepartmentFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNoticeType1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNoticeType1(driver).click();
		
		
		Thread.sleep(3000);
		performerPOM.clickRiskFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectRiskFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickAgeFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectAgeFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCategoryFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCategoryFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCategoryFilter1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickStageFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectStageFilter(driver).click();	Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		
		
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
	
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(7000);
		performerPOM.clearButton(driver).click();
		
		
		
		
		
		
		Thread.sleep(2000);
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
		
		
//		
//		Thread.sleep(3000);
//		performerPOM.clickLocationFilter(driver).click();
//		
//		Thread.sleep(3000);
//		performerPOM.clickLocationFilter1(driver).click();
//		
//		Thread.sleep(3000);
//		performerPOM.clickLocationFilter2(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNotice(driver).click();
		//performerPOM.clickStatusFilter(driver).click();
		//performerPOM.selectCaseNotice(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickStatusFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectStatusFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickDepartmentFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectDepartmentFilter(driver).click();
		
//		Thread.sleep(3000);
//		performerPOM.selectDepartmentFilter1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNoticeType1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNoticeType1(driver).click();
		
		
		Thread.sleep(3000);
		performerPOM.clickRiskFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectRiskFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickAgeFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectAgeFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCategoryFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCategoryFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCategoryFilter1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickStageFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectStageFilter(driver).click();
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		
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
		
		Thread.sleep(2000);
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
		performerPOM.clickLocationFilter2(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNotice(driver).click();
		//performerPOM.clickStatusFilter(driver).click();
		//performerPOM.selectCaseNotice(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickStatusFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectStatusFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickDepartmentFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectDepartmentFilter(driver).click();
		

//		Thread.sleep(3000);
//		performerPOM.selectDepartmentFilter1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNoticeType1(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNoticeType1(driver).click();
		
		
		Thread.sleep(3000);
		performerPOM.clickRiskFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectRiskFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickAgeFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.selectAgeFilter(driver).click();
		
		Thread.sleep(3000);
		performerPOM.clickCategoryFilter(driver).click();
//		
//		Thread.sleep(3000);
//		performerPOM.selectCategoryFilter(driver).click();
//		
		Thread.sleep(3000);
		performerPOM.selectCategoryFilter1(driver).click();
//		
//		Thread.sleep(3000);
//		performerPOM.clickStageFilter(driver).click();
//		
//		Thread.sleep(3000);
//		performerPOM.selectStageFilter(driver).click();
		
		
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
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(7000);
		performerPOM.clearButton(driver).click();
			
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		performerPOM.caseNoticeSummaryGraphClose(driver).click();
		
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
		
	}		
	public static void CaseHearing(WebDriver driver, ExtentTest test, String compliancesCount1,String type) throws InterruptedException, IOException
		{
			
			//performerPOM.CaseHearingCount(driver).click();
			//performerPOM.CaseHearingGridCount(driver).click();
			
			int	open = Integer.parseInt(performerPOM.CaseHearingCount(driver).getText());	//Reading Notice Open count.
	        performerPOM.CaseHearingCount(driver).click();						//Clicking on 'Open' notice

			
			
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
           	
           	
			
			
				Thread.sleep(100);
				File dir = new File("C://Users//Admin//Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(500);
				CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
				Thread.sleep(250);
				performerPOM.CaseHearingExport(driver).click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				
				Thread.sleep(3000);
				performerPOM.CaseHearingView(driver).click();
				
				Thread.sleep(3000);
				driver.switchTo().parentFrame();
				
				Thread.sleep(3000);
				performerPOM.CaseHearingPopupClose(driver).click();
				
				
				
				Thread.sleep(300);
				OverduePOM.clickDashboard(driver).click();
		}		
		
		
		
		
			
			public static void HearingCalender(WebDriver driver, ExtentTest test, String compliancesCount1, String type) throws InterruptedException
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				Thread.sleep(4000);
				performerPOM.HearingCalender(driver).click();
				
				int	open = Integer.parseInt(performerPOM.HearingCalenderNum(driver).getText());	//Reading Notice Open count.
		        performerPOM.HearingCalenderNum(driver).click();						//Clicking on 'Open' notice

		       	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
				
				Thread.sleep(10000);
				CFOcountPOM.readcalenderCount(driver).click();
				String item = CFOcountPOM.readcalenderCount(driver).getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(2000);
				    item = CFOcountPOM.readcalenderCount(driver).getText();
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
	           	
				
				
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
               	js.executeScript("window.scrollBy(0,300)");
               	
            
               	Thread.sleep(2000);
		
				
				Thread.sleep(100);
				File dir = new File("C://Users//Admin//Downloads");
			//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(250);
				performerPOM.HearingCalenderExport(driver).click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(500);
	            performerPOM.HearingCalenderView(driver).click();
				
				Thread.sleep(2000);
				driver.switchTo().parentFrame();
			
				Thread.sleep(6000);
				performerPOM.HearingCalenderclose(driver).click();
				
				
				Thread.sleep(300);
				OverduePOM.clickDashboard(driver).click();
				
				
				
			}
					
			

		
	
		
		
			
			
		
			
		}

		

	
			
	
           

