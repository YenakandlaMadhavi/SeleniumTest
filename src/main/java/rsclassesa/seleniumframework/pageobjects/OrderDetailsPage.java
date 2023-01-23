package rsclassesa.seleniumframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rsclassesa.seleniumframework.abstractcomponets.AbstractComponent;

public class OrderDetailsPage extends AbstractComponent {
	WebDriver driver;
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement pageHeader;
	
	public String getPageHeader() {
		return pageHeader.getText();
	}

}
