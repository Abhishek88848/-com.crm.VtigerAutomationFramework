package vtiger.OrganizationsTests;

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

public class CreateOrganizationWithoutHardcodeTest 
{
	
           @Test
           public void createOrganizationWithoutHardCodeTest() throws IOException
			{
				WebDriver driver;
				Random r = new Random();
				int RANDOM = r.nextInt(1000);
				//Step1 : Read the necessary data into testscript
				//Read the data from property file
				FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				Properties pObj = new Properties();
				pObj.load(fisp);
				String BROWSER = pObj.getProperty("browser");
				String URL = pObj.getProperty("url");
				String USERNAME = pObj.getProperty("username");
				String PASSWORD = pObj.getProperty("password");
				
				//Read data from excel sheet
				FileInputStream fise =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fise);
				 Sheet sh = wb.getSheet("Organizations");
				 Row row = sh.getRow(1);
				  Cell cell = row.getCell(2);
				String  ORGNAME = cell.getStringCellValue();
				
				//Step2: launch the browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
					System.out.println("Chrome browser launched sucessfully");
				}
				else if(BROWSER.equalsIgnoreCase("Firefox"))
				{
					driver = new FirefoxDriver();
					System.out.println("firefox browser launched sucessfully");
				}
				else
				{
					driver = new ChromeDriver();
					System.out.println("Chrome browser launched sucessfully");		
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				//step3 :login
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				//step4: navigate to organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step5: navigate to create organization lookup image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//step6: fill the necessary data 
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
				
				//step7: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step8: logout
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
				System.out.println("clicked on administration");
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement signOutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign Out']")));
				signOutElement.click();
				//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("organization created sucessfully");
						

			}

}

