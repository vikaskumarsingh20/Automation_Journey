package Automated_Guy.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class test 

{
	@Test
	public void xcc ()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20,)
		
		driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Vikas");
		driver.findElement(By.xpath("(//input[@id='userName'])[1]")).sendKeys("Here i am entering the name in input tag");
//		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
//
//        // Create a new instance of the ChromeDriver
//        WebDriver driver = new ChromeDriver();
//
//        // Maximize the browser window
//        driver.manage().window().maximize();
//
//        // Navigate to the specified URL
//        driver.get("https://uat.startupindia.gov.in/bhaskar/register");

//        // Locate the input field for the first name using its ID
//        WebElement firstNameInput = driver.findElement(By.id("firstName"));
//
//        // Fill the input field with a sample first name
//        firstNameInput.sendKeys("John");
//
//        // Optionally, you can add a comment to indicate the action
//        System.out.println("Filled the first name input with 'John'.");
        
        driver.close();
		
		
	}
	

}
