package rsclassesa.seleniumframework.abstractcomponets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rsclassesa.seleniumframework.pageobjects.CartPage;
import rsclassesa.seleniumframework.pageobjects.OrderHeaderPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]")
	WebElement cart;
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[2]")
	WebElement orders;
	
	public void waitUntilElementAppear(By findBy) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitUntilWebElementAppear(WebElement elements) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elements) );
	}
	
	public void waitUntilInvisibleOfElement(WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCart() {
		cart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	public OrderHeaderPage goToOrders() {
		orders.click();
		OrderHeaderPage orderPage=new OrderHeaderPage(driver);
		return orderPage;
	}
}
