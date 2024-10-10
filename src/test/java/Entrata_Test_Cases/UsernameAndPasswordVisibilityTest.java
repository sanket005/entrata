package Entrata_Test_Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Waits;
import PageObjects.HomePage;
import PageObjects.PropertyManagerPage;
import PageObjects.SignInPage;

public class UsernameAndPasswordVisibilityTest extends Waits{
	
	WebDriver driver;
	
	HomePage HomeObject;
	PropertyManagerPage ProprertyManagerObject;
	SignInPage signInObject;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
	driver = browserSetup();
		HomeObject = new HomePage(driver);
		 wait = Explicitlywait(20, driver);	
		wait.until(ExpectedConditions.visibilityOf(HomeObject.getcancelCookies())).click();//Cancel cookies
		
		wait.until(ExpectedConditions.elementToBeClickable(HomeObject.getLoginButton()));
		WebElement loginButton = HomeObject.getLoginButton();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);//Click on SignIn button

		ProprertyManagerObject=new PropertyManagerPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(ProprertyManagerObject.getcancelCookies())).click();//Cancel on Proprerty Manager page cookies.

		wait.until(ExpectedConditions.elementToBeClickable(ProprertyManagerObject.getPropertyManagerLogin())).click();//Click on Proprerty Manager Login button
	}
	@Test
	public void avaibilityOfUsernameandPassword() {
		
		signInObject=new SignInPage(driver);
		Assert.assertTrue(signInObject.getUsername().isDisplayed(),"Username is not visible"); 
		Assert.assertTrue(signInObject.getPassword().isDisplayed(),"Username is not visible"); 
		
    //	prop=property(System.getProperty("user.dir") + "TestData\\LoginData.properties");
	//	UsernameField.sendKeys(prop.getProperty("Username")); //We can enter data
	//	PasswordField.sendKeys(prop.getProperty("Password")); //We can enter data
		
	
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
