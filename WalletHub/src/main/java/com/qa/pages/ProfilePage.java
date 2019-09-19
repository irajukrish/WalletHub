package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class ProfilePage extends BasePage{
	
	private By userName=By.xpath("(//span[contains(text(),'Rajendran')])[1]");
	private By Profile=By.xpath("(//a[contains(text(),'Profile')])[1]");	
	private By Comment=By.xpath("//p[@class='pr-rec-type']");
	Actions action=new Actions(driver);
	static String review_verification_url="https://wallethub.com/profile/username/reviews/";
	

	public ProfilePage(WebDriver _driver, WebDriverWait _wait) {
		super(_driver, _wait);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement UserName() {
		return getElement(userName);
	}
	
	public WebElement profile() {
		return getElement(Profile);
	}
	
	public WebElement comment() {
		return getElement(Comment);
	}
	
	public String ProfileV() {
		
		action.moveToElement(UserName()).moveToElement(profile()).click().build().perform();
		System.out.println(comment().getText());
		return comment().getText();
		
	}
	
	public String PostConfirmation() {
		driver.navigate().to(review_verification_url);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText;
		
	}

}
