package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility//create a separate class for every webpage
{
    //locate and store the webelements using @FindBy, @FindAll, @FindBys and declare them as private
	//Declaration
	  @FindBy(linkText = "Leads")
	  private WebElement leadsLnk;
	  
	  @FindBy(linkText = "Organizations")
	  private WebElement organizationLnk;
	  
	  @FindAll({@FindBy(xpath = "//a[text()='Contacts']"),@FindBy(linkText ="Contacts")})
	  private WebElement contactsLnk;
	  
	  @FindAll({@FindBy(xpath = "//a[text() = 'Opportunities']"), @FindBy(linkText = "Opportunities")})
	  private WebElement opportunitiesLnk;
	  
	  @FindAll({@FindBy(xpath = "//a[text()  = 'Products']"),@FindBy(linkText = "Products")})
	  private WebElement productsLnk;
	  
	  @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	  private WebElement AdministratorImg;
	  
	  @FindAll({@FindBy(xpath = "//a[text()= 'Sign Out']"), @FindBy(linkText = "Sign Out")})
	  private WebElement signOutLnk;
	  
	  
	//Create a constructor to initialize
	//initialization
	  public HomePage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	//provide getter methods to access these web elements in test scripts
	  public WebElement getLeadsLnk()
	  {
		  return leadsLnk;
	  }
	  
	  public WebElement getContactsLnk()
	  {
		  return contactsLnk;
	  }

	public WebElement getOrganizationLnk() 
	{
		return organizationLnk;
	}

	public WebElement getOpportunitiesLnk() 
	{
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() 
	{
		return productsLnk;
	}
	  
	  
	//business libraries
	/**
	 * this method will perform click operation on leads link
	 * @author ABHISHEK KELUSKER
	 */
	public void clickOnLeadsLink()
	{
		leadsLnk.click();
	}
	
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	
	public void clickOnOrganizationLnk()
	{
		organizationLnk.click();
	}
	public void clickOnOpportunitiesLnk()
	{
		opportunitiesLnk.click();
	}
	/**
	 * this method will click on product link
	 */
	public void clickOnProductLnk()
	{
		productsLnk.click();
	}
	/**
	 * this method will perform signout operation from the application
	 * @param driver
	 */
	public void SignOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, AdministratorImg);
		signOutLnk.click();
		
		
	}
}
