package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="h1")
	public WebElement cartHeader;

	@FindBy(css = "a.product-name")
	WebElement productName;

	@FindBy(css="button.remove-btn")
	WebElement removeCheck;

	@FindBy(id="updatecart")
	WebElement updateCartBtn;

	@FindBy(css="td.subtotal")
	public WebElement totalPriceLabel;	

	@FindBy(css="input.qty-input valid")
	public WebElement quantityTxt;	

	@FindBy(css="div.no-data")
	public WebElement resultMessage;	

	@FindBy(id= "checkout")
	WebElement checkoutBtn;

	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;

	public void removeProductFromShoppingCart() {
		clickButton(removeCheck);
	}

	public void UpdateProductQuantityInCart(String quantity) {
		// Clear quantity text box
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}

	public void openCheckoutPage() {
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
}
