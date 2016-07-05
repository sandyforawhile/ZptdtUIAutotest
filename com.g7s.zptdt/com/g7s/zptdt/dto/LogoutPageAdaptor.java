package com.g7s.zptdt.dto;

import java.util.Properties;

import com.g7s.zptdt.utils.PropUtil;

public class LogoutPageAdaptor {

	static Properties np=PropUtil.PropLoader("/page_logout.properties");

	public static String LOGOUT_BUTTON=np.getProperty("page_logout.link_logout.xpath");
	public static String LOGOUT_BUTTON_ACCEPT=np.getProperty("page_logout.button_accept.xpath");
	
}
