package ThePackage1;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class MainHomeOp {
	WebDriver driver;
  @Test(priority=1)
  public void ScrollUpAndDown() throws InterruptedException 
  {
	  driver=new ChromeDriver();
	  driver.get("https://www.ebay.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  
	  String actualURL=driver.getCurrentUrl();
		String expectedURL="https://www.ebay.com/";
		Assert.assertEquals(actualURL,expectedURL,"mismatched URL");
		
	  JavascriptExecutor jse= (JavascriptExecutor)driver;
	  jse.executeScript("window.scroll(0,1900)");
	  Thread.sleep(3000);
	  jse.executeScript("window.scroll(0,-1900)");
	  Thread.sleep(2000);
  }
	  //Scroll inside a WebElement--
	  
	  //Display all dropdown options and verify they are unique
  @Test(priority=2)
	public void UniqueDropDownElements() throws InterruptedException
	{
	    WebElement clickdropdown=driver.findElement(By.xpath("//select[@id='gh-cat']"));
		clickdropdown.click();
		Thread.sleep(1000);
		
		Select select=new Select(clickdropdown);
		select.selectByVisibleText("Books");
		Thread.sleep(3000);
		select.selectByVisibleText("All Categories");
		Thread.sleep(3000);
		clickdropdown.click();
		
		List<WebElement> options = select.getOptions();
		options.remove(0);
		for(WebElement i:options)
		{
			System.out.println(i.getText());
		}
		
		Set<WebElement> check= new HashSet<WebElement>(options);
		Assert.assertEquals(options.size(),check.size());
		System.out.println("\nVerified: Only Unique Elements are present in the DropDown\n");
  }
  //check logo present
  @Test(priority=3)
  public void newRegister() 
  {
	  
	  boolean IsLogoDisplayed=EbayImg(driver,By.xpath("/html/body/header/table/tbody/tr/td[1]"));
	  Assert.assertTrue(IsLogoDisplayed); 
	  System.out.println("Ebay image is present");
	 
	  boolean IscartDisplayed=EbayImg(driver,By.xpath("//*[@id=\"gh-minicart-hover\"]/div/a[1]"));
	  Assert.assertTrue(IscartDisplayed); 
	  System.out.println("Cart symbol is present");
	  
	  boolean IsNotificationDisplayed=EbayImg(driver,By.xpath("//*[@id=\"gh-eb-Alerts\"]/div/button"));
	  Assert.assertTrue(IsNotificationDisplayed); 
	  System.out.println("Notification Bell symbol is present\n ");
	  //driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[7]/svg/g/path")).click();	  
  }
  //Method to know if profile symbol is visible or not 
  private boolean EbayImg(WebDriver driver,By locator)
  {
	  
	  try
	  {
		  WebElement ele=driver.findElement(locator);
		  if(ele.isDisplayed())
		  {
			  return true;
		  }
		  else
		  {
			  return false; 
		  }
		  
	  }catch (NoSuchElementException e)
	  {
		  return false;
	  }
  }
  
  @Test(priority=4)
  public void hover() throws InterruptedException 
  {
	 WebElement electronics=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
	 WebElement motors = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[4]"));
	 WebElement fashion = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[5]"));
	 WebElement collectables=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]"));
	 WebElement sports=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[7]"));
	 WebElement HealthAndBeauty=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[8]"));
	 WebElement IE=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[9]"));
	 WebElement HG=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[10]"));
	 WebElement Sell=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[12]"));
	 
	 Actions action= new Actions(driver);
	 action.moveToElement(electronics).perform();
	 Thread.sleep(1500);
	 action.moveToElement(motors).perform();
	 Thread.sleep(1500);
	 action.moveToElement(fashion).perform();
	 Thread.sleep(1500);
	 action.moveToElement(collectables).perform();
	 Thread.sleep(1500);
	 action.moveToElement(sports).perform();
	 Thread.sleep(1500);
	 action.moveToElement(HealthAndBeauty).perform();
	 Thread.sleep(1500);
	 action.moveToElement(IE).perform();
	 Thread.sleep(1500);
	 action.moveToElement(HG).perform();
	 Thread.sleep(1500);
	 action.moveToElement(Sell).perform();
	 Thread.sleep(1500);
	 
	 JavascriptExecutor js= (JavascriptExecutor)driver;
	 js.executeScript("window.scroll(0,1900)");
	 WebElement country =driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[5]/ul[3]/li/div"));
	 country.click();
	 action.moveToElement(country).perform();
	 Thread.sleep(2000);
	 //driver.findElement(By.xpath("//*[@id=\"gf-f\"]/ul/li[21]/a")).click(); //xpath of India
	 driver.findElement(By.cssSelector("li.gf-f-li2:nth-child(21) > a:nth-child(1)")).click(); //cssSelectpr of India
	 //Thread.sleep(8000);
	 WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(12));
	 String LinkGot=driver.getCurrentUrl();
	 String OrgLink="https://sellglobal.ebay.in/seller-center/";
	 Assert.assertEquals(LinkGot, OrgLink,"Link Mismatch");
	 System.out.println("Matched with the expected link after choosing India.");
	 Thread.sleep(4000);
	 
	 driver.navigate().back();
	 String ActualOldLink=driver.getCurrentUrl();
	 String ExpectedOldLink="https://www.ebay.com/";
	 Assert.assertEquals(ActualOldLink,ExpectedOldLink,"Link Mismatch");
	 System.out.println("Reached Back!\n");
	 js.executeScript("window.scroll(0,-1900)");
  }
  
  @Test(priority=5)
  
  public void WatchListAndLogin() throws InterruptedException
  {
	  driver.findElement(By.xpath("//*[@id=\"gh-wl-click\"]/div")).click();
	  WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10));
	  By locator1=By.xpath("//*[@id=\"gh-wl-click-body\"]/div/div/div");
      WebElement whileWaiting=wait3.until(ExpectedConditions.visibilityOfElementLocated(locator1));
      String txt2 = whileWaiting.getText();
	  System.out.println(txt2);
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id=\"gh-wl-click-body\"]/div/div/div/a")).click();
	  Thread.sleep(8000);
	  String GotLoginUrl=driver.getCurrentUrl();
	  String expLoginUrl="https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2Fmye%2Fmyebay%2Fwatchlist";
	  Assert.assertEquals(GotLoginUrl,expLoginUrl,"Link Mismatch");
	  driver.findElement(By.cssSelector("#userid")).sendKeys("demoemt23@gmail.com");
	  driver.findElement(By.cssSelector("#signin-continue-btn")).click();
	  //password
	  By locatorPass=By.xpath("//*[@id=\"pass\"]");
	  WebElement whileWaitingPass=wait3.until(ExpectedConditions.visibilityOfElementLocated(locatorPass));
	  //System.out.println("Password feild: "+whileWaitingPass);
	  //wait3.until(ExpectedConditions.elementToBeClickable(whileWaitingPass));
	 
	  driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("elzaa123*");
	  Thread.sleep(3000);
	  driver.findElement(By.cssSelector("#sgnBt")).click();
	  Thread.sleep(3000);
	  
	  String ExpTiredPass="https://www.ebay.com/mye/myebay/watchlist";
	  String ActualTiredPass=driver.getCurrentUrl();
	  Assert.assertEquals(ExpTiredPass, ActualTiredPass,"Mismarched link");
	  System.out.println("Reached Watchlist Successfully");
	  Thread.sleep(10000);
	  
	  WebElement hi=driver.findElement(By.xpath("//*[@id=\"gh-ug\"]"));
	  Actions choose = new Actions(driver);		  
	  choose.moveToElement(hi).perform();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//*[@id=\"gh-uo\"]/a")).click();
	  String SignOutMsg=driver.findElement(By.xpath("//*[@id=\"signout-banner-text\"]")).getText();
	  if(SignOutMsg.contains("signed out"))
	  {
		  System.out.println("Successfully Signed Out");
	  }
	  Thread.sleep(5000);
	  driver.quit();
	  
	  
  }
  
 
}
