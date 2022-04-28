package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndDataPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;
	String firstName= LoadProperties.userData.getProperty("firstName");
	String lastName= LoadProperties.userData.getProperty("lastName");
	String email= LoadProperties.userData.getProperty("email");
	String username= LoadProperties.userData.getProperty("username");
	String password= LoadProperties.userData.getProperty("password");


	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, password);
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
		loginpage.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
