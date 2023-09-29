package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingNumeriValue {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TestDataADS.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		//3 methods can implemented
		//getNumericCellValue()
		//getStringCellValue()
		//else we can override toString()[it will return double type of value]
		//String value = wb.getSheet("Sheet1").getRow(2).getCell(0).toString();
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(wb.getSheet("Sheet1").getRow(2).getCell(0));
		System.out.println(value);
	}

}
