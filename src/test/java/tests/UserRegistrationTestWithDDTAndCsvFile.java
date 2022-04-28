package tests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCsvFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginpage;


	CSVReader reader;
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException{

		// Get path of CSV File
		String CSV_File = System.getProperty("user.dir")+"/src/test/java/data/userData.csv"; 
		reader = new CSVReader(new FileReader(CSV_File));

		String[] csvCell;
		// while loop will loop to the last file 
		while((csvCell = reader.readNext()) != null){
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String username = csvCell[3];
			String password = csvCell[4];

			homeObject = new HomePage(driver);
			homeObject.openRegistrationLink();
			registerObject = new UserRegistrationPage(driver);
			registerObject.userRegisteration(firstName, lastName, email, username, password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userCanLogout();
			homeObject.openLoginPage();
			loginpage=new LoginPage(driver);
			loginpage.UserLogin(email, password);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
			registerObject.userCanLogout();
		}
	}
}


