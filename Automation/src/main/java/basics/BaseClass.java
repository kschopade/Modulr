package basics;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() {
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();

		return driver;
	}

}
