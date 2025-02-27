package WebDriverActions;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

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
	
	@Test
	public void dropDownUsingFinadElementTest() throws AWTException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userNameField = driver.findElement(By.name("username"));
		userNameField.sendKeys("Admin", Keys.TAB, "admin123");
		userNameField.submit();
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
		driver.findElement(By.linkText("Assign Leave")).click();
		driver.findElement(By.xpath("//div[text()='-- Select --']")).click();
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.quit();	
		
	}
	
	@Test
	public void selectClassTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoqa.com/select-menu");
		
		WebElement element = driver.findElement(By.id("oldSelectMenu"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		
		Select sel = new Select(element);
		sel.selectByIndex(6);
		Thread.sleep(3000);
		sel.selectByValue("5");
		Thread.sleep(3000);
		sel.selectByVisibleText("Voilet");
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
