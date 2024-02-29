package stepDefinition;

import java.time.Duration;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import org.openqa.selenium.WebDriver;

public class Signup {
	private static final Logger logger = LogManager.getLogger(Signup.class.getName());

	WebDriver driver;

	@Given("Launch the chrome Browser")
	public void launch_the_chrome_browser() {
		driver = new ChromeDriver();
		logger.info("Chrome Driver is initialized");
		driver.manage().window().maximize();
		

	}

	@When("The browser is launched enter the Demo automation Practice form URL")
	public void the_browser_is_launched_enter_the_demo_automation_practice_form_url() {
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		logger.info("Selenium Practice form is launched");
	}

	@Then("User is on Demo automation Practice form  page and verify the title of the webpage")
	public void user_is_on_demo_automation_practice_form_page_and_verify_the_title_of_the_webpage() throws Exception {
		logger.info("Page Title is:"+ driver.getTitle());
		System.out.println(driver.getTitle());

	}

	@Given("Enter valid first name")
	public void enter_valid_first_name() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.enterFirstName();
		logger.info("FirstName is entered");
	}

	@And("Enter valid Last name")
	public void enter_valid_last_name() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.enterLastName();
		;
		logger.info("LastName is entered");
	}

	@And("Select the gender")
	public void select_the_gender() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.selectGender();
		logger.info("Gender is selected");
	}

	@And("Select the number of years of experience")
	public void select_the_number_of_years_of_experience() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.selectExperience();
		logger.info("Experience in years is entered");
	}

	@And("Enter Date")
	public void enter_date() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.enterDate();
		logger.info("Valid date is entered");
	}

	@And("Enter profession")
	public void enter_profession() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.selectProfession();
		logger.info("Profession details are entered");
	}

	@And("Enter Automation Tools")
	public void enter_automation_tools() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.selectAutomationTools();

	}

	@And("Enter Continents")
	public void enter_continents() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.selectcontinents();

	}

	@And("Enter Selenium Command")
	public void enter_selenium_command() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.selectSeleniumCommands();
	}

	@And("Upload the file to be choosen")
	public void upload_the_file_to_be_choosen() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.uploadImageorFile();
	}

	@And("Download the file")
	public void download_the_file() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.downloadFile();
		driver.navigate().back();

	}

	@When("Click on submit button")
	public void click_on_submit_button() {
		SignupPage signupPage = new SignupPage(driver);
		signupPage.clickSubmitBtn();

	}

	@Then("Verify the title of the page")
	public void verify_the_title_of_the_page() {
		driver.getCurrentUrl();
		driver.getTitle();
		logger.info(driver.getCurrentUrl());
		logger.info(driver.getTitle());
	}

}
