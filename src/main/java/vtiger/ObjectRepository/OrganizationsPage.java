package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility
{

  @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
  private WebElement organizationsLookUpImg;
  
  public OrganizationsPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  public WebElement getOrganizationsLookUpImg()
  {
	  return organizationsLookUpImg;
  }
  
  //Business libraries
  public void clickOnOrganizationsLookUpImg()
  {
	  organizationsLookUpImg.click();
  }

}
