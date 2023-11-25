package com.selenium.basics;

import java.util.Set;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	@Test
	public void windowHandles() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		//WebDriver initialization
		WebDriver driver = new ChromeDriver();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximize window
		driver.manage().window().maximize();
		//Launch Browser and Open URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		/*
		//getWindowHandle()
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);*/
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		
		java.util.Iterator<String> it = windowIds.iterator();
		
		String paId = it.next();
		String chId = it.next();
		
		System.out.println(paId);
		System.out.println(chId);
		
		
		driver.switchTo().window(paId);
		System.out.println("Parent title : " + driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.switchTo().window(chId);
		System.out.println("Chaild title : " + driver.getTitle());
		
		
		driver.quit();
		
		}
	

}