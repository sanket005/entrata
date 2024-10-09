package Entrata_Test_Cases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Waits;
import PageObjects.HomePage;
import PageObjects.PropertyManagerPage;
import PageObjects.SignInPage;

public class HomePageVerificationTest extends Waits {
	WebDriver driver;
	Properties prop;
	HomePage HomeObject;
	PropertyManagerPage ProprertyManagerObject;
	SignInPage signInObject;
	

	@BeforeMethod
	public void setup() {
		driver = browserSetup();
	}

	@Test
	public void testHomePageLandingAndTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Property Management Software | Entrata","Home page title is not correct");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
