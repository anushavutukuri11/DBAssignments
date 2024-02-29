package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;

public class EcommWebsitePage {
	WebDriver driver;
	private CommonUtils commonUtils;

	public EcommWebsitePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);

	}

	@FindBy(xpath = "//span[text() = 'Gear']")
	private WebElement GearDropdown;

	@FindBy(xpath = "//a[text() = 'Bags']")
	private WebElement GearDropdown_Bags;

	@FindBy(xpath = "//div[@class='products wrapper grid products-grid']/ol/li[1]/div")
	private WebElement Product1;

	@FindBy(xpath = "//span[text() = 'Add to Cart']")
	private WebElement addCartBtn;

	public void selectProduct() {
		GearDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(GearDropdown_Bags));
		GearDropdown_Bags.click();
	}

	public void addToCart() {
		Product1.click();
		addCartBtn.click();

	}

}
