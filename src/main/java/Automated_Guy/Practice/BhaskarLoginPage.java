package Automated_Guy.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BhaskarLoginPage {

	public static void main(String[] args) {
		
		// MY INITIAL CODE
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try { 
			driver.get("https://uat.startupindia.gov.in/bhaskar/register");
			driver.manage().window().maximize();
		    driver.findElement(By.id("firstName")).sendKeys("Vikas");
		    driver.findElement(By.id("lastName")).sendKeys("Singh");
	        driver.findElement(By.id("nationality")).click();
		    Select nationality = new Select(driver.findElement(By.id("nationality")));
		    nationality.selectByIndex(1);
		    driver.findElement(By.id("emailId")).sendKeys("vikaskumarsingh123@gmail.com");
		    driver.findElement(By.id("mobileNumber")).sendKeys("9865432276");
		    driver.findElement(By.id("password")).sendKeys("Test@231");
		    driver.findElement(By.id("confirmPassword")).sendKeys("Test@231");
		    Thread.sleep(4000);
		    driver.findElement(By.className("styles_nextStep__gGpOq")).click();
		    
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
