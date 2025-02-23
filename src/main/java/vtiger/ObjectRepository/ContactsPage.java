package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage //create separate webpage for every webpage
{
   //identify every webelements using @FindBy, @FindBys, @FindAll annotaions and store it
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookUpImg;
	
	//create a constructor to initialize
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//provide getter methods to access these web elemnts
	//utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	//Business libraries
	/**
	 * this method will perform click operation on create contacts look up image
	 * @author ABHISHEK KELUSKER
	 */
	public void clickOnCreateContactsLookUpImg()
	{
		createContactLookUpImg.click();
	}
	
}
