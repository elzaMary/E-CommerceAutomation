package ThePackage1;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerCommands extends ScreenShotTaker implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Started Execution");
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Execution successful");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Execution Failed");
		try
		{
			GetScreenshotMethod();
			System.out.println("Screenshot Taken Successfully");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
  
}
