package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement  checkoutAsGuestBtn ;

	@FindBy(css = "button.button-1 register-button")
	WebElement  registerBtn ;

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement  firstNameTextBox ;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement  lastNameTextBox ;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement  emailTextBox ;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement  countryList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement  cityTxtBox;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement  address1TextBox ;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement  zipCodeTextBox ;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement  phoneTextBox ;

	@FindBy (name="save")
	WebElement continueBillingBtn;

	///////////Shipping
	@FindBy(id = "shippingoption_0")
	WebElement  shippingOption1 ;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement  shippingMethodContinueBtn ;

	////////////Payment
	@FindBy(id = "paymentmethod_0")
	WebElement  paymentOption1 ;

	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;

	/////////info
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement  paymentInformationContinueBtn ;

	//////////Order
	@FindBy(css = "a.product-name")
	public WebElement prodcutName;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement  confirmOrderBtn ;

	@FindBy(css = "h1")
	public WebElement thankyouMessage;

	@FindBy(css = "div.title")
	private WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;

	@FindBy(css="button.button-1.order-completed-continue-button")
	WebElement continueCompleteOrderBtn;	

	public void RegisteredUserCheckoutProduct(String countryName, String city, String address, String postcode, String phone,String productName) {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxtBox, city);
		setTextElementText(address1TextBox, address);
		setTextElementText(zipCodeTextBox, postcode);
		setTextElementText(phoneTextBox, phone);
		clickButton(continueBillingBtn);
		clickButton(shippingMethodContinueBtn);
		clickButton(paymentMethodContinueBtn);
		clickButton(paymentInformationContinueBtn);

	}
	public void confirmOrder() {
		clickButton(confirmOrderBtn);
	}
	public void clickOnRegisterAsGuestBtn() {
		clickButton(checkoutAsGuestBtn);

	}
	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}

	public void CheckoutProduct(String firstName, String lastName, String countryName,
			String email, String address, String postcode, 
			String phone, String city, String productName) {
		setTextElementText(firstNameTextBox, firstName);
		setTextElementText(lastNameTextBox, lastName);
		setTextElementText(emailTextBox, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxtBox, city);
		setTextElementText(address1TextBox, address);
		setTextElementText(zipCodeTextBox, postcode);
		setTextElementText(phoneTextBox, phone);
		clickButton(continueBillingBtn);
		clickButton(shippingMethodContinueBtn);
		clickButton(paymentMethodContinueBtn);
		clickButton(paymentInformationContinueBtn);
	}
}
