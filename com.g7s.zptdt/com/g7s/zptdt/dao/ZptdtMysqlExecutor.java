package com.g7s.zptdt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.g7s.zptdt.utils.JDBCUtil;


public class ZptdtMysqlExecutor {
	
	private PreparedStatement preStmt= null;
	private String sql;


	public void executeAdd(String table, Map<String,Object> map){
		
		//构造插入SQL语句
		sql ="insert into "+table+ map.keySet().toString().replace("[", " (").replace("]", ") ")+map.keySet().toString().replaceAll("\\w+", "?").replace("[", "values (").replace("]", ")");
		//执行SQL语句
		 try { 
			preStmt = JDBCUtil.getInstance().getConnect().prepareStatement(sql);
			List<Entry<String,Object>> list = new ArrayList<>(map.entrySet());
			for(int i = 0 ; i<list.size(); i++){
				preStmt.setObject(i+1, list.get(i).getValue());
			}		
			preStmt.executeUpdate(); 
			} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}
	
	public void executeDelete(String table, String conditions){
		
		//构造SQL语句
		sql="delete from "+table+" where "+conditions;
		//执行SQL语句
		 try { 
			preStmt = JDBCUtil.getInstance().getConnect().prepareStatement(sql);
			preStmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executeQuery(){
		//TODO
	}
	
	public void executeUpdate(){
		//TODO
	}

//	public static void  main(String [] args){
//		ZptdtMysqlExecutor zptexe =  new ZptdtMysqlExecutor();
//		Map<String ,Object> map = new HashMap<String,Object>();
//		map.put("orgroot","200GUR");
//		map.put("orgcode", "200GUR");
//		map.put("postmanname", "testtesttest");
//		map.put("phone","13433333333");
//		map.put("passwd","13433333333");
//		
//		zptexe.executeAdd("zpt_postman", map);
//		System.out.println("数据插入成功~");
//		zptexe.executeDelete("zpt_postman", "postmanname='testtesttest'");
//		System.out.println("数据删除成功~");
//	}
}
