package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class InsuranceCompanyPage extends BasePage{
	
	
	private By whatsYourRating=By.xpath("(//review-star[@class='rvs-svg']//*[@class='rvs-star-svg'])[4]");
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public InsuranceCompanyPage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
	}
	
	public WebElement getRating() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(whatsYourRating));
		Thread.sleep(2000);
		return getElement(whatsYourRating);		
	}
	
	public WriteReviewPage Review() throws InterruptedException {
		
		Actions action=new Actions(driver);
		for (int i=1; i<=4;i++) {
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(By.xpath("(//review-star[@class='rvs-svg']//*[@class='rvs-star-svg'])["+i+"]"))).build().perform();
			
		}		
		getRating().click();
		
		return getInstance(WriteReviewPage.class);
		
	}
	
	

}
