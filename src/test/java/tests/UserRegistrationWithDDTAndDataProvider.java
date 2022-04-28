package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;

	@DataProvider(name="testData")
	public static Object[][] userData() {
		return new Object[][] {
			{"sara","hussien","sara1@test.com","saraa","123456"},
			{"yara","hussien","yara1@test.com","yaraa","123456"}
		};
	}

	@Test(priority = 1,alwaysRun = true,dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String firstName, String lastName,String email,String username,String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userCanLogout();

	}
}
