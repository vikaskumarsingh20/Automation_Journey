package Automated_Guy.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {

	public static void main(String[] args) {
		// Set the path for the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the specified URL
		driver.get("https://uat.startupindia.gov.in/bhaskar/register");

		// Locate the input field for the first name using its ID
		WebElement firstNameInput = driver.findElement(By.id("firstName"));

		// Fill the input field with a sample first name
		firstNameInput.sendKeys("John");

		// Optionally, you can add a comment to indicate the action
		System.out.println("Filled the first name input with 'John'.");

		// Close the browser after the operation
		driver.quit();
	}
}