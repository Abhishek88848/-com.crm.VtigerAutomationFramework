package vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class ProductsPage extends WebDriverUtility  //step1: create a separate class for every webpage and class name of POM class and webpage name should be same
{
	//step2: locate and store the web elements locators using selenium annotations and declare them as private
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productsLookUpImg;
	
	//Step3: create a constructor to initialize the web elements
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step4: create getter methods to access these web elements in Test Scripts
	public WebElement getProductsLookUpImg()
	{
		return productsLookUpImg;
	}
	
	//Step5: Business libraries
	/**
	 * this method will perform click operation on create new lookup image
	 * @param driver
	 */
	public void clickOnProductsLookUpImg(WebDriver driver) 
	{
		mouseHoverOn(null, productsLookUpImg);
		leftClickOn(driver);
	}
	

}
