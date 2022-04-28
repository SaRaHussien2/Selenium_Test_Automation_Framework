package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcelFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;


	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException {
		//read data from Excel Reader class
		ExcelReader excelreader = new ExcelReader();
		return excelreader.getExcelData();
	}


	@Test(dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String firstname , String lastname , String email ,String username, String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationLink();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, username, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userCanLogout();
		homeObject.openLoginPage();
		loginpage=new LoginPage(driver);
		loginpage.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userCanLogout();
	}
}
