package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.InsuranceCompanyPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.WHLoginPage;
import com.qa.pages.WriteReviewPage;

public class WHTest extends BaseTestWH {

	String WHUsername = "rajuspi@gmail.com";
	String WHPassword = "Rajuwallethub!1";

	@Test(priority = 2, description = "login test with correct username and correct password....")
	public void WH() throws InterruptedException {

		// Please Don't share this Credentials with anyone
		page.getInstance(WHLoginPage.class).doLogin(WHUsername, WHPassword);

		// Rating is done by hover and clicking
		page.getInstance(InsuranceCompanyPage.class).Review();

		// Selecting a policy from drop down and Writing a Review
		page.getInstance(WriteReviewPage.class).WriteReview();

		// Validation
		String bodyText = page.getInstance(WriteReviewPage.class).ConfirmationMsg();
		Assert.assertTrue(bodyText.contains(bodyText), "you have reviewed the institution");

		page.getInstance(ProfilePage.class).ProfileV();

		// Validation
		String BodyText = page.getInstance(ProfilePage.class).PostConfirmation();
		Assert.assertTrue(BodyText.contains(BodyText), "Review is not showing in profile/review page, Failing Test!");
		System.out.println("Posted review is showing in profile/review page, Passing Test!");

	}

}
