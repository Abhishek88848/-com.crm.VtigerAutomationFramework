package vtiger.Products;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

public class CreateProductsWithoutHardCode 
{

	public static void main(String[] args) throws IOException 
	{
		Random r = new Random();
		int RANDOM = r.nextInt(10000);
		WebDriver driver=null ;
		//step1: read all the necessary data
		
		 // read the data from property file
		//load the property file location into file input stream
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//create an object of property file
		Properties pObj = new Properties();
		
		//load the file input stream into properties class
		pObj.load(fisp);
		
		//read the data into testscript
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//Step2: read data from excel sheet
		//load the excel file location into file input stream
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create an object of workbook
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Products");
		//navigate to row
		Row row = sh.getRow(4);
		
		//navigate to cell
		Cell cell = row.getCell(2);
		String productName = cell.getStringCellValue();
		
		//launch the browser example of run time polymorphism
		if(BROWSER.equalsIgnoreCase("CHROME"))
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
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//step3: login to application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		WebElement pwdElement = driver.findElement(By.xpath("//input[@type='password']"));
		pwdElement.sendKeys(PASSWORD);
		pwdElement.submit();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName+RANDOM);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		
		
		
		
		
	}

}
