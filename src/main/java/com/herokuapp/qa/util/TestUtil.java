package com.herokuapp.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.herokuapp.qa.base.Base;


public class TestUtil extends Base{

	public static long Pageload_Time_Out=40;
	public static long Implicty_Wait=20;
	public static String Test_sheet_path=
	"F:\\KeyWordDrivenFrameWork\\com.client.tracify.com\\src\\main\\java\\com\\herokuapp\\qa\\testdata\\missionData.xlsx";
	
	public static Workbook book;
	public static Sheet sheet;
	public void switchtoFrame() {
		driver.switchTo().frame("mainframe");
		
	}
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(Test_sheet_path);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
		for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
		}
	return data;
		
	} 
}
