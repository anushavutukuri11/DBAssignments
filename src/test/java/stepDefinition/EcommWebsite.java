package stepDefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EcommWebsitePage;

public class EcommWebsite {
	WebDriver driver  = DriverFactory.getDriver();
	
	private static final Logger logger = LogManager.getLogger(GoogleSearch.class.getName());
	@Given("Launch the Ecommerce Website to perform operations")
	public void launch_the_ecommerce_website_to_perform_operations() {
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

	@Then("Checkout the cart")
	public void checkout_the_cart() {
	   logger.info("Unable to checkout the cart as the website is for practing automation only not to fullfill the orders");
	}

	

}
