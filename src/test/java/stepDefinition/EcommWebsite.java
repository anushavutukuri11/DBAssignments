package stepDefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EcommWebsitePage;

public class EcommWebsite {
	WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(GoogleSearch.class.getName());
	@Given("Launch the Ecommerce Website to perform operations")
	public void launch_the_ecommerce_website_to_perform_operations() {
		driver = new ChromeDriver();
		logger.info("Chrome Driver is initialized");
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		logger.info("Magento Ecommerce website is launched");
	}

	@When("Select the product to be purchased and add to the cart")
	public void select_the_product_to_be_purchased_and_add_to_the_cart() {
		EcommWebsitePage Epage = new EcommWebsitePage(driver);
		Epage.selectProduct();
		Epage.addToCart();	   
	}

	@And("and checkout the cart")
	public void and_checkout_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is quit the chrome browser")
	public void user_is_quit_the_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
