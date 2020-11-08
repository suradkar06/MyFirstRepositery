package com.qa.techlift.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.techlift.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports report;

	
	public TestBase(){
		prop=new Properties();
		try {
		FileInputStream fi = new FileInputStream("D:\\Selenium practise\\POM_Techlift\\src\\main\\java\\com\\qa\\techlift\\config\\config.properties");
		prop.load(fi);
		}catch(FileNotFoundException f)
		{
			f.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@BeforeSuite
	public void initialization(){
		report = new ExtentReports("D:\\Selenium practise\\POM_Techlift\\ExtentReportResults.html");
		String testBrowser=prop.getProperty("browser");
		if(testBrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium practise\\POM_Techlift\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		if(testBrowser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver(); 
		}
		
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		String testURL= prop.getProperty("url");
		driver.get(testURL);
	}
	@AfterSuite
	public void endtest()
	{
	//	driver.close();
		report.endTest(test);
		report.flush();
	}
	
	
}