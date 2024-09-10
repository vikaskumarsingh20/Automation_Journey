package Automated_Guy.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BhaskarPageLoginAndSignUp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://uat.startupindia.gov.in/bhaskar/register");
			driver.manage().window().maximize();
//			driver.manage().window().setSize(new Dimension(1552, 840));

			// Add explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

			// Filling in the registration form
			driver.findElement(By.id("firstName")).sendKeys("Vikas");
			driver.findElement(By.id("lastName")).sendKeys("Singh");

			Select nationality = new Select(driver.findElement(By.id("nationality")));
			nationality.selectByIndex(1);

			driver.findElement(By.id("emailId")).sendKeys("vikaskumarsingh12311@gmail.com");
			driver.findElement(By.id("mobileNumber")).sendKeys("9821190201");
			driver.findElement(By.id("password")).sendKeys("Test@231");
			driver.findElement(By.id("confirmPassword")).sendKeys("Test@231");

			// Click "Generate OTP for Email & Mobile"
			driver.findElement(By.className("styles_nextStep__gGpOq")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("styles_optBtn__nGUBb"))); // Email
																												// OTP
																												// field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("styles_optBtn__nGUBb"))); // Mobile
																												// OTP
																												// field

			Thread.sleep(2000);
			// Enter hardcoded OTP for both email and mobile
			driver.findElement(By.name("emailOtp")).sendKeys("AA4488"); // Email OTP
			Thread.sleep(2000);
			driver.findElement(By.name("mobileOtp")).sendKeys("AA4488"); // Mobile OTP
			Thread.sleep(4000);

			// Submit the form or proceed to the next step (assuming there's a button to
			// click after OTP verification)
			driver.findElement(By.className("styles_nextStep__gGpOq")).click();

			// Verify redirection to the next page after OTP submission (Update this as per
			// your actual next step URL)
			String expectedUrl = "https://uat.startupindia.gov.in/bhaskar/register/stepone";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);
			Thread.sleep(4000);
			// Optionally, verify a welcome message or any other element on the next page
			WebElement welcomeMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcomeMessage")));
			Assert.assertTrue(welcomeMessage.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Ensure driver.quit() is always called, even if an exception occurs
			if (driver != null) {
				driver.close(); // Close browser and end WebDriver session
			}
		}

	}
}
