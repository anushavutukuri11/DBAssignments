package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleSearchPage;

public class GoogleSearch {
	private static final Logger logger = LogManager.getLogger(GoogleSearch.class.getName());

	WebDriver driver;

	@Given("Launch the chrome Browser to perform search operations")
	public void launch_the_chrome_browser_to_perform_search_operations() {
		driver = new ChromeDriver();
		logger.info("Chrome Driver is initialized");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		logger.info("Google search page is displayed");
	}

	@SuppressWarnings("deprecation")
	@When("Perform the search action the search bar")
	public void perform_the_search_action_the_search_bar() {

		GoogleSearchPage GPage = new GoogleSearchPage(driver);
		GPage.EnterTextinSearchBar();
		logger.info("Valid text is entered in to the Search bar");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
	}

	@And("Print the respective suggestion and click the respective suggestion")
	public void print_the_respective_suggestion_and_click_the_respective_suggestion() {
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class = 'wM6W7d']/span"));
		System.out.println(suggestions.size());

		for (int i = 0; i < suggestions.size(); i++) {

			logger.info("Search suggestions  " + suggestions.get(i).getText());
			if (suggestions.get(i).getText().contains("selenium tutorial")) {
				Actions action  = new Actions(driver);
				action.moveToElement(suggestions.get(i)).build().perform();
				suggestions.get(i).click();
				logger.info("Selenium tutorial is clicked");
				break;
			}
		}

	}

	@Then("User is quit the  chrome browser")
	public void user_is_quit_the_chrome_browser() {
		driver.quit();
		logger.info("Browser is closed");
	}

}
