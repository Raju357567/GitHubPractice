package com.CRM.VTiger.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.CRM.VTiger.GenericUtilities.FileUtility;

public class FlipkartPriceFetch {

	public static void main(String[] args) throws Throwable {
		FileUtility fu = new FileUtility();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		try {
			WebElement cross = driver.findElement(By.xpath("//button[.='✕']"));
			cross.click();
		} catch (Exception e) {

		}
		WebElement mouse = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouse).perform();
		driver.findElement(By.linkText("Gaming")).click();
		WebElement price = driver.findElement(
				By.xpath("//a[.='AMKETTE Evo Gamepad Pro 4 Controller with Instant Play ...']/..//div[.='₹1,849']"));
		String productPrice = price.getText();

		fu.writeDataInCSVFile(1, productPrice);
		System.out.println("Price has been printed in CSV File");
		driver.quit();

	}

}
