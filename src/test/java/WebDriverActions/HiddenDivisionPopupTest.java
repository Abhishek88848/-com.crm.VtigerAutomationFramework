package WebDriverActions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiddenDivisionPopupTest 
{
	//https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html
	//https://aquabottesting.com/?utm_source=chatgpt.com
	@Test
	public void hiddenDivisionPopupTest() throws InterruptedException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://aquabottesting.com/?utm_source=chatgpt.com");
		WebElement POPUP = driver.findElement(By.xpath("//a[text()='POP-UP']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", POPUP);
		jse.executeScript("window.scrollBy(0,-150);", POPUP);
		Actions act = new Actions(driver);
		act.moveToElement(POPUP).click().build().perform();
		WebElement checkBox = driver.findElement(By.xpath("//p[normalize-space(text())='Check a check box']/child::input[@type='checkbox']"));
		if(checkBox.isDisplayed())
		{
			System.out.println("Checkbox is displaying");
			if(checkBox.isEnabled())
			{
				System.out.println("checkbox is interactable");
				if(checkBox.isSelected())
				{
					System.out.println("checkbox is selected");
				}
				else
				{
					System.out.println("checkbox is not selected");
					checkBox.click();
				}
			}
			else
			{
				System.out.println("Checkbox is not interactable");
			}
			
		}
		else
		{
			System.out.println("checkbox is not displaying");
		}
		
		driver.findElement(By.xpath("(//div[@class='form-group']/child::input[@type='text' and @class='form-control-input'])[1]")).sendKeys("Abhishek");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='colors']"));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Yellow");
		Thread.sleep(3000);
		sel.selectByIndex(4);
		dropDown.submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='All fields were validated!']")));
		
		String TEXT = driver.findElement(By.xpath("//div[text()='All fields were validated!']")).getText();
		if(TEXT.equalsIgnoreCase("All fields were validated!"))
		{
			System.out.println("all field entered is correct");
			WebElement xButton = driver.findElement(By.xpath("//button[text()='×']"));
			xButton.click();
			Thread.sleep(2000);
			driver.quit();
		}
		else
		{
			System.out.println("all filed enter is incorrect pls check it");
		}
		
		
		
		
	}

}
