package vtiger.ContactsTests;

import vtiger.genericUtility.JavaUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;

public class CreateContactWithOrganizationTest 
{

	@Test(groups = "RegressionSuite")
	public void createContactWithOrganizationTest() throws IOException
	{
		WebDriver driver= null ;
		/*Create object of generic Utilities*/
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		/* Read the required data into test script*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 3);
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 2);
		int RANNUM =jUtil.getRandomNumber();
		
		
		
		//launch the browser
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
			System.out.println("-------------invalid browser------------");
		}
		
		
		//login to application
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//navigate to organization module/link
		driver.findElement(By.linkText("Organizations")).click();
		
		//navigate to create organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//fill the data into required field
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+RANNUM);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String orgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgName);
		if(orgName.contains(ORGNAME+RANNUM))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization not created");
		}
		
		//navigate to the contacts module
		driver.findElement(By.linkText("Contacts")).click();
		
		//navigate to the create contact link
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//fill the data to the required field
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+RANNUM);
		
		//navigate to child window
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title=\"Select\"]")).click();
		wUtil.switchToWindow(driver, "specific_contact_account");
		
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME+RANNUM);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.linkText(ORGNAME+RANNUM)).click();
		wUtil.switchToWindow(driver, "Contacts&action");
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String contactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactName);
		if (contactName.contains(LASTNAME+RANNUM))
		{
		  System.out.println("contact created successfully");	
		}
		else
		{
			System.out.println("contact not created successfully");
		}
		
		
		//logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("create contact with organization test script got completed succeddfully");
		

	}
	
	@Test
	public void regionalRegressionPractice2Test()
	{
		System.out.println("This 2nd testScript got Effected");
	}

}
