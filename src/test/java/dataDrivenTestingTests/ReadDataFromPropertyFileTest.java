package dataDrivenTestingTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFileTest
{
	@Test
	public void readDataFromPropertyFile() throws IOException
	{
		//step1: load the property file location into File input stream
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//step2: create an object of property file
		Properties pObj = new Properties();
		
		//step3: load the file input stream object into pObj
		pObj.load(fisp);
		
		//step4: read the required data into testscript
		String BROWSER = pObj.getProperty("browser");
		String URL  = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}

}
