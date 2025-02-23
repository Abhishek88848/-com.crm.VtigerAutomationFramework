package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DOB 
{

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,300);");
			
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		WebElement monthEle = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		
		Select sel = new Select(monthEle);
		sel.selectByVisibleText("Apr");
		
		Select Sel1 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		Sel1.selectByVisibleText("1998");
		
		String date ="9";
		
		 List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		 
		 for(WebElement dt : allDates)
		 {
			 String dtText = dt.getText();
			 if(dtText.equals(date))
			 {
				 dt.click();
				 break;
			 }
		 }
		
		
		
		
		
		
		

	}

}
