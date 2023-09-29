package com.CRM.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrg {

	@FindBy(name="accountname") private WebElement orgNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement clickSave;
	
	public CreateNewOrg(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void passOrgName(String orgName)
	{
		orgNameTextField.sendKeys(orgName);
	}
	public void clickOnSaveBtn()
	{
		clickSave.click();
	}
}
