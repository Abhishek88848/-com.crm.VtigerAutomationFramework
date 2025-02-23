package vtiger.ContactsTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
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
import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.ExcelFileUtility;
import vtiger.genericUtility.JavaUtility;
import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;

public class CreateConWithOrgUsingBaseClassTest extends BaseClass 
{
	@Test(groups = {"RegressionSuite", "SmokeSuite"})
	public void createConWithOrgTest() throws EncryptedDocumentException, IOException
	{
		
		
		//read the data into test script
		//read the data from excel sheet
		 String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
		 String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2);
		String INDUSTRYTYPE = eUtil.readDataFromExcelSheet("Contacts", 4, 4);
		
		 
		//navigate to organization link
		 HomePage hp = new HomePage(driver);
		 hp.clickOnOrganizationLnk();
		 Reporter.log("Clicked on organization link successfully", true);
		 
		//navigate to create new organization link
		 OrganizationsPage op = new OrganizationsPage(driver);
		 op.clickOnOrganizationsLookUpImg();
		 Reporter.log("Clicked on organization lookup img successfully", true);
		 
		//fill the mandatory fields in create organization page and save it
		 CreateNewOrganizationPage cnop =  new CreateNewOrganizationPage(driver);
		 cnop.createNewOrganization(ORGNAME, INDUSTRYTYPE);
		 
		 
		//validation
		 OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		 String orgHeader = oip.getOrganizationHeaderInTextMethod();
		 
		 if(orgHeader.contains(ORGNAME))
		 {
			 System.out.println("pass");
			 Reporter.log("organization created successfully", true);
		 }
		 else
		 {
			 System.out.println("FAIL");
			 Reporter.log("organization not created ", true);
		 }
		 
	    //navigate to contacts link
		 hp.clickOnContactsLnk();
		 Reporter.log("Clicked on Create Contact link successfully", true);
		 
		//navigate to create new contacts link
		 ContactsPage cp = new ContactsPage(driver);
		 cp.clickOnCreateContactsLookUpImg();
		 Reporter.log("Clicked on Create Contact Lookup image successfully", true);
		 
		 CreateNewContactPage cncp = new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME, driver, ORGNAME);
		 
		//validation
		 ContactInformationPage cip = new ContactInformationPage(driver);
		 String conHeader = cip.getContactHeaderText();
		 if (conHeader.contains(LASTNAME)) 
		 {
			 System.out.println("PASS");
			 Reporter.log("Contact created successfully ", true);
			
		 }
		 else
		 {
		 System.out.println("contact not created");
		 Reporter.log("Contact not created ", true);
		 }
		 
		 Reporter.log("Create Contact with organization successfull ", true);
	}

}
