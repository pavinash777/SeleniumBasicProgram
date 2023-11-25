package com.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	@Test
	public void handleIFrames() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//WebDriver initialization
		WebDriver driver = new ChromeDriver();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximize window
		driver.manage().window().maximize();
		//Launch Browser and Open URL
		driver.get("https://the-internet.herokuapp.com/iframe");
		Thread.sleep(3000);
		WebElement firstFrame = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(firstFrame);
		
		WebElement content = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		content.clear();
		content.sendKeys("bb bbyhd");
		
		
		
		driver.close();
		
	}
}
