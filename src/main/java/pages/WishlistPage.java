package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css="a.product-name")
	public WebElement productname;

	@FindBy(css ="h1")
	public WebElement wishlistHeader;

	@FindBy(name = "addtocart")
	WebElement addToCartCheckBox;

	@FindBy(css = "button.remove-btn")
	public WebElement removeFromCartCheck;

	@FindBy(id = "updatecart")
	WebElement updateWishlistBtn;

	@FindBy(css = "div.no-data")
	public WebElement emptyCartLabel;

	public void removeProductFromWishlist() {
		clickButton(addToCartCheckBox);
		clickButton(removeFromCartCheck);
	}
}
