package BTH4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

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

public class TestSearchProduct {
	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = InitBrowser.getDriver();
	}

	@Test
	void testSearchProduct() throws InterruptedException {
		driver.get("https://automationexercise.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']"))).click();
		
		assertTrue(driver.getPageSource().contains("All Products"));
		
		WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
		searchInput.sendKeys("Dress");
		
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_search")));
		Helper.safeClick(driver, searchButton);
		
		assertTrue(driver.getPageSource().contains("Searched Products"));
		
		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='productinfo text-center']")));
		
		assertTrue(products.size() > 0, "No products displayed!");
	}

	@AfterEach
	void tearDown() {
		InitBrowser.quitDriver(driver);
	}
}
