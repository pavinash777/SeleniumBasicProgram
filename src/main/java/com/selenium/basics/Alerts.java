package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	@Test
	public void alertTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//WebDriver initialization
		WebDriver driver = new ChromeDriver();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximize window
		driver.manage().window().maximize();
		//Launch Browser and Open URL
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();*/
		
		
		
		Thread.sleep(3000);
		driver.close();
	}
}
