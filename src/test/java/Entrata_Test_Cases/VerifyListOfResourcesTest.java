package Entrata_Test_Cases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Waits;
import PageObjects.HomePage;

public class VerifyListOfResourcesTest extends Waits {
	WebDriver driver;
	HomePage HomeObject;
	Actions mouse;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		driver = browserSetup();
		HomeObject = new HomePage(driver);
		wait = Explicitlywait(10, driver);
		wait.until(ExpectedConditions.visibilityOf(HomeObject.getcancelCookies()));
		HomeObject.getcancelCookies().click();
	}

	@Test
	public void VerifyResources() {
		mouse = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(HomeObject.getResources()));
		mouse.moveToElement(HomeObject.getResources()).build().perform();
		List<WebElement> resourceList = HomeObject.getResourcesList();
		List<String> optionTexts = new ArrayList<>();

		for (WebElement option : resourceList) {
			String text = option.getText();
			optionTexts.add(text);
			System.out.println(text); 
		}
		List<String> expectedValues = List.of("All Resources", "Guides", "Webinars", "Resident Experts", "Blog"); 
		Assert.assertEquals(optionTexts, expectedValues, "Dropdown values do not match expected values!");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
