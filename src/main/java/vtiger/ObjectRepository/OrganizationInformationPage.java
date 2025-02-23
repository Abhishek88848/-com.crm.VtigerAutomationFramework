package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class OrganizationInformationPage extends WebDriverUtility //create separate class for every webpage
{
	//identify the web elements using @FindBy, @FindAll, @FindBys
	//declaration
	@FindBy(className = "dvHeaderText")
	private WebElement orgHeaderText;
	
	//create a constructor to initialize
	//initialization
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//provide getters methods to access webelemets in test script
	//utilization
	public WebElement getOrgHeaderText() 
	{
		return orgHeaderText;
	}
	
	//Business libraries
	/**
	 * this method will convert the encrypted form to understandable language and of Organization header and return the value 
	 * @return
	 */
	public String getOrganizationHeaderInTextMethod()
	{
		String orgText = orgHeaderText.getText();
		return orgText;
	}
	
	
	
	

}
