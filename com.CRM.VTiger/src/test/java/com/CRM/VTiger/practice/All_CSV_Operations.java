package com.CRM.VTiger.practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class All_CSV_Operations {
	
	public static void main(String[] args) throws IOException, CsvValidationException {
		
		//Writing data in CSV
		FileWriter fw=new FileWriter("./src/test/resources/NewTestdata.csv");
		CSVWriter csw=new CSVWriter(fw);
		
		String cell[]=new String[2];
		
		cell[0]="admin";
		cell[1]="password";
		csw.writeNext(cell);
		csw.flush();
		
		//fetching data fromCSV
		try
		{
		FileReader fr=new FileReader("./src/test/resources/NewTestdata.csv");
		CSVReader read=new CSVReader(fr);
		
		String cell1[];
		
			while((cell1=read.readNext())!=null)
			{
				String un=cell1[0];
				String pw=cell1[1];
				WebDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("http://localhost:8888");
				driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pw,Keys.ENTER);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
	
	}

}
