package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitBrowser {
	public static WebDriver getDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void quitDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}
}
