package rsclassesa.seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsclassesa.seleniumframework.abstractcomponets.AbstractComponent;

public class OrderHeaderPage extends AbstractComponent{
	WebDriver driver;
	public OrderHeaderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productLists;
	
	
	
	
	public Boolean verifyDisplayedProduct(String productName ) {
		Boolean match=productLists.stream().anyMatch(productes->productes.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	

}
