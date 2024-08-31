package commons;

import googlecloud.pageObjects.HomePageObject;
import googlecloud.pageObjects.ProductsPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static ProductsPageObject getProductsPage(WebDriver driver) {
		return new ProductsPageObject(driver);
	}
}
