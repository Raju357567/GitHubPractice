package com.CRM.VTiger.practice;

import java.io.FileWriter;
import java.io.IOException;

import com.CRM.VTiger.GenericUtilities.IPathConstant;
import com.opencsv.CSVWriter;

public class Write_Data_Into_CSV {
	
	public static void main(String[] args) throws IOException {
		
		FileWriter fw=new FileWriter(IPathConstant.CSVfilepath);
		CSVWriter csw=new CSVWriter(fw);
		
		String cell[]=new String[3];
		
		cell[0]="Raju";
		cell[1]="Sriyanka";
		cell[2]="Rudra";
		
		csw.writeNext(cell);
		csw.flush();
		System.out.println("Ok I'm Done");
	}

}
