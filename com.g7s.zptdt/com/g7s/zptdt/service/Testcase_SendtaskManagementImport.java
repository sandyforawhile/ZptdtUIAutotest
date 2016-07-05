package com.g7s.zptdt.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.SendtaskPageAdaptor;
import com.g7s.zptdt.utils.ExcelUtil;

import jxl.JXLException;
import jxl.read.biff.BiffException;

public class Testcase_SendtaskManagementImport extends BaseTask{
  @Test
  public void Test01_ImportPostman() throws InterruptedException, BiffException, IOException {
	  WebElement webElement  = null;
	  
	  //Click_Import
	  BrowserElemtHandler.switchToFrame();
	  BrowserElemtHandler.WaitForSec(5);
	  webElement = BrowserElemtHandler.findElement("xpath", SendtaskPageAdaptor.SENDTASK_IMPORT_IMPORT);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	  
	  //UpLoadFile
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrameByXpath(SendtaskPageAdaptor.SENDTASK_IMPORT_NEXTSTEP);
	  webElement = BrowserElemtHandler.findElement("xpath", SendtaskPageAdaptor.SENDTASK_IMPORT_UPLOADFILE);
	  String filepath = System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"sendtask.xls";
	  webElement.sendKeys(filepath);
	  BrowserElemtHandler.WaitForSec(3);
	  
	  //Save
	  webElement = BrowserElemtHandler.findElement("xpath", SendtaskPageAdaptor.SENDTASK_IMPORT_NEXTSTEP);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);  
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElement("xpath", SendtaskPageAdaptor.SENDTASK_IMPORT_SUBMIT);
	  webElement.click();  
	  BrowserElemtHandler.WaitForSec(15);
	  
	  //Assert_Tips
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrameByXpath(SendtaskPageAdaptor.SENDTASK_IMPORT_RETURN);
	  webElement = BrowserElemtHandler.findElementtobevisible("xpath",SendtaskPageAdaptor.SENDTASK_IMPORT_ASSERT);
	  String Iresult = webElement.getText();
	  boolean success = false;
	  if(Iresult.contains("数据导入成功"))
	  {
		  success = true;
	  }
	  AssertJUnit.assertTrue(success);
	  
	  //ReturnToManagementPage
	  webElement = BrowserElemtHandler.findElementtobevisible("xpath",SendtaskPageAdaptor.SENDTASK_IMPORT_RETURN);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrame();
	  
	  String filepath1=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"sendtask.xls";
	  Object[][] data = ExcelUtil.getData(filepath1, "sendtask"); 
	  
		 //Assert_Data
		 String xpath = null,Lresult = null;
		 for(int i =1; i<=data.length; i++)
		 {
				 success = false;
				 ArrayList<Object>list = ExcelUtil.getColumn(filepath1, "sendtask", 0);
				 xpath = "//table[@id='tblMain']/tbody/tr["+i+"]/td[4]";
				 Lresult = BrowserElemtHandler.findElementtobevisible("xpath",xpath).getText();
				 if (list.contains(Lresult))
					 {
						success = true;
					 }
				 AssertJUnit.assertTrue(success);
		 }
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException, JXLException, IOException {
  	
	      //DataCreator
	  	 ArrayList<String>list=new ArrayList<String>();
	 	 SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 java.util.Date currenttime = new java.util.Date();
		 String date = df.format(currenttime);
	  	 for(int i =0; i <4; i++){
	  		 list.add(date);
	  	 }
	  	 
	  	String filepath=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"sendtask.xls";
	  	ExcelUtil.setColumn(filepath, "sendtask", 1, list);
	  	 
	  	 NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
  		 NavigateTo.PostmanmanagementPageInstant.navigatetoSendtaskmanagementPage();
  	     BrowserElemtHandler.WaitForSec(2);
  }
  
  @AfterClass
  public void afterClass() throws InterruptedException, BiffException, IOException {
	  

	   //读取Excel数据
		String filepath=System.getProperty("user.dir")+File.separator+"DataFeeder"+File.separator+"sendtask.xls";
		Object[][] data = ExcelUtil.getData(filepath, "sendtask");
		
		//刪除数据
	    for(int i =0 ;i < data.length;i++)
	    {
	    	String taskcode = data[i][0].toString();
			ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
			zptexe.executeDelete("zpt_send_task", "taskcode='"+taskcode+"'");
	    }
		System.out.println("删除语句成功！");
  }
  
  }
  

