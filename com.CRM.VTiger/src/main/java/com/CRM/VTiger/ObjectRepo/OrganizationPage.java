package com.CRM.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath = "//img[contains(@alt,'Crea')]")
	private WebElement orgLookUpImg;

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLookUp() {
		orgLookUpImg.click();
	}
}
