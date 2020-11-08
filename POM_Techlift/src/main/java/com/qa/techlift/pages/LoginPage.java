package com.qa.techlift.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.techlift.testbase.TestBase;



public class LoginPage extends TestBase{

	// webelement loginLink= driver.findelement(By.linktext("Login"))
	@FindBy(how=How.ID, using= "login_email")
	public WebElement emailTxtBox;
	
	@FindBy(how=How.ID, using= "login_password")
	public WebElement passwordTxtBox;
	
	@FindBy(how=How.CSS, using= "button[type='submit']")
	public WebElement submitBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public void login(String u, String p) {
		emailTxtBox.sendKeys(u);
		passwordTxtBox.sendKeys(p);
		submitBtn.click();
	}
	
	public void loginWithValidValues()
	{
		emailTxtBox.sendKeys(prop.getProperty("user"));
		passwordTxtBox.sendKeys(prop.getProperty("password"));
		submitBtn.click();
	}
	
}
