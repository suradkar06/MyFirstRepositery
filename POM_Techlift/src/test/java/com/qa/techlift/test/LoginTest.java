package com.qa.techlift.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.techlift.pages.HomePage;
import com.qa.techlift.pages.LoginPage;
import com.qa.techlift.testbase.TestBase;
import com.qa.techlift.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;



public class LoginTest extends TestBase {

	HomePage homePageObj;
	LoginPage loginPageObj;
	
	public LoginTest() {
		super();
		initialization();
	}
	
	@Test(priority=3)
	public void verifysuccessfullLogin() throws InterruptedException
	{
		test = report.startTest("verifysuccessfullLogin");
		// go to home page
		homePageObj= new HomePage();
		test.log(LogStatus.INFO, "on home page");
		// go to login  page by clciking onm login link
		homePageObj.clickOnLogin();
		
		loginPageObj = new LoginPage();
		test.log(LogStatus.INFO, "login done");
		// specify userid nad password and click on submit
		loginPageObj.loginWithValidValues();
	
		Utility.waitForPageLoad();
		Thread.sleep(5000);
		// verify whether user has navigated to desk page
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		test.log(LogStatus.INFO, "Verifying current url");
		Assert.assertTrue(currentUrl.contains("test.techlift.in/desk"), "not navigated to dek page");
		test.log(LogStatus.PASS, "Chacked page title");
	}
	
	/*public void logout() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Logout")).click();
	}*/
	
}
