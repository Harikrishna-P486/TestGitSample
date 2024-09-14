package july09_2024;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Using_PropertyFile_ExtentReports {
	WebDriver driver ;
	Properties conpro;
	@BeforeMethod
	public void setUp() throws Throwable {
		conpro = new Properties();
		//load property file
		conpro.load(new FileInputStream("./Primus.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(conpro.getProperty("Url"));
		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys("Admin");
		driver.findElement(By.xpath(conpro.getProperty("ObjPass"))).sendKeys("Admin");
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
	}
	@Test
	public void branchCreation() throws Throwable {
		driver.findElement(By.xpath(conpro.getProperty("ObjBranch"))).click();	
		driver.findElement(By.xpath(conpro.getProperty("ObjNewBranch"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjBranchname"))).sendKeys("Punjab National Bank");
		driver.findElement(By.id(conpro.getProperty("ObjAddress1"))).sendKeys("Hyderabad");
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress2"))).sendKeys("srnagar");
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress3"))).sendKeys("Kukatpalli");
		driver.findElement(By.xpath(conpro.getProperty("ObjArea"))).sendKeys("Manikonds");
		driver.findElement(By.xpath(conpro.getProperty("ObjZip"))).sendKeys("12345");
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjCountry")))).selectByIndex(3);
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjState")))).selectByIndex(2);
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjCity")))).selectByIndex(1);
		driver.findElement(By.xpath(conpro.getProperty("ObjSubmit"))).click();
		String alertmessage = driver.switchTo().alert().getText();
		Reporter.log(alertmessage,true);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}

	@Test
	public void roleCreation() throws Throwable{
		driver.findElement(By.xpath(conpro.getProperty("ObjRole"))).click();	
		driver.findElement(By.xpath(conpro.getProperty("ObjNewRole"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjRoleName"))).sendKeys("Manager");
		driver.findElement(By.id(conpro.getProperty("ObjDesc"))).sendKeys("Working as Assitant Manager");
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjRoleType")))).selectByIndex(2);
		String alertmessage = driver.switchTo().alert().getText();
		Reporter.log(alertmessage , true);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}


	@AfterMethod
	public void tearDown()throws Throwable {
		driver.findElement(By.xpath(conpro.getProperty("Objlogout"))).click();
		Thread.sleep(4000);
		driver.quit();

	}



}
