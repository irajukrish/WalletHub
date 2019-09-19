package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class FBHomePage extends BasePage{
	
	private By Status=By.name("xhpc_message"); 
	private By Postbtn=By.xpath("//*[@class='_45wg _69yt']/button");
	WebDriverWait wait = new WebDriverWait(driver,30);
	private By Post=By.xpath("//p[contains(text(),'Hello World')]");

	public FBHomePage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
	}
	
	public WebElement getStatusArea() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Status));
		return getElement(Status);
	}
	
	public WebElement getPostbutton() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Postbtn));
		return getElement(Postbtn);
	}
	
	public WebElement getPost() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Post));
		return getElement(Post);
	}
	
	
	
	public void AddStatus() throws InterruptedException {
		
		getStatusArea().click();
		getStatusArea().sendKeys("Hello World");
		getPostbutton().click();
		
	}
	
	public String VerifyStatus() {
		
		return getPost().getText();
		
	}

}
