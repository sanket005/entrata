package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public 	WebDriver driver;
@FindBy(linkText="Sign In")
private WebElement SignInButton;
@FindBy (id="cookie-decline")
private WebElement cancelCookies;
@FindBy(xpath="//div[text()='Resources']")
private WebElement Resources;

@FindBy(css="nav[id='w-dropdown-list-6'] a")
private List<WebElement> ResourcesList;



public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getLoginButton() {
	return SignInButton;
}

public WebElement getcancelCookies() {
	return cancelCookies;
}
public WebElement getResources() {
	return Resources;
}
public List<WebElement> getResourcesList() {
	return ResourcesList;
}

}
