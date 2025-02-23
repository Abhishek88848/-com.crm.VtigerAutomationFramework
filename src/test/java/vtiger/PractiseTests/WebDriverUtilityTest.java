package vtiger.PractiseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.genericUtility.WebDriverUtility;

public class WebDriverUtilityTest 
{

	public static void main(String[] args) 
	{
		WebDriver abhi = new ChromeDriver();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.waitForElementsToLoadInDom(abhi);

	}

}
