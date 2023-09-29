package com.CRM.VTiger.practice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPractice {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/rajus/OneDrive/Desktop/FileUploadExercise.html");
		WebElement arg=driver.findElement(By.xpath("//input[@type='file']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", arg);
		File f=new File("./src/test/resources/Screenshot (3).png");
		String pic = f.getAbsolutePath();
		arg.sendKeys(pic);
		
	}

}
