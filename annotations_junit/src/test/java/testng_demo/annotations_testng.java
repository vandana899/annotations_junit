package testng_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class annotations_testng {
	WebDriver driver;
	public String Title;
	public String Url="https://www.google.com";
	
@BeforeTest
public void BT()
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(Url);
		
}
@Test(priority=0)
public void apple()
{
	Title = driver.getTitle();
	Assert.assertEquals("vandana", "raheja");
}
@Test(priority=1,dependsOnMethods="apple",alwaysRun=true)
public void bat()
{
	Title = driver.getCurrentUrl();
	
}
@Test
public void car()
{
	Title = driver.getCurrentUrl();
	
}
@AfterTest
public void AT()
{	
	driver.close();
}
}

