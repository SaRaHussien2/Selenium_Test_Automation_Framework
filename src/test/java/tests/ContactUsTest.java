package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	HomePage homepage;
	ContactUsPage contactpage;

	String email="SaRa@Hussien.com";
	String fullname="SaRa";
	String enquiry = "hello test";


	@Test
	public void UserCanUseContactUs() {
		homepage=new HomePage(driver);
		homepage.openContactUsPage();
		contactpage = new ContactUsPage(driver);
		contactpage.ContactUs(fullname, email, enquiry);
		Assert.assertTrue(contactpage.resultMessage.getText().contains("Your enquiry has been successfully sent to the store owner"));
	}
}
