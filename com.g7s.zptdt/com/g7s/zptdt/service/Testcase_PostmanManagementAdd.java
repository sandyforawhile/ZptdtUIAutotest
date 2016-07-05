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

public class Testcase_PostmanManagementAdd extends BaseTask{
	
  @Test(dataProvider = "addpostman")
  public void Test01_AddPostman(String postmanname, String postmanorg, String postmanphone) throws InterruptedException {

	  	  WebElement webElement  = null;
	  	  
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
		  webElement.sendKeys(postmanname);
		  //FillinOrg
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LINK);
		  webElement.click();
		  BrowserElemtHandler.WaitForSec(2);
	      webElement = BrowserElemtHandler.findElementtobeclickable("css", PostmanPageAdaptor.POSTMANORGADD_TEXTBOX);
	      webElement.click();
	      webElement.sendKeys(postmanorg);
	      BrowserElemtHandler.WaitForSec(2);
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LI);
		  BrowserElemtHandler.WaitForSec(2);
		  webElement.click();
	      //FillinPhone
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANPHONEADD_TEXTBOX);
		  webElement.click();
		  webElement.sendKeys(postmanphone);
		  
		  //Save
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.ADD_BUTTON);
		  webElement.click();
		  BrowserElemtHandler.WaitForSec(6);
		  
		  //Assert
		  BrowserElemtHandler.switchToDefaultContent();
		  BrowserElemtHandler.switchToFrame();
		  String result = BrowserElemtHandler.findElementtobevisible("xpath",PostmanPageAdaptor.SEARCH_NAME_RESULT).getText();  
		  AssertJUnit.assertEquals("测试司机", result);
		  
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	      NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
  		  NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
  		  BrowserElemtHandler.WaitForSec(2);
  }

	  @AfterClass
	  public void afterClass() throws InterruptedException {
		  
			ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
			zptexe.executeDelete("zpt_postman", "postmanname='测试司机'");
			System.out.println("删除语句成功！");
	  }
  
	@DataProvider(name="addpostman")
	public Object[][] getCreate() throws BiffException, IOException
	{
		String filepath=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"DataFeeder.xls";
		return ExcelUtil.getData(filepath, "addpostman");
	}
}
