package WebDriverActions;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Set;

public class WindowHandlingTest 
{
	@Test
	public void windowHandlingTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
		searchBox.sendKeys("iphone 16");
		
		searchBox.submit();
		driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Black, 128 GB)']")).click();
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId : allWindowIds)
		{
			
			String TITLE = driver.switchTo().window(windowId).getTitle();
			if(TITLE.equals("apple-iphone-16-black-128-gb")) //child window partial value
			{
				break;
				
			}
		}
		String priceText = driver.findElement(By.xpath("//span[text()='Apple iPhone 16 (Black, 128 GB)']/ancestor::div[@class='C7fEHH']/descendant::div[@class='Nx9bqj CxhGGd']")).getText();
		System.out.println(priceText);
	}

}
