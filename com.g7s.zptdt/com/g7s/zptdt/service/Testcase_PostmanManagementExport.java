package com.g7s.zptdt.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.Logout;
import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.PostmanPageAdaptor;
import com.g7s.zptdt.utils.ExcelUtil;

import jxl.read.biff.BiffException;

public class Testcase_PostmanManagementExport extends BaseTask{
	
  @Test
  public void Test01_ExportPostman() throws InterruptedException, BiffException, IOException {
	  
  	  WebElement webElement  = null;
  	  
	  //Click_Export
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.EXPORT_POSTMAN);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	  
	  //Click_Download
	  BrowserElemtHandler.switchToActiveFrame();
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",PostmanPageAdaptor.POSTMANEXPORT_DOWNLOAD);
	  webElement.click();
	  BrowserElemtHandler.WaitForSec(5);
	  
	  //ReadFile
	  String filepath1="E:\\download";
	  
	  
	  //Recall
	  File dictionary = new File(filepath1);	
	  List<File> fileList = Arrays.asList(dictionary.listFiles());	  
	  Collections.sort(fileList,new Comparator<File>() {
		public int compare(File f1, File f2) {
			return  f1.lastModified() >= f2.lastModified() ? 1 :-1 ;
		}
	});
	  String filepath = fileList.get(0).getAbsolutePath();
      
 	 //Assert_Data
     boolean success = false;
 	 String xpath = null,Lresult = null;
 	 for(int i =1; i<=10; i++)
 	 {
 		 for(int j=0; j<3; j++)
 		 {
 			 success = false; 			 
 			 ArrayList<Object>list = ExcelUtil.getColumn(filepath, "Worksheet", j);
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
  	
		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		Map<String ,Object> map = new HashMap<String,Object>();
	    
		for(int i =0 ; i<10; i++){
			int rand = (int) (Math.random() *100);
			long currentTime=System.currentTimeMillis();
			map.put("id", currentTime+rand);
			map.put("orgcode","2000KL");
			map.put("orgroot", "2000KL");
			map.put("postmanname", "捧"+i);
			map.put("phone","13433333333");
			zptexe.executeAdd("zpt_postman", map);
	}
		System.out.println("插入语句成功！");
		
		  NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
  		  NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
  		  BrowserElemtHandler.WaitForSec(2);
  }
  
 @AfterClass
 public void afterClass() throws InterruptedException {
	 
	  //Logout
	  BrowserElemtHandler.switchToParentFrame();
	  Logout.LogoutInstant.logout();
	  BrowserElemtHandler.WaitForSec(2);
	  
		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		zptexe.executeDelete("zpt_postman", "postmanname LIKE '%捧%'");
		System.out.println("删除语句成功！");
 }
}
