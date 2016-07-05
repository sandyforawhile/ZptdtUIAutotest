package com.g7s.zptdt.service;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.g7s.zptdt.action.Login;
import com.g7s.zptdt.action.Logout;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.utils.PropUtil;

import jxl.read.biff.BiffException;


public class BaseTask {

	  WebDriver mydriver = null;
	  
	  @BeforeSuite
	  public void beforeSuite() throws InterruptedException {
		  
		  //initialize browser
		  Properties np=PropUtil.PropLoader("/com/g7s/zptdt/conf/EnvInitialization.properties");
		  String BROWSER=np.getProperty("envinitialzation.optional.browser");	  
		  String BASEURL=np.getProperty("envinitialization.optional.baseurl");
				  
			switch(BROWSER.toLowerCase())
			{
			case"chrome":
				System.setProperty("webdriver.chrome.driver",
						"E:\\Users11\\Haonina\\workspace\\G7s_Zptdt_AutoTest\\testTools\\chromedriver.exe");
				mydriver = new ChromeDriver();
				break ;
				
			case"ie":
				System.setProperty("webdriver.ie.driver",
						"E:\\Users11\\Haonina\\workspace\\G7s_Zptdt_AutoTest\\testTools\\IEDriverServer.exe");
				mydriver = new InternetExplorerDriver();
				break ;
				
			default:
				System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				ProfilesIni ffpi = new ProfilesIni();
				FirefoxProfile profile = ffpi.getProfile("default");
				mydriver = new FirefoxDriver(profile);
			    break ;
			}
			
			BrowserElemtHandler.setDriver(mydriver);
			BrowserElemtHandler.get(BASEURL);
			BrowserElemtHandler.implicitlyWait(6);
			BrowserElemtHandler.windowmaxmize();
			BrowserElemtHandler.switchToDefaultContent();
			
			//Login
	  		  Login.LoginInstant.login();
	  		  BrowserElemtHandler.WaitForSec(5);
	  }	
	  
	  @AfterSuite
	  public void afterSuite() throws IOException, BiffException, InterruptedException{           
		  
		  //Logout
		  BrowserElemtHandler.switchToParentFrame();
		  Logout.LogoutInstant.logout();
		  BrowserElemtHandler.WaitForSec(2);
		  
		  BrowserElemtHandler.quit();
	  }
}
