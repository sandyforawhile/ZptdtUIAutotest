package com.g7s.zptdt.action;

import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.MenuAdaptor;
import com.g7s.zptdt.utils.PropUtil;

public class NavigateTo {

		public static final NavigateTo PostmanmanagementPageInstant = 
				new NavigateTo();
		private  NavigateTo() {
	}
		
		public void navigatetoHomepage() throws InterruptedException{
			
			Properties np=PropUtil.PropLoader("/com/g7s/zptdt/conf/EnvInitialization.properties");
			String BASEURL=np.getProperty("envinitialization.optional.baseurl");
			BrowserElemtHandler.get(BASEURL);
		}
		
		public void navigatetoPostmanmanagementPage() throws InterruptedException{
			
			  WebElement webElement  = null;
			  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", MenuAdaptor.ZPTPBASEURL);
			  webElement.click();
			  BrowserElemtHandler.WaitForSec(3);

			  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", MenuAdaptor.ZPTPOSTMANSUPERURL);
			  webElement.click();
			  BrowserElemtHandler.WaitForSec(2);

			  webElement =BrowserElemtHandler.findElementtobeclickable("xpath", MenuAdaptor.ZPTPOSTMANSUBURL);
			  webElement.click();
		}
		
		public void navigatetoSendtaskmanagementPage() throws InterruptedException{
			
			  WebElement webElement  = null;
			  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", MenuAdaptor.ZPTPBASEURL);
			  webElement.click();
			  BrowserElemtHandler.WaitForSec(3);

			  webElement = BrowserElemtHandler.findElementtobeclickable("xpath", MenuAdaptor.ZPTSENDTASKSUBURL);
			  webElement.click();
			  BrowserElemtHandler.WaitForSec(2);

		}
}
