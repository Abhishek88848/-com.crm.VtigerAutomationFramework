package vtiger.ObjectRepository;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class ProductInformationPage 
{
	@FindBy(className = "lvtHeaderText")
	private WebElement productHeaderText;
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getproductHeaderText()
	{
		return productHeaderText;
	}
	
	//Business Libraries
	/**
	 * this method will capture the product header and return it 
	 * @return
	 */
	public String getProductHeader()
	{
		String headerText = productHeaderText.getText();
		return headerText;
	}

}
