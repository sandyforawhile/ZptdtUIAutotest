package com.g7s.zptdt.action;

import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.g7s.zptdt.dto.BrowserElemtHandler;
import com.g7s.zptdt.dto.TimerPickerAdaptor;

public class TimePicker {

	public static final TimePicker tpInstant = new TimePicker();
	private  TimePicker() {
	}
	
	public void timeSelect(int forward, int afterward){
		
		  int[] begintime = new int[2];
		  int[] endtime = new int[2];
		  begintime = monthAndDay(forward);
		  endtime = monthAndDay(afterward);
		  
		  String beginmonth = String.valueOf(begintime[0]);
		  String beginday = String.valueOf(begintime[1]);
		  
		  String endmonth = String.valueOf(endtime[0]);
		  String endday = String.valueOf(endtime[1]);
		  
		   WebElement webElement  = null;
		   webElement = BrowserElemtHandler.findElementtobeclickable("xpath", TimerPickerAdaptor.TIMEPICKER_BEGINMONTH);
		   Select selbeg = new Select(webElement);
		   selbeg.selectByValue(beginmonth);
		   
//		   webElement = BrowserElemtHandler.findElement("xpath",TimerPickerAdaptor.TIMEPICKER_BEGINDAY+" and tr/td[@text='"+beginday+"']");
		   webElement = BrowserElemtHandler.findElement("xpath","//div[@class='calendar left']//table//tbody//tr//td[@class='available' and text() = '"+beginday+"']");
		   webElement.click();
		   
		   webElement = BrowserElemtHandler.findElementtobeclickable("xpath", TimerPickerAdaptor.TIMEPICKER_ENDMONTH);
		   Select selend = new Select(webElement);
		   selend.selectByValue(endmonth);
		   
		   //webElement = BrowserElemtHandler.findElement("xpath",TimerPickerAdaptor.TIMEPICKER_ENDDAY+" and tr/td[@text='"+endday+"']");
		   webElement = BrowserElemtHandler.findElement("xpath","//div[@class='calendar right']//table//tbody//tr//td[@class='available' and text() = '"+endday+"']");
		   webElement.click();
		   
		   webElement = BrowserElemtHandler.findElement("xpath", TimerPickerAdaptor.TIMEPICKER_CONFIRM);
		   webElement.click();
	}
	
	public int [] monthAndDay(int day){
		
		int[] time = new int[2];
		Calendar now = Calendar.getInstance();  
		now.add(Calendar.DATE,  day);
		time[0] = now.get(Calendar.MONTH) ;  
		time[1]  =  now.get(Calendar.DATE);
		return time;
	}
	
}
