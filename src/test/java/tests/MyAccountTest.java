package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;
	MyAccountPage myAccountObject;

	String firstName="SaRa";
	String lastName="Hussien";
	String email="SaRa@hussien.com";
	String username="saraa";
	String oldPassword="123456";
	String newPassword="1234567";


	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void registerUserCanChangePassword() {
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultChangePassword.getText().contains("Password was changed"));
		myAccountObject.closeIconNotificationBar.click();
	}

	@Test(priority = 3)
	public void RegisteredUserCanLogout() {
		registerObject.userCanLogout();
	}

	@Test(priority = 4)
	public void RergisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginpage=new LoginPage(driver);
		loginpage.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
