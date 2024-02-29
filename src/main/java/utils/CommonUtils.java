package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	WebDriver driver;
	//WebElement webElement;

	public CommonUtils(WebDriver driver) {

		this.driver = driver;
			}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForWebElement(element,durationInSeconds);
		webElement.click();

	}

	public void enterText(WebElement element, String text,long durationInSeconds) {
		WebElement webElement = waitForWebElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);

	}
	public void ScrolltoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void selectValueInDropdown(WebElement element, String value, long durationInSeconds) {
		WebElement webElement = waitForWebElement(element,durationInSeconds);
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}
	
	public WebElement waitForWebElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}
}
