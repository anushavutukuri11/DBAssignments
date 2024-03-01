package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;

	@Before
	public  void  LaunchChromeBrowser() {

		driver = DriverFactory.initializeBrowser();

	}

	@After

	public void tearDown(Scenario scenario) {

		String scenarioName = scenario.getName().replaceAll(" ", "_");

		if (scenario.isFailed()) {

			byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}

	driver.quit();

	}

}
