package com.henu.utils;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.henu.bean.Student;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetDataFromExcel {
	public static List<Student> getAllByExcel(String path) throws IOException{
		File filePath;
		
		try {
			filePath = new File(path);
			Workbook wb1 = Workbook.getWorkbook(filePath);
		} catch (Exception e) {
			filePath = new File("C:\\Test.xls");
			
		}
		List<Student> list = new ArrayList<Student>();
		try {
			Workbook wb = Workbook.getWorkbook(filePath);
			//得到文件中第一个工作表格，若要得到全部用sheet[] sheets = wb.getSheets()
			Sheet sheet = wb.getSheet(0);
			//得到第一个表中的总行数和列数
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			//循环取出表中的所有数据,第一行一般是标题，所有循环从1开始而不是0
			for(int i=1;i<rows;i++){
				for(int j=0;j<cols;j++){
					String stuId = sheet.getCell(j++,i).getContents();
					String stuName = sheet.getCell(j++,i).getContents();
					String stuClass = sheet.getCell(j++,i).getContents();
					list.add(new Student(stuId,stuName,stuClass,"","",""));
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static boolean isExist(String stu_id){
		String sql = "select * from student where stu_id = '"+stu_id+"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		try {
			if(rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
}
