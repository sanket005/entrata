package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
	public static Properties prop;
	public static WebDriver driver;

	public static WebDriver browserSetup() {
		String Configpath = System.getProperty("user.dir") + "\\Configgurations\\Config.properties";
		if (property(Configpath).getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (property(Configpath).getProperty("Browser").equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.get(property(Configpath).getProperty("URL"));
		
		Waits.Implicitlywait(driver, 30);
		return driver;
	}

	public static Properties property(String path) {

		try {
			FileInputStream fs = new FileInputStream(path);
			prop = new Properties();
			prop.load(fs);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

}
