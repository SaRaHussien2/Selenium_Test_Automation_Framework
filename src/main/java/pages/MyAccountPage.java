package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText  = "Change password")
	WebElement changePasswordLink;

	@FindBy(id  = "OldPassword")
	WebElement oldPasswordLink;

	@FindBy(id  = "NewPassword")
	WebElement newPasswordLink;

	@FindBy(id  = "ConfirmNewPassword")
	WebElement confirmPasswordLink;

	@FindBy(css="button.button-1.change-password-button")
	WebElement changePasswordBtn;

	@FindBy(css  = "p.content")
	public WebElement resultChangePassword;

	@FindBy(id = "bar-notification")
	WebElement notificationBar;

	@FindBy(className = "close")
	public
	WebElement closeIconNotificationBar;

	public void openChangePasswordPage(){
		clickButton(changePasswordLink);
	}
	public void changePassword(String oldPassword, String newPassword) {
		setTextElementText(oldPasswordLink, oldPassword);
		setTextElementText(newPasswordLink, newPassword);
		setTextElementText(confirmPasswordLink, newPassword);
		clickButton(changePasswordBtn);
	}
}
