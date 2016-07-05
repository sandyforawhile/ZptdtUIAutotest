package com.g7s.zptdt.dto;

import java.util.Properties;

import com.g7s.zptdt.utils.PropUtil;

public class TimerPickerAdaptor {

	static Properties np=PropUtil.PropLoader("/public.properties");
	
	//TIMERPICKER
	public static String TIMEPICKER_BEGINMONTH=np.getProperty("timepicker.beginmonth.xpath");
	public static String TIMEPICKER_ENDMONTH=np.getProperty("timepicker.endmonth.xpath");
	public static String TIMEPICKER_BEGINDAY=np.getProperty("timepicker.beginday.xpath");
	public static String TIMEPICKER_ENDDAY=np.getProperty("timepicker.endday.xpath");
	public static String TIMEPICKER_CONFIRM=np.getProperty("timepicker.button.confirm");
}
