package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJsonFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException {

		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.username, jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userCanLogout();
		homeObject.openLoginPage();
		loginpage=new LoginPage(driver);
		loginpage.UserLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userCanLogout();
	}
}
