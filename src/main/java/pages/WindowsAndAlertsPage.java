package pages;

import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class WindowsAndAlertsPage {
	
	WebDriver driver;
	CommonUtils commonUtils;

	public WindowsAndAlertsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);

	}

	@FindBy(xpath = "//button[@id = 'openwindow']")
	private WebElement WindowHandleBtn;

	@FindBy(xpath = "//input[@name = 'enter-name']")
	private WebElement AlertTextBox;

	@FindBy(xpath = "//input[@id = 'alertbtn']")
	private WebElement AlertBtn;

	@FindBy(xpath = "//input[@id = 'confirmbtn']")
	private WebElement ConfirmBtn;

	public void WindowHandle() {
		commonUtils.ScrolltoElement(WindowHandleBtn);
		commonUtils.clickOnElement(WindowHandleBtn, 30);

	}

	public void EnterTextinAlertTextbox() {
		AlertTextBox.sendKeys("Test");
	}

	public void ValidatePromptAlert() {
		AlertBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		System.out.println(alert.getText());
		
		alert.accept();

	}

	public void ValidateConfirmAlert() {
		ConfirmBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();

	}

}
