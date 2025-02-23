package vtiger.PractiseTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicCongiPraticeTest 
{
	
	@BeforeMethod
	public void bmConfi()
	{
		System.out.println("Before method configuration");
	}
	
	@AfterMethod
	public void amConfi()
	{
		System.out.println("After method configuration");
	}
	
	@BeforeClass
	public void bcConfi()
	{
		System.out.println("Before class configration");
	}

	@BeforeSuite
	public void bsConfi()
	{
		System.out.println("Before suite configuration");
	}
	
	@AfterSuite
	public void asCongi()
	{
		System.out.println("After suite configuration");
	}
	
	@AfterClass
	public void acConfi()
	{
		System.out.println("After class configuration");
	}
	
	@Test
	public void testPrac1()
	{
		System.out.println("Test 1 execution");
	}
	
	@Test
	public void testPrac2()
	{
		System.out.println("Test 2 execution");
	}
}
