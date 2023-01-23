package rsclassesa.seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsclassesa.seleniumframework.abstractcomponets.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> productList;
	
	@FindBy(css=".subtotal ul button")
	WebElement checkOut;
	
	
	public Boolean verifyProductCorrect(String productName ) {
		Boolean match=productList.stream().anyMatch(productes->productes.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public paymentPage checkOutPage() {
		checkOut.click();
		paymentPage page=new paymentPage(driver);
		return page;
	}

}
