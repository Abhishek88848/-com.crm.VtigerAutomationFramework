package vtiger.Vendors;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.JavaUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;

public class CreateVendorTest 
{
	@Test
	public void createVendorWithHardCode()
	{
		//step1: launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//step2: launch the url
		driver.get("http://localhost:8888/index.php");
		
		//step3: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to vendors
		WebElement moreDrpDwn = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(moreDrpDwn).perform();
		WebElement vendorsLnk = driver.findElement(By.name("Vendors"));
		act.moveToElement(vendorsLnk).click().build().perform();
		
		//click on create new vendor lookup image
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		
		//give required credentials
		driver.findElement(By.name("vendorname")).sendKeys("Google");
		
		//save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//signOut
		WebElement signOutDropDown = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(signOutDropDown).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//close the browser
		driver.quit();
		
	}
	
	
	@Test
	public void createVendorWithDDT() throws EncryptedDocumentException, IOException
	{
		WebDriver driver=null;
		//step1: read the required data from Property File
		//load the property file into FileInputStream
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		//create an object of Properties class
		Properties pObj = new Properties();
		//load the file input stream object into properties class object
		pObj.load(fisp);
		//read the required data from property file into TestScript
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//step2: read data from excel file
		//load the excel file into file input stream
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create an object of workbook and load the fise object into it
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Vendor");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		String vendorName = cell.getStringCellValue();
		
		//step3: launch the browser
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched successfully");
			
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox driver launched successfully");
		}
		else
		{
			System.out.println("non of the browser launched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//launche the url
		driver.get(URL);
		
		// login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to the vendons
		WebElement moreDrpDwn = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(moreDrpDwn).perform();
		WebElement vendorsLnk = driver.findElement(By.name("Vendors"));
		act.moveToElement(vendorsLnk).click().build().perform();
		
		//click on create new vendors lookup image
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		
		// enter the required filed
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		
		//save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//signout
		WebElement signOutDropDown = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(signOutDropDown).perform();
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		act.click(signOut).perform();
		
		driver.close();
		
	}
	
	@Test
	public void createVendorWithGenericUtilsTest() throws IOException, InterruptedException
	{
		WebDriver driver = null;
		//step1: create objects of generic utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step2: read required data into TestScript
		//FROM PROPERTY FILE
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//FROM EXCELSHEET
		String vendorName = eUtil.readDataFromExcelSheet("Vendor", 1, 2);
		
		//step3: launch the browser
		if(BROWSER.equalsIgnoreCase("ChRoMe"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched successfully");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox driver launched successfully");
		}
		else
		{
			System.out.println("non of the browser launched");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		/*
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		WebElement clickButton = driver.findElement(By.id("submitButton"));
		wUtil.leftClickOn(driver, clickButton);
		
		//navigate to vendors module
		WebElement moreDropDown = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wUtil.mouseHoverOn(driver, moreDropDown);
		WebElement vendorModule = driver.findElement(By.name("Vendors"));
		wUtil.mouseHoverOn(driver, vendorModule);
		wUtil.leftClickOn(driver);
		
		//click on create new vendor lookup image
		WebElement vendorLookupImg = driver.findElement(By.xpath("//img[@title='Create Vendor...']"));
		wUtil.leftClickOn(driver, vendorLookupImg);
		
		//enter the required data 
		driver.findElement(By.name("vendorname")).sendKeys(vendorName+jUtil.getRandomNumber());
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//signout
		WebElement signoDrpDwn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, signoDrpDwn);
		wUtil.leftClickOn(driver, driver.findElement(By.linkText("Sign Out")));// if we are passing element directly then no need to type ;
		
		Thread.sleep(3000);
		driver.quit();
		
		*/
		
		
		
		
	}

}
