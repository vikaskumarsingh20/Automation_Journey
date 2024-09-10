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

public class RandomFile {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
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

			// Wait for the Email OTP field to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("styles_optBtn__nGUBb"))); // Email
																												// OTP
																												// field

			// Wait for the Mobile OTP field to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("styles_optBtn__nGUBb"))); // Mobile
																												// OTP
																												// field

			// Pause for a short duration to simulate any potential delays
			Thread.sleep(2000);

			// Enter hardcoded OTP for both email and mobile
			driver.findElement(By.name("emailOtp")).sendKeys("AA4488"); // Email OTP
			Thread.sleep(2000);
			driver.findElement(By.name("mobileOtp")).sendKeys("AA4488"); // Mobile OTP
			Thread.sleep(4000);

			// Ensure both OTP fields are filled before enabling the button
			WebElement nextStepButton = driver.findElement(By.className("styles_nextStep__gGpOq"));
			if (driver.findElement(By.name("emailOtp")).getAttribute("value").equals("AA4488")
					&& driver.findElement(By.name("mobileOtp")).getAttribute("value").equals("AA4488")) {
				// Enable the button if both OTPs are filled
				wait.until(ExpectedConditions.elementToBeClickable(nextStepButton));

				// Click the button to proceed
				nextStepButton.click();
			} else {
				System.out.println("Both OTP fields must be filled.");
			}

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
				driver.quit(); // Close browser and end WebDriver session
			}
		}

	}
}
