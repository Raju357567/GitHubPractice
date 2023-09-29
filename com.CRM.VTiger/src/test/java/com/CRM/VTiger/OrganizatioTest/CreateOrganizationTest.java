package com.CRM.VTiger.OrganizatioTest;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.FileUtility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;
import com.CRM.VTiger.GenericUtilities.WebDriverUtility;
import com.CRM.VTiger.ObjectRepo.CreateNewOrg;
import com.CRM.VTiger.ObjectRepo.HomePage;
import com.CRM.VTiger.ObjectRepo.LoginPage;
import com.CRM.VTiger.ObjectRepo.OrganizationInfoPage;
import com.CRM.VTiger.ObjectRepo.OrganizationPage;

@Listeners(com.CRM.VTiger.GenericUtilities.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = { "RegressionSuite",
			"SmokeSuite" }, retryAnalyzer = com.CRM.VTiger.GenericUtilities.RetryAnalyzer.class)
	public void createOrganization() throws Throwable {

		JavaUtility ju = new JavaUtility();
		HomePage hp = new HomePage(driver);

		String name = fu.getDataFromexcelSheet("Class", 0, 3) + ju.getRandom();

		OrganizationPage op = new OrganizationPage(driver);
		hp.clickOrganization();
		Reporter.log("click on organization", true);
		// Assert.fail();//to fail the test script
		op.clickOnLookUp();
		Reporter.log("click on lookup image", true);

		CreateNewOrg cno = new CreateNewOrg(driver);
		cno.passOrgName(name);
		cno.clickOnSaveBtn();
		Reporter.log("click on save button", true);

		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String head = orgInfo.nameOfOrg();
		wdu.screenshotForEntireWebPage(driver, "Papa");

//		if (head.contains(name)) {
//			System.out.println("TC passed");
//		} else {
//			System.out.println("TC failed");
//		}
		Assert.assertTrue(head.contains(name));
		Reporter.log("validation passed", true);
		System.out.println("TC passed");

	}

}
