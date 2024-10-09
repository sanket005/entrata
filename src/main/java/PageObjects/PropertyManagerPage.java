package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyManagerPage {
	public WebDriver driver;
	@FindBy(css=".button.hover_black.new-button.w-inline-block")
	private WebElement PropertyManagerLogin;
	@FindBy (id="cookie-decline")
	private WebElement cancelCookies;
	
	
	public PropertyManagerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getPropertyManagerLogin() {
		return PropertyManagerLogin;
	}
	public WebElement getcancelCookies() {
		return cancelCookies;
	}
	
}
