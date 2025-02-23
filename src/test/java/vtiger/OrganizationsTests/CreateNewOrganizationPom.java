package vtiger.OrganizationsTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.JavaUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateNewOrganizationPom
{

	@Test(groups = "SmokeSuite")
	public void createOrganizationTest() throws IOException
	{
		WebDriver driver= null;
		//Step1: create objects of generic utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step2: read the data into testscript
		//read the data from property file
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//read data from excel sheet
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 1, 2)+jUtil.getRandomNumber();
		//String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 1, 2);
		//int RANDOM = jUtil.getRandomNumber();
		//String ORGRAN = ORGNAME+RANDOM;
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched successfully");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox browsr launched successfully");
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		//login to application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getLoginToApp(USERNAME,PASSWORD);
		
		//navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();
		
		//click on create new organization link
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationsLookUpImg();
		
		// fill the required data and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//validation
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String headerText = oip.getOrganizationHeaderInTextMethod();
		if (headerText.contains(ORGNAME)) 
		{
			System.out.println("pass");
			System.out.println("organization created successfully");
		}
		else
		{
			System.out.println("fail");
			System.out.println("organization not created");
		}
		
		//logout
		hp.SignOutOfApp(driver);
		

	}

}
