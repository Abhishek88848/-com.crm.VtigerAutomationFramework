package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //step1: create a separate class for every webpage
{
	//step2: locate and store the web elements using @FindBy, @FindBys, @FindAll and declare them as private
	//Declaration
	@FindBy(name = "user_name")
    private WebElement userNameEdt;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	
	//Step3: create a constructor to initialize the web elements
	//initialization
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	
	}

	
	//Step4: provide getters method to access these private web elements in Test Scripts
	// without writing getters methods manually if we want automatically then right click on workspace and navigate to Source and select
	// Generate getters and setters then it will show options like setters method and getters methods so select getters because we  want 
	// Getters methods
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}


	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}


	public WebElement getSubmitBtn()
	{
		return loginBtn;
	}
	
	//Step5: Business Library
	/**
	 * This method will perform login to the application operation
	 * @author Abhishek Kelusker
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	    
	}
	
	
	
}
