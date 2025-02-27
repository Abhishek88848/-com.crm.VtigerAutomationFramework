package WebDriverActions;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrameTest 
{
	@Test
	public void nestedFrameTest()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try
		{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Frames.html");
		WebElement IframewithInAnButton = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		if(IframewithInAnButton.isDisplayed())
		{
			System.out.println("Iframe with in an Iframe is displaying");
			if(IframewithInAnButton.isEnabled())
			{
				System.out.println("Iframe with in an Iframe button is Enabled");
				if(IframewithInAnButton.isSelected())
				{
					System.out.println("Iframe with in an Iframe Button is selected");
				}
				else
				{
					System.out.println("Iframe with in an Iframe Button is not selected");
					IframewithInAnButton.click();
					WebElement nestedIFrames = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
					driver.switchTo().frame(nestedIFrames);
					WebElement iFrameDemo = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html' and @style='float: left;height: 250px;width: 400px']"));
					driver.switchTo().frame(iFrameDemo);
					driver.findElement(By.xpath("//input[@type='text']")).sendKeys("KELUSKER");
					driver.switchTo().defaultContent();
					driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
					driver.switchTo().frame("singleframe");
					driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ABHISHEK");
				}
			}
			else
			{
				System.out.println("Iframe with in an Iframe button is not Enabled");
			}
		}
		else
		{
			System.out.println("Iframe with in an Iframe is displaying is not displaying");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception is : "+e.getMessage());
		}
		
		finally
		{
			driver.quit();
		}
		
	}

}
