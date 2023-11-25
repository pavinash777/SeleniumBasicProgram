import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class LaunchCromeBrowser {

	@Test
	public void launchChromeBrowser() {
		//chromedriver setup
		WebDriverManager.chromedriver().setup();
		//WebDriver initialization
		WebDriver driver = new ChromeDriver();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximize window
		driver.manage().window().maximize();
		//Launch Browser and Open URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//verify by Title
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		
		//Asserttion
		Assert.assertEquals(expTitle, actTitle, "Test Case Pass");
		//Browser close
		driver.close();
	}
	
	
}
