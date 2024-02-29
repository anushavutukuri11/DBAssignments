package pages;

import java.time.Duration;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HandlingTablesPage;
import utils.CommonUtils;

public class GoogleSearchPage {

	WebDriver driver;
	CommonUtils commonUtils;

	public GoogleSearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);

	}

	@FindBy(xpath = "//textarea[@title ='Search']")
	private WebElement SearchBar;

	public void EnterTextinSearchBar() {
		SearchBar.sendKeys("Selenium");
	}

}
