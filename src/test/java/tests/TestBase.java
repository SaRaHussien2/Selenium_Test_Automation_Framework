package tests;

import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;



public class TestBase {
	public static WebDriver driver;

	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) 
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOption()); 
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOption()); 
		}

		else if (browserName.equalsIgnoreCase("ie")) 
		{
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver(); 
		}

		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver();
			driver = new SafariDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
	} 


	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

	//Take screen shot when test case fail and add it in the screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screnshot.....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}

}
