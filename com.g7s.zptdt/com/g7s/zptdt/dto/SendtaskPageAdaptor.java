package com.g7s.zptdt.dto;

import java.util.Properties;

import com.g7s.zptdt.utils.PropUtil;

public class SendtaskPageAdaptor {

	static Properties np=PropUtil.PropLoader("/page_sendtaskmanagement.properties");
	
	//IMPORT
	public static String SENDTASK_IMPORT_IMPORT=np.getProperty("page_sendtaskmanagement.button_import.xpath");
	public static String SENDTASK_IMPORT_UPLOADFILE = np.getProperty("page_sendtaskmanagement.button_sendtaskfile");
	public static String SENDTASK_IMPORT_NEXTSTEP = np.getProperty("page_sendtaskmanegement.button_nextstep.xpath");
	public static String SENDTASK_IMPORT_SUBMIT = np.getProperty("page_sendtaskmanagement.button_submit.xpath");
	public static String SENDTASK_IMPORT_ASSERT = np.getProperty("page_sendtaskmanagement.text_assert.xpath");
	public static String SENDTASK_IMPORT_RETURN = np.getProperty("page_sendtaskmanagement.button_return.xpath");
	
	//SEARCH
	public static String SENDTASK_SEARCH_TIMEPICKER = np.getProperty("page_sendtaskmanagement.input_time.xpath");
	public static String SENDTASK_SEARCH_BUTTON=np.getProperty("page_sendtaskmanagement.button_search.xpath");
	public static String SENDTASK_SEARCH_POSTMANNAME=np.getProperty("page_sendtaskmanagement.input_postmanname.xpath");
}
