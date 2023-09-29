package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty("username");
		System.out.println(value);
		
		
	}

}
