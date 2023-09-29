package com.CRM.VTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.CRM.VTiger.ObjectRepo.HomePage;
import com.CRM.VTiger.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver listenerDriver;
	public FileUtility fu = new FileUtility();
	public WebDriverUtility wdu = new WebDriverUtility();

	@BeforeSuite(groups = { "RegressionSuite", "SmokeSuite" })
	public void connectDatabase() {
		System.out.println("Open database connection");
	}

	@Parameters("browser")
	@BeforeClass(groups = { "RegressionSuite", "SmokeSuite" })
	public void launchBrowser(/* String BROWSER */) throws Throwable {
		String BROWSER = fu.getDataFromPropertyFile("Browser");
		String URL = fu.getDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new EdgeDriver();
		} else

			// driver = new EdgeDriver();
			System.out.println("Invalid browser");
		listenerDriver = driver;
		wdu.maximize(driver);
		wdu.impWait(driver);
		driver.get(URL);

	}

	@BeforeMethod(groups = { "RegressionSuite", "SmokeSuite" })
	public void login() throws Throwable {
		String UN = fu.getDataFromPropertyFile("username");
		String PW = fu.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(UN, PW);
	}

	@AfterMethod(groups = { "RegressionSuite", "SmokeSuite" })
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.logoutFromApp(driver);
	}

	@AfterClass(groups = { "RegressionSuite", "SmokeSuite" })
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite(groups = { "RegressionSuite", "SmokeSuite" })
	public void closeDatabase() {
		System.out.println("close data base connection");
	}
}
