package com.selenium.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	@Test
	public void brokenlinks() throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		//WebDriver initialization
		WebDriver driver = new ChromeDriver();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximize window
		driver.manage().window().maximize();
		//Launch Browser and Open URL
		driver.get("https://flipkart.com");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("Links Count :" +links.size());
		
		int brokenlinks=0;
		
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			//System.out.println(url);
			
			if(url == null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			
			URL mainUrl = new URL(url);
			
			try {
				HttpURLConnection httpConn = (HttpURLConnection) mainUrl.openConnection();
				httpConn.connect();
				if(httpConn.getResponseCode() >= 400) {
					System.out.println(httpConn.getResponseCode()+url+" is broken link");
					
					brokenlinks++;
				}
				else {
					System.out.println(httpConn.getResponseCode()+url+" is valid link");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("count of broken links :"+ brokenlinks);
		driver.close();
		
		
	}
}
