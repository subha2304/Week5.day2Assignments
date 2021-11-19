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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewIncident  extends BaseClassIncident {
    @Test(dataProvider="SendData")
	public  void  runNew( String iframe,String table1, String table) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
		driver.findElement(By.xpath("(//div[@id='incident.form_scroll']//div//span[@class='icon icon-search'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
		driver.findElement(By.xpath("(//tbody//td//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(arrayList.get(0));
		driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
		
		driver.findElement(By.xpath("//div[@id='incident.form_scroll']//div//input[@id='incident.short_description']")).sendKeys("hello");
		String attribute = driver.findElement(By.xpath("(//div[@id='incident.form_scroll']//input[@type='text'])[1]")).getAttribute("value");
		
		driver.findElement(By.xpath("(//button[text()=\"Submit\"])[1]")).click();
		Thread.sleep(2000);
		
		WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		findElement2.sendKeys(attribute);
		findElement2.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(table1)).isDisplayed();
		System.out.println("the instance is created");
		}
    @DataProvider
   	public String[][] SendData() throws IOException {
   	RunIncidentExcell re = new RunIncidentExcell();
   return re.readExcellData();
    }
}
