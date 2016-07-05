package com.g7s.zptdt.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.PostmanPageAdaptor;
import com.g7s.zptdt.utils.ExcelUtil;

import jxl.read.biff.BiffException;

public class Testcase_PostmanManagementImport extends BaseTask {

@Test
  public void Test01_ImportPostman() throws InterruptedException, BiffException, IOException{
	  
	  WebElement webElement  = null;
	  
	  //Click_Import
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.IMPORT_POSTMAN);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	  
	  //UploadFile
	  BrowserElemtHandler.switchToDefaultContent();
	  //BrowserElemtHandler.switchToFrame();
	  BrowserElemtHandler.switchToFrameByXpath(PostmanPageAdaptor.POSTMANIMPORT_NEXTBUTTON);
	  webElement = BrowserElemtHandler.findElement("xpath", PostmanPageAdaptor.POSTMANIMPORT_TEXTBOX);
	  String filepath = System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"postman.xls";
	  webElement.sendKeys(filepath);
	  BrowserElemtHandler.WaitForSec(3);
	  
	  //Save
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANIMPORT_NEXTBUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);  
	  BrowserElemtHandler.switchToDefaultContent();
	  //BrowserElemtHandler.switchToFrameByXpath(PostmanPageAdaptor.POSTMANIMPORT_CONFIRMBUTTON);
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElement("xpath", PostmanPageAdaptor.POSTMANIMPORT_CONFIRMBUTTON);
	  webElement.click();  
	  BrowserElemtHandler.WaitForSec(5);
	  
	  //Assert_Tips
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElementtobevisible("xpath",PostmanPageAdaptor.POSTMANIMPORT_RESULT);
	  String Iresult = webElement.getText();
	  boolean success = false;
	  if(Iresult.contains("成功导入10条"))
	  {
		  success = true;
	  }
	  AssertJUnit.assertTrue(success);
	  
	  //ReturnToManagementPage
	  webElement = BrowserElemtHandler.findElementtobevisible("xpath",PostmanPageAdaptor.POSTMANIMPORT_RETURNBUTTON);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrame();
	  
	  //ReadFile
	 String filepath1=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"postman.xls";
	 Object[][] data = ExcelUtil.getData(filepath1, "postman"); 
	 
	 //Assert_Data
	 String xpath = null,Lresult = null;
	 for(int i =1; i<=data.length; i++)
	 {
		 for(int j=0; j<3; j++)
		 {
			 success = false;
			 ArrayList<Object>list = ExcelUtil.getColumn(filepath1, "postman", j);
			 xpath = "//table[@id='tblMain']/tbody/tr["+i+"]/td["+(j+3)+"]";
			 Lresult = BrowserElemtHandler.findElementtobevisible("xpath",xpath).getText();
			 if (list.contains(Lresult))
				 {
					success = true;
				 }
			 AssertJUnit.assertTrue(success);
		 }
	 }
	  

  }
  
@BeforeClass
public void beforeClass() throws InterruptedException {
	
	      NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
		  NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
		  BrowserElemtHandler.WaitForSec(2);
}
  
  @AfterClass
  public void afterClass() throws  InterruptedException, BiffException, IOException {
	  
	   //读取Excel数据
		String filepath=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"postman.xls";
		Object[][] data = ExcelUtil.getData(filepath, "postman");
		
		//刪除数据
	    for(int i =0 ;i < data.length;i++)
	    {
	    	String postmanname = data[i][0].toString();
			ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
			zptexe.executeDelete("zpt_postman", "postmanname='"+postmanname+"'");
	    }
		System.out.println("删除语句成功！");
  }
}
