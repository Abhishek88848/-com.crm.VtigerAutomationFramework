package WebDriverActions;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandlingTest 
{
	
	@Test
	public void dropDownUsingMouseHoverTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		WebElement dropDown = driver.findElement(By.xpath("//span[text()='Home & Furniture']"));
		Actions act = new Actions(driver);
		act.moveToElement(dropDown).perform();
		WebElement petElement = driver.findElement(By.xpath("//a[text()='Pet & Gardening']")); 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", petElement);
		act.moveToElement(petElement).click().build().perform();
		driver.quit();
		
	}

}
