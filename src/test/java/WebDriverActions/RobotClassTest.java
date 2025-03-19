package WebDriverActions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RobotClassTest
{

	@Test
	public void robotClassTest() throws AWTException
	{
		WebDriverManager.edgedriver().setup();
		 WebDriver driver = new EdgeDriver();
		
		try
		{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://actitime.com/demo-request");
		WebElement cookieButton = driver.findElement(By.xpath("//button[normalize-space(text())='Accept']"));
		cookieButton.click();
		driver.findElement(By.id("first-name")).sendKeys("Abhishek");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);
		
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);
		
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);
		
		r.keyPress(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_E);
		
		r.keyPress(KeyEvent.VK_K);
		r.keyRelease(KeyEvent.VK_K);
		
		driver.findElement(By.xpath("//div[@class='form-contact__cell']/child::input[@type='email']")).sendKeys("abhishek.kelusker007@gmail.com",Keys.TAB, "CMRIT");
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			System.out.println("exception is :"+e.getMessage());
		}
		finally
		{
			driver.close();
		}
		
		
		
	}
}