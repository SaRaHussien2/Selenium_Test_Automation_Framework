package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class ProductReviewTest extends TestBase{

	HomePage homeObject;

	UserRegistrationPage registerObject;
	LoginPage loginpage;
	String firstName="SaRa";
	String lastName="Hussien";
	String email="SaRa@hussien.com";
	String username="saraa";
	//String password="123456";

	String productName="Apple MacBook Pro 13-inch"; 
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	ProductReviewPage productreviewpage;
	String reviewTitle="test";
	String reviewText="test test test";

	// User Registration
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, "123456");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	// Search For Product
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

	// Product Review
	@Test(priority = 3)
	public void RegisterUserCansendProductReview() {
		detailsObject.openProductReviewPage();
		productreviewpage = new ProductReviewPage(driver);
		productreviewpage.ProductReview(reviewTitle, reviewText);
		Assert.assertTrue(productreviewpage.successMessage.getText().contains("Product review is successfully added"));
	}


	// Logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.userCanLogout();
	}
}
