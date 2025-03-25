package vtiger.ObjectRepository;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CreateNewVendorPage extends WebDriverUtility//Step1: create a separate Class for every WebPage and class name of that class must be same as WebPage name
{

	//Step2: locate and Store the web elements locators using selenium annotations like @FindBy, @FindBys, @FindAll and declare them as private
	//@FindBys({@FindBy(name = "vendorname") , @FindBy(xpath = "//input[@type='text']")})
	@FindBys({@FindBy(xpath = "//input[@name='vendorname']") , @FindBy(xpath = "//input[@class='detailedViewTextBox']")})
	private WebElement vendrorsNameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Step3:create a constructor to initialize the web elements locators
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Step4: provide getters methods to access these web elements locators in TestScripts
	public WebElement getVendorsNameEdt()
	{
		return vendrorsNameEdt;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	//Step5: Business Libraries
	/**
	 * this method will create new vendors and save it
	 * @param vendorName
	 * @param driver
	 */
	public void createNewVendors(String vendorName, WebDriver driver)
	{
		vendrorsNameEdt.sendKeys(vendorName);
		//saveBtn.click();
		leftClickOn(driver, saveBtn);
	}
	
	
	

}
