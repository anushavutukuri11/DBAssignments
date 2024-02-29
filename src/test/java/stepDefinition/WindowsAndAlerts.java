package stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WindowsAndAlertsPage;

public class WindowsAndAlerts {
	private static final Logger logger = LogManager.getLogger(WindowsAndAlerts.class.getName());

	WebDriver driver;

	@Given("Launch the chrome Browser to perform operations on windows and alerts in automation practice URL")
	public void launch_the_chrome_browser_to_perform_operations_on_windows_and_alerts_in_automation_practice_url() {
		driver = new ChromeDriver();
		logger.info("Chrome Driver is initialized");
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		logger.info("Practice website for Windows and Alerts is launched");
	}

	@SuppressWarnings("deprecation")
	@When("Perform the operations on Windows")
	public void perform_the_operations_on_windows() {
		WindowsAndAlertsPage WAPage = new WindowsAndAlertsPage(driver);
		WAPage.WindowHandle();
		logger.info("Clicked on Open Window button");
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				WebElement Image = driver.findElement(By.xpath("//a[@href='https://www.qaclickacademy.com']/img"));
				wait.until(ExpectedConditions.visibilityOf(Image));
				logger.info("Image is displayed");
			}

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.close();
		driver.switchTo().window(mainWindowHandle);

	}

	@And("Perform the opertaions on Alerts")
	public void Perform_the_opertaions_on_alerts() {
		WindowsAndAlertsPage WAPage = new WindowsAndAlertsPage(driver);
		WAPage.EnterTextinAlertTextbox();
		//WAPage.ValidatePromptAlert();
		//WAPage.ValidateConfirmAlert();
		WebElement AlertBtn = driver.findElement(By.xpath("//input[@id = 'alertbtn']"));
		WebElement ConfirmBtn = driver.findElement(By.xpath("//input[@id = 'confirmbtn']"));
			AlertBtn.click();
			Alert alert = driver.switchTo().alert();
			alert.getText();
			logger.info(alert.getText());
			alert.accept();
			ConfirmBtn.click();
			Alert alert1 = driver.switchTo().alert();
			alert1.getText();
			logger.info(alert1.getText());
			alert1.accept();
	}

	@Then("User is able to  quit the chrome browser")
	public void user_is_able_to_quit_the_chrome_browser() {
		driver.quit();
		logger.info("Browser is closed");
	}

}
