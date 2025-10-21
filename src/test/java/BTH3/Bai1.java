package BTH3;

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

public class Bai1 {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testBai1() throws InterruptedException {
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(10000);

		WebElement firstName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
		firstName.sendKeys("Phan Dinh");
		
		WebElement lastName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastname']")));
		lastName.sendKeys("Phu");
		
		WebElement gender = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sex-0']")));
		Helper.safeClick(driver, gender);
		
		WebElement experience = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='exp-4']")));
		Helper.safeClick(driver, experience);
		
		WebElement date = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datepicker']")));
		date.sendKeys("10/10/2023");
		
		WebElement profession = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profession-1']")));
		Helper.safeClick(driver, profession);
		WebElement automation = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='profession-0']")));
		Helper.safeClick(driver, automation);
		
		WebElement tool = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='tool-2']")));
		Helper.safeClick(driver, tool);
		
		WebElement continent = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='continents']")));
		continent.sendKeys("Australia");
		
		WebElement commands = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='selenium_commands']")));
		commands.sendKeys("Browser Commands");
		
		Thread.sleep(5000);
		
		WebElement chooseFile = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='photo']")));
		chooseFile.sendKeys("E:\\workspace\\SoftwareDev\\ProxyUML.png");
		
		Thread.sleep(5000);
		
		WebElement button = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));
		Helper.safeClick(driver, button);
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
