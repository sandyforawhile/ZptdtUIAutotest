package com.g7s.zptdt.dto;

import java.util.Properties;
import com.g7s.zptdt.utils.PropUtil;

/*
 *@Description: 适配LoginPage元素
 *@author: Sandy Hao
 *@version: v0.1.0
 */

public class LoginPageAdaptor {

	static Properties np=PropUtil.PropLoader("/page_login.properties");

	public static String USERNAME_TEXTBOX=np.getProperty("page_login.textbox_username.id");
	public static String PASSWORD_TEXTBOX=np.getProperty("page_login.testbox_password.id");
	public static String REMEMBER_CHECKBOX=np.getProperty("page_login.checkbox_remember.xpath");
	public static String LOGIN_BUTTON=np.getProperty("page_login.button_login.id");
	
}