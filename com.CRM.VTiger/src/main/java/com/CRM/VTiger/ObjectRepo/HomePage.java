package com.CRM.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.VTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText = "Organizations")
	private WebElement organizationEdt;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsEdt;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administartorEdt;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutEdt;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOrganization() {
		organizationEdt.click();
	}

	public void clickContact() {
		ContactsEdt.click();
	}

	public void logoutFromApp(WebDriver driver) {
		moveToElement(driver, administartorEdt);
		signoutEdt.click();
	}

}
