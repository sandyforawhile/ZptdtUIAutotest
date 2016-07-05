package com.g7s.zptdt.action;

import org.openqa.selenium.WebElement;

import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.LogoutPageAdaptor;

public class Logout{

	public static final Logout LogoutInstant = new Logout();
	private  Logout() {
	}
	
	public void logout( ) throws InterruptedException{
		BrowserElemtHandler.WaitForSec(4);
		WebElement webElement  = null;
		webElement  = BrowserElemtHandler.findElementtobeclickable("xpath", LogoutPageAdaptor.LOGOUT_BUTTON);
		webElement.click();
		BrowserElemtHandler.WaitForSec(2);
		
//		driver.switchToActiveElement();
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath",LogoutPageAdaptor.LOGOUT_BUTTON_ACCEPT);
		webElement.click();
		BrowserElemtHandler.WaitForSec(2);
	}
}

