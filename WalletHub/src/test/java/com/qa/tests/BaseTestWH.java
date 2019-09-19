package com.qa.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.base.BasePage;
import com.qa.base.Page;

public class BaseTestWH {
	
	WebDriver driver;
	WebDriverWait wait;
	public Page page;
	public Properties prop;
	public static String flash;
	String URL="http://wallethub.com/profile/test_insurance_company/";
	
	@BeforeMethod
	public void setUp() {
		
		try {
//		Properties obj = new Properties();					
//	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");									
//	    obj.load(objfile);
//		String browser=obj.getProperty("browser");
//		
//		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//			driver = new ChromeDriver();
//			} 
//		else if (browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//			}
		
		
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get(URL);
				
		page=new BasePage(driver, wait);
		}
		
		catch(NoSuchElementException e) {
			System.out.println("Error NoSuchElementException");
		}
		catch(Exception e) {
			System.out.println("Error Exception" + e);
		}
		
		
		
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
