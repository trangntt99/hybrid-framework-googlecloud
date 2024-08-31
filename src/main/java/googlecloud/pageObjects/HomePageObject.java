package googlecloud.pageObjects;

import java.util.List;
import java.util.Locale;

import googlecloud.pageUIs.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BaseElement;

public class HomePageObject extends BaseElement {
	WebDriver driver;
	HomePageUI homePageUI;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		homePageUI = new HomePageUI();
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, homePageUI.SEARCH_BUTTON);
		clickToElementByJS(driver, homePageUI.SEARCH_BUTTON);
	}

	public void enterToSearchTextbox(String valueToSend) {
		waitForElementVisible(driver, homePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, homePageUI.SEARCH_TEXTBOX, valueToSend);
	}

	public void pressEnterKeyBoard() {
		waitForElementVisible(driver, homePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, homePageUI.SEARCH_TEXTBOX, Keys.ENTER);
	}

	public boolean verifySearchResults(String valueToSearch) {
		waitForListElementVisible(driver, homePageUI.SEARCH_RESULTS_CONTENT);
		List<WebElement> results = getListWebElement(driver, homePageUI.SEARCH_RESULTS_CONTENT);
		String[] values = valueToSearch.split(" ");

		for (WebElement element : results) {
			boolean checked = false;
			for(String value : values) {
				if (element.getText().contains(value) || element.getText().contains(value.toLowerCase()) || element.getText().contains(value.toUpperCase())) {
					checked	= true;
					break;
				}
			}

			if (!checked) {
				return false;
            }
		}
		return true;
	}
}
