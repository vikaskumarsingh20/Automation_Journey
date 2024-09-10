package Automated_Guy.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();

			// Find and interact with the search box
			WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
			searchbox.sendKeys("Iphone X");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

			// Click on the first result for "Apple iPhone 13 (128GB) - Blue"
			driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Blue")).click();
			driver.findElement(By.xpath("(//img[@alt='Apple iPhone 13 (128GB) - Blue'])[1]")).click();

			// Additional interactions or logic (e.g., selecting quantity) can be added here

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
