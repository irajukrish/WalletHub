package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Page(WebDriver _driver, WebDriverWait _wait) {
		this.driver=_driver;
		this.wait=_wait;
	}
	

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver,this.wait);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);

	
	
	
	
}
