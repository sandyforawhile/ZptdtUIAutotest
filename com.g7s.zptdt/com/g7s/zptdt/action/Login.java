package com.g7s.zptdt.action;

import org.openqa.selenium.WebElement;

import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.LoginPageAdaptor;

public class Login{
	
	public static final Login LoginInstant = new Login();
	private  Login() {
	}
	
	public void login(){
		WebElement webElement  = null;
		webElement = BrowserElemtHandler.findElementtobeclickable("id", LoginPageAdaptor.USERNAME_TEXTBOX);
		webElement.click();
		webElement.sendKeys("zpttest_hao");
	    webElement  = BrowserElemtHandler.findElementtobeclickable("id",LoginPageAdaptor.PASSWORD_TEXTBOX);
	    webElement.click();
	    webElement.sendKeys("ht2A605");
	    webElement = BrowserElemtHandler.findElementtobeclickable("id",LoginPageAdaptor.LOGIN_BUTTON);
	    webElement.click();
	}
}
