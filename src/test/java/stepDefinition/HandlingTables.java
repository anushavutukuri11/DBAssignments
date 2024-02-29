package stepDefinition;

import java.time.Duration;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HandlingTablesPage;

import org.openqa.selenium.WebDriver;

public class HandlingTables {

	private static final Logger logger = LogManager.getLogger(HandlingTables.class.getName());

	WebDriver driver;

	@Given("Launch the chrome Browser with Demotables URL")
	public void launch_the_chrome_browser_with_demotables_url() {
		driver = new ChromeDriver();
		logger.info("Chrome Driver is initialized");
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		logger.info("Demo Web Tables page is launched");
	}

	@And("Perform the actions on the static webtable")
	public void perform_the_actions_on_the_static_webtable() {
		HandlingTablesPage handlingTablesPage = new HandlingTablesPage(driver);
		handlingTablesPage.ScrollToStaticTable();
		for (int j = 2; j <= 6; j++) {
			for (int i = 1; i <= 3; i++) {
				logger.info("Printing the static table values");
				String CellValue = driver
						.findElement(By.xpath("//table[@id = 'customers']/tbody/tr[" + j + "]/td[" + i + "]"))
						.getText();
				logger.info("Cell Value is " + CellValue);
			}
		}

	}

	@When("Perform actions on Dynamic webtable")
	public void perform_actions_on_dynamic_webtable() {
		HandlingTablesPage handlingTablesPage = new HandlingTablesPage(driver);
		handlingTablesPage.ScrollToStaticTable();

		int rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();

		int columns = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td")).size();
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				logger.info("Printing the Dynamic table values");
				String CellValue = driver
						.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]")).getText();
				logger.info("Cell Value is " + CellValue);
			}
		}

	}

	@Then("User is quit the browser")
	public void user_is_quit_the_browser() {
		driver.quit();
		logger.info("Browser is closed");

	}

}
