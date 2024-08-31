package com.googlecloud.user;

import com.aventstack.extentreports.Status;
import googlecloud.pageObjects.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;

import org.testng.annotations.Parameters;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class GoogleCloud_01_Home extends BaseTest {
	private WebDriver driver;
	private String browserName, valueToSearch;
	private HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		this.browserName = browserName;
		valueToSearch = "BigQuery";

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openPageUrl(driver, "https://cloud.google.com");
	}
	
	@Test
	public void Home_01_Search(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Home_01_Search");
		ExtentTestManager.getTest().log(Status.INFO, "Home_01_Search - Step 01: Click to search button to open search textbox");
		homePage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Home_01_Search - Step 02: Enter to search textbox");
		homePage.enterToSearchTextbox(valueToSearch);

		ExtentTestManager.getTest().log(Status.INFO, "Home_01_Search - Step 03: Press Enter keyboard");
		homePage.pressEnterKeyBoard();

		ExtentTestManager.getTest().log(Status.INFO, "Home_01_Search - Step 04: Verify results");
		Assert.assertTrue(homePage.verifySearchResults(valueToSearch));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
