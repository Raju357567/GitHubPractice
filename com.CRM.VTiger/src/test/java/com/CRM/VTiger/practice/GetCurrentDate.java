package com.CRM.VTiger.practice;

import com.CRM.VTiger.GenericUtilities.JavaUtility;

public class GetCurrentDate {
	
	public static void main(String[] args) {
		
		JavaUtility jut=new JavaUtility();
		String todaysDate = jut.sysDateAndTime();
		System.out.println(todaysDate);
		String currentDate = jut.modifiedDate();
		System.out.println(currentDate);
	}

}
