package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Print")
	WebElement printBtn;

	@FindBy(linkText = "PDF Invoice")
	WebElement pdfBtn;


	public void PrintOrderDetails() {
		clickButton(printBtn);	
	}

	public void DownloadPDFInvoice() {
		clickButton(pdfBtn);
	}
}
