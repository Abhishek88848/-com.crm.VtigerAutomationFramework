package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxActionTest 
{

	public static void main(String[] args) 
	{
		
		        System.setProperty("webdriver.chrome.driver", "D:\\\\AUTOMATION_TESTING_2024\\\\chromedriver-win32\\\\chromedriver.exe");
		        WebDriver driver = new ChromeDriver();

		        try
		        {
		            driver.get("https://seleniumbase.io/demo_page");
		            driver.manage().window().maximize();

		            // Locate the checkbox element
		            WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkBox1']"));

		            // Perform operations
		            performCheckboxOperations(checkbox);

		        } 
		        catch (Exception e)
		        {
		            System.out.println("Test failed due to exception: " + e.getMessage());
		        } 
		        finally 
		        {
		            // Close the browser
		            driver.quit();
		        }
		    }
		    public static void performCheckboxOperations(WebElement checkbox) 
		    {
		        // Validate if the checkbox is displayed
		        if (checkbox.isDisplayed()) 
		        {
		            System.out.println("Checkbox is displayed.");

		            // Validate if the checkbox is enabled
		            if (checkbox.isEnabled()) 
		            {
		                System.out.println("Checkbox is enabled.");

		                // Check if the checkbox is already selected
		                if (!checkbox.isSelected()) 
		                {
		                    checkbox.click();
		                    System.out.println("Checkbox was not selected. It is now checked.");
		                    Assert.assertTrue(checkbox.isSelected(), "Checkbox should be selected after clicking.");
		                } 
		                else 
		                {
		                    System.out.println("Checkbox is already selected.");
		                }

		                // Perform uncheck operation
		                checkbox.click();
		                System.out.println("Checkbox is now unchecked.");
		                Assert.assertFalse(checkbox.isSelected(), "Checkbox should not be selected after clicking again.");

		            }
		            else 
		            {
		                System.out.println("Checkbox is disabled. Cannot perform actions.");
		                Assert.fail("Checkbox is disabled.");
		            }
		        } 
		        else 
		        {
		            System.out.println("Checkbox is not visible on the webpage.");
		            Assert.fail("Checkbox is not displayed.");
		        }
		    }
		


	}



