package WebDriverActions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class ScrollHandlingTest 
{
	@Test
	public void ScrollHandlingTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		//driver.findElement(By.xpath("//span[@role='button']")).click();
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
		searchBox.sendKeys("iphone 16");
		searchBox.submit();
		WebElement element = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Teal, 128 GB)']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
	}

}
