package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement fullNametextBox;

	@FindBy(id = "Email")
	WebElement emailTextBox;

	@FindBy(id = "Enquiry")
	WebElement enquiryTextBox;

	@FindBy(css = "button.button-1.contact-us-button")
	WebElement submitBtn;

	@FindBy(css = "div.result")
	public WebElement resultMessage;

	public void ContactUs(String fullName,String email, String enquiry) {
		setTextElementText(fullNametextBox, fullName);
		setTextElementText(emailTextBox, email);
		setTextElementText(enquiryTextBox, enquiry);
		clickButton(submitBtn);
	}
}
