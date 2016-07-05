package com.g7s.zptdt.service;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.PostmanPageAdaptor;
import com.g7s.zptdt.utils.ExcelUtil;

import jxl.read.biff.BiffException;

public class Testcase_PostmanManagementUpdate extends BaseTask {
	
  @Test(dataProvider = "editpostman")
  public void Test01_EditUsedPostman(String postmanname, String postmanorg) throws InterruptedException, BiffException, IOException {
	  
	  WebElement webElement  = null;
	  
	 //Select
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.POSTMANEDIT_CHECKBOX);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(2);
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.POSTMANEDIT_BUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(2);
	  
	  //Edit
	  //EditName
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrameByXpath(PostmanPageAdaptor.POSTMANNAMEADD_TEXTBOX);
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.POSTMANNAMEADD_TEXTBOX);
	  webElement.clear();
	  webElement.sendKeys(postmanname);
	  //EditOrg
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGEDIT_LINK);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(2);
      webElement = BrowserElemtHandler.findElementtobeclickable("css", PostmanPageAdaptor.POSTMANORGADD_TEXTBOX);
      webElement.click();
      webElement.sendKeys(postmanorg);
      BrowserElemtHandler.WaitForSec(2);
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LI);
	  BrowserElemtHandler.WaitForSec(2);
	  webElement.click();
	  
	  //Save
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANEDIT_SAVEBUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(6);
	 
	 //Assert
	 BrowserElemtHandler.switchToDefaultContent();
	 BrowserElemtHandler.switchToFrame();
	 String xpath = null,Lresult = null;
	 for(int i =0; i<3; i++)
	 {
		 xpath = "//table[@id='tblMain']/tbody/tr[1]/td["+(i+3)+"]";
		 Lresult = BrowserElemtHandler.findElementtobevisible("xpath",xpath).getText();
		switch(i)
		{
			case 0:
				AssertJUnit.assertEquals(postmanname, Lresult);
				break;
			case 1:
				AssertJUnit.assertEquals(postmanorg, Lresult);
				break;
		}
	 }
	 
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	  WebElement webElement  = null;

	  NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
	  NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
	  BrowserElemtHandler.WaitForSec(5);
	  
	  //Click_Add
	  BrowserElemtHandler.switchToFrame();
	  webElement=BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.ADD_POSTMAN);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	   
	  //FillinName
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrameByXpath(PostmanPageAdaptor.POSTMANNAMEADD_TEXTBOX);
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.POSTMANNAMEADD_TEXTBOX);
	  webElement.click();
	  webElement.sendKeys("测试司机");
	  //FillinOrg
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LINK);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(2);
      webElement = BrowserElemtHandler.findElementtobeclickable("css", PostmanPageAdaptor.POSTMANORGADD_TEXTBOX);
      webElement.click();
      webElement.sendKeys("zpttest");
      BrowserElemtHandler.WaitForSec(2);
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LI);
	  BrowserElemtHandler.WaitForSec(2);
	  webElement.click();
      //FillinPhone
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANPHONEADD_TEXTBOX);
	  webElement.click();
	  webElement.sendKeys("13433333334");
	  
	  //Save
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.ADD_BUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(6);
  }

   @AfterClass
   public void afterClass() throws InterruptedException {

		 ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		 zptexe.executeDelete("zpt_postman", "postmanname='测试测试司机'");
		 zptexe.executeDelete("zpt_postman", "postmanname='测试司机'");
		 System.out.println("删除语句成功！");
  }

 @DataProvider(name="editpostman")
 public Object[][] edit() throws BiffException, IOException
	{
		String filepath=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"DataFeeder.xls";
		return ExcelUtil.getData(filepath, "editpostman");
	}
 
//@DataProvider(name="addpostman")
//public Object[][] add() throws BiffException, IOException
//{
//	String filepath=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"DataFeeder.xls";
//	return ExcelUtil.getData(filepath, "addpostman");
//}
}
