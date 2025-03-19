package vtiger.ContactsTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.JavaUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;

/**
 * this class contains create contact with organization test script
 * @author ADMIN
 *
 */
public class CreateContactWithOrganizationPOMTest  
{
	@Test(groups = "SmokeSuite")
	public void createContactWithOrganizationPOMTest() throws IOException
	{
		WebDriver driver = null;
		//create object of all the generic utilities
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//read the data into test script
		//read data from property file
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//read the data from excel sheet
		 String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
		 String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2);
		String INDUSTRYTYPE = eUtil.readDataFromExcelSheet("Contacts", 4, 4);
		
		//launch the browser
		 if (BROWSER.equalsIgnoreCase("chrome")) 
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 System.out.println("chrome browser launched successfully");
			
		}
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver =  new FirefoxDriver();
			 System.out.println("fire fox browser launched successfully");
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
		 lp.loginToApp(USERNAME, PASSWORD);
		 
		//navigate to organization link
		 HomePage hp = new HomePage(driver);
		 hp.clickOnOrganizationLnk();
		 
		//navigate to create new organization link
		 OrganizationsPage op = new OrganizationsPage(driver);
		 op.clickOnOrganizationsLookUpImg();
		 
		//fill the mandatory fields in create organization page and save it
		 CreateNewOrganizationPage cnop =  new CreateNewOrganizationPage(driver);
		 cnop.createNewOrganization(ORGNAME, INDUSTRYTYPE);
		 
		 
		//validation
		 OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		 String orgHeader = oip.getOrganizationHeaderInTextMethod();
		 
		 if(orgHeader.contains(ORGNAME))
		 {
			 System.out.println("pass");
			 System.out.println("organization created successfully");
		 }
		 else
		 {
			 System.out.println("FAIL");
			 System.out.println("org not created ");
		 }
		 
	    //navigate to contacts link
		 hp.clickOnContactsLnk();
		 
		//navigate to create new contacts link
		 ContactsPage cp = new ContactsPage(driver);
		 cp.clickOnCreateContactsLookUpImg();
		 
		//fill the mandatory fields and save it
		 
		 CreateNewContactPage cncp = new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME, driver, ORGNAME);
		 
		//validation
		 ContactInformationPage cip = new ContactInformationPage(driver);
		 String conHeader = cip.getContactHeaderText();
		 if (conHeader.contains(LASTNAME)) 
		 {
			 System.out.println("PASS");
			 System.out.println(" contact created successfully");
			
		}
		 else
		 {
			 System.out.println("contact not created");
		 }
		//logout
		 hp.SignOutOfApp(driver);
		 
		 System.out.println("contact with organization got created");
		
	}
	
	

}
