package Automated_Guy.Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandlingDemo {
	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/users/sign_up");

		driver.findElement(By.id("user_full_name")).sendKeys("Ravi Singh");
		driver.findElement(By.id("input-lg text user_email_ajax")).sendKeys("ravisingh@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("1234789");
		driver.findElement(By.id("user_submit")).click();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage = driver.switchTo().alert().getText(); // capture alert message

		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(5000);
		alert.accept();
	}
}