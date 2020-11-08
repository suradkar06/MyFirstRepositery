package com.qa.techlift.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.techlift.testbase.TestBase;


public class ItemPage extends TestBase{
	
	public ItemPage() {
		PageFactory.initElements(driver, this);
	}

}
