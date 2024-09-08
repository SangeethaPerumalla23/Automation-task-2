package Excel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Facebook {
WebDriver driver;

@Test(dataProvider = "LoginData",dataProviderClass =ExcelDataSuppliers.class)
  
   void testlogin(String Username, String Password ) {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
	driver.findElement(By.xpath("//button[@name='login']")).click();
	
	
	   
   }
}

