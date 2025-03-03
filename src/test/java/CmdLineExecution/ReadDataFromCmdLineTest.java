package CmdLineExecution;

import org.testng.annotations.Test;


public class ReadDataFromCmdLineTest 
{


	public class CommandLineReader
	{

	  @Test
	  public void cmdLineReaderTest()
	  {
			
			String BROWSER = System.getProperty("browser");
			String URL = System.getProperty("url");
			String USERNAME = System.getProperty("username");
			String PASSWORD = System.getProperty("password");
			
			System.out.println(BROWSER);
			System.out.println(URL);
			System.out.println(USERNAME);
			System.out.println(PASSWORD);
	  }
		

	}

}
