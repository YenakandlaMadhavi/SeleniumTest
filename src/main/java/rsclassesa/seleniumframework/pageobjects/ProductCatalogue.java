package rsclassesa.seleniumframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rsclassesa.seleniumframework.abstractcomponets.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='card-body']/h5/b")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement loaderWait;
	
	@FindBy(xpath="//div[@class='card-body']/button[2]")
	List<WebElement> addTOCarts;
	
	
	By product=By.xpath("//div[@class='card-body']/h5/b");
	By addCart=By.xpath("//div[@class='card-body']/button[2]");
	By tagToast=By.id("toast-container");
	

	public void getListOfProducts(String productName) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement>prod= products;
		for(int i=0;i<prod.size();i++) {
			String names=prod.get(i).getText().toLowerCase();
			 if(productName.contains(names)) {
				 addTOCarts.get(i).click();
				
			 }
			 
		}
		 waitUntilElementAppear(tagToast);
		 waitUntilInvisibleOfElement(loaderWait);
		
				 		
	}
	
	
	
	
}
