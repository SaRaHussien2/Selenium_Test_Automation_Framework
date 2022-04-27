package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{

	HomePage homeObject;

	UserRegistrationPage registerObject;
	LoginPage loginpage;
	String firstName="SaRa";
	String lastName="Hussien";
	String email="SaRa@hussien.com";
	String username="saraa";

	String productName="Apple MacBook Pro 13-inch"; 
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	EmailFriendPage emailFriendPage;
	String emailFriend="1@1.com";
	String personalMessage="test test tes";

	// User Registration
	@Test(priority = 1,alwaysRun = true)
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

	// EmailFriend
	@Test(priority = 3)
	public void RegisterUserCansendProductEmailToFriend() {
		detailsObject.sendEmail();
		emailFriendPage = new EmailFriendPage(driver);
		emailFriendPage.emailFriend(emailFriend, personalMessage);
		Assert.assertTrue(emailFriendPage.resultMessage.getText().contains("Your message has been sent"));
	}


	// Logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.userCanLogout();
	}
}
