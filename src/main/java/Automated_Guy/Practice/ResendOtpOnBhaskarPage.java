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

public class ResendOtpOnBhaskarPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.startupindia.gov.in/bhaskar/register");
		driver.manage().window().maximize();

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

		// Wait for OTP fields to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailOtp"))); // Email OTP field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mobileOtp"))); // Mobile OTP field

		// Enter hardcoded OTP for both email and mobile
		driver.findElement(By.name("emailOtp")).sendKeys("AA4488"); // Email OTP
		driver.findElement(By.className("mobileOtp")).sendKeys("AA4488"); // Mobile OTP

		// Submit the form or proceed to the next step
		driver.findElement(By.className("styles_nextStep__gGpOq")).click();

		// Check if OTP verification fails (using a failure message, update selector as
		// needed)
		boolean otpFailed = false;
		try {
			// Wait to see if an OTP verification failure message appears (update the
			// element as per actual page)
			WebElement otpErrorMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("styles_resend__bcWyK")));
			otpFailed = otpErrorMessage.isDisplayed();
		} catch (Exception e) {
			// If no failure message appears, assume OTP verification was successful
			otpFailed = false;
		}

		if (otpFailed) {
			System.out.println("OTP verification failed, resending OTP...");

			// Click the "Resend OTP" button
			driver.findElement(By.className("styles_resend__bcWyK")).click();

			// Wait for the new OTP fields to reappear (this might already be visible)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailOtp")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mobileOtp")));

			// Re-enter hardcoded OTP again
			driver.findElement(By.name("emailOtp")).clear();
			driver.findElement(By.name("emailOtp")).sendKeys("AA4488"); // Email OTP
			driver.findElement(By.className("mobileOtp")).clear();
			driver.findElement(By.className("mobileOtp")).sendKeys("AA4488"); // Mobile OTP

			// Submit OTP again
			driver.findElement(By.className("styles_nextStep__gGpOq")).click();
		}

		// Verify redirection to the next page after OTP submission
		String expectedUrl = "https://uat.startupindia.gov.in/bhaskar/register/stepone";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		// Optionally, verify a welcome message or any other element on the next page
		WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcomeMessage")));
		Assert.assertTrue(welcomeMessage.isDisplayed());

		// Close the browser
		driver.quit();
	}
}
