package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchtTxtBox;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchtBtn;

	@FindBy(linkText   = "Apple MacBook Pro 13-inch")
	WebElement productTitle;

	@FindBy(id = "ui-id-1")
	List<WebElement> productList;

	public void productSearch(String productName) {
		setTextElementText(searchtTxtBox, productName);
		clickButton(searchtBtn);
	}

	public void openProductDetailsPage() {
		clickButton(productTitle);
	} 

	public void searchProductUsingAutoComplete(String searchtxt) {
		setTextElementText(searchtTxtBox, searchtxt);
		productList.get(0).click();
	}
}
