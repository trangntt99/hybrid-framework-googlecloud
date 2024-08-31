package commons;

import org.openqa.selenium.WebDriver;

public class BaseElement extends BasePage {
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}
}
