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
	  
	  @FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	  private WebElement moreDrpDwn;
	  
	  @FindBy(linkText = "Vendors")
	  private WebElement vendorsLnk;
	  
	  
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
	
	public WebElement getMoreDrpDwn()
	{
		return moreDrpDwn;
	}
	
	public WebElement getVendorsLnk()
	{
		return vendorsLnk;
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
	/**
	 * this method will perform click operation on contacts link
	 * @author Abhishek kelusker
	 */
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	
	/**
	 * this method will perform click operation on  organization link
	 * @author ABHISHEK K
	 */
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
	 * @author ABHISHEK K
	 */
	public void clickOnProductLnk()
	{
		productsLnk.click();
	}
	/**
	 * This method will perform click operation on Vendors link
	 * @Abhishek kelusker
	 * @param driver
	 */
	public void clickOnVendorsLnk(WebDriver driver)
	{
		mouseHoverOn(driver, moreDrpDwn);
		leftClickOn(driver, vendorsLnk);
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
