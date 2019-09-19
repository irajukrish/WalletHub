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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.base.BasePage;
import com.qa.base.Page;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	public Page page;
	public Properties prop;

	@BeforeMethod
	public void setUp() {

		try {

//		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//			driver = new ChromeDriver();
//			} 
//		else if (browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//			}

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get("https://www.facebook.com/");
			page = new BasePage(driver, wait);
		}

		catch (NoSuchElementException e) {
			System.out.println("Error NoSuchElementException");
		} 
		
		catch (Exception e) {
			System.out.println("Error Exception" + e);
		}

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	public Properties initialize_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
