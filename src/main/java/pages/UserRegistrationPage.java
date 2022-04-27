package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FirstName")
	WebElement firstNameTxtBox;

	@FindBy(id = "LastName")
	WebElement lastNameTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordTxtBox;

	@FindBy(css = "div.result")
	public WebElement successMessage;

	@FindBy(id = "register-button")
	public WebElement registerBtn;

	@FindBy(linkText  = "Log out")
	public WebElement logoutLink;

	@FindBy(linkText  = "My account")
	public WebElement myAccountLink;


	public void userRegisteration(String firstName, String lastName, String email,  String username,String password) {
		//firstNameTxtBox.sendKeys(firstName);
		setTextElementText(firstNameTxtBox, firstName);
		setTextElementText(lastNameTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmpasswordTxtBox, password);
		clickButton(registerBtn);
	}

	public void userCanLogout() {
		clickButton(logoutLink);
	}

	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}
}