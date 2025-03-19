package vtiger.OrganizationsTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.JavaUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;

public class CreateNewOrgWithIndustryTestNGTest 
{
	//create Object of all the utilities globally 
	JavaUtility jUtil = new JavaUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
			
	@Test(dataProvider = "MultipleOrg", groups = {"SmokeSuite","Regression"})
	public void createNewOrgWithIndustryTest(String orgName, String industryType) throws IOException
	{
		WebDriver driver = null;
		
		//read the data into testscript
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = orgName+jUtil.getRandomNumber();
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched successfully");
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser launched successfully");
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//login to application
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		//navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();
		
		//navigate to create new organization lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationsLookUpImg();
		
       //fill the required field and save it
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, industryType);
		
		//validation
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String ORGHEADER = oip.getOrganizationHeaderInTextMethod();
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		hp.SignOutOfApp(driver);
		
		
	}
	
	@DataProvider(name = "MultipleOrg")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
	
	@Test
	public void regionalRegressionPractice1Test()
	{
		System.out.println("THIS testScript got ehhected");
	}

}
