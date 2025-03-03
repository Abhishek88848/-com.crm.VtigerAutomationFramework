package WebDriverActions;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileHandlingTest 
{
	@Test
	public void fileHandlingTest() throws IOException
	{
		File f1 =  new File("c://QWERTY");
		f1.mkdir();
		File f2 = new File("c://QWERTY//ytrewq.txt");
		f2.createNewFile();
		f2.delete();
		File f3 = new File("c://QWERTY//ytrewq.png");
		f2.createNewFile();
		//f1.delete();
	}
	

}
