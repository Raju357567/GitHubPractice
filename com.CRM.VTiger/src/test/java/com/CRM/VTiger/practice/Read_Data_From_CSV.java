package com.CRM.VTiger.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Read_Data_From_CSV {
	
	public static void main(String[] args) throws Throwable
	{
		try
		{
		FileReader fr=new FileReader("./src/test/resources/NewTestdata.csv");
		CSVReader read=new CSVReader(fr);
		
		String cell[];
		
			while((cell=read.readNext())!=null)
			{
				String un=cell[0];
				String pw=cell[1];
				System.out.println(un+"\n"+pw);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
