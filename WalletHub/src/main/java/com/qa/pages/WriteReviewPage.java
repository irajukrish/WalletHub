package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class WriteReviewPage extends BasePage {
	
	private By categorydropdown=By.xpath("(//span[@class='dropdown-placeholder'])[2]");
	private By selectHI=By.xpath("//ul/*[contains(text(),'Health Insurance')]");
	private By writeYourReview=By.xpath("//div/textarea[starts-with(@class, 'textarea')]");
	private By submitBtn=By.xpath("//div[contains(text(),'Submit')]");
	private By continueBtn=By.xpath("//div[contains(text(),'Continue')]");	
	private By confirmationmsg=By.xpath("//div[contains(text(),'you have reviewed the institution')]");	
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public WriteReviewPage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
	}
	
	public WebElement getCategory() {
		return getElement(categorydropdown);
	}
	
	public WebElement getSelectHI() {
		return getElement(selectHI);
	}
	
	public WebElement getWriteYourReview() {
		return getElement(writeYourReview);
	}
	
	public WebElement getSubmitBtn() {
		return getElement(submitBtn);
	}
	
	public WebElement getContinueBtn() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn));
		return getElement(continueBtn);
	}

	public ProfilePage WriteReview() {
		
		getWriteYourReview().sendKeys("Health Insurance is a kind of insurance that provides coverage for medical expenses "
				+ "to the policy holder. Depending on the health insurance plan chosen the policy holder can get coverage "
				+ "for critical illness expenses, surgical expenses, hospital expenses etc.");
		
		getCategory().click();
		getSelectHI().click();
		getSubmitBtn().click();
		getContinueBtn().click();
		
		return getInstance(ProfilePage.class);
		
	}
	
	public WebElement getConfirmationMessage() {
		return getElement(confirmationmsg);	
	}

	public String ConfirmationMsg() {
		return driver.findElement(By.tagName("body")).getText();
		
	}	
	
	

}
