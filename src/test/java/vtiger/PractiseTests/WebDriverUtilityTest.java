package vtiger.PractiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.genericUtility.PropertyFileUtility;
import vtiger.genericUtility.WebDriverUtility;

public class WebDriverUtilityTest 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriver abhi = new ChromeDriver();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.waitForElementsToLoadInDom(abhi);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		

	}

}
