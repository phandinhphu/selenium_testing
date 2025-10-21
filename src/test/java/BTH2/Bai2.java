package BTH2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.InitBrowser;

public class Bai2 {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testLogin() throws InterruptedException {
		driver.get("https://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		assertTrue(title.contains("Google"));
		
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("google.com"));
		
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		
		System.out.println("Page Source Length: " + pageSourceLength);
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
