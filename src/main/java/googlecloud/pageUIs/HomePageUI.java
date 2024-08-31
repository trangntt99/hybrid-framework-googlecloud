package googlecloud.pageUIs;

public class HomePageUI {
	public final String SEARCH_BUTTON = "xpath=//form[@data-search-trailing-icon='send_spark']/parent::div/preceding-sibling::div";
	public final String SEARCH_TEXTBOX = "xpath=//form[@data-search-trailing-icon='send_spark']//input[@aria-label='Search']";
	public final String SEARCH_RESULTS_CONTENT = "xpath=//a[@track-type='search-result']/parent::div/following-sibling::div[last()]";
}
