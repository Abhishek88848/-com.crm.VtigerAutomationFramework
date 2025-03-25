package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class VendorsPage extends WebDriverUtility //Step1: create a separate java class/pom class for every web page and webpage name and class name should be same
{
	//Step2: locate and store the WebElements locators using selenium annotations like FindBy, FindBys, @FindAll and declare there web elements locators as private
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createVendorLookupImg;
	
	//Step3: create a constructor to initialize these webelements locators
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step4: provide getters methods to access these web Elements locators in Testscript
	public WebElement getCreateVendorLookUpImg()
	{
		return createVendorLookupImg;
	}
	
	//Step5: Business libraries
	/**
	 * this method will perform click operation on create vendor look up image
	 * @param driver
	 */
	public void clickOnCreateVendorLookUpImg(WebDriver driver)
	{
		leftClickOn(driver, createVendorLookupImg);
	}

}
