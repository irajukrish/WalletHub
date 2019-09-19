package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.Page;
import com.qa.pages.FBLoginPage;
import com.qa.pages.FBHomePage;

public class FBTest extends BaseTest {
	
	String FBUserName="rajendrankrish@yahoo.com";
	String FBPassword="dhanushraj";
	
	@Test(priority = 1, description = "login test with correct username and correct password....")
	public void FB() throws InterruptedException {
		
		//Please Don't share this Credentials with anyone
		page.getInstance(FBLoginPage.class).doLogin(FBUserName, FBPassword);
		
		//Add Status Hello world
		page.getInstance(FBHomePage.class).AddStatus();
		
		
		//Verify the Status
		String Post=page.getInstance(FBHomePage.class).VerifyStatus();
		Assert.assertEquals(Post, "Hello World");
		
		
	}
	
	

}
