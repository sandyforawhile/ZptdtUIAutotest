package com.g7s.zptdt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;

public class ExcelUtil {
//TODO:interface
	
	public static Object[][] getData(String fileName, String sheetName) throws BiffException, IOException
	{
		
//		ArrayList<Object>list=new ArrayList<Object>();
		
		InputStream in = new FileInputStream(fileName);
			
		Workbook wb = 	Workbook.getWorkbook(in);
        Sheet rs = wb.getSheet(sheetName);
        
        //get rows
        int rsRows = rs.getRows();
        //get Columns
        int rsColumns = rs.getColumns();
        
		Object[][] data = new Object[rsRows-1][];
        
		if(rsRows > 0)
		{
			for(int i=0; i<=rsRows-2;i++)
			{
				Object[] colum = new Object[rsColumns];
				for(int j=0; j<=rsColumns-1;j++)
				{
					jxl.Cell cell = rs.getCell(j,i+1);
					Object cz =  cell.getContents();
					colum[j]=cz;
				}
				data[i] = colum;
			}
		}
		return data;
	}
	
	public static ArrayList<Object> getColumn(String fileName, String sheetName, int column) throws BiffException, IOException{

		
		ArrayList<Object>list=new ArrayList<Object>();
		
		InputStream in = new FileInputStream(fileName);
		
		Workbook wb = 	Workbook.getWorkbook(in);
        Sheet rs = wb.getSheet(sheetName);
        
        //get rows
        int rsRows = rs.getRows();
        //get Columns
        int rsColumns = rs.getColumns();
        
		Object[][] data = new Object[rsRows-1][];
        
		if(rsRows > 0)
		{
			for(int i=0; i<=rsRows-2;i++)
			{
				Object[] colum = new Object[rsColumns];
				for(int j=0; j<=rsColumns-1;j++)
				{
					jxl.Cell cell = rs.getCell(j,i+1);
					Object cz =  cell.getContents();
					colum[j]=cz;
				}
				data[i] = colum;
			}
		}
		
		for(int i = 0; i<data.length; i++)
		{
			list.add(data[i][column]);
		}
		
		return list;
	}
	
	public static void setColumn(String fileName,String sheetName, int column,ArrayList<String> list) throws JXLException, IOException{
		
		InputStream in = new FileInputStream(fileName);
		jxl.Workbook wb  = 	Workbook.getWorkbook(in); 
		//创建副本
        jxl.write.WritableWorkbook wbe = Workbook.createWorkbook(new File(fileName),wb);
        WritableSheet  sheet  = wbe.getSheet(sheetName);

       for(int i = 1; i<=list.size(); i++){
           WritableCell cell = sheet.getWritableCell(column,i);
           jxl.format.CellFormat cf = cell.getCellFormat();
           jxl.write.Label lbl = new jxl.write.Label(column, i, list.get(i-1));
           lbl.setCellFormat(cf);
           sheet.addCell(lbl);
        }
       
        wbe.write();
        wbe.close();
	}
}
