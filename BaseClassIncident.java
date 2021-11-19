package testNgAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassIncident {
     public static  ChromeDriver driver;
     @Parameters({"url","username","password"})
     @BeforeMethod
	public void preCondition(String url  , String uname, String pword) {
        WebDriverManager.chromedriver().setup();	
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
		driver.findElement(By.xpath("//html[@class='ltr date-calendar tabbed']//input[@type='text']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pword);
		driver.findElement(By.id("sysverb_login")).click();
		WebElement findElement = driver.findElement(By.xpath("//input[@id='filter']"));
		findElement.sendKeys("Incident");
		findElement.sendKeys(Keys.ENTER);
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
