package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
import vtiger.genericUtility.BaseClass;
@Listeners(vtiger.genericUtility.ListenerImplementation.class)
public class CreateConWithOrgAssertionTest extends BaseClass
{
	
	@Test(groups = {"RegressionSuite", "SmokeSuite"})
	public void createConWithOrgAssertionTest() throws EncryptedDocumentException, IOException
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
		 Assert.assertTrue(orgHeader.contains(ORGNAME));
		 
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
		 Assert.assertEquals(conHeader.contains(LASTNAME), true);
		 
		 Reporter.log("Create Contact with organization successfull ", true);
	}
	
	@Test(groups = "RegressionSuite")
	public void testForRegressionSuiteTest()
	{
		System.out.println("this is a sample for regression suite Job execution");
	}

}

