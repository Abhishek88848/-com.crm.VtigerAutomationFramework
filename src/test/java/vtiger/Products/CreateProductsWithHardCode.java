package vtiger.Products;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductsWithHardCode 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION_TESTING_2024\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("admin");
		pwd.submit();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("Samsung s25");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Actions act = new Actions(driver);
		WebElement admElement = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(admElement).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		

	}

}
