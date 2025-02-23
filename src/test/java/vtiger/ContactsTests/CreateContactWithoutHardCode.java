package vtiger.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class CreateContactWithoutHardCode 
{

	@Test(groups = "SmokeSuite")
	public void createContactWithoutHardCode() throws IOException
	{
		
		WebDriver driver;
		Random r = new Random();
		int RANDOM = r.nextInt();
		//step1: read all the necessary Data into testscript
		
		//Read data from property file
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		String BROWSER = pObj.getProperty("browser");
		
		
		//Read data from excel sheet
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Contacts");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		String LASTNAME = cel.getStringCellValue();
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver =  new ChromeDriver();
			System.out.println("chrome browser launched sucesfully");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched successfully");
		}
		else
		{
			System.out.println("invalid browser");
			driver = new ChromeDriver();
			System.out.println("chrome browser launched successfully");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//login to application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//navigate to Contacts module
         driver.findElement(By.linkText("Contacts")).click();
         
         //navigate to Contacts look up image
         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
         
         //fill the mandatory field
         driver.findElement(By.name("lastname")).sendKeys(LASTNAME+RANDOM);
         
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
