package vtiger.ObjectRepository;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VendorInformationPage 
{
	@FindBy(className = "lvtHeaderText")
	private WebElement vendorHeaderText;
	
	public VendorInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	
	public WebElement getvendorHeaderText()
	{
		return vendorHeaderText;
	}
	
	//Business Libraries
	/**
	 * this method will return the header test of vendors
	 * @return
	 */
	public String getVendorsHeader()
	{
		String headerText = vendorHeaderText.getText();
		return headerText;
	}

}
