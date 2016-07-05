package com.g7s.zptdt.dto;

import java.util.Properties;
import com.g7s.zptdt.utils.PropUtil;

/*
 *@Description: 适配PostmanPage元素
 *@author: Sandy Hao
 *@version: v0.1.0
 */

public class PostmanPageAdaptor {

	static Properties np=PropUtil.PropLoader("/page_postmanmanagement.properties");

	//Home+Search
	public static String NAMESEARCH_TEXTBOX=np.getProperty("page_postmanmanagement.textbox_postmanname.xpath");
	public static String PHONESEARCH_TEXTBOX = np.getProperty("page_postmanmanagement.textbox_phone.xpath");
	public static String SEARCH_BUTTON = np.getProperty("page_postmanmanagement.button_search.xpath");
	public static String SEARCH_NAME_RESULT = np.getProperty("page_postmanmanagement.table_namesearch.xpath");
	public static String SEARCH_PHONE_RESULT = np.getProperty("page_postmanmanagement.table_phonesearch.xpath");
	public static String SEARCH_ORG_RESULT = np.getProperty("page_postmanmanagement.table_orgsearch.xpath");
	public static String  ADD_POSTMAN =np.getProperty("page_postmanmanagement.button_add.xpath");
	public static String  IMPORT_POSTMAN = np.getProperty("page_postmanmanagement.button_import.xpath");
	public static String  ORGSEARCH_LINK = np.getProperty("page_postmanmanagement.link_orgsearch.xpath");
	public static String  ORGSEARCH_TEXTBOX = np.getProperty("page_postmanmanegement.textbox_org.css");
	public static String  POSTMANORGSEARCH_LI = np.getProperty("page_postmansearch.li_postmanorg.xpath");
	public static String  EXPORT_POSTMAN = np.getProperty("page_postmanmanagement.button_export.xpah");
	public static String  DELETE_POSTMAN = np.getProperty("page_postmanmanagement.button_delete.xpath");
	
	//Add
	public static String  POSTMANNAMEADD_TEXTBOX=np.getProperty("page_postmanadd.textbox_postmanname.xpath");
	public static String  POSTMANPHONEADD_TEXTBOX=np.getProperty("page_postmanadd.textbox_postmanphone.xpath");
	public static String  POSTMANORGADD_TEXTBOX=np.getProperty("page_postmanadd.textbox_postmanorg.css");
	public static String  POSTMANORGADD_LINK=np.getProperty("page_postmanadd.link_postmanorg.xpath");
	public static String  ADD_BUTTON=np.getProperty("page_postmanadd.button_postmanadd.xpath");
	public static String  POSTMANORGADD_LI=np.getProperty("page_postmanadd.li_postmanorg.xpath");
	
	//Import
	public static String POSTMANIMPORT_TEXTBOX = np.getProperty("page_postmanimport.textbox_postmanfile.xpath");
	public static String POSTMANIMPORT_NEXTBUTTON = np.getProperty("page_postmanimport.button_nextbutton.xpath");
	public static String POSTMANIMPORT_CONFIRMBUTTON = np.getProperty("page_postmanimport.button_confirmbutton.xpath");
	public static String POSTMANIMPORT_RESULT=np.getProperty("page_postmanimport.text_importresult.xpath");
	public static String POSTMANIMPORT_RETURNBUTTON = np.getProperty("page_postmanimport.button_returntolist.xpath");
	
	//Edit
	public static String POSTMANEDIT_BUTTON=np.getProperty("page_postmanmanagement.button_edit.xpath");
	public static String POSTMANEDIT_CHECKBOX=np.getProperty("page_postmanedit.chechbox_selectresult.xpath");
	public static String POSTMANEDIT_SAVEBUTTON=np.getProperty("page_postmanedit.button_savebutton.xpath");
	public static String  POSTMANORGEDIT_LINK=np.getProperty("page_postmanedit.link_postmanorg.xpath");
	
	//Export
	public static String POSTMANEXPORT_DOWNLOAD = np.getProperty("page_postmanexport.button_postmandownload.xpath");
	
	//Delete
	public static String POSTMANDELETE_CONFIRM = np.getProperty("page_postmandelete.button_postmandeleteconfirm.xpath");
}
