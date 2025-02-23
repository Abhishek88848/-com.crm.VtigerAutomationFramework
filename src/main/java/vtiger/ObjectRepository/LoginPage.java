package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //create a separate class for every webpage
{
	//rule2: identify the webelement by using @FindBy, @FindAll, @FindBys to store elements
	//Declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//rule3: create a constructor to initialize the webelements
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//rule4: provide getter method to access webelement in test script
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}
	
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	//rule5: business library
	/**
	 * this method will perform login to the application
	 * @author ABHISHEK KELUSKER
	 * @param userName
	 * @param password
	 */
	public void getLoginToApp(String userName, String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
