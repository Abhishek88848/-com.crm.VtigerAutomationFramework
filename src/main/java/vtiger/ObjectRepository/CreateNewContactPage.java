package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;
/**
 * this class contains all object repository things related to create new contacts page like webelements, constructor, getters method, business libraries
 * @author ADMIN
 *
 */
public class CreateNewContactPage extends WebDriverUtility
{
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchBtn;
	
	
	
	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	//utilization
	public WebElement getLastNameEdt()
	{
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	
	
	public WebElement getSearchBox() {
		return searchBox;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	//Business libraries
	/**
	 * this method will Create new contact with last name and save it
	 * @param lastName
	 */
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
		
	}
	/**
	 * this method will create contact with lead source type and save it
	 * @param lastName
	 * @param leadSourcrType
	 */
	public void createNewContact(String lastName, String leadSourcrType)
	{
		lastNameEdt.sendKeys(lastName);
		handleDropDown(leadSourcrType, leadSourceDropDown);
		saveBtn.click();	
	}
	/**
	 * this method will create contact with organization and save it
	 * @param lastName
	 * @param driver
	 * @param orgName
	 */
	public void createNewContact(String lastName, WebDriver driver, String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts&action");
		searchBox.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
	

}
