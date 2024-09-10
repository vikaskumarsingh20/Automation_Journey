package Automated_Guy.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Implicit Wait: Waits up to 10 seconds for elements to appear (applies
			// globally)
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://www.facebook.com/");

			WebElement emailField = driver.findElement(By.id("email"));
			emailField.sendKeys("codersingh@gmail.com");

			WebElement passwordField = driver.findElement(By.id("pass"));
			passwordField.sendKeys("875321");

			// Explicit Wait: Wait until the login button is clickable before proceeding
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));

			loginButton.click();

		} catch (Exception e) {

			System.out.println("An error occurred: " + e.getMessage());
		} finally {

			driver.quit();
		}
	}
}
