package WebDriverActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropTest 
{
     @Test
     public void DragAndDropTest()
     {
    	 WebDriverManager.firefoxdriver().setup();
    	 WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	 driver.get("http://www.dhtmlgoodies.com/packages/dhtml-suite-for-applications/demos/demo-drag-drop-3.html");
    	 WebElement srcOslo =  driver.findElement(By.xpath("//div[@id='dropContent']/child::div[text()='Oslo']"));
    	 WebElement dropNorway = driver.findElement(By.xpath("//div[text()='Norway']"));
    	 
    	 Actions act = new Actions(driver);
    	 act.dragAndDrop(srcOslo,dropNorway);
    	// act.perform();
    	 
    	WebElement dragWashington = driver.findElement(By.xpath("//div[@id='dropContent']/child::div[text()='Washington']"));
    	WebElement dropUnited = driver.findElement(By.xpath("//div[text()='United States']"));
        //act.dragAndDrop(dragWashington , dropUnited);
        //act.dragAndDrop(dragWashington , dropUnited).perform();
    	
    	
    	WebElement srcElement = driver.findElement(By.xpath("//div[@id='dropContent']/child::div[text()='Rome']"));
    	WebElement targetElement = driver.findElement(By.xpath("//div[text()='Italy']"));
    	act.dragAndDrop(srcElement, targetElement);
    	//act.perform();
    	
    	act.dragAndDrop(srcOslo, dropNorway).dragAndDrop(dragWashington, dropUnited).dragAndDrop(srcElement, targetElement).build().perform();
     }
	
	
}
