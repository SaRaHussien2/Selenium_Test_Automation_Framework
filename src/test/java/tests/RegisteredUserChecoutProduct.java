package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserChecoutProduct extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	String firstName="SaRa";
	String lastName="Hussien";
	String email="S-a1-R-a-11-40-0@hussien.com";
	String username="saraa";
	String productName="Apple MacBook Pro 13-inch"; 

	String countryName="Egypt";
	String address="Egypt";
	String postcode="0123";
	String phone="0100100";
	String city="haram";

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	OrderDetailsPage orderObject;
	CheckoutPage checkoutObject;


	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, "123456");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	//search
	@Test(priority = 2)
	public void UserCanSearchWithAutoComplete() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.searchProductUsingAutoComplete("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}
	}

	//add product to card
	@Test(priority = 3)
	public void UserCanAddProductToCart() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToCart();
		detailsObject.navigateToShoppingCartPage();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.cartHeader.isDisplayed());
	}


	@Test(priority = 4)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));

		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.thankyouMessage.isDisplayed());
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver); 
		orderObject.PrintOrderDetails();
		orderObject.DownloadPDFInvoice();

	}
	//logout
	@Test(priority = 5)
	public void RegisteredUserCanLogout() {
		registerObject.userCanLogout();
	}
}
