package WebDriverActions;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class DragAndDropByTest 
{
	@Test
	public void dragAndDropTest()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
		searchBox.sendKeys("iphone 16");
		searchBox.submit();
		WebElement element = driver.findElement(By.xpath("//div[@style='transform: translateX(0px);']/child::div[@class='PYKUdo']"));
		WebElement element2 = driver.findElement(By.xpath("//div[@style='transform: translateX(-1.19px);']/child::div[@class='PYKUdo']"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(element, 40, 0).perform();
		act.dragAndDropBy(element2, -40, 0).perform();
		
	//	act.dragAndDropBy(element, 40, 0).dragAndDropBy(element2, -40, 0).build().perform();
		
	}

}
