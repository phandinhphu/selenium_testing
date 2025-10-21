package BTH2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.InitBrowser;

public class Bai3 {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testLogin() throws InterruptedException {
		driver.get("https://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.navigate().to("https://www.facebook.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
