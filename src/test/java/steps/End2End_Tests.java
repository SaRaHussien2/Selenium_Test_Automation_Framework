package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class End2End_Tests extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	//String productName;
	String productName = "Apple MacBook Pro 13-inch";

	String firstName="SaRa";
	String lastName="Hussien";
	String email="SaRA01@hussien.com";
	String username="saraa";

	String countryName="Egypt";
	String address="Egypt";
	String postcode="0123";
	String phone="0100100";
	String city="haram";

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		homeObject = new HomePage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));

	}

	@When("he search for {string}")
	public void he_search_for(String productName) {
		searchObject = new SearchPage(driver);
		searchObject.searchProductUsingAutoComplete(productName);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}

	@When("choose to buy Two items")
	public void choose_to_buy_two_items() {
		cartObject = new ShoppingCartPage(driver);
		detailsObject.addProductToCart();
		detailsObject.navigateToShoppingCartPage();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.cartHeader.isDisplayed());
	}


	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.openCheckoutPage();
		checkoutObject.clickOnRegisterAsGuestBtn();
		checkoutObject.CheckoutProduct(firstName, lastName, countryName, email, address, postcode, phone, city, productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.thankyouMessage.isDisplayed());

	}
	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver); 
		orderObject.PrintOrderDetails();
		orderObject.DownloadPDFInvoice();
	}

}
