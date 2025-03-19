package WebDriverActions;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionHandlingTest 
{
	
	@Test
	public void autoSuggestionTest() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.wikipedia.org/");
     	WebElement element = driver.findElement(By.name("search"));
     	element.sendKeys("Abhishek");
     	List<WebElement> suggetions = driver.findElements(By.xpath("//em[@class='suggestion-highlight']"));
     	for(WebElement suggetion : suggetions)
     	{
     		String NAME = suggetion.getText();
     		System.out.println(NAME);
     		
     	}
		
	}
	
	
	
	
	

}
