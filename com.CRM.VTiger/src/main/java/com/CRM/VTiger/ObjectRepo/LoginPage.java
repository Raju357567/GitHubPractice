package com.CRM.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name") private WebElement usernameEdt;
	
	@FindBy(name="user_password") private WebElement passwordEdt;
	
	@FindBy(id="submitButton") private WebElement loginBtn;
	
	//Initialize the elements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);//also called as lazy initialization.
	}
	
	/**
	 * This method will help to login.
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

	
	
	

}
