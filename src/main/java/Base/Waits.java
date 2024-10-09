package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Waits extends BaseSetup{
	public static WebDriverWait Explicitlywait(int timeInSeconds,WebDriver driver) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
       return wait;
}

	public static Timeouts Implicitlywait(WebDriver driver, int timeInSeconds) {
		Timeouts wait=driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
		return wait;
	}
}
