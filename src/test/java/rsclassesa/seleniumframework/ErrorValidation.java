package rsclassesa.seleniumframework;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import rsclassesa.seleniumframework.pageobjects.CartPage;
import rsclassesa.seleniumframework.pageobjects.OrderHeaderPage;
import rsclassesa.seleniumframework.pageobjects.ProductCatalogue;
import rsclassesa.seleniumframework.testcomponents.BaseTest;
import rsclassesa.seleniumframework.testcomponents.Retry;

public class ErrorValidation extends BaseTest{
	@Test(retryAnalyzer=Retry.class)
	public void errorCheck() {
	landingPage.loginPage("anuAB@gmail.com", "Madhu7");
	Assert.assertEquals("Incorrect email password.", landingPage.errorMessages());
	}
	
	@Test
	public void productErrorMessage() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productName="adidas original";
		ProductCatalogue productcat=landingPage.loginPage("anuAB@gmail.com", "Madhu@17");
		productcat.getListOfProducts(productName);
		CartPage cartpage=productcat.goToCart();
		Boolean match=cartpage.verifyProductCorrect("adidas originall");
		Assert.assertFalse(match);
	}
	
	


}
