package Automated_Guy.Practice.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPraticeForm {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open URL
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

		driver.manage().window().setSize(new Dimension(1552, 840));

		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).sendKeys("Tom");

		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).sendKeys("Wood");
		// Select Gender
		driver.findElement(By.id("sex-0")).click();
		// Select Experience
		driver.findElement(By.id("exp-4")).click();
		// Enter Date
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.id("datepicker")).sendKeys("16-10-2020");
		// Select Profession
		driver.findElement(By.id("profession-1")).click();
		// Select Automation Tool
		driver.findElement(By.id("tool-2")).click();

		// Select Continent
		driver.findElement(By.id("continents")).click();
		WebElement dropdown = driver.findElement(By.id("continents"));
		dropdown.findElement(By.xpath("//option[. = 'Europe']")).click();

		// Select Command
		WebElement dropdown1 = driver.findElement(By.id("selenium_commands"));
		dropdown1.findElement(By.xpath("//option[. = 'Browser Commands']")).click();

		// Scroll Vertical
//		js.executeScript("window.scrollTo(0,675.5555419921875)");

		// Click Submit
		driver.findElement(By.id("submit")).click();
	}
}