package rsclassesa.seleniumframework;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rsclassesa.seleniumframework.pageobjects.CartPage;
import rsclassesa.seleniumframework.pageobjects.OrderDetailsPage;
import rsclassesa.seleniumframework.pageobjects.OrderHeaderPage;
import rsclassesa.seleniumframework.pageobjects.ProductCatalogue;
import rsclassesa.seleniumframework.pageobjects.paymentPage;
import rsclassesa.seleniumframework.testcomponents.BaseTest;

public class StandAloneClass extends BaseTest {

	@Test(dataProvider = "getData", groups = "MultipleData")
	public void eCommerceAppication(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productcat = landingPage.loginPage(input.get("email"), input.get("password"));
		productcat.getListOfProducts(input.get("product"));
		CartPage cartpage = productcat.goToCart();
		Boolean match = cartpage.verifyProductCorrect(input.get("product"));
		Assert.assertTrue(match);
		paymentPage page = cartpage.checkOutPage();
		page.selectCountry("India");
		OrderDetailsPage orderDetailsPage = page.placeOrder();
		String finalPage = orderDetailsPage.getPageHeader();

		Assert.assertTrue(finalPage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = "eCommerceAppication")
	public void verifyTheProductPlaced() throws InterruptedException {
		String productName = "adidas original";
		ProductCatalogue productcat = landingPage.loginPage("anuAB@gmail.com", "Madhu@17");
		OrderHeaderPage orderPage = productcat.goToOrders();
		Assert.assertTrue(orderPage.verifyDisplayedProduct(productName));
	} 


	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				"C:\\Users\\Yenakandla.Madhavi\\eclipse-workspace\\Selenium_Practice\\SeleniumFramework\\src\\test\\java\\rsclassesa\\seleniumframework\\testData\\LoginCredentials.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
}