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
import org.testng.annotations.BeforeTest;

import com.qa.base.BasePage;
import com.qa.base.Page;

public class BaseTestWH {
	
	WebDriver driver;
	WebDriverWait wait;
	public Page page;
	public Properties prop;
	public static String flash;
	
	@BeforeMethod
	public void setUp() {
		
		try {

			String browser=prop.getProperty("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
				driver = new ChromeDriver(options);
				} 
			else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				}
		
			
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//driver.get("http://wallethub.com/profile/test_insurance_company/");
		
		driver.get(prop.getProperty("WHURL"));		
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
	
	@BeforeTest
	public Properties initialize_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configs\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error in the code");
			e.printStackTrace();
		}

		return prop;
	}
	
	


}
