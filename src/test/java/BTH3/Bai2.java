package BTH3;

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

public class Bai2 {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void test1Lab3() throws InterruptedException {
		driver.get("https://practicetestautomation.com/practice-test-login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		username.sendKeys("student");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		password.sendKeys("Password123");
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));
		Helper.safeClick(driver, submit);
		Thread.sleep(5000);
		
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")));
		
		String urlPage = driver.getCurrentUrl();
		assertTrue(urlPage.contains("practicetestautomation.com/logged-in-successfully/"));
		assertTrue(logout.isDisplayed());
	}
	
	@Test
	void test2Lab3() throws InterruptedException {
		driver.get("https://practicetestautomation.com/practice-test-login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		username.sendKeys("incorrectUser");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		password.sendKeys("Password123");
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));
		Helper.safeClick(driver, submit);
		
		WebElement errorUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error']")));
		assertTrue(errorUsername.isDisplayed());
		assertTrue(errorUsername.getText().contains("Your username is invalid!"));
	}
	
	@Test
	void test3Lab3() throws InterruptedException {
		driver.get("https://practicetestautomation.com/practice-test-login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		username.sendKeys("User");
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		password.sendKeys("incorrectPassword");
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));
		Helper.safeClick(driver, submit);
		
		WebElement errorPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error']")));
		assertTrue(errorPassword.isDisplayed());
		assertTrue(errorPassword.getText().contains("Your password is invalid!"));
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
