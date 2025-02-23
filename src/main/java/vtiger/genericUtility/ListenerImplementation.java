package vtiger.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * this class contains all implementation of those ITestListerners interface abstract methods
 * @author ADMIN
 *
 */
public class ListenerImplementation implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript Execution Started", true);
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" TestScript executed successfully", true);
		
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriverUtility wUtil = new WebDriverUtility(); // create here anothe webdriver utility bcs it is not taking from baseclass
		JavaUtility jUtil = new JavaUtility();
		String methodName = result.getMethod().getMethodName();
		String screenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
		Reporter.log(methodName+" TestScript Failed", true);
		try
		{
			wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);//if i pass driver directly here it is not accepting from Base calss bcs this method so create another WebDriver object in BaseClass and declare it as static reason for creating static means from baseclass this is the only thing which is required in listenerImplementation so class directly by using classname no need to create object and declare sDriver = driver below the browser launch bcs once jvm select the browser it might be new Firefox or new ChromeDriver than the driver is properly initialized then that driver gonna store the proper value either chrome or firefox thet will be stored in sDriver = driver.
		} catch (IOException e)
		{
			
			e.printStackTrace();
		} 
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		String msg = result.getThrowable().toString();
		Reporter.log(methodName+" TestScript Skipped and the Reason is "+msg, true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}
	

}
