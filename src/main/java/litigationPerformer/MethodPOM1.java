package litigationPerformer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licensePerformer.LiPerformerPOM;
import performer.OverduePOM;

public class MethodPOM1 {
	
	
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
	
	public static void AdvancedSearch(WebDriver driver,ExtentTest test, String type) throws InterruptedException
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
		performerPOM.startDate(driver).sendKeys("05/10/2022");
		
		Thread.sleep(4000);
		performerPOM.endDate(driver).sendKeys("05/12/2022");
		
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
	
	
	


}
