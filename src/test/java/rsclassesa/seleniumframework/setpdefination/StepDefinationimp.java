package rsclassesa.seleniumframework.setpdefination;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rsclassesa.seleniumframework.pageobjects.CartPage;
import rsclassesa.seleniumframework.pageobjects.LandingPage;
import rsclassesa.seleniumframework.pageobjects.OrderDetailsPage;
import rsclassesa.seleniumframework.pageobjects.ProductCatalogue;
import rsclassesa.seleniumframework.pageobjects.paymentPage;
import rsclassesa.seleniumframework.testcomponents.BaseTest;

public class StepDefinationimp extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productcat;
	public CartPage cartpage;
	public OrderDetailsPage orderDetailsPage;
	
	@Given("I Land on Ecommerce Page")
	public void I_Land_on_Ecommerce_Page() throws IOException {
		 landingPage=applicationLaunch();
	}
	
	@Given("^login with username (.+) and password (.+)$")
	public void login_with_username_and_password(String userName,String passWord) {
		 productcat = landingPage.loginPage(userName, passWord);
	}
	
	@When("^add the product (.+) to cart$")
	public void add_the_product_to_cart(String product) throws InterruptedException {
		productcat.getListOfProducts(product);
	}
	@When("^checkout (.+) submit the order$")
	public void checkout_submit_the_order(String product) throws InterruptedException {
		cartpage = productcat.goToCart();
		Boolean match = cartpage.verifyProductCorrect(product);
		Assert.assertTrue(match);
		paymentPage page = cartpage.checkOutPage();
		page.selectCountry("India");
		 orderDetailsPage = page.placeOrder();
	}
	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string) {
		String finalPage = orderDetailsPage.getPageHeader();
		Assert.assertTrue(finalPage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}
	

}
