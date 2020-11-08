package com.qa.techlift.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.techlift.pages.HomePage;
import com.qa.techlift.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class HomeTest extends TestBase{

	HomePage homePageObj;
	public HomeTest() {
		super();
		initialization();
	}
	
	
	@Test(priority =1)
	public void verifyHomePageTitle()
	{
		test = report.startTest("verifyHomePageTitle");
		homePageObj= new HomePage();
		test.log(LogStatus.INFO, "Homepage openend ");
		String ActualTitle = homePageObj.getPageTitle();
		test.log(LogStatus.INFO, "Chacking page title");
		Assert.assertTrue("Techlift Test".equals(ActualTitle));	
		test.log(LogStatus.PASS, "page title displayed");
	}
	
	@Test(priority=2)
	public void verifyCopyRight()
	{
		test = report.startTest("verifyCopyRight");
		boolean copyrightPresentCheck= homePageObj.validateFooterCopyright(); 
		Assert.assertTrue(copyrightPresentCheck,"copyright not displayed");
		test.log(LogStatus.PASS, "page title checked");
		
	}

	
	
}
