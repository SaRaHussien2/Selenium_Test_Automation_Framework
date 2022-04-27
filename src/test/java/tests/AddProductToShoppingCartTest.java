package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {

	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	SearchPage searchObject;

	String productName="Apple MacBook Pro 13-inch"; 

	//search
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
	public void UserCanAddProductToCart() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToCart();
		detailsObject.navigateToShoppingCartPage();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.cartHeader.isDisplayed());
	}

	@Test(priority = 3)
	public void userCanRemoveProductFromShoppingCart() {
		cartObject.removeProductFromShoppingCart();
		Assert.assertTrue(cartObject.resultMessage.getText().contains("Your Shopping Cart is empty!"));
	}
}
