package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class SignupPage {
	WebDriver driver;
	CommonUtils commonUtils;

	public SignupPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);

	}

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(xpath = "//input[@value ='Female']")
	private WebElement Gender;
	
	@FindBy(xpath = "//input[@name = 'exp' and @value ='5']")
	private WebElement experience;
	
	@FindBy(id = "datepicker")
	private WebElement date;
	
	@FindBy(xpath = "//input[@value ='Manual Tester']")
	private WebElement profession;
	
	@FindBy(xpath = "//input[@name = 'tool' and @value ='Selenium Webdriver']")
	private WebElement automationTools;
	
	@FindBy(id = "continents")
	private WebElement continents;
	
	@FindBy(id = "selenium_commands")
	private WebElement seleniumCommands;
	
	@FindBy(id = "photo")
	private WebElement uploadImage;
	
	@FindBy(xpath = "//a[text() = 'Click here to Download File']")
	private WebElement downlaodFile;
	

	@FindBy(id = "submit")
	private WebElement submitBtn;
	
	public void enterFirstName() {
		commonUtils.enterText(firstName,"Test",20);
		
	}
	
	public void enterLastName() {
		commonUtils.enterText(lastName,"TestDB",20);
		
	}
	
	public void selectGender() {
		commonUtils.clickOnElement(Gender,20);
	}
	
	public void selectExperience() {
		commonUtils.ScrolltoElement(experience);
		commonUtils.clickOnElement(experience,20);
		
	}
	
	public void enterDate() {
		commonUtils.enterText(date,"22-02-2024",10);
	}
	
	
	public void selectProfession() {
		commonUtils.clickOnElement(profession,20);
	}
	
	public void selectAutomationTools() {
		commonUtils.clickOnElement(automationTools,20);
		
	}
	
	public void selectcontinents() {
		commonUtils.selectValueInDropdown(continents,"Europe",30);
		
	}
	
	public void selectSeleniumCommands() {
		commonUtils.selectValueInDropdown(seleniumCommands,"Browser Commands",20);
		commonUtils.selectValueInDropdown(seleniumCommands,"Wait Commands",20);
		
	}
	
	public void uploadImageorFile() {
		commonUtils.clickOnElement(uploadImage, 20);
		//WebElement frame =driver.switchTo().activeElement();
		//  frame.sendKeys("C:\\Users\\sekha\\OneDrive\\Downloads\\Anusha Vutukuri_Testing_Resume.docx");
		//uploadImage.sendKeys("C:\\Users\\sekha\\OneDrive\\Downloads\\Anusha Vutukuri_Testing_Resume.docx");
	}
	
	public void downloadFile() {
		commonUtils.clickOnElement(downlaodFile, 20);
	}
	
	
	
	
	public void clickSubmitBtn() {
		commonUtils.ScrolltoElement(submitBtn);
		commonUtils.clickOnElement(submitBtn,30);
		
	}
}
