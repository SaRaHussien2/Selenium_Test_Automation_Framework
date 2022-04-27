package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTextBox;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTxtTextBox;

	@FindBy(id="addproductrating_5")
	WebElement ratingRadioButton;

	@FindBy(css ="button.button-1.write-product-review-button")
	WebElement submitReviewButton;

	@FindBy(css ="div.result")
	public WebElement successMessage;


	public void ProductReview(String reviewTitle, String reviewText) {
		setTextElementText(reviewTitleTextBox, reviewTitle);
		setTextElementText(reviewTxtTextBox, reviewText);
		clickButton(ratingRadioButton);
		clickButton(submitReviewButton);
	}
}
