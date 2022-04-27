package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FriendEmail")
	WebElement emailFriendTextBox;

	@FindBy(id="PersonalMessage")
	WebElement personalMessageTextBox;


	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendEmailButton;

	@FindBy(css="div.result")
	public WebElement resultMessage;

	public void emailFriend(String emailFriend, String personalMessage) {
		setTextElementText(emailFriendTextBox, emailFriend);
		setTextElementText(personalMessageTextBox, personalMessage);
		clickButton(sendEmailButton);
	}


}
