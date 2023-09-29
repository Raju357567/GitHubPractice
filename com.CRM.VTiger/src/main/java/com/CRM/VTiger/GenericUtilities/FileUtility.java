package com.CRM.VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.opencsv.CSVWriter;

/**
 * This class consist of generic method to fetch the data from property file
 * 
 * @author rajus
 *
 */
public class FileUtility {

	/**
	 * This method help us to fetch the data from property file
	 * 
	 * @Raju
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.propertyfilepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

	public String getDataFromexcelSheet(String sheetName, int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return value;
	}

	public void updateExcelData(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		book.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstant.excelfilepath);
		book.write(fos);
	}
	public void writeDataInCSVFile(int cellNum,String value) throws Throwable
	{
		FileWriter fw=new FileWriter(IPathConstant.CSVfilepath);
		CSVWriter cw=new CSVWriter(fw);
		String cell[]=new String[cellNum];
		cell[cellNum-1]=value;
		cw.writeNext(cell);
	}
	
	@DataProvider
	public Object[][] multipleDataFromExcel() throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.excelfilepath);
		Sheet sh = WorkbookFactory.create(fis).getSheet("DataProvider");
		int lastRow = sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] dt=new Object[lastRow][lastCell];
		DataFormatter dft=new DataFormatter();
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				dt[i][j]=dft.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		return dt;
	}

}
