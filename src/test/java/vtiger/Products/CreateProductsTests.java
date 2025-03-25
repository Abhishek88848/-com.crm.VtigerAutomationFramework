package vtiger.Products;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtility.WebDriverUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.JavaUtility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductsTests
{

	@Test
	public void createProductsWithHardCodeTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION_TESTING_2024\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("admin");
		pwd.submit();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("Samsung s25");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Actions act = new Actions(driver);
		WebElement admElement = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(admElement).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		

	}
	
	@Test
	public void CreateProductWithDDT() throws IOException
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
		driver.close();
		
	}
	
	@Test
	public void createProductUdingPOM()
	{
		
	}
	
	@Test
	public void createProductsWithVendorsWithHardCodeTest()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement moreDrpDwn = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(moreDrpDwn).perform();
		WebElement vendorsLnk = driver.findElement(By.linkText("Vendors"));
		act.click(vendorsLnk).perform();
		WebElement vendorsLookUpImg = driver.findElement(By.xpath("//img[@title='Create Vendor...']"));
		vendorsLookUpImg.click();
		driver.findElement(By.name("vendorname")).sendKeys("Abhishek kelusker");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Products' and @href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("Oneplus 11r");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		
		Set<String> allIDs = driver.getWindowHandles();
		for(String oneID : allIDs)
		{
			String TITLE = driver.switchTo().window(oneID).getTitle();
			if(TITLE.contains("Vendors&action=Popup&html=Popup_picker&popuptype"))
			{
				break;
				
			}
			
		}
		
		driver.findElement(By.xpath("//a[text()='Abhishek kelusker']")).click();
		
		for(String oneID :  allIDs)
		{
			@Nullable
			String title = driver.switchTo().window(oneID).getTitle();
			if(title.contains("module=Products&action=EditView&return_action"))
			{
				break;
				
			}
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement administration = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(administration).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();		
	}
	
	
     @Test
     public void createProductsWithVendorsWithGenericUtilitiesTest() throws IOException
     {
    	 WebDriver driver = null;
    	 //step1: create the objects of all the generic utilities
    	 WebDriverUtility wUtil = new WebDriverUtility();
    	 PropertyFileUtility pUtil = new PropertyFileUtility();
    	 ExcelFileUtility eUtil = new ExcelFileUtility();
    	 JavaUtility jUtil = new JavaUtility();
    	 
    	 //step2: read the required data into testscript
    	 //read data from property file
    	 //load the property file into FileInputStream
    	 FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
    	 //create an object of properties class
    	  Properties pObj = new Properties();
    	  //load the object of File input stream into properties object
    	  pObj.load(fisp);
    	  //read the required data into testscript
    	String BROWSER =  pObj.getProperty("browser");
    	String URL = pObj.getProperty("url");
    	String USERNAME = pObj.getProperty("username");
    	String PASSWORD = pObj.getProperty("password");
    	
    	//read data from excel sheet
    	//load the excel file into FileInputStream
    	FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
    	//create an Object of WorkBook
    	Workbook wb = WorkbookFactory.create(fise);
    	//navigate to sheet
    	Sheet sh = wb.getSheet("Products");
    	Row row = sh.getRow(1);
    	Cell cel = row.getCell(3);
    	String productName = cel.getStringCellValue();
    	Cell cel2 = row.getCell(2);
    	String vendorsName = cel2.getStringCellValue();
    	
    	
    	 //Step3: launch the browser
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
    		System.out.println("firefox brower launched successfully");
    	}
    	else
    	{
    		System.out.println("non of the browser launched successfully");
    	}
    	
    	wUtil.maximizeWindow(driver);
    	wUtil.waitForElementsToLoadInDom(driver);
    	driver.get(URL);
    	
    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
    	driver.findElement(By.id("submitButton")).click();
    	WebElement moreDrpDwn = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
    	wUtil.mouseHoverOn(driver, moreDrpDwn);
    	WebElement vendorsLnk = driver.findElement(By.linkText("Vendors"));
    	wUtil.leftClickOn(driver, vendorsLnk);
    	WebElement VendorsLookUpImg = driver.findElement(By.xpath("//img[@title='Create Vendor...']"));
    	wUtil.leftClickOn(driver, VendorsLookUpImg);
    	 driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(vendorsName);
    	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	 
    	 driver.findElement(By.linkText("Products")).click();
    	 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
    	 driver.findElement(By.name("productname")).sendKeys(productName);
    	 driver.findElement(By.xpath("//img[@alt='Select']")).click();
    	 wUtil.switchToWindow(driver, "Vendors&action=Popup&html=Popup_picker&popuptype");
    	 driver.findElement(By.xpath("//a[text()='"+vendorsName+"']")).click();
    	 driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
    	 WebElement administrationImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	 wUtil.mouseHoverOn(driver, administrationImg);
    	WebElement signOutBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
    	 wUtil.leftClickOn(driver, signOutBtn);
    	 driver.quit();
    	 
     }
	
     @Test
     public void createProductsWithVendorsWithPOM()
     {
    	 
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
