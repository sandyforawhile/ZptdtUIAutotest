package com.g7s.zptdt.service;

import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dto.BrowserElemtHandler;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Testcase_PostmanManagementLocate extends BaseTask{
	
  @Test
  public void Test01_LocatePostman()  {
	  
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	  NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
	  NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
	  BrowserElemtHandler.WaitForSec(5);
	  
  }

  @AfterClass
  public void afterClass() {
	  
  }

}
