package com.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	@Test
	public void links() {
		WebDriverManager.chromedriver().setup();
		//WebDriver initialization
		WebDriver driver = new ChromeDriver();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximize window
		driver.manage().window().maximize();
		//Launch Browser and Open URL
		driver.get("https://flipkart.com");
		System.out.println(driver.getTitle());
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Links Count :" +links.size());
		
		
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
		driver.close();
		
	}
}
