package com.CRM.VTiger.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokyoOlympic2020 {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
		List<WebElement> allCountry=driver.findElements(By.className("hjfJyH"));
		
			for(int i=1;i<=allCountry.size();i++)
			{
				WebElement country=driver.findElement(By.xpath("//div[contains(@class,'hjfJyH')]["+i+"]"));
				System.out.print(" "+country.getText());
				
				WebElement gold=driver.findElement(By.xpath("//div[@title='Gold']["+i+"]"));
				System.out.print("Gold :"+" "+gold.getText());
				
				WebElement silver=driver.findElement(By.xpath("//div[@title='Silver']["+i+"]"));
				System.out.print("Silver"+" "+silver.getText());
				
				WebElement bronze=driver.findElement(By.xpath("//div[@title='Bronze']["+i+"]"));
				System.out.print("Bronze"+" "+bronze.getText());
				
				WebElement total=driver.findElement(By.xpath("//div[@data-medal-id='total-medals-row-"+i+"']"));
				System.out.print("Total"+" "+total.getText());
				
				System.out.println();
				
			}
			driver.quit();

		}
	}


