package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParellelTesting extends TestBase2
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	Faker fakeData = new Faker(); 
	String firstname = fakeData.name().firstName(); 
	String lastname = fakeData.name().lastName(); 
	String username = fakeData.name().username(); 
	String email = fakeData.internet().emailAddress(); 
	String password = fakeData.number().digits(8).toString(); 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(getDriver()); 
		homeObject.openLoginPage();
		registerObject = new UserRegistrationPage(getDriver()); 
		registerObject.userRegisteration(firstname,lastname,email,username,password);
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userCanLogout();
	}

	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(getDriver()); 
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
