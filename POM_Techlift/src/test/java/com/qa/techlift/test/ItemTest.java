package com.qa.techlift.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.techlift.pages.DeskPage;
import com.qa.techlift.pages.HomePage;
import com.qa.techlift.pages.ItemPage;
import com.qa.techlift.pages.LoginPage;
import com.qa.techlift.pages.SelleingPage;
import com.qa.techlift.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class ItemTest extends TestBase{
	HomePage homePageObj;
	LoginPage loginPageObj;
	ItemPage itemPageObj;
	DeskPage deskPageObj;
	SelleingPage sellingPageObj;
	
	public ItemTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		System.out.println("i am under before test");
		homePageObj=new HomePage();
		loginPageObj = new LoginPage();
		deskPageObj = new DeskPage();
		sellingPageObj= new SelleingPage();
	}

	@Test(priority=4)
	public void verifyNewItemCreation()
	{
		test = report.startTest("verifyNewItemCreation");
		homePageObj.clickOnLogin();
		test.log(LogStatus.INFO, "login link click");
		loginPageObj.login("testology.qa.learning@gmail.com", "Testology@123");
		test.log(LogStatus.INFO, "Login page");
		deskPageObj.clickOnSellingModule();
		
		test.log(LogStatus.INFO, "Navigate to selling module");
		sellingPageObj.clickOnItem();
		test.log(LogStatus.INFO, "Navigate to item page");
		test.log(LogStatus.PASS, "Chacked page title");
		
	}
	
		
}
