package BTH4;

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

public class TestRegister {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testRegister() throws InterruptedException {
		driver.get("https://automationexercise.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);

		WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']")));
		Helper.safeClick(driver, registerLink);
		
		WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-name']")));
		nameInput.sendKeys("Nguyen Van A");
		
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-email']")));
		String email = "phutester" + System.currentTimeMillis() + "@mail.com";
		emailInput.sendKeys(email);
		
		WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='signup-button']")));
		Helper.safeClick(driver, signupButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("quocnaru123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='days']"))).sendKeys("10");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='months']"))).sendKeys("May");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='years']"))).sendKeys("2004");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first_name']"))).sendKeys("Nguyen");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='last_name']"))).sendKeys("Van A");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='company']"))).sendKeys("ABC Company");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address1']"))).sendKeys("123 ABC Street");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address2']"))).sendKeys("XYZ Area");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='country']"))).sendKeys("United States");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='state']"))).sendKeys("California");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='city']"))).sendKeys("Los Angeles");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='zipcode']"))).sendKeys("90001");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mobile_number']"))).sendKeys("1234567890");
		
		WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='create-account']")));
		Helper.safeClick(driver, createAccountButton);
		Thread.sleep(8000);
		System.out.println(driver.getPageSource());
		assertTrue(driver.getPageSource().contains("Account Created!"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-qa='continue-button']"))).click();
		
		Thread.sleep(3000);
		
		assertTrue(driver.getPageSource().contains("Logged in as"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/logout']"))).click();
		
		assertTrue(driver.getCurrentUrl().contains("/login"));
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
