package vtiger.PractiseTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.genericUtility.ExcelFileUtility;

public class DataProviderPractice2 
{
	
	@Test(dataProvider = "getData")
	public void dataProviderTest(String orgName, String industryType)
	{
		System.out.println(orgName+" "+industryType);
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		
		String sheetName= "MultipleOrg";
		ExcelFileUtility eUtil = new ExcelFileUtility();
		Object[][] data = eUtil.readMultipleDataFromExcel(sheetName);
		return data;
	}

}
