package litigationPerformer;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class performerPOM 
{
	private static WebElement litigation = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)

	
	
	public static WebElement clickNoticeOpen(WebDriver driver)			//Searching 'Open' Notice link
	{
		//litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenNoticeCount']"));
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenNoticeCount']"));
		return litigation;
	}
	
	public static WebElement clickNew(WebDriver driver)					//Searching 'New'
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewCaseNotice']"));
		return litigation;
	}
	
	public static WebElement clickDated(WebDriver driver)				//Searching 'Dated' input box
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtNoticeDate']"));
		
		return litigation;
	}
	
	public static WebElement clickFinancialYear(WebDriver driver)
	{//Searching 'Financial Year' drop down
	
		WebDriverWait wait = new WebDriverWait(driver,(30));
	    litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]")));
		//litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]"));
		return litigation;
	}
	
	public static List<WebElement> chooseDropDownOption(WebDriver driver)	//Searching drop down in 'Financial Year'
	{
		//elementsList = driver.findElements(By.xpath("//*[@id='pnlNotice']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		elementsList = driver.findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[1]")).findElements(By.tagName("li"));
		return elementsList;
	}
	
	public static WebElement clickAct(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[2]"));
		return litigation;
	}
	
	public static List<WebElement> chooseAct(WebDriver driver)
	{
    //	div.findElement(By.className("multiselect-container dropdown-menu")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
		//elementsList = driver.findElements(By.xpath("//*[@id='pnlNotice']/div[5]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		elementsList=driver.findElement(By.xpath("//*[@id=\"pnlNotice\"]/div[4]/div[1]/div[1]/span[1]/div/ul")).findElements(By.tagName("li"));
		
		return elementsList;
	}
	
	public static List<WebElement> chooseAct1(WebDriver driver)
	{
		//elementsList = driver.findElements(By.xpath("//*[@id='pnlCase']/div[4]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		//elementsList=driver.findElement(By.xpath("//*[@id=\"pnlCase\"]/div[4]/div[1]/div[1]/span[1]/div/ul")).findElements(By.tagName("li"));
		elementsList=driver.findElements(By.xpath("//*[@id='pnlCase']/div[5]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		return elementsList;
	}
	
	public static WebElement clickRefNo(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxRefNo']"));
		return litigation;
	}
	
	public static WebElement clickNoticeType(WebDriver driver)
	{
		//litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']"));
		litigation = driver.findElement(By.id("rbNoticeInOutType_chosen"));
		
		return litigation;
	}
	
	public static WebElement chooseNoticeType(WebDriver driver)
	{
		  // elementsList =  driver.findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
		   litigation= driver.findElement(By.xpath("//*[@id='rbNoticeInOutType_chosen']/div/ul/li[2]"));
		   		
		   return litigation;
		}
	
	
	public static WebElement clickUnderSection(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxSection']"));
		return litigation;
	}
	
	public static WebElement clickNoticeCategory(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']"));
		return litigation;
		
		
	}
	
	public static WebElement chooseCategory(WebDriver driver)
	{
		//elementsList = clickNoticeCategory(driver).findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
		litigation=driver.findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']/div/ul/li[1]"));
		return litigation;
	}
	
	
	
	
	public static WebElement clickSearch(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickOpponentcfo(WebDriver driver)
	{
		//litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[3]"));
		
		 litigation=driver.findElement(By.xpath("//*[@id='tbxOpponent']"));
		  return litigation;
	}
	public static WebElement clickOpponent(WebDriver driver)
	{
		//litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[3]"));
		
		 litigation=driver.findElement(By.xpath(("(//*[@id='divOpponentAndOpposition']/div[1]/div[1]/span[1]/div/button)")));
		  return litigation;
	}
	public static WebElement chooseOpponent(WebDriver driver)
	{
		//elementsList = driver.findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[3]")).findElements(By.tagName("li"));
		litigation=driver.findElement(By.xpath("//*[@id='divOpponentAndOpposition']/div[1]/div[1]/span[1]/div/ul/li/a/label/input"));
		return litigation;
	}
	
	public static WebElement deleteOpponent(WebDriver driver)
	{
		
		litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLCParty_LinkButton2_0']/img"));
		return litigation;
	}
	
	
	public static WebElement clickOppLawyer(WebDriver driver)
	{    
		
		litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[4]"));
		return litigation;
	}
	
	public static WebElement clickSearch1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[1]/div[1]/span[1]/div/ul/li[1]/div/input"));
		return litigation;
	}
	
	public static WebElement clickSearch2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[2]/span/div/ul/li[1]/div/input"));
		return litigation;
	}
	
	public static WebElement clickSelectAll(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[1]/div[1]/span[1]/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickSelectAll1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[2]/span/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickNoticeTitle(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxTitle']"));
		return litigation;
	}
	
	public static WebElement clickNoticeDescription(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxDescription']"));
		return litigation;
	}
	
	public static WebElement clickLocation(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxBranch']"));
		return litigation;
	}
	
	public static WebElement clickPlus(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tvBranchesn1']"));
		return litigation;
	}
	
	public static List<WebElement> selectLocation(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[contains(@id,'tvBranchest')]"));
		return elementsList;
	}
	
	public static WebElement clickJurisdiction(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlJurisdiction_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch3(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlJurisdiction_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickDepartment(WebDriver driver)
	{
		 WebDriverWait wait=new WebDriverWait(driver,40);
		 litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlDepartment_chosen']")));
		//litigation = driver.findElement(By.xpath("//*[@id='ddlDepartment_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch4(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlDepartment_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickContactDept(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch5(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickNoticeTerm(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxNoticeTerm']"));
		return litigation;
	}
	
	public static WebElement clickOwner(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlOwner_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch6(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlOwner_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickWinningProspect(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/a"));
		return litigation;
	}
	
	public static WebElement clickWinningProspect1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']/a"));
		return litigation;
	}
	
	//*[@id="ddlNoticeRisk_chosen"]
	public static WebElement clickRisk(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']"));
		return litigation;
	}
	
	public static WebElement selectRisk(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement selectRisk1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickNoticeBudget(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxNoticeBudget']"));
		return litigation;
	}
	
	public static WebElement clickClaimedAmount(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxClaimedAmt']"));
		return litigation;
	}
	
	public static WebElement clickState(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlState_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchState(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlState_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickProbableAmount(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxProbableAmt']"));
		return litigation;
	}
	
	public static WebElement clickProvisionalAmount(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtprovisionalamt']"));
		return litigation;
	}
	
	public static WebElement clickProtestMoney(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtprotestmoney']"));
		return litigation;
	}
	
	public static WebElement clickRisk1(WebDriver driver)
	{
		//litigation = driver.findElement(By.xpath("//div[@id='ddlRisk_chosen']"));
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']"));
		return litigation;
	}
	
	public static WebElement selectRisk2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//div[@id='ddlRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickPotentialImpactRadio(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='rblPotentialImpact_0']"));
		return litigation;
	}
	
	public static WebElement clickMonetary(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxMonetory']"));
		return litigation;
	}
	
	public static WebElement clickLawFirm(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlLawFirm_chosen']"));
		return litigation;
	}
	
	public static WebElement chooseLawFirm(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
		return litigation;
	}
	
	
	
	
	
	
	 public  static WebElement selectNoticeUploadDocument(WebDriver driver) throws InterruptedException 
	    {
	  	  
	  	  WebDriverWait wait = new WebDriverWait(driver, 100);
	        WebElement NoticeUploadDocument = wait.until(ExpectedConditions.elementToBeClickable(By.id("FileUpLoad1")));
	  	 // WebElement NoticeUploadDocument=driver.findElement(By.id("FileUpLoad1"));
	  	  NoticeUploadDocument.sendKeys("C:\\Users\\Admin\\Desktop\\Teamlease\\Compliance Assignment.xlsx");
	  	  Thread.sleep(3000);
	  	    return litigation;
	    }
	 
	  public  static WebElement selectNoticeRecipetDate(WebDriver driver)
      {
 	
         WebElement openDate=driver.findElement(By.id("txtNoticeReceiptDate"));
         return openDate;
        
      }
	 
	public static WebElement clickInternalUser(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[5]"));
		return litigation;
	}
	
	public static List<WebElement> chooseInternalUser(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[@id='pnlNoticeAssignment']/div[1]/div/span[1]/div/ul/li/a/label/input"));
		return elementsList;
	}
	
	public static List<WebElement> chooseInternalUser1(WebDriver driver)
	{
		//elementsList = driver.findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/ul/li/a/label"));
		
		//elementsList = driver.findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/button"));
		
		elementsList = driver.findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/ul/li/a/label/input"));
		//elementsList=driver.findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[5]")).findElements(By.tagName("li"));
		return elementsList;
	}
	
	public static WebElement clickLawyer(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[6]"));
		return litigation;
	}
	
	public static List<WebElement> chooseLawyer(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[@id='UpdatePanel6']/div/span/div/ul/li/a/label"));
		return 		elementsList;
	}
	
	public static WebElement readTotal(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span"));
		return litigation;
	}
	
	public static WebElement readMessage(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='VSNoticePopup']"));
		return litigation;
	}
	
	public static WebElement readMessage1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='VSCasePopup']"));
		return litigation;
	}
	
	public static WebElement clickClose(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='btnAddEditcase']"));
		return litigation;
	}
	
	public static WebElement clickLinkNotice(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='lnkLinkNotice']"));
		return litigation;
	}
	
	public static WebElement clickLinkCase(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='lnkLinkCase']"));
		return litigation;
	}
	
	public static WebElement clickViewDoc(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='lnkActDetails']"));
		return litigation;
	}
	
	public static WebElement clickSendMail(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='btnSendMailPopup']"));
		return litigation;
	}
	
	public static WebElement clickSendMail1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='lnkSendMailWithDoc']"));
		return litigation;
	}
	
	public static WebElement clickEditNotice(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[18]/a[1]"));
		return litigation;
	}
	
	public static WebElement clickEditCase(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='btnEditCaseDetail']"));
		return litigation;
	}
	
	public static WebElement clickNoticeClosed(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedNoticeCount']"));
		return litigation;
	}
	
	public static WebElement clickExcelReport(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='exportReport']"));
		return litigation;
	}
	public static WebElement clickExcelReport1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='exportReport2']"));
		return litigation;
	}
	
	public static WebElement clickCaseOpen(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenCaseCount']"));
		return litigation;
	}
	
	public static WebElement clickCaseDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtCaseDate']"));
		return litigation;
	}
	
	public static List<WebElement> clickFinanceSearchCheckbox(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[@id='pnlCase']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		
		return elementsList;
	}
	
	public static WebElement clickFinancialYear1(WebDriver driver)
	{//Searching 'Financial Year' drop down
	
		WebDriverWait wait = new WebDriverWait(driver,(30));
	    litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]")));
		//litigation = driver.findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]"));
		return litigation;
	}
	
	public static List<WebElement> chooseDropDownOption1(WebDriver driver)	//Searching drop down in 'Financial Year'
	{
		//elementsList = driver.findElements(By.xpath("//*[@id='pnlNotice']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		elementsList = driver.findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[1]")).findElements(By.tagName("li"));
		return elementsList;
	}
	
	
	public static WebElement clickInternalCaseNo(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxInternalCaseNo']"));
		return litigation;
	}
	
	public static WebElement clickCaseCategory(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseCategory_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchCaseCategory(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseCategory_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseType1(WebDriver driver) 
	{
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement CaseType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rbCaseInOutType_chosen")));
		litigation = driver.findElement(By.id("rbCaseInOutType_chosen"));
		return litigation;
	}
	
	public static WebElement chooseCaseType(WebDriver driver)	//Searching drop down in 'case type'
	{
		litigation=driver.findElement(By.xpath("//*[@id='rbCaseInOutType_chosen']/div/ul/li[2]"));

		return litigation;
	}
	
	
	public static WebElement clickCaseBudget(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxCaseBudget']"));
		return litigation;
	}
	
	public static WebElement clickSearchBox(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@placeholder='Search'])[3]"));
		return litigation;
	}
	
	public static WebElement clickSearchBox1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@placeholder='Search'])[4]"));
		return litigation;
	}
	
	public static WebElement clickSelectAll2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='pnlCase']/div[6]/div[1]/div[1]/span[1]/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickSelectAll3(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@value='multiselect-all'])[4]"));
		return litigation;
	}
	
	public static WebElement clickCourt(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCourt_chosen']/a"));
		return litigation;
	}
	
	public static WebElement clickSearchCourt(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCourt_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickJudge(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxJudge']"));
		return litigation;
	}
	
	public static WebElement clickCaseClosed(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedCaseCount']"));
		return litigation;
	}
	
	public static WebElement clickTaskOpen(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenTaskCount']"));
		return litigation;
	}
	
	public static WebElement clickAddNewTask(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAdd']"));
		return litigation;
	}
	
	public static WebElement clickTaskTitle(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxTaskTitle']"));
		return litigation;
	}
	
	public static WebElement clickTaskDesc(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxTaskDesc']"));
		return litigation;
	}
	
	public static WebElement clickDueDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxTaskDueDate']"));
		return litigation;
	}
	
	public static WebElement clickPriority(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTaskPriorityADD_chosen']"));
		return litigation;
	}
	
	public static WebElement clickExpOutcome(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxExpOutcome']"));
		return litigation;
	}
	
	public static WebElement clickInternalUser1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchInternalUser1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickExternalUser(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTaskUserExternal_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchExternalUser(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTaskUserExternal_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickRemark(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxTaskRemark']"));
		return litigation;
	}
	
	public static WebElement clickUpload(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='fuTaskDocUpload']"));
		return litigation;
	}
	
	public static WebElement clickMessage(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='VsAddTasValidateSuccess']"));
		return litigation;
	}
	
	public static WebElement clickClose1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@onclick='javascript:reloadTaskList();']"));
		return litigation;
	}
	
	public static WebElement clickTaskClosed(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedTaskCount']"));
		return litigation;
	}
	
	public static WebElement clickStatusDropDown(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("(//*[@class='k-multiselect-wrap k-floatwrap'])[3]"));
		return litigation;
	}
	
//	public static WebElement selectStatusDropDown(WebDriver driver)
//	{
//		litigation = driver.findElement(By.xpath("(//*[@class='k-group k-treeview-lines']/li[1])[2]"));
//		return litigation;
//	}
//	
	public static WebElement GridLoad(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']"));
		return litigation;
	}
	
	public static WebElement clickGridElement(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[1]"));
		return litigation;
	}
	
	public static List<WebElement> clickAction(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	
	public static WebElement clickCheckBox(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grdNoticeList_LinkNotice_chkRowLinkCases_0']"));
		return litigation;
	}
	
	public static WebElement clickApply(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//a[@id='lnkLinkCaseFilter']"));
		return litigation;
	}
	
	public static WebElement clickApply1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//a[@id='lnkLinkNoticeFilter']"));
		return litigation;
	}
	
	public static WebElement clickSave(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@value='Save']"));
		return litigation;
	}
	
	public static WebElement readMsg(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='vsLinkCase']"));
		return litigation;
	}
	
	public static WebElement clickClosePopup(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='divLinkNoticePopup']/div/div/div[1]/button"));
		return litigation;
	}
	
	public static WebElement readRef(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grdNoticeList_LinkNotice']/tbody/tr[2]/td[3]/div/span"));
		return litigation;
	}
	
	public static List<WebElement> readRef1(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[contains(@id,'grdLinkedNotices_lblCaseNo')]"));
		return elementsList;
	}
	
	public static WebElement clickMyWorkspace(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='leftworkspacemenu']"));
		return litigation;
	}
	
	public static WebElement clickStatus(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/div/span"));
		return litigation;
	}
	
	public static WebElement clickStatusPayments(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='lnkNoticeStatusPayment']"));
		return litigation;
	}
	
	public static WebElement clickNoticeStatus(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeStatus_chosen']"));
		return litigation;
	}
	
	public static WebElement clickClosedStatus(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeStatus_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickCloseDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxNoticeCloseDate']"));
		return litigation;
	}
	
	public static WebElement clickNoticeResult(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeResult_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSelectResult(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlNoticeResult_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickRemark1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxCloseRemark']"));
		return litigation;
	}
	
	public static WebElement clickSave1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//input[@id='btnSaveStatus']"));
		return litigation;
	}
	
	public static WebElement readMessage2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ValidationSummary3']"));
		return litigation;
	}
	
	public static WebElement clickCourtCaseNo(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxAppealCaseNo']"));
		return litigation;
	}
	
	public static WebElement clickSaveConvertCase(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='btnSaveConvertCase']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatusPayments(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='lnkCaseStatus']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatus(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatusClose(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']/div/ul/li[3]"));
		return litigation;
	}
	
	public static WebElement clickCaseCloseDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxCaseCloseDate']"));
		return litigation;
	}
	
	public static WebElement clickCaseResult(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseResult_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSelectCaseResult(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseResult_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseStage(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseStage_chosen']"));
		return litigation;
	}
	
	public static WebElement selectCaseStage(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlCaseStage_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseCheckBox(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grdCaseList_LinkCase_chkRowLinkCases_0']"));
		return litigation;
	}
	
	public static WebElement readCaseRef(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grdCaseList_LinkCase']/tbody/tr[2]/td[3]/div/span"));
		return litigation;
	}
	
	public static List<WebElement> readCaseRef1(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[contains(@id,'grdLinkedCases_lblCaseNo')]"));
		return elementsList;
	}
	
	public static WebElement clickClosePopupCase(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='divLinkCasePopup']/div/div/div[1]/button"));
		return litigation;
	}
	
	public static WebElement clickMyReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='leftreportsmenu']"));
		return litigation;
	}
	public static WebElement clickMoreReports(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		litigation = driver.findElement(By.xpath("//*[@id='MoreReport']"));
		return litigation;
	}
	public static WebElement clicklocationFilterReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return litigation;
	}
	public static WebElement selectlocationFilterReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt8']"));
		return litigation;
	}
	public static WebElement FromDateReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFromDate']"));
		return litigation;
	}
	public static WebElement MISReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMis']"));
		return litigation;
	}
	
	public static WebElement closedCasesReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMisCloseReport']"));
		return litigation;
	}
	public static WebElement ExtLawyerPerformanceReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnLawyerPerformance']"));
		return litigation;
	}
	public static WebElement BudgetReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnBudgetVsExpenseTracking']"));
		return litigation;
	}
	public static WebElement LawyerDetailsReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnLawyerDetails']"));
		return litigation;
	}
	public static WebElement CasePaymentReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCasepayments']"));
		return litigation;
	}
	public static WebElement CaseHearingReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCaseHearning']"));
		return litigation;
	}
	public static WebElement CourtCaseReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCourtCases']"));
		return litigation;
	}
	public static WebElement CourtOrderReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCourtOrders']"));
		return litigation;
	}
	public static WebElement CourtDoumentReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCaseDocument']"));
		return litigation;
	}
	public static WebElement noticeCovertedToCaseReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnNoticeToCase']"));
		return litigation;
	}
	public static WebElement AllReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAll']"));
		return litigation;
	}
	
	public static WebElement clickNoticeReport(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkNotice']"));
		return litigation;
	}
	public static WebElement clickNoticePaymentReport(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnNoticepayments']"));
		return litigation;
	}
	public static WebElement clickNoticeResponseReport(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnNoticeResponse']"));
		return litigation;
	}
	
	
	
	
	
	public static WebElement selectFromDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a"));
		return litigation;
	}
	public static WebElement selectToDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a"));
		return litigation;
	}
	
	
	public static WebElement ToDateReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtToDate']"));
		return litigation;
	}
	public static WebElement AdvancedSearchReports(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='AdavanceSearch']"));
		return litigation;
	}
	public static WebElement startDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='Startdatepicker']"));
		return litigation;
	}
	
	public static WebElement endDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='Lastdatepicker']"));
		return litigation;
	}
	public static WebElement clickApplyButton(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ApplyBtnAdvanced']"));
		return litigation;
	}
	public static WebElement clickExportAdavanced(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='exportAdvanced']"));
		return litigation;
	}
	public static WebElement clickShowResponseDetails(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]"));
		return litigation;
	}
	public static WebElement clickclosepopup(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='btnAddEditcase']"));
		return litigation;
	}
	
	public static WebElement clickviewNoticeDtails(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]"));
		return litigation;
	}
	
	public static WebElement CheckRecordsTable(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='grid']"));
		return litigation;
	}
	
	public static WebElement clickTypeDropdown(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@aria-owns='dropdownType_listbox']"));
		return litigation;
	}
	public static WebElement clickTypeDropdown1(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 100);
		litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[6]")));
		return litigation;
	}
	public static WebElement clickTypeDropdown2(WebDriver driver)
	{
		
		 WebDriverWait wait = new WebDriverWait(driver, 100);
		litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[15]")));
		//litigation = driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[15]"));
		return litigation;
	}
	
	public static WebElement selectTypeCase(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='dropdownType_listbox']/li[2]"));
		return litigation;
	}
	
	public static WebElement selectTypeCase1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='dropdownType1_listbox']/li[2]"));
		return litigation;
	}
	public static WebElement selectTypeCase2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='dropdownlistCase_listbox']/li[2]"));
		return litigation;
	}

	
	public static WebElement selectTypeTask(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='dropdownType_listbox']/li[3]"));
		return litigation;
	}
	
	public static WebElement selectTypeTask1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='dropdownType1_listbox']/li[3]"));
		return litigation;
	}
	public static WebElement selectTypeTask2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='dropdownlistCase_listbox']/li[3]"));
		return litigation;
	}
	public static WebElement clickMyReminder(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='leftremindersmenu'][@class='leftdummy']"));
		return litigation;
	}
	
	public static WebElement clickAddNew1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='Addnew']"));
		return litigation;
	}
	
	public static WebElement clickType(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTypePopup_chosen']"));
		return litigation;
	}
	
	public static WebElement clickTitle(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ddlTitlePopup_chosen']"));
		return litigation;
	}
	
	public static WebElement clickReminderText(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtReminderTitle']"));
		return litigation;
	}
	
	public static WebElement clickDescription(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtReminderDesc']"));
		return litigation;
	}
	
	public static WebElement clickRemark2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtRemark']"));
		return litigation;
	}
	
	public static WebElement clickDate(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='txtRemindOn']"));
		return litigation;
	}
	
	public static WebElement readMsg1(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='vsReminder']"));
		return litigation;
	}
	
	public static WebElement readMsg2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='vsReminder']/ul/li"));
		return litigation;
	}
	
	public static WebElement clickCloseReminder(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@onclick='CloseMyReminderPopup();']"));
		return litigation;
	}
	
	public static WebElement clickMasters(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='leftmastermenu']"));
		return litigation;
	}
	
	public static WebElement clickMastersMenu(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='leftmastermenu']/ul"));
		return litigation;
	}
	
	public static WebElement clickAddNew2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return litigation;
	}
	
	public static WebElement clickCaseNoticeType(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='tbxCaseType']"));
		return litigation;
	}
	
	public static WebElement readMesg(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return litigation;
	}
	
	public static WebElement clickClose2(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@onclick='RefreshParent()']"));
		return litigation;
	}
	
	public static WebElement clickDtei(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath(""));
		return litigation;
	}
	
	public static WebElement clickDtevrt(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath(""));
		return litigation;
	}
	
	public static WebElement clickDteir(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath(""));
		return litigation;
	}

	
	public static WebElement readDocMsg(WebDriver driver)
	{
		litigation = driver.findElement(By.xpath("//*[@id='vsContractDocument']"));
		return litigation;
	}
	
	 public static WebElement clickNoticeDocument(WebDriver driver)
	 {
		litigation= driver.findElement(By.xpath("//*[@id='lnkDocument']"));
		return litigation;
		 
	 }
	 public static WebElement clickNewDocument(WebDriver driver)
	    {
		 litigation = driver.findElement(By.xpath("//*[@id='lnkAddNewDoctype']"));
	  	  return litigation;
	 } 
	 
	    public static void selectDocumentType(WebDriver driver)
	    {
	  	
	        WebElement DocumentType = driver.findElement(By.xpath ("//*[@id='ddlDocType_chosen']"));
            System.out.println("pdf doc");
	  	    DocumentType.click();
	    } 

		    public static void chooseDocumentType(WebDriver driver)
		    {
		    	 WebElement DocumentType = driver.findElement(By.xpath ("//*[@id='ddlDocType_chosen']/div/ul/li[2]"));
		            System.out.println("pdf doc");
			  	    DocumentType.click();
		    	
		    }
//	  	     List<WebElement> options = DocumentType.findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
//	  		    for (WebElement option : options)
//	  		    {
//	  			   if (option.getText().trim().equals("Receipts"))
//	  		      {
//	  		        option.click(); // click the desired option
//	  		        break;
//	  		      }
//	  		   }
	    
//	    
	    public static void selectUploadDocument(WebDriver driver) 
	     {
	   	  
	   	     WebDriverWait wait = new WebDriverWait(driver, 20);
	         WebElement UploadDocument = wait.until(ExpectedConditions.elementToBeClickable(By.id("LitigationFileUpload")));
	   	     UploadDocument.sendKeys("C:\\Users\\Admin\\Desktop\\Teamlease\\Compliance Assignment.xlsx");
	   	
	     } 
		 
		 public static WebElement clickUploadDocument(WebDriver driver) 
	     {
	   	  
			  WebDriverWait wait = new WebDriverWait(driver, 20);
	         litigation = wait.until(ExpectedConditions.elementToBeClickable(By.id("lnkDocumentUpload")));
	    	  return litigation;
	   	
	     } 
		 
		 public static WebElement clickClosedDocument(WebDriver driver)
		 {
			 WebDriverWait wait=new WebDriverWait(driver,20);
			 litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
			 return litigation;
			
			 
		 }
		 
		 public static WebElement readTaskMsg(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='ValidationSummary8']"));
				return litigation;
			}
		 public static WebElement clickTaskorActivity(WebDriver driver)
		 {
			
			 litigation=driver.findElement(By.id("lnkNoticeTask"));
			 return litigation;
		 }
		 
		 public static WebElement clickNewTask(WebDriver driver)
		 {
			 litigation=driver.findElement(By.id("LinkButton2")); 
			return litigation;
		 }
		 

		public static WebElement ClickTaskTitle(WebDriver driver)
		{
			   WebDriverWait wait = new WebDriverWait(driver, 30);
			  litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbxTaskTitle")));
			   return litigation;
		 }
		
		public static WebElement ClickTaskDescription(WebDriver driver)
		{

			    WebDriverWait wait = new WebDriverWait(driver, 30);
			    litigation= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbxTaskDesc']")));
			    return litigation;
			 
		 }
		
		public static WebElement selectTaskDueDate(WebDriver driver)
	    {
		
	       litigation = driver.findElement(By.id("tbxTaskDueDate"));
	       return litigation;
	    }
	       public static WebElement UpdatePanel1(WebDriver driver)
		    {
	    	     litigation=driver.findElement(By.id("UpdatePanel1"));
	    	     return litigation;
	     }
		
		public static WebElement clickInternalUser2(WebDriver driver)
	    {      
			WebElement TaskPanel=driver.findElement(By.id("UpdatePanel1"));
	        TaskPanel.click();
			
		    WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTaskUserInternal_chosen']")));
          TaskPanel.click();
            return litigation;
		  }
		
		 public static WebElement selectInternalUser2(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTaskUserInternal_chosen']/div/div/input")));
	    	  return litigation;
	    	  
	      } 
		 public static WebElement selectInternalUser3(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']/div/div/input")));
	    	  return litigation;
	    	  
	      } 
		
		  public static WebElement clickSaveButton(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTaskSave")));
	    	// litigation = driver.findElement(By.id("btnTaskSave"));
	    	  return litigation;
	    	  
	      } 

		  public static WebElement readResponseMsg(WebDriver driver)
		  {
			  litigation= driver.findElement(By.xpath("//*[@id='ValidationSummary10']"));
			 return litigation;
			  
		  }
		  
		  public static WebElement clickResponse(WebDriver driver)
		  {
			  
			  litigation= driver.findElement(By.xpath("//*[@id='lnkNoticeResponse']"));
			 return litigation;
			  
		  }
		  
		  public static WebElement clickNewResponse(WebDriver driver)
		  {
			  litigation =driver.findElement(By.id("LinkButton1"));
			  return litigation;
		  }
		  
		  public static void selectSentNotice(WebDriver driver)
		  {
			
			  System.out.println("Received");
			  Select sentnotice = new Select(driver.findElement(By.id("ddlNoticeResponseDate"))); 
			 // sentnotice .selectByVisibleText("Received");
			  sentnotice.selectByValue("1");
			
		  }
		  
		  public static void selectReplyDueDate(WebDriver driver)
		  {
			

			  WebDriverWait wait = new WebDriverWait(driver, 30);
			  WebElement ReplyDueDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxNoticeDueDate']")));
			 ReplyDueDate.sendKeys("01-10-2022");
			
		  }
		  
		  public static void selectRespondedDate(WebDriver driver)
		  {
			  

			  WebDriverWait wait = new WebDriverWait(driver, 30);
			  WebElement RespondedDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxResponseDate']")));
			 // WebElement RespondedDate =driver.findElement(By.xpath("//*[@id='tbxResponseDate']"));
			  RespondedDate.sendKeys("01-09-2022");
			  
			  WebElement ResponsePanel=driver.findElement(By.id("DivResponceCollapsTwo"));
			  ResponsePanel.click();
			  
		  }
		  
		  public static WebElement clickDeliveryMode(WebDriver driver)
		  {
		
//			  Select selectDeliveryMode = new Select(driver.findElement(By.xpath("//*[@id='ddlRespBy_chosen']"))); 
//			
//			  selectDeliveryMode.selectByValue("1");
			  litigation =driver.findElement(By.xpath("//*[@id='ddlRespBy_chosen']"));
			  return litigation;
			  
			  
		  }
		  
		  public static WebElement selectDeliveryMode(WebDriver driver)
		  {
		
			  litigation =driver.findElement(By.xpath("//*[@id='ddlRespBy_chosen']/div/div/input"));
			  return litigation;
			  
		  }
		  
		  public static WebElement clickCourierCompany(WebDriver driver)
		  {
			 litigation =driver.findElement(By.id("tbxRespThrough"));
			  return litigation;
		  }
		
		  
		  public static WebElement RefTrackingNo(WebDriver driver)
		  {

			 litigation=driver.findElement(By.xpath("//*[@id='tbxRespRefNo']"));
			  return litigation;
			  
		  }
		
		
		  public static WebElement Description(WebDriver driver)
		  {
			  litigation =driver.findElement(By.xpath("//*[@id='tbxResponseDesc']"));
			 return litigation;
			  
		  }
		
		  
		  public static WebElement clickSaveResponse(WebDriver driver)
		  {
			  WebDriverWait wait = new WebDriverWait(driver,30);
			 // litigation =driver.findElement((By.xpath("//*[@id='btnSaveResponse']")));
			 
			litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSaveResponse']")));
			  return litigation;
			 
			  
		  }
		  
		  public static WebElement clickExternalLawyerRating(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver,300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='lnkLawyerRating']")));
	    	// litigation = driver.findElement(By.xpath("//*[@id='lnkLawyerRating']"));
	    	  return litigation;
	      }  
		  
		  public static void selectExternalLawyerRating(WebDriver driver) 
	      {  
			  WebDriverWait wait = new WebDriverWait(driver,300);
		     WebElement ExternalLawyer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlLayerType_chosen']")));
		     ExternalLawyer.click();
	    		List<WebElement> ExternalLawyer1= driver.findElements(By.xpath("//*[@id='ddlLayerType_chosen']/div/ul/li"));
	    		ExternalLawyer1.get(1).click();
	    		 
	      } 
		  public static WebElement clickExternalLawyerRating1(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver,300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='lnkCaseRating']")));
	    	// litigation = driver.findElement(By.xpath("//*[@id='lnkLawyerRating']"));
	    	  return litigation;
	    	  
	      } 
		
		  
		  public static void selectCaseExternalLawyer(WebDriver driver) 
	      {

			  WebDriverWait wait = new WebDriverWait(driver,30);
			  WebElement ExternalLawyer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlLayerType_chosen']")));
	    	// WebElement ExternalLawyer= driver.findElement(By.xpath("//*[@id='ddlLayerType_chosen']"));
	    	 ExternalLawyer.click();
	    	  List<WebElement> options =ExternalLawyer.findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));

				for (WebElement option : options)
				{
				    if (option.getText().equals("Deepali Devkar"))
				    {
				    	System.out.println(option.getText());
				        option.click(); // click the desired option
				        break;
				    }
				} 
				 
		 }
		  
		  public static WebElement clickNewCriteria(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver,30);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnAddPromotor']")));
	    	// litigation = driver.findElement(By.xpath("//*[@id='lnkLawyerRating']"));
	    	  return litigation;
	    	  
	      } 
		  public static WebElement clickCriteria (WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver,30);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxCriteria']")));
	         // litigation = driver.findElement(By.xpath("//*[@id='tbxCriteria']"));
	    	  return litigation;

//			  WebDriverWait wait = new WebDriverWait(driver, 30);
//			  WebElement criteria = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxCriteria']")));
//			 criteria.sendKeys("Test");
	    	  
	      } 
		  public static WebElement clickSaveCriteria(WebDriver driver) 
	      {
//			  WebDriverWait wait = new WebDriverWait(driver,30);
//			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnSave']")));
	    	 litigation = driver.findElement(By.xpath("//*[@id='btnSave']"));
	    	  return litigation;
	    	  
	      } 
		  
		  public static WebElement clickclosecriteria(WebDriver driver) 
	      {
//			  WebDriverWait wait = new WebDriverWait(driver,30);
//			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnSave']")));
	    	 litigation = driver.findElement(By.xpath("//*[@id='AddLayerRatingCriteriaShowDialog']/div/div/div[1]/button"));
	    	  return litigation;
	    	  
	      } 
		  
		  public static WebElement clickstar(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='grdLawyerRating_LawyerRating_9_Star_1']")));
	    	
	    	  return litigation;
	      } 
		  
		  public static WebElement clickstar1(WebDriver driver) 
	      {
			  
               WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='grdLawyerRating_LawyerRating_9_Star_2']")));
	    	//litigation = driver.findElement(By.xpath("//*[@id='grdLawyerRating_LawyerRating_9_Star_2']"));
	    	  return litigation;
	      } 
		  public static WebElement clickSaveRating(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnSaveLawRating']")));
	    	//litigation = driver.findElement(By.xpath("	//*[@id='btnSaveLawRating']"));
	    	  return litigation;
	      } 
		  
		  public static WebElement clickAuditLog(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='liAuditLog']")));
	    	 //litigation = driver.findElement(By.xpath("//*[@id='liAuditLog']"));
	    	  return litigation;
	    	  
	      } 
		
		  
		  public static WebElement clickExport(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnExport']")));
	    	// litigation = driver.findElement(By.xpath("//*[@id='btnExport']"));
	    	  return litigation;
	    	  
	      } 
		  
	
		  public static WebElement clickclosebutton(WebDriver driver) 
	      {
			  WebDriverWait wait = new WebDriverWait(driver, 500);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnAddEditcase']")));
	    	 //litigation = driver.findElement(By.xpath("//*[@id='btnAddEditcase']"));
	    	  return litigation;
	    	  
	      } 
		  public static WebElement clickInvoiceNo(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='grdNoticePayment_tbxInvoiceNo']"));
				return litigation;
			}
		  public static WebElement clickPaymentType(WebDriver driver)
			{
			litigation = driver.findElement(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']"));
			return litigation;
			
			}
		  
		  public static WebElement selectPaymentType(WebDriver driver)
			{
			litigation = driver.findElement(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/div/input"));
			return litigation;
			
			}
		  
		
		  
				
		  
		  public static WebElement clickAmount(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='grdNoticePayment_tbxAmount']"));
				return litigation;
			}
		  public static WebElement clickSavePaymentLog(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='grdNoticePayment_btnPaymentSave']"));
				return litigation;
			}
		  
		  public static WebElement readPymentmsg(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='ValidationSummary4']"));
				return litigation;
			}
		  
		  public static WebElement readRatingmsg(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='ValidationSummary6']"));
				return litigation;
			}
		  public static WebElement clickCaseTask(WebDriver driver)
			{
				litigation = driver.findElement(By.xpath("//*[@id='lnkCaseTask']"));
				return litigation;
			}
		  public static WebElement clickCaseNewTask(WebDriver driver)
		    {
		  	  litigation = driver.findElement(By.xpath("//*[@id='LinkButton1']"));
		  	  return litigation ;
		    }
		 public static WebElement clickHearingDate(WebDriver driver)
		    {
			 WebDriverWait wait = new WebDriverWait(driver,300);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxTaskHearingDate']")));
		  	 //litigation = driver.findElement(By.id("tbxTaskHearingDate"));
		  	  return litigation;
		  	  
		    }
		 public static WebElement clickSaveHearingDate(WebDriver driver)
		    {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lnkSaveRefNo")));
		  	// litigation = driver.findElement(By.id("lnkSaveRefNo"));
		  	 return litigation; 
		  	  
		    }
		 public static WebElement clickInternalUser3(WebDriver driver)
		    {      
				WebElement TaskPanel=driver.findElement(By.id("UpdatePanel1"));
		        TaskPanel.click();
				
				  WebDriverWait wait = new WebDriverWait(driver, 10);
				  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']")));
				 // System.out.println(InternalUser.isDisplayed());
				  TaskPanel.click();
				return litigation;

			  }
		 public static WebElement clickCaseHearing(WebDriver driver)
		 {
			 WebDriverWait wait = new WebDriverWait(driver,30);
			litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkCaseHearing']")));
			// litigation=driver.findElement(By.xpath("//*[@id='lnkCaseHearing']"));
			 return litigation;
		 }
		 public static WebElement clickNewCaseHearing(WebDriver driver)
		 {
			 WebDriverWait wait = new WebDriverWait(driver,30);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkAddhearing']")));
			 //litigation=driver.findElement(By.xpath("//*[@id='lnkAddhearing']"));
			 return litigation;
		 }
		 
		 public static WebElement clickCaseHearingDate(WebDriver driver)
		 {
			 WebDriverWait wait = new WebDriverWait(driver,30);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxTabHearingDate']")));
			   return litigation;
		 }
		 
		 public static WebElement clickSaveCaseHearingDate(WebDriver driver)
		 {
			 WebDriverWait wait = new WebDriverWait(driver,30);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkTabSaveRefNo']")));
		       return litigation;
		 }
		 public static WebElement clickCaseHearingDecsri(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxResponseDesc']"));
			 return litigation;
		 }
		 public static WebElement clickSaveCaseHearing(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='btnSaveHearing']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrder(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='lnkCaseOrder']"));
			 return litigation;
		 }
		 public static WebElement clickNewCaseOrder(WebDriver driver)
		 {
			 WebDriverWait wait = new WebDriverWait(driver,30);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='LinkButton3']")));
			// litigation=driver.findElement(By.xpath("//*[@id='AddNewOrderDiv']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrderDate(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxOrderDate']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrderType(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='ddlOrderType_chosen']"));
			 return litigation;
		 }
		 public static WebElement selectCaseOrderType(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='ddlOrderType_chosen']/div/ul/li[2]"));
			 return litigation;
		 }
		 
		 public static WebElement clickCaseOrderTitle(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxOrderTitle']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrderDecri(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxOrderDesc']"));
			 return litigation;
		 }
		
		 public static WebElement clickSaveCaseOrder(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='btnOrderSave']"));
			 return litigation;
		 }
		 public static WebElement clickOrderPanel(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='collapseDivOrderLogs']"));
			 return litigation;
		 }
		 public static WebElement clickAdvocateBill(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='lnkCaseAdvocateBill']"));
			 return litigation;
		 }
		 public static WebElement clickNewAdvocateBill(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='LnkAddAdvocateBill']"));
			 return litigation;
		 }
		 public static WebElement clickInvoiceNum(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxAdvInvoiceno']"));
			 return litigation;
		 }
		 public static WebElement clickInvoiceDate(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxinvoicedate']"));
			 return litigation;
		 }
		 public static WebElement clickInvoiceAmount(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='tbxAdvInvoiceAmount']"));
			 return litigation;
		 }
		 public static WebElement clickLawFirm1(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='ddlLawyerAdvocate_chosen']"));
			 return litigation;
		 }
		 public static void selectLawFirm1(WebDriver driver)
		 {
			 
//			// Create object of the Select class
//			 Select LawFirm1 = new Select(driver.findElement(By.xpath("//*[@id='ddlLawyerAdvocate_chosen']")));
//			 			
//			 // Select the option by index
//			 LawFirm1.selectByIndex(3);
//			 WebElement selectMyElement = driver.findElement((By.xpath("//*[@id='ddlLawyerAdvocate_chosen']"))); 
//			 selectMyElement.click();
//
//			 Actions keyDown = new Actions(driver);
//			 keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
	   
			List<WebElement>LawFirm1= driver.findElements(By.xpath("//*[@id='ddlLawyerAdvocate_chosen']/div/ul/li"));
			 LawFirm1.get(1).click();
		
		 }
	

		public static WebElement clickApprover1(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='ddlApprover1_chosen']"));
			 return litigation;
		 }
		 public static void selectApprover1(WebDriver driver)
		 {
				List<WebElement> Approver1= driver.findElements(By.xpath("//*[@id='ddlApprover1_chosen']/div/ul/li"));
				Approver1.get(0).click();
		 }
		 public static WebElement clickApprover2(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='ddlApprover2_chosen']"));
			 return litigation;
		 }
		 public static void selectApprover2(WebDriver driver)
		 {
	        List<WebElement> Approver1= driver.findElements(By.xpath("//*[@id='ddlApprover2_chosen']/div/ul/li"));
			Approver1.get(0).click();
		 }
		 public static WebElement clickSaveAdvocateBill(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='btnAdvocateBillSave']"));
			 return litigation;
		 }
		 public static WebElement clickAdvocateBillPanel(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='collapseDivAdvocateBillLogs']"));
			 return litigation;
		 }
		
		 public static WebElement clickCaseInvoiceNo1(WebDriver driver)
		 {
			 litigation=driver.findElement(By.xpath("//*[@id='grdCasePayment_tbxInvoiceNo']"));
			 return litigation;
		 }
		  public static void clickPaymentTyp1(WebDriver driver)
				{
				WebElement PaymentType  = driver.findElement(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']"));
				PaymentType.click();
					
				}
			  
		  public static WebElement clickAmount1(WebDriver driver)
			 {
				 litigation=driver.findElement(By.xpath("//*[@id='grdCasePayment_tbxAmount']"));
				 return litigation;
			 }
		  public static WebElement clickSavePaymentLog1(WebDriver driver)
			 {
				 litigation=driver.findElement(By.xpath("//*[@id='grdCasePayment_btnPaymentSave']"));
				 return litigation;
			 }
		  
		  public static WebElement clickMyDocument(WebDriver driver)
			 {
	           WebDriverWait wait = new WebDriverWait(driver,30);
			    litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftdocumentsmenu']/a/span[1]")));
	            return litigation;
			 }
		  public static WebElement clickmyDocument(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DocumentShareListNew']")));
			 
			   return litigation;
			   
			}
		  public static WebElement clickDownloadDocument(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[16]/a[1]")));
			 
			   return litigation;
			   
			}
		  public static WebElement clickDownloadDocument1(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[14]/a[1]")));
			 
			   return litigation;
			   
			}
		    public static WebElement clickViewDocument(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[16]/a[2]")));
			 
			   return litigation;
			 }

		    public static WebElement clickViewDocument1(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[14]/a[2]")));
			 
			   return litigation;
			 }
		    
		    
		    public static WebElement clickcloseViewDocument(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divViewDocument2']/div/div/div[1]/button")));
			 
			   return litigation;
			   
			}
		  
		    public static WebElement clickcloseViewDocument1(WebDriver driver)
			{
		
		       WebDriverWait wait = new WebDriverWait(driver,30);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divViewDocument1']/div/div/div[1]/button")));
			 
			   return litigation;
			   
			}
		  public static WebElement ClickImportUtility(WebDriver driver)
		  {
			  WebDriverWait wait=new WebDriverWait(driver,30);
			  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftuploadmenu']/a/span[1]")));
			  return litigation;
		  }
		  public static WebElement ChooseCaseType(WebDriver driver)
		  {
			  WebDriverWait wait=new WebDriverWait(driver,30);
			  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoCCUpload']")));
			  return litigation;
		  }
		  public static WebElement ChooseCaseFile(WebDriver driver) throws InterruptedException
		  {
			  
			     WebElement CaseFile=driver.findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("C:\\Users\\Admin\\Desktop\\CaseFileUpload.xlsx");
			     return litigation;
	      }
		  public static WebElement UploadCaseFile(WebDriver driver) throws InterruptedException
		  {
			  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnUploadFile']"));
			  return litigation;
		  }
		  
		  
		  
		  public static WebElement readCaseMsg(WebDriver driver) throws InterruptedException
		  {
			  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']"));
			  return litigation;
		  }
		  
		  public static WebElement ClickcaseHearing(WebDriver driver) throws InterruptedException
		  {
			  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoCHUpload']"));
			  return litigation;
		  }
		  
		  public static WebElement ClickcaseOrder(WebDriver driver) throws InterruptedException
		  {
			  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoCOUpload']"));
			  return litigation;
		  }
		  public static WebElement ClickcasePayment(WebDriver driver) throws InterruptedException
		  {
			  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoCPUpload']"));
			  return litigation;
		  }
		  
		  
		  

        public static WebElement clickNotice(WebDriver driver) throws InterruptedException
          {
              litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkLN']"));
               return litigation;
           }
        
  	  public static WebElement ChooseNoticeType(WebDriver driver)
	  {
		  WebDriverWait wait=new WebDriverWait(driver,30);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoLNUpload']")));
		  return litigation;
	  }
  	  
  	  public static WebElement ChooseNoticeResponse(WebDriver driver)
	  {
		  WebDriverWait wait=new WebDriverWait(driver,30);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoNRUpload']")));
		  return litigation;
	  }
  	  
	  public static WebElement ChoosePaymentInfo(WebDriver driver)
	  {
		  WebDriverWait wait=new WebDriverWait(driver,30);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoPIUpload']")));
		  return litigation;
	  }
  	    
	  public static WebElement ChooseNoticeFile(WebDriver driver) throws InterruptedException
	  {
		  
		     WebElement CaseFile=driver.findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("C:\\Users\\Admin\\Desktop\\NoticeFileUpload.xlsx");
		     return litigation;
      }
	  public static WebElement UploadNoticeFile(WebDriver driver) throws InterruptedException
	  {
		  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnUploadFileLN']"));
		  return litigation;
	  }
	  
	  public static WebElement readNoticeMsg(WebDriver driver) throws InterruptedException
	  {
		  litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']"));
		  return litigation;
	  }
	  
	  public static WebElement caseNoticeSummaryGraph(WebDriver driver) throws InterruptedException
	  {
		  litigation=driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		  return litigation;
	  }
	  
	  
	  public static WebElement readTotalItemsD(WebDriver driver) throws InterruptedException
	  {
		  litigation=driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		  return litigation;
	  }
	  
	  public static WebElement caseNoticeSummaryGraphExport(WebDriver driver) throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='exportReport']")));
		 // litigation=driver.findElement(By.cssSelector("button[id='exportReport']"));
		  return litigation;
	  }
	  
	  public static WebElement CaseNoticeTypeSummaryGraph(WebDriver driver) throws InterruptedException
	  {
		  
		  litigation=driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		  return litigation;
	  }
	  public static WebElement RiskSummaryGraph(WebDriver driver) throws InterruptedException
	  {
		  
		  litigation=driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[3]"));
		  return litigation;
	  }
	  public static WebElement DepartmentSummaryGraph(WebDriver driver) throws InterruptedException
	  {
		  
		  litigation=driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[4]"));
		  return litigation;
	  }
	  public static WebElement LocationSummaryGraph(WebDriver driver) throws InterruptedException
	  {
		  
		  litigation=driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[7]"));
		  return litigation;
	  }
	  
	  public static WebElement CategorySummaryGraph(WebDriver driver) throws InterruptedException
	  {
		  
		  litigation=driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[9]"));
		  return litigation;
	  }
	  
	  public static WebElement caseNoticeSummaryGraphClose(WebDriver driver) throws InterruptedException
	  {
		  
		  litigation=driver.findElement(By.xpath("//*[@id='divGraphDetails']/div/div/div[1]/button"));
		 // litigation=driver.findElement(By.cssSelector("button[id='exportReport']"));
		  return litigation;
	  }
	  
	  

	  public static WebElement TableLoad(WebDriver driver) throws InterruptedException
	  {
		  litigation=driver.findElement(By.xpath("//*[@id='grid']"));
		  return litigation;
	  }
	  
	  
	  
		public static WebElement chooseMasterLegalEntity(WebDriver driver)
		{
			 WebDriverWait wait = new WebDriverWait(driver, 20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[1]/a")));
			//WebElement LawFirm = driver.findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
			return litigation;
			
		}
		
		public static WebElement addLegalEntity(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddCustomerBranch']")));
			return litigation;
		}
	  
		public static WebElement legalEntityName(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxName']")));
			return litigation;
		}
		
		
	
	  
		public static WebElement clickUnitType(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlType']")));
			return litigation;
		}
		public static WebElement chooseUnitType(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlType']/option[2]")));
			return litigation;
		}
		public static WebElement clickLegalEntityType(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCompanyType']")));
			return litigation;
		}
		public static WebElement chooseLegalEntityType(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCompanyType']/option[2]")));
			return litigation;
		}
		public static WebElement editLegalEntity(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomerBranch_LinkButton1_0']/img")));
			return litigation;
		}
		
		
		public static WebElement clickAddressLine(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxAddressLine1']")));
			return litigation;
		}
  	  
		public static WebElement clickState1(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlState']")));
			return litigation;
		}
        
		public static WebElement chooseState1(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlState']/option[75]")));
			return litigation;
		}
        
        
		public static WebElement clickCity(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCity']")));
			return litigation;
		}
        
		public static WebElement chooseCity(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCity']/option[3]")));
			return litigation;
		}
        
		public static WebElement clickContactPerson(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactPerson']")));
			return litigation;
		}
		public static WebElement clickEmail(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
			return litigation;
		}
		
		public static WebElement clickSaveLegalEntity(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
			return litigation;
		}
		public static WebElement clickcloseLegalEntity(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
			return litigation;
		}
		
		public static WebElement readlegalmsg(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_valcustomerbranch']")));
			return litigation;
		}
		
		
		public static WebElement chooseMasterLawFirm(WebDriver driver)
		{
			litigation=driver.findElement(By.xpath("//*[@id='Mastersubmenu']/li[2]/a"));
			//WebElement LawFirm = driver.findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
			return litigation;
			
		}
		  public static WebElement newLawFirm(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddLaywer']"));
				return litigation;
				
			}
			
			public static WebElement  nameLawFirm(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstName']")));
				return litigation;
			}
			
			public static WebElement Email(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
				return litigation;
			}
		 
			public static WebElement contactNo(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
				return litigation;
			}
			
			
			public static WebElement ReadLawFirmMsg(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
				return litigation;
			}
			
			public static WebElement clickSaveLawFirm(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
				return litigation;
			}
			

			public static WebElement clickCloseButton(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
				return litigation;
			}
			
			public static WebElement editLawFirm(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLawyer_lbtnEdit_0']/img")));
				return litigation;
			}
			
			public static WebElement clickAddNewLawyer(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLawyer_lbtAddLawyer_0']/img")));
				return litigation;
			}
			
			public static WebElement clickLawyerName(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstNameUser']")));
				return litigation;
			}
			
			public static WebElement clickLawyerLastName(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxLastNameUser']")));
						
				return litigation;
			}
			
			public static WebElement clickLawyerDesignation(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxDesignation']")));
						
				return litigation;
			}
			public static WebElement clickLawyerEmail(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmailUser']")));
						
				return litigation;
			}
			public static WebElement clickLawyerContactNo(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNoUser']")));
						
				return litigation;
			}
			
			public static WebElement clickLawyerDepartment(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']")));
						
				return litigation;
			}
			public static WebElement selectLawyerDepartment(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']/option[3]")));
						
				return litigation;
			}
			public static WebElement clickLawyerRole(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']")));
						
				return litigation;
			}
			public static WebElement selectLawyerRole(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']/option[2]")));
						
				return litigation;
			}
			public static WebElement readLawyerMsg(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_vsUserPopup']/ul/li")));
						
				return litigation;
			}
			
			
			public static WebElement saveLawyer(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_SaveLawyer']")));
						
				return litigation;
			}
			public static WebElement closeLawyer(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divUserDialog']/div/div/div[1]/button")));
						
				return litigation;
			}
			
			
			public static WebElement clickUserMaster(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[3]/a")));
				return litigation;
			}
			
			public static WebElement clickAddNewUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddUser']")));
				return litigation;
			}
			
			public static WebElement clickUserName(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstName']")));
				return litigation;
			}
			
			public static WebElement clickUserLastName(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxLastName']")));
						
				return litigation;
			}
			
			public static WebElement clickUserDesignation(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxDesignation']")));
						
				return litigation;
			}
			public static WebElement clickUserEmail(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
						
				return litigation;
			}
			public static WebElement clickUserContactNo(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
						
				return litigation;
			}
			
			public static WebElement clickUserDepartment(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']")));
						
				return litigation;
			}
			public static WebElement selectUserDepartment(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']/option[3]")));
						
				return litigation;
			}
			public static WebElement clickUserRole(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']")));
						
				return litigation;
			}
			public static WebElement selectUserRole(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']/option[2]")));
						
				return litigation;
			}
			
			public static WebElement saveUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
						
				return litigation;
			}
			public static WebElement closeUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
						
				return litigation;
			}
			public static WebElement editUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnEdit_0']/img")));
						
				return litigation;
			}
			
			public static WebElement UserAddress(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxAddress']")));
						
				return litigation;
			}
			public static WebElement UserReadMsg(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_vsUserPopup']/ul/li")));
						
				return litigation;
			}
			public static WebElement UserDeleted(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,20);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnDelete_0']/img")));
						
				return litigation;
			}
			
			
			
			public static WebElement chooseOpponentMasters(WebDriver driver)
			{
				
				litigation =driver.findElement(By.xpath("//*[@id='Mastersubmenu']/li[4]/a"));
						
				return litigation;
			}
			public static WebElement NewOpponent(WebDriver driver)
			{
				
				litigation =driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
						
				return litigation;
			}
			public static WebElement clickOpponentName(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='tbxName']"));
			    return litigation;
			}
			
			public static WebElement  opponentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rbPartyType_1']")));
				return litigation;
			}
			public static WebElement  readOppoenentMsg(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ValidationSummary1']/ul/li")));
				return litigation;
			}
			
			public static WebElement  saveOpponent(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement  closeOpponent(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement  editOpponent(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLCParty_LinkButton1_0']/img")));
				return litigation;
			}
			
			public static WebElement  clickCourtMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[5]/a")));
				return litigation;
			}
			public static WebElement  clickNewCourt(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement clickCourtName(WebDriver driver)
			{
				//WebDriverWait wait= new WebDriverWait(driver,300);
				//litigation =wait.until(ExpectedConditions.elementToBeClickable(By.id("tbxCourtName")));
			//	litigation =driver.findElement(By.id("tbxCourtName"));
				
				//WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =driver.findElement(By.xpath("//input[@name='tbxCourtName']"));
				
				
				
				return litigation;
			}
			public static WebElement  clickCourtType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlCourtType_chosen']")));
				return litigation;
			}
			
			public static WebElement  selectCourtType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlCourtType_chosen']/div/ul/li[3]")));
				return litigation;
			}
			
			public static WebElement  clickCountry(WebDriver driver)
			{
//				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =driver.findElement(By.xpath("//*[@id='ddlCountry_chosen']"));
				return litigation;
			}
			
			public static WebElement  selectCountry(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlCountry_chosen']/div/ul/li[1]")));
				return litigation;
			}
			
			
			
			public static WebElement  saveCourt(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
	
			
			
			public static WebElement  closeCourt(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			public static WebElement  editCourt(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCourtMaster_lbtcourMedit_0']/img")));
				return litigation;
			}
			public static WebElement deleteCourt(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCourtMaster_lbtcourMdelete_0']/img")));
				return litigation;
			}
			
			
			
			
			
			public static WebElement  clickCasNoticeType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[6]/a")));
				return litigation;
			}
			public static WebElement  NewCaseNoticeType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement  CaseNoticeType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='upPromotor']/div/div[2]/div/span[1]/div/button")));
				return litigation;
			}
			public static WebElement  selectCaseNoticeType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='upPromotor']/div/div[2]/div/span[1]/div/ul/li[2]/a/label/input")));
				return litigation;
			}
			
			public static WebElement  TypeName(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxCaseType']")));
				return litigation;
			}
			
			public static WebElement  saveCaseNoticeType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement  closeCaseNoticeType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement  editCaseNoticeType(WebDriver driver)
			{
				//WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdCaseType_LinkButton1_0']/img"));
				return litigation;
			}
			
			public static WebElement  deleteCaseNoticeType(WebDriver driver)
			{
				//WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdCaseType_LinkButton2_0']/img"));
				return litigation;
			}
			
			
			public static WebElement  clickPaymentTypeMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[7]/a")));
				return litigation;
			}
			
			public static WebElement  clickPaymentTypeNew(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPayment']")));
				return litigation;
			}
			public static WebElement PaymentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtFName']")));
				return litigation;
			}
			
			
			public static WebElement savePaymentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closePaymentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancelDeptPopUp']")));
				return litigation;
			}
			public static WebElement editPaymentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPayment_LinkButton1_0']/img")));
				return litigation;
			}
			public static WebElement deletePaymentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPayment_LinkButton2_0']/img")));
				return litigation;
			}
			
			
			public static WebElement customParameterMaster(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[8]/a")));
				return litigation;
			}
			public static WebElement newCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAdd']")));
				return litigation;
			}
			public static WebElement typeCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='AddCustFieldDiv']/div/div[2]/span[1]/div/button")));
				return litigation;
			}
			public static WebElement selectTypeCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='AddCustFieldDiv']/div/div[2]/span[1]/div/ul/li[2]")));
				return litigation;
			}
			
			public static WebElement ParameterLabel(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxLableName']")));
				return litigation;
			}
			public static WebElement saveCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closeCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement editCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomFieldList_lblEdit_0']/img")));
				return litigation;
			}
			public static WebElement deleteCustomParameter(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomFieldList_lblDelete_0']/img")));
				return litigation;
			}
			
			public static WebElement caseStageMaster(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[9]/a")));
				return litigation;
			}
			public static WebElement newCaseStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement clickcaseStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxcasestageType']")));
				return litigation;
			}
			public static WebElement readcaseStagemsg(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxcasestageType']")));
				return litigation;
			}
			
			
			public static WebElement savecaseStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closecaseStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement editcaseStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdcaseStageType_LinkButton1_0']/img")));
				return litigation;
			}
			
			
			public static WebElement deletecaseStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdcaseStageType_LinkButton2_0']/img")));
				return litigation;
			}
			
			
			
			public static WebElement DocumentTypeMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[10]/a")));
				return litigation;
			}
			public static WebElement NewDocumentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement clickDocumentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxDocumentType']")));
				return litigation;
			}
			public static WebElement saveDocumentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closeDocumentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			public static WebElement editDocumentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdDocType_lnkEditDocType_0']/img")));
				return litigation;
			}
			
			public static WebElement deleteDocumentType(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdDocType_lnkDeleteDocType_0']/img")));
				return litigation;
			}
			
			
			public static WebElement ratingCriteriaMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[11]/a")));
				return litigation;
			}
			public static WebElement clickcriteria(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxCriteria']")));
				return litigation;
			}
			
			public static WebElement editcriteria(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCriteriaMaster_LinkButton1_0']/img")));
				return litigation;
			}
			public static WebElement deletecriteria(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCriteriaMaster_LinkButton2_0']/img")));
				return litigation;
			}
			
			
			
			
			public static WebElement pageAuthorizationaMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[12]/a")));
				return litigation;
			}
			public static WebElement clickUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUserType_chosen']/a/span")));
				return litigation;
			}
			public static WebElement selectUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUserType_chosen']/div/ul/li[2]")));
				return litigation;
			}
			public static WebElement clickAddButton(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkADD_0']")));
				return litigation;
			}
			
			public static WebElement clickUpdateButton(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkupdate_0']")));
				return litigation;
			}
			public static WebElement clickDeleteButton(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkDelete_0']")));
				return litigation;
			}
			public static WebElement clickViewButton(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkView_0']")));
				return litigation;
			}
			public static WebElement clicksaveButton(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSavePageAutorization']")));
				return litigation;
			}
			
			public static WebElement readPageAuthoMsg(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary2']/ul/li")));
				return litigation;
			}
			
			
			public static WebElement noticeStageMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[14]/a")));
				return litigation;
			}
			public static WebElement addNoticeStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[1]/div/a")));
				return litigation;
			}
			public static WebElement clickNoticeStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[1]/input")));
				return litigation;
			}
			public static WebElement updateNoticeStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/a[1]")));
				return litigation;
			}
			public static WebElement editNoticeStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/a[1]")));
				return litigation;
			}
			public static WebElement deleteNoticeStage(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/a[2]")));
				return litigation;
			}
			
			
			public static WebElement UserReassignmentMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[15]/a")));
				return litigation;
			}
			
			public static WebElement clickUser1(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div[1]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectUser1(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlUsers_listbox']/li[1]")));
				return litigation;
			}
			public static WebElement clickAssigntoUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div[2]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectAssigntoUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlAssignUsers_listbox']/li[2]")));
				return litigation;
			}
			public static List<WebElement> selectcheckBox(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				//litigation =driver.findElement(By.xpath("//label[@class='k-checkbox-label k-no-text'])[2]"));
				elementsList =driver.findElements(By.xpath("//*[@id='gridCases']/div[2]/table/tbody/tr/td[1]"));
			     return elementsList;
        }
			

			public static WebElement clickAssignButoon(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnAssignTo']")));
				return litigation;
			}
			public static WebElement clicknotice(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tabstripAssignment']/ul/li[2]/span[2]")));
				return litigation;
			}
			
			
			public static WebElement selectNoticeCheckkBox(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridNotices']/div[2]/table/tbody/tr[1]/td[1]")));
				return litigation;
			}
			public static WebElement clickTask(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tabstripAssignment']/ul/li[3]/span[2]")));
				return litigation;
			}
			public static WebElement selectTaskCheckkBox(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridTask']/div[2]/table/tbody/tr[1]/td[1]")));
				return litigation;
			}
			public static WebElement clickAutidLog(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tabstripAssignment']/ul/li[4]/span[2]")));
				return litigation;
			}
			
			public static WebElement MailAuthorizationMasters(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[16]/a")));
				return litigation;
			}
			public static WebElement clickTypeOfUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectTypeOfUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownUserType_listbox']/li[1]")));
				return litigation;
			}
			public static WebElement clickRole(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[2]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectRole(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownRole_listbox']/li[2]")));
				return litigation;
			}
			public static WebElement clickUsers(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divusers']/div/div")));
				return litigation;
			}
			
			public static WebElement clickSearchBoxUser(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[11]/div/span/input")));
				return litigation;
			}
			
		
			public static WebElement selectUsers(WebDriver driver)
			{
		    
			  //  litigation=driver.findElement(By.xpath("//*[@id='d1930d81-019a-4612-ab86-bc6942b76687_tv_active']/div/span[2]"));
			    
			    litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[9]"));
				
				return litigation;
			}
			
	
			public static WebElement clickMailServices(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[4]/div/div/span[1]")));
				return litigation;
			}
			
			public static WebElement clickSearchBoxMail(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/span/input")));
				return litigation;
			}
			
			
			
			public static WebElement selectMailService(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-checkbox-wrapper'])[2]")));
				return litigation;
			}
			public static WebElement clickEnable(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnEnabledMail']")));
				return litigation;
			}
			public static WebElement clickExportMail(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[1]/a")));
				return litigation;
			}
			public static WebElement clickDisable(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnDisabledMail']")));
				return litigation;
			}
			
			public static WebElement clickCaseNoticeStageHearingGraph(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[2]")));
				return litigation;
			}
			public static WebElement clickCaseNoticeStageHearingExport(WebDriver driver)
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='exportReport']")));
				return litigation;
			}
			
			public static WebElement clickGridCount(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
				return litigation;
			}
			public static WebElement clickLocationFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickLocationFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]"));
				return litigation;
			}
			
			public static WebElement clickLocationFilter2(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[97]"));
				return litigation;
			}
			public static WebElement clickCaseNotice(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[2]/div/span[1]"));
				return litigation;
			}
			
			public static WebElement selectCaseNotice(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//div[@class='k-check-all'])[7]"));
				return litigation;
			}
			
			public static WebElement clickStatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[3]/div"));
				return litigation;
			}
			public static WebElement selectStatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[181]"));
				return litigation;
			}
			
			
			public static WebElement clickDepartmentFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[4]/div"));
				return litigation;
			}
			
			public static WebElement selectDepartmentFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[50]"));
				return litigation;
			}
			public static WebElement selectDepartmentFilter1(WebDriver driver)
			{

				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[56]"));
				return litigation;
			}
			public static WebElement clickRiskFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[6]/div"));
				return litigation;
			}
			public static WebElement selectRiskFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[185]"));
				return litigation;
			}
			public static WebElement clickAgeFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/span/span/span[1]"));
				return litigation;
			}
			public static WebElement selectAgeFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='drpAgeing_listbox']/li[1]"));
				return litigation;
			}
			public static WebElement clickCategoryFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[2]/div[1]/div"));
				return litigation;
			}
			public static WebElement selectCategoryFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[3]"));
				return litigation;
			}
			public static WebElement selectCategoryFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[5]"));
				return litigation;
			}
			
			
			public static WebElement clickStageFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[2]/div[2]/div"));
				return litigation;
			}
			public static WebElement selectStageFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[39]"));
				return litigation;
			}
			
			public static WebElement selectNotice1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[183]"));
				return litigation;
			}
			public static WebElement clickCaseNoticeType1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[5]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectCaseNoticeType1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[29]"));
				return litigation;
			}
			
			
        	public static WebElement clearButton(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
				return litigation;
			}
			
			
			public static WebElement CaseHearingCount(WebDriver driver) 
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_divPendingHearing']")));
				return litigation;
			}
			public static WebElement CaseHearingGridCount(WebDriver driver) 
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridPendingUpdation']/div[3]/span[2]")));
				return litigation;
			}
			public static WebElement CaseHearingExport(WebDriver driver) 
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnexport']")));
				return litigation;
			}
			public static WebElement CaseHearingView(WebDriver driver) 
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridPendingUpdation']/div[2]/table/tbody/tr[1]/td[7]/a")));
				return litigation;
			}
			public static WebElement CaseHearingPopupClose(WebDriver driver) 
			{
				WebDriverWait wait= new WebDriverWait(driver,30);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")));
				return litigation;
			}
			
			
			public static WebElement HearingCalender(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[3]/div[13]/a")));
				return litigation;
			}
			public static WebElement HearingCalenderNum(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[3]/div[13]/span")));
				return litigation;
			}
			
			public static WebElement HearingCalenderCount(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/span[2]")));
				return litigation;
			}
			
			
			public static WebElement HearingCalenderView(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[5]/a")));
				return litigation;
			}
			
			
			public static WebElement HearingCalenderExport(WebDriver driver)
			{
				//WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=driver.findElement(By.xpath("//*[@id='exportReport']/span"));
				return litigation;
			}
			public static WebElement HearingCalenderclose(WebDriver driver)
			{
				//WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=driver.findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button"));
				return litigation;
			}
			
			public static WebElement CaseNoticeTypeViewGraph(WebDriver driver)
			{
				//WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[13]/a"));
				return litigation;
			}
			public static WebElement CaseNoticeTypeclosePopupGraph(WebDriver driver)
			{
				//WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=driver.findElement(By.xpath("//*[@id='btnAddEditcase']"));
				return litigation;
			}
			
			public static WebElement viewNoticeDetails1(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver,30);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]")));
	            return litigation;
			}
			public static WebElement viewNoticeDetails(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a[2]"));
				return litigation;
			}
			public static WebElement viewTaskDetails(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
				return litigation;
			}
			public static WebElement Actionclosepopup(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='btnAddEditcase1']"));
				return litigation;
			}
			public static WebElement Actionclosepopup1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='btnAddEditcase']"));
				return litigation;
			}
			
			public static WebElement ActioncloseTaskpopup(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button"));
				return litigation;
			}
			public static WebElement showResponseDetailIcon(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a[1]"));
				return litigation;
			}
			
			public static WebElement showResponseDetailIcon1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]"));
				return litigation;
			}
			public static WebElement clickEditReminder(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a[1]"));
				return litigation;
			}
			public static WebElement clickDeleteReminder(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a[2]"));
				return litigation;
			}
			
			public static WebElement clickCaseNotice1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='linoticeCase']/a"));
				return litigation;
			}
			
			public static WebElement clicklocationFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement clicklocationFilter2(WebDriver driver)
			{
				 WebDriverWait wait = new WebDriverWait(driver, 300);
				  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[242]")));
				return litigation;
			}
			public static WebElement clickDepartmentFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/div[2]/div"));
				return litigation;
			}
			public static WebElement clickDepartmentFilter2(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[387]"));
				return litigation;
			}
			public static WebElement clickFinancialYear2(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/span[2]/span/span[1]"));
				return litigation;
			}
			
			public static WebElement clickFinancialYear3(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownFY_listbox']/li[2]"));
				return litigation;
			}
			
			public static WebElement clickCalenderYear2(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/span[3]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickCalenderYear3(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownCalYear_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickstatus(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/span/span/span[1]"));
				return litigation;
			}
			
			public static WebElement clickstatus1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownStatus_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickcategory(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[3]"));
				return litigation;
			}
			public static WebElement clickcategory1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[96]"));
				return litigation;
			}
			public static WebElement clickType1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[2]/div"));
				return litigation;
			}
			public static WebElement clicktype1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[461]"));
				return litigation;
			}
			public static WebElement clickeditButton(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td[18]/a[1]"));
				return litigation;
			}
			public static WebElement clickdeleteButton(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td[18]/a[2]"));
				return litigation;
			}
			public static WebElement viewTaskDetails1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[9]/a"));
				return litigation;
			}
			public static WebElement clickDropdown(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/span[1]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickCaseHearing1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='liHearing']/a"));
				return litigation;
			}
			public static WebElement clickSearchFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='txtSearch']"));
				return litigation;
			}
			
			public static WebElement clickTaskLocFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[1]/div"));
				return litigation;
			}
			public static WebElement clickTaskLocFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[5]"));
				return litigation;
			}
			
			public static WebElement clickTaskPriorityFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[2]/div"));
				return litigation;
			}
			
			public static WebElement clickTaskPriorityFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[32]"));
				return litigation;
			}
			public static WebElement clickTaskStatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[3]/div"));
				return litigation;
			}
			public static WebElement clickTaskStatusFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[35]"));
				return litigation;
			}
			public static WebElement clickTaskPeriodFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/span/span/span[1]"));
				return litigation;
			}
			public static WebElement clickTaskPeriodFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickDocStatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[2]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickDocStatusFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownlist2_listbox']/li[3]"));
				return litigation;
			}
			public static WebElement clickDocTypeFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/div[1]/div"));
				return litigation;
			}
			public static WebElement clickDocTypeFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[1]"));
				return litigation;
			}
			public static WebElement clickDocLocFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickDocLocFilter2(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[23]"));
				return litigation;
			}
			public static WebElement clickDocDeptFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/div[4]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickDocDeptFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[84]"));
				return litigation;
			}
			
			public static WebElement clickDocDropdownFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[1]/span/span[1]"));
				return litigation;
			}
			
			public static WebElement clickDocTaskFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[3]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickDocTaskFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownTaskType_listbox']/li[4]"));
				return litigation;
			}
			public static WebElement clickDocTaskPriorityFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/div[2]/div"));
				return litigation;
			}
			public static WebElement clickDocTaskPriorityFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[158]"));
				return litigation;
			}
			
			public static WebElement clickReportStatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/span[2]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickReportStatusFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//ul[@id='dropdownStatus_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickReportDeptFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickReportDeptFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[387]"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[2]/div"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[461]"));
				return litigation;
			}
			public static WebElement clickReportCategoryFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickReportCategoryFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[96]"));
				return litigation;
			}
			public static WebElement clickReportLocFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[4]/div/div"));
				return litigation;
			}
			public static WebElement clickReportLocFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[242]"));
				return litigation;
			}
			public static WebElement clickReportFYFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[4]/span[1]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickReportFYFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownFY_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickReportCYFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div/div[4]/span[2]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickReportCYFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownCalYear_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickReportprioFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[2]/div"));
				return litigation;
			}
			public static WebElement clickReportprioFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[4]"));
				return litigation;
			}
			public static WebElement clickReportstatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickReportstatusFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//span[@class='k-checkbox-label checkbox-span']"));
				return litigation;
			}
			public static WebElement clickReportFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='childrow']/div/div[3]/span/span/span[1]"));
				return litigation;
			}
			public static WebElement clickReportFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardLocFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
				return litigation;
			}
			public static WebElement clickDashboardLocFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt10']"));
				return litigation;
			}
			public static WebElement clickDashboardCaseNoticeFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTypePage_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardCaseNoticeFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTypePage_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardTypeFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNoticeTypePage_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardTypeFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNoticeTypePage_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardDeptFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDeptPage_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardDeptFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDeptPage_chosen']/div/ul/li[4]"));
				return litigation;
			}
			public static WebElement clickDashboardstatusFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlStatus_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardstatusFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlStatus_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardRiskFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlWinningImpact_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardRiskFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlWinningImpact_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardApplyBtn(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnFilter']"));
				return litigation;
			}
			
			public static WebElement clickDashboardClearBtn(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnClearFilter']"));
				return litigation;
			}
			
			public static WebElement clickLegalEntityFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']"));
				return litigation;
			}
			public static WebElement clickLawFirmFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxtypeTofilter']"));
				return litigation;
			}
			
			public static WebElement clickApplybtn(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnApplyFilter']"));
				return litigation;
			}
			public static WebElement clickCustomParameterFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlType_chosen']/a/span"));
				return litigation;
			}
			
			public static WebElement clickCustomParameterFilter1(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlType_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickNoticeStageFilter(WebDriver driver)
			{
				litigation=driver.findElement(By.xpath("//*[@id='txtSearch']"));
				return litigation;
			}
			
}

			




		  
