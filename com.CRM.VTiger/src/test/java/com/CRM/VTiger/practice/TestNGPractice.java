package com.CRM.VTiger.practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = -5)
	public void create()
	{
		System.out.println("User created");
	}
	@Test(invocationCount = -98)
	public void updated()
	{
		System.out.println("User updated");
	}
	@Test(invocationCount = 5)
	public void deleted()
	{
		System.out.println("User deleted");
	}

}
