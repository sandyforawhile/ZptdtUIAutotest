package com.g7s.zptdt.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 *@Description: 处理Properties文件
 *@author: Sandy Hao
 *@version: v0.1.0
 **/

public class PropUtil {
//TODO:interface
/**
 * @Desciption:  加载Properties文件
 * @param fileName
 * @author: Sandy Hao
 * @version: v0.1.0
 **/
	public static Properties  PropLoader(String fileName){
		
		Properties prop = new Properties();

		try{
			InputStream in2 =PropUtil.class.getResourceAsStream(fileName.replaceAll("\\s+", ""));
			prop.load(in2);
		}catch(Exception e){
			System.out.println(e);
		}
		return prop;
	}
	
/** 
 * @Desciption: 关闭流文件
 * @author: Sandy Hao
 * @version: v0.1.0
 * */
    
	public static void Close(){
    	//TODO
    }
}
