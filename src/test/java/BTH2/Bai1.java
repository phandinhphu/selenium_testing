package BTH2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.InitBrowser;

public class Bai1 {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testLogin() throws InterruptedException {
		driver.get("https://daotao.qnu.edu.vn");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		assertTrue(title.contains("Thông báo chung"));
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
