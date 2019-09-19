package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class FBLoginPage extends BasePage{


	private By EmailId=By.id("email");
	private By Password=By.id("pass");
	private By logInButton=By.xpath("//input[@value='Log In']");
	private By header=By.xpath("");
	
	public FBLoginPage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getEmailId() {
		return getElement(EmailId);		
	}
	
	public WebElement getPassword() {
		return getElement(Password);
	}
	
	public WebElement getLoginButton() {
		return getElement(logInButton);
	}
	
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public void getLoginPageHeader() {
		getPageHeader(header);
	}
	
	public FBHomePage doLogin(String username, String password) {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(FBHomePage.class);
	}


}
