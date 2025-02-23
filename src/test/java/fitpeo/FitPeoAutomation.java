package fitpeo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class FitPeoAutomation 
{

	public static void main(String[] args) throws AWTException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION_TESTING_2024\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://fitpeo.com/");
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		
		WebElement slideElement = driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']"));
		int sliderWidth1 = slideElement.getSize().getWidth();
		System.out.println("Slider Width in pixels: " + sliderWidth1);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", slideElement);
		//js.executeScript("window.scrollBy(0, -100);");
		
		
		//js.executeScript("window.scrollBy(0,200)", "");
		//js.executeScript("window.scrollBy(0, -100);");
		
		
		int y = slideElement.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",slideElement );
		js.executeScript("window.scrollBy(0, -100);");
		
		WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));
		
		
		int sliderWidth = slideElement.getSize().getWidth(); // E.g., 300px
		int minValue = 0, maxValue = 2000, currentValue = 200; // Slider values
		int desiredValue = 820;
		int pixelOffset = (desiredValue - currentValue) * sliderWidth / (maxValue - minValue);

		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, pixelOffset, 0).perform();
		WebElement textField = driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']"));
		String sliderTextFieldValue = textField.getAttribute("value");
		System.out.println(sliderTextFieldValue);
		
		//validation
		if(sliderTextFieldValue.equals("820")) //"820" because sliderTextFieldValue is String
		{
			System.out.println("Value matches Expected 820 and found "+sliderTextFieldValue);
			
		}
		else
		{
			System.out.println("Value mismatch! Expected 820 but found "+sliderTextFieldValue);
		}
		textField.click();
		//textField.clear();

		Robot robot = new Robot();

	    // Simulate Ctrl+A (Select All)
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_A);
	    robot.keyRelease(KeyEvent.VK_A);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    // Simulate Backspace (Clear the selected text)
	    robot.keyPress(KeyEvent.VK_BACK_SPACE);
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	    textField.sendKeys("560");

	    robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        
        /*textField.click();
		textField.sendKeys(Keys.CONTROL + "a"); // Select all
		textField.sendKeys(Keys.BACK_SPACE); // Clear with backspace

		// Enter new value
 		textField.sendKeys("560");
		textField.sendKeys(Keys.TAB); // Move focus to trigger events
		*/
        String updatedValue = textField.getAttribute("value");
        System.out.println("Updated Value after keyboard actions: " + updatedValue);
        
        //validation
        if(updatedValue.equals("560")) //"560" because we got updated value which is String
        {
        	  System.out.println("Text field updated and slider moved.");
        }
        else
        {
            System.out.println("Failed to update the text field or move the slider.");
        }
        
        driver.findElement(By.xpath("//p[text()='CPT-99091']/following::span[text()='57']/../descendant::input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
        driver.findElement(By.xpath("//p[text()='CPT-99453']/following-sibling::label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg']/child::span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1sp9p8c']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99454']/following-sibling::label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg']/child::span[contains(@class,'MuiButtonBase-root MuiCheckbox-root MuiCheckbox')]")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99474']/following-sibling::label[contains(@class,'labelPlacementEnd ')]/span[starts-with(@class , 'MuiButtonBase')]")).click();

		String actualAmount = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']/following-sibling::p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19']")).getText();
	    System.out.println(actualAmount);
		String expectedAmount = "$110700";
		if(expectedAmount.equals(actualAmount))
		{
			System.out.println("Total Recurring Reimbursement for all Patients Per Month is "+actualAmount);
		}
		else
		{
			System.out.println("Total Recurring Reimbursement for all Patients Per Month is "+actualAmount+" not as expected amount "+ expectedAmount);
		}
	}

}
