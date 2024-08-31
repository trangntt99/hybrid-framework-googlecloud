package googlecloud.pageObjects;

import java.util.List;

import googlecloud.pageUIs.ProductPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BaseElement;

public class ProductsPageObject extends BaseElement {
	WebDriver driver;
	ProductPageUI productPageUI;
	
	public ProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		productPageUI = new ProductPageUI();
	}

	public void enterToSearchTextbox(String valueToSend) {
		waitForElementVisible(driver, productPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, productPageUI.SEARCH_TEXTBOX, valueToSend);
	}

	public void pressEnterKeyBoard() {
		waitForElementVisible(driver, productPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, productPageUI.SEARCH_TEXTBOX, Keys.ENTER);
	}

	public boolean verifySearchResults(String value) {
		waitForListElementVisible(driver, productPageUI.SEARCH_RESULTS);
		List<WebElement> results = getListWebElement(driver, productPageUI.SEARCH_RESULTS);
		
		for (WebElement element : results) {
			if (!element.getText().contains(value)) {
				System.out.println(element.getText());
				return false;
			}
		}
		return true;
	}

	public void clearSearchTextBox() {
		waitForElementClickable(driver, productPageUI.CLEAR_BUTTON_IN_SEARCH_FORM);
		clickToElement(driver, productPageUI.CLEAR_BUTTON_IN_SEARCH_FORM);
		sleepInSeconds(5);
	}

	public void filterBy(String section) {
		waitForElementClickable(driver, productPageUI.FILTER_BY_DYNAMIC_CONTENT, section.toLowerCase());
		clickToElement(driver, productPageUI.FILTER_BY_DYNAMIC_CONTENT, section.toLowerCase());
	}

	public boolean isHeaderSectionDisplayed(String section) {
		return isElementDisplayed(driver, productPageUI.HEADER_SECTION, section);
	}

	public int getNumberOfSectionContent() {
		waitForListElementVisible(driver, productPageUI.NUMBER_OF_SECTION_DATA);
		return getListElementSize(driver, productPageUI.NUMBER_OF_SECTION_DATA);
	}

	public void clearAllFilters() {
		waitForElementClickable(driver, productPageUI.CLEAR_ALL_FILTERS_BUTTON);
		clickToElement(driver, productPageUI.CLEAR_ALL_FILTERS_BUTTON);
	}
	
	public String getLinkText(String section, String value) {
		waitForElementVisible(driver, productPageUI.LINK_TEXT_BY_SEARCH_AND_FILTER, section, value.toLowerCase());
		return getElementAttribute(driver, productPageUI.LINK_TEXT_BY_SEARCH_AND_FILTER, "href", section, value.toLowerCase());
	}

	public void navigateToPageDetails(String section, String value) {
		waitForElementClickable(driver, productPageUI.LINK_TEXT_BY_SEARCH_AND_FILTER, section, value.toLowerCase());
		clickToElement(driver, productPageUI.LINK_TEXT_BY_SEARCH_AND_FILTER, section, value.toLowerCase());
	}
}
