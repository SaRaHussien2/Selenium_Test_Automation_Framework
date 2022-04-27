package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase{

	String productName="Apple MacBook Pro 13-inch"; 
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistpage;

	//Search on product

	@Test(priority = 1)
	public void UserCanSearchWithAutoComplete() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.searchProductUsingAutoComplete("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}
	}

	@Test(priority = 2)
	public void userGoToWishlistPage() {
		wishlistpage = new WishlistPage(driver);
		detailsObject.addProductToWishlist();		
		//Assert.assertTrue(wishlistpage.wishlistHeader.getText().contains("Wishlist"));
		Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
		//Assert.assertTrue(wishlistpage.productname.getText().contains(productName));
	}


	@Test(priority = 3)
	public void userCanRemoveProductFromWishlist() {
		wishlistpage = new WishlistPage(driver);
		wishlistpage.removeProductFromWishlist();
		Assert.assertTrue(wishlistpage.emptyCartLabel.getText().contains("empty!"));
	}
}
