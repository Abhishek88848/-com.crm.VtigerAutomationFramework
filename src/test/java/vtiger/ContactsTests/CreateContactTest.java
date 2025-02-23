package vtiger.ContactsTests;

import vtiger.genericUtility.JavaUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;
/**
 * this test script will create a contact
 * @author ADMIN
 *
 */
public class CreateContactTest 
{

	@Test
	public void createContactTest() throws IOException
	{
		WebDriver driver;// if we didnot initialize diver ( driver= new chromedriver();) still want to use driver reference than we need to give value as null. 
		/*Create object of generic utilities*/
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		/*Read all the necessary data from property file*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*Read all the necessary data from excel sheet*/
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1 , 2);
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox launched successfully");
		}
		else
		{
			System.out.println("invalid Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched successfully");
		}
		 
		//login
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		//navigate to contacts module
		driver.findElement(By.linkText("Contacts")).click();
		
		//navigate to contacts look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		//apply necessary data to the required field
		 driver.findElement(By.name("lastname")).sendKeys(LASTNAME+jUtil.getRandomNumber());
		 
		//save
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 
		//logout
		 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         Actions act = new Actions(driver);
         act.moveToElement(element).perform();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign Out']")));
 		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
