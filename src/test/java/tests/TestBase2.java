package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import utilities.Helper;

public class TestBase2 {

	public static String BaseURL = "http://demo.nopcommerce.com" ; 

	protected ThreadLocal<RemoteWebDriver> driver = null ; 

	@BeforeClass
	@Parameters(value= {"browser"})
	public void setUp(String browser) throws MalformedURLException 
	{
//		driver = new ThreadLocal<>(); 
//		DesiredCapabilities caps = new DesiredCapabilities(); 
//		caps.setCapability("browserName", browser);
//
//		// selenium Grid Local
//		driver.set(new RemoteWebDriver(new URL("http://localhost:4444"),caps));
//		getDriver().navigate().to(BaseURL);
//
//
		/*
      //	ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		browserOptions.setCapability("sauce:options", sauceOptions);

		*/
		//SauceLabs Configuration
		public static final String USERNAME = LoadProperties.saucelabData.getProperty("username");
		public static final String ACCESS_KEY = LoadProperties.saucelabData.getProperty("accesskey");
		public static final String SauceURL ="http://"+USERNAME+":"+ACCESS_KEY+ LoadProperties.saucelabData.getProperty("seleniumURL");


	
		 if(browser.equals("chrome")){
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("chrome");
			
			capability.setPlatform(Platform.WINDOWS);
			ChromeOptions options = new ChromeOptions();
			options.merge(capability);
			// Seleniu Grid Local
			// driver.set(new RemoteWebDriver(new URL("http://localhost:4444"),capability));
			
			// Run ON Sauce Labs on Cloud
			
			driver.set(new RemoteWebDriver(new URL(SauceURL),capability));
			
			getDriver().navigate().to(BaseURL);
			}
		 else if(browser.equals("firefox")){
			 DesiredCapabilities capability = new DesiredCapabilities();
			 capability.setBrowserName("firefox");
			 capability.setPlatform(Platform.WINDOWS);
			 FirefoxOptions options1 = new FirefoxOptions();
			 options1.merge(capability);
				driver.set(new RemoteWebDriver(new URL("http://localhost:4444"),capability));
				getDriver().navigate().to(BaseURL);
			 }
	
	
	
	}

	public WebDriver getDriver() 
	{
		return driver.get(); 
	}

	@AfterClass
	public void stopDriver() 
	{
		getDriver().quit();
		driver.remove();
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(getDriver(), result.getName());
		}
	}

}
