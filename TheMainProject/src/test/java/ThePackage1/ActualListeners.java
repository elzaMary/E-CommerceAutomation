package ThePackage1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test
@Listeners (ListenerCommands.class)
public class ActualListeners extends BaseLaunch
{
	@Test
	public void AppLaunching() throws InterruptedException
	{
	driver.get("https://www.ebay.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  
	}
	@Test
	public void VerifyTitle()
	{
		String Title1=driver.getTitle();
		String Title2="Ebay Shoppings";
		Assert.assertEquals(Title1, Title2);
	}
}
