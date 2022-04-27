package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;
	String firstName="SaRa";
	String lastName="Hussien";
	String email="SaRa@hussien.com";
	String username="saraa";
	//String oldPassword="123456";
	//String newPassword="1234567";


	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, "123456");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout() {
		registerObject.userCanLogout();
	}

	@Test(dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RergisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginpage=new LoginPage(driver);
		loginpage.UserLogin(email, "123456");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
