package testNgAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssigningIncident extends BaseClassIncident {
    @Test(dataProvider="SendData")
	public  void runAssign(String iframe, String table, String table1 ) throws InterruptedException {

		driver.findElement(By.xpath("(//div[text()=\"Open\"])[1]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
		driver.findElement(By.xpath(table)).click();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[5]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
		WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		findElement2.sendKeys("software");
		findElement2.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//tbody//td//a[text()=\"Software\"]")).click();
		driver.switchTo().window(arrayList.get(0));
		driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
		driver.findElement(By.xpath("(//button[text()=\"Update\"])[1]")).click();
		driver.findElement(By.xpath("(//tbody//td//a[text()=\"Software\"])[1]")).isDisplayed();
		System.out.println("the software is verified");
		}
    @DataProvider
   	public String[][] SendData() throws IOException {
   	RunIncidentExcell re = new RunIncidentExcell();
   return re.readExcellData();
   	
    }

}
