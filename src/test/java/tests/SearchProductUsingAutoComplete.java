package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoComplete  extends TestBase{

	String productName="Apple MacBook Pro 13-inch"; 
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	@Test
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
}
