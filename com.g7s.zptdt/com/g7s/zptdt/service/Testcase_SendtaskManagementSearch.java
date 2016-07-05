package com.g7s.zptdt.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.action.TimePicker;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.SendtaskPageAdaptor;

public class Testcase_SendtaskManagementSearch extends BaseTask{
	
  @Test
  public void Test01_SearchByTasktime() throws InterruptedException {
	  
	  WebElement webElement  = null;
	  BrowserElemtHandler.switchToFrame();
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath",SendtaskPageAdaptor.SENDTASK_SEARCH_TIMEPICKER);
	  webElement.click();
	  TimePicker.tpInstant.timeSelect(-3, 3);
	  BrowserElemtHandler.WaitForSec(5);
	  BrowserElemtHandler.switchToDefaultContent();
	  BrowserElemtHandler.switchToFrame();
	  webElement=BrowserElemtHandler.findElementtobeclickable("xpath", SendtaskPageAdaptor.SENDTASK_SEARCH_BUTTON);
	  webElement.click();
	  
	  //TODO:assert
  }
  
  @Test
  public void Test02_SearchByPostman() throws InterruptedException {
	  
	  WebElement webElement = null;
	  //BrowserElemtHandler.switchToFrame();
	  
	  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", SendtaskPageAdaptor.SENDTASK_SEARCH_POSTMANNAME);
	  webElement.click();
	  webElement.sendKeys("大圣");
	  webElement=BrowserElemtHandler.findElementtobeclickable("xpath", SendtaskPageAdaptor.SENDTASK_SEARCH_BUTTON);
	  webElement.click();
	  
	//TODO:assert
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		Map<String ,Object> map = new HashMap<String,Object>();
		
	 	 SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 java.util.Date currenttime = new java.util.Date();
		 String date = df.format(currenttime);
		 
		for(int i =0 ; i<3; i++){
			int rand = (int) (Math.random() *100);
			long currentTime=System.currentTimeMillis();
			map.put("id", currentTime+rand);
			map.put("orgroot", "2000KL");
			map.put("orgcode","2000KL");
			map.put("tasktime", date);
			map.put("taskcode", "2016CD100"+i);
			map.put("ordercode","2016CD100"+i);
			map.put("ordtoname", "谢依依");			
			map.put("ordtotel", "13400013333");
			map.put("ordtoaddr", "四川成都武侯区红牌楼广场");
			map.put("statuslog", -1);
			map.put("postmanname", "大圣");
			zptexe.executeAdd("zpt_send_task", map);
	}
		
		NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
		NavigateTo.PostmanmanagementPageInstant.navigatetoSendtaskmanagementPage();
	    BrowserElemtHandler.WaitForSec(2);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  		
		BrowserElemtHandler.WaitForSec(2);
		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
		zptexe.executeDelete("zpt_send_task", "ordtoname='谢依依'");
		System.out.println("删除语句成功！");
		
  }
}
