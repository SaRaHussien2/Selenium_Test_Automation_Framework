package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;
//	String firstName="SaRa";
//	String lastName="Hussien";
//	String email="SaRa@hussien.com";
//	String username="saraa";
//	String password="123456";

	
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String username = fakeData.name().username();
	String password = fakeData.number().digits(8).toString();

	
	
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, password);
		System.out.println("The Userr Data is : "+ firstName + " " + lastName + " " + email +" " + username + " " + password);
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
