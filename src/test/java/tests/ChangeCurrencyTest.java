package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homepage;

	String productName="Apple MacBook Pro 13-inch"; 
	SearchPage searchObject;
	ProductDetailsPage detailsObject;


	@Test(priority = 1)
	public void UserCanChangeCurrencyOfProduct() {
		homepage = new HomePage(driver);
		homepage.ChangeCurrency();
	}

	@Test(priority = 2)
	public void UserCanSearchWithAutoComplete() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.searchProductUsingAutoComplete("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(detailsObject.productPriceLabel.getText().contains("€"));
			System.out.println(detailsObject.productPriceLabel.getText());
		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}
	}
}
