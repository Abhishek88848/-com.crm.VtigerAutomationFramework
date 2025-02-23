package vtiger.PractiseTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class CreateContactWithHardcodeTest
{

	public static void main(String[] args) 
	{
		Random r = new Random();
		int RANDOM = r.nextInt(10000);
		//step1: launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//step2: login to application
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		WebElement passElement = driver.findElement(By.name("user_password"));
		passElement.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step3: navigate to contacts module or link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step4: navigate to contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step5: fill the data to the mandatory field
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kelusker"+RANDOM);
		
		
		//step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//step7: logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign Out']")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	  
		
		
		

	}

}
