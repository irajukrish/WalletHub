package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page{
	
	

	public BasePage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		
		return driver.findElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
		return driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("Some exception occurred while locating an element " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e) {
			System.out.println("Some exception occurred while waiting for an element " + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e) {
			System.out.println("Some exception occurred while waiting for an element " + title.toString());
			e.printStackTrace();
		}
	}
	
	

}
