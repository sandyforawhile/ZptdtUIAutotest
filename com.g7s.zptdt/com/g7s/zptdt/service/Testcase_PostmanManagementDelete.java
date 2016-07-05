package com.g7s.zptdt.service;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.g7s.zptdt.action.NavigateTo;
import com.g7s.zptdt.dao.ZptdtMysqlExecutor;
import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.PostmanPageAdaptor;

public class Testcase_PostmanManagementDelete extends BaseTask {

	@Test
	public void Test01_DeletePostman() throws InterruptedException {

		WebElement webElement = null;

		// Select
		BrowserElemtHandler.switchToDefaultContent();
		BrowserElemtHandler.switchToFrame();
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANEDIT_CHECKBOX);
		webElement.click();
		BrowserElemtHandler.WaitForSec(2);

		// Delete
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.DELETE_POSTMAN);
		webElement.click();
		BrowserElemtHandler.WaitForSec(2);
		webElement = BrowserElemtHandler.findElement("xpath", PostmanPageAdaptor.POSTMANDELETE_CONFIRM);
		webElement.click();
		BrowserElemtHandler.WaitForSec(2);

		// Assert
		BrowserElemtHandler.switchToDefaultContent();
		BrowserElemtHandler.switchToFrame();
		String result = BrowserElemtHandler.findElementtobevisible("xpath", PostmanPageAdaptor.SEARCH_NAME_RESULT)
				.getText();
		Assert.assertNotEquals("测试司机", result);

	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {

		WebElement webElement = null;

		NavigateTo.PostmanmanagementPageInstant.navigatetoHomepage();
		NavigateTo.PostmanmanagementPageInstant.navigatetoPostmanmanagementPage();
		BrowserElemtHandler.WaitForSec(5);

		// Click_Add
		BrowserElemtHandler.switchToFrame();
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.ADD_POSTMAN);
		webElement.click();
		BrowserElemtHandler.WaitForSec(5);

		// FillinName
		BrowserElemtHandler.switchToDefaultContent();
		BrowserElemtHandler.switchToFrameByXpath(PostmanPageAdaptor.POSTMANNAMEADD_TEXTBOX);
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANNAMEADD_TEXTBOX);
		webElement.click();
		webElement.sendKeys("测试司机");
		// FillinOrg
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LINK);
		webElement.click();
		BrowserElemtHandler.WaitForSec(2);
		webElement = BrowserElemtHandler.findElementtobeclickable("css", PostmanPageAdaptor.POSTMANORGADD_TEXTBOX);
		webElement.click();
		webElement.sendKeys("zpttest");
		BrowserElemtHandler.WaitForSec(2);
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANORGADD_LI);
		BrowserElemtHandler.WaitForSec(2);
		webElement.click();
		// FillinPhone
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.POSTMANPHONEADD_TEXTBOX);
		webElement.click();
		webElement.sendKeys("13433333334");

		// Save
		webElement = BrowserElemtHandler.findElementtobeclickable("xpath", PostmanPageAdaptor.ADD_BUTTON);
		webElement.click();
		BrowserElemtHandler.WaitForSec(6);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {

		// Logout
//		BrowserElemtHandler.switchToParentFrame();
//		Logout.LogoutInstant.logout();
//		BrowserElemtHandler.WaitForSec(2);

		ZptdtMysqlExecutor zptexe = new ZptdtMysqlExecutor();
		zptexe.executeDelete("zpt_postman", "postmanname='测试司机'");
		System.out.println("删除语句成功！");
	}

}
