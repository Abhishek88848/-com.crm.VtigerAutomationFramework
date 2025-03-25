package vtiger.ObjectRepository;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewProductsPage extends WebDriverUtility //step1: create a separate POM class for every WebPage and class name of POM class and webpage name should be same
{
	//Step2: locate and store the webelements locators using selenium annotations like @FindBy, @FindBys, @FindAll and declare them as private
	//DECLARATION
	@FindBys({@FindBy(xpath = "//input[@type='text']") , @FindBy(name = "productname")})
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorsNameImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath ="//select[@name='productcategory']")
	private WebElement productCategoryDrpDwn;
	
	//Step3: create a constructor to initialize the WebElements locators
	//INITIALIZATION
	public CreateNewProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Step4: create getter methods to utiliza these web eleents in Testscripts
	//Utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getVendorsNameImg() {
		return vendorsNameImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getSearchEdt()
	{
		return searchEdt;
	}
	public WebElement getSearchBtn()
	{
		return searchBtn;
	}
	
	public WebElement getProductCategoryDrpDwn()
	{
		return productCategoryDrpDwn;
		
	}
	
	//Step5: Business Libraries
	/**
	 * this method will create new product and save it
	 * @param productName
	 */
	public void createNewProduct(String productName)
	{
		productNameEdt.sendKeys(productName);
		saveBtn.click();
		
		
	}
	/**
	 * this method will perform create new products with vendors and select the product Category Typesave action
	 * @param productName
	 * @param driver
	 * @param partialName
	 * @param vendorsName
	 */
	public void createNewProduct(String productName, WebDriver driver, String vendorsName, String productCategoryType)
	{
		productNameEdt.sendKeys(productName);
		vendorsNameImg.click();
		switchToWindow(driver, "Vendors&action");
		searchEdt.sendKeys(vendorsName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorsName+"']")).click();
		switchToWindow(driver , "Products&action");
		handleDropDown(productCategoryType, productCategoryDrpDwn);
		saveBtn.click();
	}
	

}
