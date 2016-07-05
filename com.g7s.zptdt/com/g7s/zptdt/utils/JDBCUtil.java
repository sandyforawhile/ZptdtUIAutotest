package com.g7s.zptdt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	//TODO：读取jdbc.zptdt配置文件
	private static JDBCUtil jdbcUtil = new JDBCUtil();
	
	/**
	 * getIntance(获取JDBCUtil实例)public static String ZPTPOSTMANSUPERURL=np.getProperty("page_postmanmanagement.link_level1.xpath");
	 * @return 
	 * @author : Sandy Hao
	 * @version : 0.1.0
	 */
	public static JDBCUtil getInstance(){
		return jdbcUtil;
	}
	
	public  Connection getConnect(){
		
		  Properties np=PropUtil.PropLoader("/com/g7s/zptdt/conf/zptjdbc.properties");
		  String HOSTNAME = np.getProperty("jdbc.zptdtmysql.hostname");	  
		  int PORT = Integer.parseInt(np.getProperty("jdbc.zptdtmysql.port"));
		  String DATABASE = np.getProperty("jdbc.zptdtmysql.database");
		  String USER = np.getProperty("jdbc.zptdtmysql.user");
		  String PASSWD = np.getProperty("jdbc.zptdtmysql.passwd");
		
        String url="jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DATABASE+"?"+"user="+USER+"&"+"password="+PASSWD+"&useUnicode=true&characterEncoding=UTF8";
		 Connection conn = null;
        	try {
        		conn = DriverManager.getConnection(url);
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
	}
	
//	public void closeConnect(){
//		
//	}
}
