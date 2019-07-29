package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportTest 
{
	public static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void googleTitleTest()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority=2)
	public void googleLogoTest()
	{
		boolean googleLogo=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		//Assert.assertEquals(googleLogo, true);
		Assert.assertTrue(googleLogo, "Google logo is not matched");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
