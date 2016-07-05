package com.g7s.zptdt.dto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * *
 *@Description:抽象类，定位操作浏览器 & 页面元素
 *@author: Sandy Hao
 *@version: v0.1.0
* *
*/

public   class  BrowserElemtHandler {

	private static volatile WebDriver driver;
//	private static WebDriver driver;
	
	public static void setDriver(WebDriver mydriver){
		  driver = mydriver;
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
	
	public  static  WebElement  findElement(final String method,final String path){
		
		WebElement webElement = null;
		switch (method.toLowerCase())
		{
			case "xpath":
				webElement =driver.findElement(By.xpath(path));		
				break;
			case  "id":
				webElement = driver.findElement(By.id(path));
				break;
			case "name":
				webElement = driver.findElement(By.name(path));
				break;
			case "class":
				webElement =driver.findElement(By.className(path));
				break;
			case "css":
				webElement = driver.findElement(By.cssSelector(path));
				break;
			default:
		}
		return webElement;
	}

	public  static  WebElement  findElementtobeclickable(final String method,final String path){
		
		WebDriverWait  wait = new WebDriverWait(driver,30);
		
		WebElement webElement = null;
		switch (method.toLowerCase())
		{
			case "xpath":
				webElement =driver.findElement(By.xpath(path));		
				break;
			case  "id":
				webElement = driver.findElement(By.id(path));
				break;
			case "name":
				webElement = driver.findElement(By.name(path));
				break;
			case "class":
				webElement =driver.findElement(By.className(path));
				break;
			case "css":
				webElement = driver.findElement(By.cssSelector(path));
				break;
			default:
		}
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		return webElement;
	}
	
	public  static  WebElement  findElementtobevisible(final String method,final String path){
		
		WebDriverWait  wait = new WebDriverWait(driver,30);
		
		WebElement webElement = null;
		switch (method.toLowerCase())
		{
			case "xpath":
				webElement =driver.findElement(By.xpath(path));		
				break;
			case  "id":
				webElement = driver.findElement(By.id(path));
				break;
			case "name":
				webElement = driver.findElement(By.name(path));
				break;
			case "class":
				webElement =driver.findElement(By.className(path));
				break;
			case "css":
				webElement = driver.findElement(By.cssSelector(path));
			default:
		}
		wait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement;
	}
	
	
	public  static List<WebElement>  findElements(final String method, final  String path){
		List<WebElement> webElements  = null ;
		
		switch (method.toLowerCase())
		{
		case "xpath":
			webElements = driver.findElements(By.xpath(path));
			break;
		case  "id":
			webElements =  driver.findElements(By.id(path));
			break;
		case "name":
			webElements = driver.findElements(By.name(path));
			break;
		case "class":
			webElements = driver.findElements(By.className(path));
			break;
		default:
		}
		return webElements;
	}

	public  static void implicitlyWait(int sec)
	{
		 driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public static void WaitForSec(int sec) throws InterruptedException{
		 int msec = sec * 1000;
		 Thread.sleep(msec);
	}
	
	public static void switchToActiveFrame(){
		driver.switchTo().activeElement();
	}
	
	public static void switchToAlert(){
		driver.switchTo().alert();
	}
	
	public static  void switchToDefaultContent() throws InterruptedException
	{
		driver.switchTo().defaultContent();
	}
	
	public static  void switchToParentFrame() throws InterruptedException
	{
		driver.switchTo().parentFrame();
	}
	
	public static  void switchToFrame() throws InterruptedException
	{
//		if(driver.findElements(By.xpath("//header[@role='heading']")).size()==0)
//		{
			WebDriverWait  wait = new WebDriverWait(driver,20,3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("content-frame")));
//		}
	}
	
	public  static void switchToFrameByXpath(String path) throws InterruptedException
	{
		if(driver.findElements(By.xpath(path)).size()==0)
		{
			WebDriverWait  wait = new WebDriverWait(driver,20,3000) ;
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("content-frame")));
//			driver.switchTo().frame("content-frame");
		}
	}
	
	public static void switchToFrameByElement(WebElement ele) throws InterruptedException{
		WebDriverWait  wait = new WebDriverWait(driver,20,3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

	public static void get(String url) {
		driver.get(url);
	}

	public static void quit() {
		driver.quit();
	}

	public static void windowmaxmize() {
		driver.manage().window().maximize();
	}
	
}

//interface browserHander {
//	public  void click(List<WebElement> list);
//	public void clear(List <WebElement> list);
//	public void sendKeys(List <WebElement> list, String value);
//}