package rsclassesa.seleniumframework.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsclassesa.seleniumframework.abstractcomponets.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	@FindBy(id="login")
	WebElement login;
	
	
	public ProductCatalogue loginPage(String email,String passwords) {
		userName.sendKeys(email);
		password.sendKeys(passwords);
		login.click();
		ProductCatalogue productcat=new ProductCatalogue(driver);
		return productcat;
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String errorMessages() {
		waitUntilWebElementAppear(errorMessage);
		return errorMessage.getText();
	}
	}
