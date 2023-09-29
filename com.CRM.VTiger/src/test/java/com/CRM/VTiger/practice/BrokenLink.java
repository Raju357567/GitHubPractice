package com.CRM.VTiger.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
		
		ArrayList<String> brokenLinks=new ArrayList<String>(); 
		
		for(int i=0;i<=allLinks.size();i++)
		{
			String links=allLinks.get(i).getAttribute("href");
			int statusCode=0;
			try
			{
				URL url=new URL(links);
				URLConnection urlcon = url.openConnection();
				HttpURLConnection httpurl=(HttpURLConnection)urlcon;
				statusCode=httpurl.getResponseCode();
				if(statusCode>=400)
				{
					brokenLinks.add(links+""+statusCode);
				}
			}
			catch(Exception e)
			{
				continue;
			}
		}
		System.out.println(brokenLinks);
	}



}
