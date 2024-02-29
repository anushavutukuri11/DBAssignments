package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class HandlingTablesPage {

	WebDriver driver;
	CommonUtils commonUtils;

	public HandlingTablesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);

	}

	@FindBy(xpath = "//span[text()='Demo Webtable 1 (Static Table)']")
	private WebElement StaticTable;

	@FindBy(xpath = "//span[text() = 'Demo Webtable 2 (Dynamic Table)']")
	private WebElement DynamicTable;

	public void ScrollToStaticTable() {
		commonUtils.ScrolltoElement(StaticTable);

	}

	public void ScrollToDynamicTable() {
		commonUtils.ScrolltoElement(DynamicTable);

	}

}
