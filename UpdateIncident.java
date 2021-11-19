package testNgAssignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClassIncident {
    @Test(dataProvider="SendData")
	public  void  runUpdate(String iframe, String table1, String table) {

		driver.findElement(By.xpath("(//a//div//div[text()='Incidents'])[1]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
		driver.findElement(By.xpath(table1)).click();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));
		WebElement findElement2 = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select dropDown = new Select(findElement2);
		dropDown.selectByVisibleText("1 - High");
		WebElement findElement3 = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select dropDown1 = new Select(findElement3);
		dropDown1.selectByVisibleText("In Progress");
		driver.findElement(By.xpath("(//button[text()=\"Update\"])[1]")).click();
		driver.findElement(By.xpath(table1)).click();
        driver.findElement(By.xpath("//option[text()=\"1 - High\"]")).isDisplayed();
        System.out.println("the priority is displayed");
        driver.findElement(By.xpath("//option[text()=\"In Progress\"]")).isDisplayed();
        System.out.println("the state is displayed");
		
	}
            
    @DataProvider
   	public String[][] SendData() throws IOException {
   	RunIncidentExcell re = new RunIncidentExcell();
   return re.readExcellData();
   	
   		
}}
