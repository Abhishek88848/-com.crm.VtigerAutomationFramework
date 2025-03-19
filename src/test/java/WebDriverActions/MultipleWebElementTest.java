package WebDriverActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWebElementTest 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
		searchBox.sendKeys("iphone 16");
		searchBox.submit();
		List<WebElement> productsNames = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> productsPrices = driver.findElements(By.xpath("//div[@class='KzDlHZ']/parent::div[@class='col col-7-12']/following-sibling::div[@class='col col-5-12 BfVC2z']/descendant::div[@class='Nx9bqj _4b5DiR']"));
		int index = 0;
		for(WebElement productName : productsNames)
		{
			String Name = productName.getText();
			if(index < productsPrices.size())
			{
				String Price = productsPrices.get(index).getText();
				System.out.println(Name+"------->"+Price);
			}
	
			index++;
		}
		
	}

}
