package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class WHLoginPage extends BasePage{
	
	private By LoginOption=By.xpath("//span[contains(text(),'Login')]");
	private By EmailId=By.name("em");
	private By Password=By.name("pw");
	private By LoginBtn=By.xpath("//span[contains(text(),'Login')]");
	WebDriverWait wait = new WebDriverWait(driver,30);

	public WHLoginPage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getLoginOption() {
		return getElement(LoginOption);
	}
	
	public WebElement getEmailId() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(EmailId));
		return getElement(EmailId);		
	}
	
	public WebElement getPassword() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		return getElement(Password);
	}
	
	public WebElement getLoginButton() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginBtn));
		return getElement(LoginBtn);
	}
	
	public InsuranceCompanyPage doLogin(String username, String password) {
		getLoginOption().click();
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(InsuranceCompanyPage.class);
	}
	
	

}
