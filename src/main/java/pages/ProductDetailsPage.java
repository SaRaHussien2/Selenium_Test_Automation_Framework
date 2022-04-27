package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;

	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFrinedButton;

	@FindBy(css = "span.price-value-4")
	public WebElement productPriceLabel;

	@FindBy(linkText = "Add your review")
	WebElement productReviewLink;

	@FindBy(linkText = "wishlist")
	WebElement wishlistMessageLink;

	@FindBy(css = "button.button-2.add-to-compare-list-button")
	public WebElement addProductToCompareBtn;

	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishlistBtn;

	@FindBy(linkText = "product comparison")
	WebElement productComparisonLink;

	@FindBy (id = "add-to-cart-button-4")
	WebElement addToCartBtn;

	@FindBy(linkText = "shopping cart")
	WebElement shoppingCartLink;

	// Methods
	public void sendEmail() {
		clickButton(emailFrinedButton);
	}

	public void openProductReviewPage() {
		clickButton(productReviewLink);
	}

	public void addProductToWishlist() {
		clickButton(addToWishlistBtn);
		clickButton(wishlistMessageLink);
	}

	public void addProductToComare() {
		clickButton(addProductToCompareBtn);
	}

	public  void  goToComparePage() {
		clickButton(productComparisonLink);
	}

	public void addProductToCart() {
		clickButton(addToCartBtn);
	}

	public void navigateToShoppingCartPage() {
		clickButton(shoppingCartLink);
	}
}

