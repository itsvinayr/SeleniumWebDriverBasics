package com.learning.selenium.seleniumWebDriverBasics.excelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OperationsOnExcel {

	public static void main(String[] args) throws IOException {

		readExcel("Vinay");
		writeExcel("Vinay");
		readExcel("Vinay");
		
	}
	
	@SuppressWarnings("resource")
	public static Object[][] readExcel(String sheetName) throws IOException {
		
		Object[][] data = null;
		Workbook workBook = null;
		Sheet sheet = null;
		Row row = null;
		DataFormatter formatter = null;
		String stringValue = null;
		
		String fileName = "Humans.xlsx";
		String filePath = System.getProperty("user.dir")+"\\src\\com\\day6\\selenium\\excel\\"+fileName;
		
		FileInputStream fileInputStream = new FileInputStream(new File(filePath));
		
		if(fileName.contains(".xlsx")) {
			workBook = new XSSFWorkbook(fileInputStream);
		}else {
			workBook = new HSSFWorkbook(fileInputStream);
		}
		
		sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Row count : "+rowCount+"\nColumn count "+colCount);
		data = new Object[rowCount+1][colCount];
		formatter = new DataFormatter();
		
		for(int i=0; i<=rowCount; i++) {
			row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++) {
				stringValue = formatter.formatCellValue(row.getCell(j));
				data[i][j]=stringValue;
				System.out.print(" || "+stringValue+" || ");
			}
			System.out.println();
		}
		
		fileInputStream.close();
		return data;
		
	}
	
	@SuppressWarnings("resource")
	public static void writeExcel(String sheetName) throws IOException {
		
		Workbook workBook = null;
		Sheet sheet = null;
		Row firstRow, newRow = null;
		Cell cell = null;
		
		String fileName = "Humans.xlsx";
		String filePath = System.getProperty("user.dir")+"\\src\\com\\day6\\selenium\\excel\\"+fileName;
		
		FileInputStream fileInputStream = new FileInputStream(new File(filePath));
		
		if(fileName.contains(".xlsx")) {
			workBook = new XSSFWorkbook(fileInputStream);
		}else {
			workBook = new HSSFWorkbook(fileInputStream);
		}
		
		sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		firstRow = sheet.getRow(0);
		newRow = sheet.createRow(rowCount+1);
		for(int i=0;i<=firstRow.getLastCellNum();i++) {
			cell = newRow.createCell(i);
			cell.setCellValue(i);
		}
		
		fileInputStream.close();
		
		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		workBook.write(fileOutputStream);
		
		fileOutputStream.close();
		
	}

}
