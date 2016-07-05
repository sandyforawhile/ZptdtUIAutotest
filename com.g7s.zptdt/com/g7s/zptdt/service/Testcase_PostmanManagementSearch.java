package com.g7s.zptdt.service;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.PostmanPageAdaptor;

public class Testcase_PostmanManagementSearch extends BaseTask {
	
  @Test
  public void Test01_SearchByPostmanname() throws Exception{	  
		  
		  WebElement webElement  = null;
	  
		  //FillinSearchName
		  BrowserElemtHandler.switchToFrame();
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.NAMESEARCH_TEXTBOX);
		  webElement.click();
		  webElement.sendKeys("测试司机");
		  //click_Search
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.SEARCH_BUTTON);
		  webElement.click();
		  BrowserElemtHandler.WaitForSec(4);
		  
		  //Assert
		  String result = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.SEARCH_NAME_RESULT).getText();  
		  AssertJUnit.assertEquals("测试司机", result);
		  
		  //ClearSearchName
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.NAMESEARCH_TEXTBOX);
		  webElement.clear();
		  //click_Search
		  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.SEARCH_BUTTON);
		  webElement.click();
		  
		  BrowserElemtHandler.WaitForSec(4);
  }
  
  @Test
  public void Test02_SearchByPhone() throws Exception{
	  
	  WebElement webElement  = null;
	  
	  //FillinSearchPhone
	  webElement  = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.PHONESEARCH_TEXTBOX);
	  webElement.click();
	  webElement.sendKeys("13433333333");
	  //Click_Search
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.SEARCH_BUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(4);
	  
	  //Assert
	  String result = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.SEARCH_PHONE_RESULT).getText();    
	  AssertJUnit.assertEquals("13433333333", result);
	  
	  //ClearSearchPhone
	  webElement  = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.PHONESEARCH_TEXTBOX);
	  webElement.clear();
	  //Click_Search
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.SEARCH_BUTTON);
	  webElement.click();
	  
	  BrowserElemtHandler.WaitForSec(4);
  }
  
  @Test
  public void Test03_SearchByOrg() throws InterruptedException{
	  
	  WebElement webElement  = null;
	  
	  //FillinSearchOrg
	  webElement  = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.ORGSEARCH_LINK);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(2);
	  webElement  = BrowserElemtHandler.findElementtobeclickable("css",PostmanPageAdaptor.ORGSEARCH_TEXTBOX);
	  webElement.click();
	  webElement.sendKeys("zpttest");
      BrowserElemtHandler.WaitForSec(2);
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGSEARCH_LI);
	  BrowserElemtHandler.WaitForSec(2);
	  webElement.click();
	  //Click_Search
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.SEARCH_BUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(4);
	  
	  //Assert
	  String result = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.SEARCH_ORG_RESULT).getText();    
	  AssertJUnit.assertEquals("zpttest", result);
	  
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		Map<String ,Object> map = new HashMap<String,Object>();
		map.put("orgroot","2000KL");
		map.put("orgcode", "2000KL");
		map.put("postmanname", "测试司机");
		map.put("phone","13433333333");
		map.put("passwd","13433333333");
		zptexe.executeAdd("zpt_postman", map);
		System.out.println("插入语句成功！");
		
		  NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
		  NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
		  BrowserElemtHandler.WaitForSec(2);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  
		BrowserElemtHandler.WaitForSec(2);
		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		zptexe.executeDelete("zpt_postman", "postmanname='测试司机'");
		System.out.println("删除语句成功！");
  }
}
