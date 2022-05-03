package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration  extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
	}

	@When("I clike on register link")
	public void i_clike_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	//	@When("I entered the user data")
	//	public void i_entered_the_user_data() {
	//
	//		registerObject = new UserRegistrationPage(driver);
	//		registerObject.userRegisteration("sara", "sara", "sara@sara1a.com", "saraa", "123456");
	//	}



	@When("I entered {string},{string},{string},{string},{string}")
	public void i_entered(String firstName, String  lastName, String email, String username, String password) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, username, password);
	}


	@Then("The registration oage displayed successfully")
	public void the_registration_oage_displayed_successfully() {
		registerObject.userCanLogout();
	}
}
