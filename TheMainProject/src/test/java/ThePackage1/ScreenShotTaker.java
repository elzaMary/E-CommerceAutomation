package ThePackage1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotTaker extends BaseLaunch
{
	public void GetScreenshotMethod() throws IOException
	{
		  Date currentdate=new Date();
		  //System.out.println(currentdate);
		   String screenshotfilename = currentdate.toString().replace(" ","-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".//screenshot1//"+screenshotfilename+".png"));
	  }
}
