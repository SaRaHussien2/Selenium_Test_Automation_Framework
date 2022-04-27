package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductsToComparePage extends PageBase {

	public AddProductsToComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement FirstProductName;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement SecondProductName;

	@FindBy(css="a.clear-list")
	WebElement clearListBtn;

	@FindBy(css="table.compare-products-table")
	WebElement compareTable;

	@FindBy(css="div.no-data")
	public WebElement noDataLabel;

	@FindBy(tagName = "tr")
	public List<WebElement> allRows;

	@FindBy(tagName = "td")
	public List<WebElement> allCols;
	//Search on First Product


	public void clearCompareList() {
		clickButton(clearListBtn);
	}

	public void compareProducts() {
		//Get all Rows
		System.out.println(allRows.size());

		//Get all Cols
		for(WebElement row: allRows) {
			System.out.println(row.getText()+" \t");

			for(WebElement col: allCols) {
				System.out.println(col.getText()+" \t");
			}
		}
	}
}
