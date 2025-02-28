package WebDriverActions;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptAlertTest 
{
	
	@Test
	public void promptAlert()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alt = driver.switchTo().alert();
		String TEXT = alt.getText();
		System.out.println(TEXT);
		alt.sendKeys("Abhishek kelusker");
		alt.accept();
		WebElement elementText = driver.findElement(By.xpath("//p[@id='demo']"));
		String TEXT1 = elementText.getText();
		System.out.println(TEXT1);
		if(TEXT1.equalsIgnoreCase("Hello Abhishek kelusker! How are you today?"))
		{
			System.out.println("expected and required text are matching");
			
		}
		else
		{
			System.out.println("expected and required text are not matching");
		}
		driver.quit();
		
	}

}
