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

public class TestAddEmployee {
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

		WebElement pimPageLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
		Helper.safeClick(driver, pimPageLink);
		
		WebElement addEmployeeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")));
		Helper.safeClick(driver, addEmployeeButton);
		
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		firstNameInput.sendKeys("John");
		
		WebElement middleNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName")));
		middleNameInput.sendKeys("M");
		
		WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
		lastNameInput.sendKeys("Doe");
		
		WebElement employeeIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/following::input[1]")));
		employeeIdInput.clear();
		employeeIdInput.sendKeys("1234");
		
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		Helper.safeClick(driver, saveButton);
		
		assertTrue(driver.getPageSource().contains("Personal Details"));
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
