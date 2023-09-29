package com.CRM.VTiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "dataSupplier")
	public void create(String name,int age,char letter,double position)
	{
		System.out.println(name+"-->"+age+"-->"+letter+"-->"+position);
	}
	
	
	@DataProvider
	public Object[][] dataSupplier()
	{
		Object[][] dt=new Object[3][4];
		dt[0][0]="Raju";
		dt[0][1]=24;
		dt[0][2]='R';
		dt[0][3]=1.2;
		dt[1][0]="Rudra";
		dt[1][1]=12;
		dt[1][2]='R';
		dt[1][3]=1.0;
		dt[2][0]="Reema";
		dt[2][1]=17;
		dt[2][2]='R';
		dt[2][3]=1.1;
		return dt;
	}

}
