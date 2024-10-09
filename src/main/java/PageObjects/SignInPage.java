package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	public WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement Username;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement Password;
	
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsername() {
		return Username;
	}
	public WebElement getPassword() {
		return Password;
	}
	
}
