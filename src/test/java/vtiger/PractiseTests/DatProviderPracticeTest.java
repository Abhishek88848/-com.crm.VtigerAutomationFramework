package vtiger.PractiseTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatProviderPracticeTest 
{
	@Test(dataProvider ="data")
	//public void addProductToTheCart(String name, String model, int price, String feature, int quantity)
	public void addProductToTheCart(String bikeName, String type, String model, int capacity, int price)
	{
		//System.out.println(name+" "+model+" "+price+" "+feature+" "+quantity);
		System.out.println(bikeName+" "+type+" "+model+" "+capacity+" "+price);
	}
	
	@DataProvider(name = "WhishList")
	public Object[][] getData()
	{
		Object [][] d = new Object[4][5];
		
		d[0][0] = "OnePlus";
		d[0][1] = "11R";
		d[0][2] = 36000;
		d[0][3] = "OxygenOS";
		d[0][4] = 15;
		
		d[1][0] = "Nokia";
		d[1][1] = "1100";
		d[1][2] = 2500;
		d[1][3] = "Build";
		d[1][4] = 10;
		
		d[2][0] = "Smasung";
		d[2][1] = "A19";
		d[2][2] = 20000;
		d[2][3] = "Processor";
		d[2][4] = 30;
		
		d[3][0] = "iphone";
		d[3][1] = "16ProMax";
		d[3][2] = 100000;
		d[3][3] = "Security";
		d[3][4] = 40;
		
		return d;
		
	}
	
	@DataProvider(name = "addToCart")
	public Object[][] data()
	{
                            //row //columns
			Object[][] d = new Object[4][5];// count of rows and column not read of rows and column
			
			d[0][0] = "Hero";
			d[0][1] = "petrol";
			d[0][2] = "Splender";
			d[0][3] = 2;
			d[0][4] = 300000;
			
			d[1][0] = "Ather";
			d[1][1] = "Electric";
			d[1][2] = "A1";
			d[1][3] = 1;
			d[1][4] = 40000;
			
			d[2][0] = "Bajaj";
			d[2][1] = "Diesel";
			d[2][2] = "pulsar";
			d[2][3] = 3;
			d[2][4] = 30000;
			
			d[3][0] = "Honda";
			d[3][1] = "petrol";
			d[3][2] = "Shine";
			d[3][3] = 4;
			d[3][4] = 90000;
			
			return d;
	}

}
