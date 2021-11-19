package testNgAssignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenproject.Excell;
public class CreateLead extends BaseClass {
	@Test(dataProvider="provideData")
	public  void runCreate(String company,String firstname,String lastname,String phnno) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnno);
		driver.findElement(By.name("submitButton")).click();

}   @DataProvider
	public String[][] provideData() throws IOException {
	RunCreateExcell re = new RunCreateExcell();
		//String[][] readData = re.readData();
		return re.readData("CreateExcell");
	}
	
	
	 }









