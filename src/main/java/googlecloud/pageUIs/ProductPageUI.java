package googlecloud.pageUIs;

public class ProductPageUI {
	public final String SEARCH_TEXTBOX = "xpath=//form[@data-search-trailing-icon='send']//input[@aria-label='Search']";
	public final String SEARCH_RESULTS = "xpath=//a[@track-metadata-module='directory page details' and not(@track-name='learn more')]";
	public final String CLEAR_BUTTON_IN_SEARCH_FORM = "xpath=//i[text()='close']";
	public final String FILTER_BY_DYNAMIC_CONTENT = "xpath=//li[@track-name='%s']";
	public final String NUMBER_OF_SECTION_DATA = "xpath=//section[@class='cws-jump-section']";
	public final String HEADER_SECTION = "xpath=//section[@class='cws-jump-section']//div[contains(text(),'%s')]";
	public final String CLEAR_ALL_FILTERS_BUTTON = "xpath=//button[text()='Clear all']";
	public final String LINK_TEXT_BY_SEARCH_AND_FILTER = "xpath=//section[@data-cws-menu-text='%s']//a[@track-name='%s']";
}
