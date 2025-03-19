package vtiger.PractiseTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMLogin 
{

	

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888/index.php");
		
		/*LoginPage lp = new LoginPage(driver);
		WebElement userName = lp.getUserNameEdt();
		userName.sendKeys("admin");
		WebElement password = lp.getPasswordEdt();
		password.sendKeys("admin");
		WebElement login = lp.getLoginBtn();
		login.click();
		*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		

	}

}
