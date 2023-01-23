package rsclassesa.seleniumframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rsclassesa.seleniumframework.abstractcomponets.AbstractComponent;

public class paymentPage extends AbstractComponent{
	WebDriver driver;
	public paymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countryDropdown;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeOrders;
	
	By countriesLoad=By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryNeedToSelect) throws InterruptedException {
		Actions a=new Actions(driver);
		a.sendKeys(country,countryNeedToSelect).build().perform();
		waitUntilElementAppear(countriesLoad);
		Thread.sleep(20000);
		countryDropdown.click();
	}
	public OrderDetailsPage placeOrder() throws InterruptedException {
		Thread.sleep(60000);
		placeOrders.click();
		Thread.sleep(2000);
		OrderDetailsPage orderPage=new OrderDetailsPage(driver);
		return orderPage;
	}
	
	
		
	

}
