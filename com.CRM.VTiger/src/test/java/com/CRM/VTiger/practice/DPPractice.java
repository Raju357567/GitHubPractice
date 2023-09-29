package com.CRM.VTiger.practice;

import org.testng.annotations.Test;

public class DPPractice {
	
	@Test(dataProvider = "dataSupplier",dataProviderClass = DataProviderPractice.class)
	public void create(String name,int age,char letter,double position)
	{
		System.out.println(name+"-->"+age+"-->"+letter+"-->"+position);
	}

}
