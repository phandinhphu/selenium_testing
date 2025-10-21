package kiem_tra;

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

import helper.Helper;
import init.InitBrowser;

public class TestLogin {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testLoginSuccess() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameInput.sendKeys("Admin");
		
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		passwordInput.sendKeys("admin123");
		
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		Helper.safeClick(driver, loginButton);
		
		assertTrue(driver.getPageSource().contains("Dashboard"));
	}
	
	@Test
	void testLoginFail() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameInput.sendKeys("Admin");
		
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		passwordInput.sendKeys("admin1");
		
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		Helper.safeClick(driver, loginButton);
		
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
		assertTrue(errorMessage.getText().contains("Invalid credentials"));
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
