package vtiger.PractiseTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractiseTest 
{
	
	@Test
	public void assetionPractiseTest1()
	{
		System.out.println("TEST 1 stpe 1");
		System.out.println("TEST 1 stpe 2");
		//Assert.assertEquals(1,3);
		System.out.println("TEST 1 stpe 3");
		System.out.println("TEST 1 stpe 4");
	}
	
	@Test
	public void assetionPractiseTest2()
	{
		SoftAssert sa = new SoftAssert(); 
		System.out.println("TEST 2 stpe 1");  
		sa.assertTrue(true); 
		System.out.println("TEST 2 stpe 2");
		Assert.assertTrue(true);
		sa.assertEquals(1, 1);
		System.out.println("TEST 2 stpe 3");
		System.out.println("TEST 2 stpe 4");
		sa.assertAll();
		System.out.println("TEST 2 stpe 5");
		Assert.assertEquals("A", "A");
		sa.assertTrue(false);
		System.out.println("TEST 2 stpe 6");
	}

}
