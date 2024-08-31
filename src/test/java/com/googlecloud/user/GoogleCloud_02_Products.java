package com.googlecloud.user;

import com.aventstack.extentreports.Status;
import googlecloud.pageObjects.ProductsPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commons.BaseTest;
import commons.PageGeneratorManager;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class GoogleCloud_02_Products extends BaseTest {
	private WebDriver driver;
	private String browserName, valueToSearch;
	private String[] sections = {"Featured products", "Business Intelligence", "Data Analytics"};
	private ProductsPageObject productsPage;
	
	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		this.browserName = browserName;
		valueToSearch = "BigQuery";

		productsPage = PageGeneratorManager.getProductsPage(driver);
		productsPage.openPageUrl(driver, "https://cloud.google.com/products");
	}

	@Test
	public void Products_01_Search(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Products_01_Search");

		ExtentTestManager.getTest().log(Status.INFO, "Products_01_Search - Step 01: Enter to search textbox");
		productsPage.enterToSearchTextbox(valueToSearch);

		ExtentTestManager.getTest().log(Status.INFO, "Products_01_Search - Step 02: Press Enter keyboard");
		productsPage.pressEnterKeyBoard();

		ExtentTestManager.getTest().log(Status.INFO, "Products_01_Search - Step 03: Verify results");
		Assert.assertTrue(productsPage.verifySearchResults(valueToSearch));
	}

	@Test
	public void Products_02_Filter_One_Item(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Products_02_Filter_One_Item");

		ExtentTestManager.getTest().log(Status.INFO, "Products_02_Filter - Step 01: Enter to search textbox");
		productsPage.clearSearchTextBox();

		ExtentTestManager.getTest().log(Status.INFO, "Products_02_Filter - Step 02: Filter by [" + sections[0] + "]");
		productsPage.filterBy(sections[0]);

		ExtentTestManager.getTest().log(Status.INFO, "Products_02_Filter - Step 03: Verify the header section");
		Assert.assertTrue(productsPage.isHeaderSectionDisplayed(sections[0]));

		ExtentTestManager.getTest().log(Status.INFO, "Products_02_Filter - Step 04: Verify the number of displayed section");
		Assert.assertEquals(productsPage.getNumberOfSectionContent(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Products_02_Filter - Step 05: Clear all filters");
		productsPage.clearAllFilters();
	}
	
	@Test
	public void Products_03_Filter_More_Than_One_Item(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Products_03_Filter_More_Than_One_Item");

		ExtentTestManager.getTest().log(Status.INFO, "Products_03_Filter_More_Than_One_Item - Step 01: Filter and verify the header section");
		for (String section : sections) {
			productsPage.filterBy(section);
			Assert.assertTrue(productsPage.isHeaderSectionDisplayed(section));
		}

		ExtentTestManager.getTest().log(Status.INFO, "Products_03_Filter_More_Than_One_Item - Step 02: Verify the number of displayed section");
		Assert.assertEquals(productsPage.getNumberOfSectionContent(), sections.length);

		ExtentTestManager.getTest().log(Status.INFO, "Products_03_Filter_More_Than_One_Item - Step 03: Clear all filters");
		productsPage.clearAllFilters();
	}
	
	@Test
	public void Products_04_Search_And_Filter(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Products_04_Search_And_Filter");

		ExtentTestManager.getTest().log(Status.INFO, "Products_04_Search_And_Filter - Step 01: Filter by [" + sections[0] + "]");
		productsPage.filterBy(sections[0]);

		ExtentTestManager.getTest().log(Status.INFO, "Products_04_Search_And_Filter - Step 02: Enter to search textbox");
		productsPage.enterToSearchTextbox(valueToSearch);

		ExtentTestManager.getTest().log(Status.INFO, "Products_04_Search_And_Filter - Step 03: Press Enter keyboard");
		productsPage.pressEnterKeyBoard();

		ExtentTestManager.getTest().log(Status.INFO, "Products_04_Search_And_Filter - Step 04: Verify the header section [" + sections[0] + "]");
		Assert.assertTrue(productsPage.isHeaderSectionDisplayed(sections[0]));

		ExtentTestManager.getTest().log(Status.INFO, "Products_04_Search_And_Filter - Step 05: Verify the number of displayed section");
		Assert.assertEquals(productsPage.getNumberOfSectionContent(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Products_04_Search_And_Filter - Step 06: Verify results");
		Assert.assertTrue(productsPage.verifySearchResults(valueToSearch));
	}
	
	@Test
	public void Products_05_Navigate_To_Page_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Products_05_Navigate_To_Page_Details");

		ExtentTestManager.getTest().log(Status.INFO, "Products_05_Navigate_To_Page_Details - Step 01 - Navigate to page details");
		String linkText = productsPage.getLinkText(sections[0], valueToSearch);
		productsPage.navigateToPageDetails(sections[0], valueToSearch);

		ExtentTestManager.getTest().log(Status.INFO, "Products_05_Navigate_To_Page_Details - Step 02 - Verify url");
		Assert.assertEquals(driver.getCurrentUrl(), linkText);
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
