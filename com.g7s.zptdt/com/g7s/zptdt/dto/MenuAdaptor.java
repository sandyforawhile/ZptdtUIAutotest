package com.g7s.zptdt.dto;

import java.util.Properties;

import com.g7s.zptdt.utils.PropUtil;

public class MenuAdaptor {

	static Properties np=PropUtil.PropLoader("/menu.properties");

	public static String ZPTPBASEURL=np.getProperty("page_zpt.link_level1.xpath");	
	
	//postman
	public static String ZPTPOSTMANSUPERURL=np.getProperty("page_postmanmanagement.link_level1.xpath");
	public static String ZPTPOSTMANSUBURL = np.getProperty("page_postmanmanagement.link_level2.xpath");
	
	//sendtask
	public static String ZPTSENDTASKSUBURL = np.getProperty("page_sendtaskmanagement.link_level2.xpath");
	
}
