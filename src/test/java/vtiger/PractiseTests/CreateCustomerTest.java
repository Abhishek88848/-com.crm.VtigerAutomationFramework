package vtiger.PractiseTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCustomerTest 
{
	@Test(priority = 0)
	public void createCustomerTest()//passed
	{
		System.out.println("Create Customer Test");
	}
	
	@Test(priority = 1, dependsOnMethods = "createCustomerTest")
	public void modifyCustomerTest()//passed
	{
		
		System.out.println("Modify customer Test");
	}
	
	@Test(priority = 2,dependsOnMethods = {"createCustomerTest","modifyCustomerTest"}, enabled = false)
    public void deleteCustomerTest()
    {
		Assert.fail();
		System.out.println("Delete customer Test");
	}
	

}
