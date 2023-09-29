package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataInExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TestDataADS.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet("Class");
		sh.createRow(0).createCell(0).setCellValue("Papa of selenium");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestDataADS.xlsx");
		wb.write(fos);
	}

}
