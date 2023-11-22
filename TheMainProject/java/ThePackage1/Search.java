package ThePackage1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Search {
	WebDriver driver;
	  
  @Test(priority=1)
  public void testSearch() throws InterruptedException 
  {
	  SoftAssert softassert=new SoftAssert();
	  
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\elzam\\OneDrive\\Desktop\\Selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	   driver = new FirefoxDriver();
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://www.ebay.com/";
		softassert.assertEquals(actualURL,expectedURL,"mismatched URL");
		
		// click search button
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Pride and Prejudice");
		driver.findElement(By.id("gh-btn")).click();
		Thread.sleep(4000);
		
		
		
		//Move back and forth
		
		/*driver.navigate().back();
		String afterbackop=driver.getCurrentUrl();
		String expectedbackop="https://www.ebay.com/";
		softassert.assertEquals(afterbackop,expectedbackop,"mismatched URL");
		Thread.sleep(4000);
		driver.navigate().forward();
		String afterForwardop=driver.getCurrentUrl();
		String ExpectedForwardLink="https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=Pride+and+Prejudice&_sacat=0";
		Assert.assertEquals(afterForwardop,ExpectedForwardLink,"mismatched URL");
		Thread.sleep(4000);*/
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(7));
		
		//Total results shown check
	    WebElement results=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
		System.out.println("Text found: "+results.getText());
		
		By plocator = By.cssSelector("#item1f616e529c > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1)");
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(plocator));
		
		//To Get Product details which is in new window now
		System.out.println("Product Found: "+product.getText());
		product.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles)
		{
			driver.switchTo().window(windowHandle);
			String name="Pride and Prejudice".toLowerCase();
			if(driver.getTitle().contains(name)||driver.getTitle().contains("Pride and Prejudice"))
			{
				System.out.println("Title found: "+driver.getTitle());
				
				//driver.findElement(By.xpath("//div[@class='vim ux-bin-nudge']"));
				//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div/div/div[6]/ul/li[2]/div/a")).click();
				By Cart = By.cssSelector(".x-atc-action > a:nth-child(1)");
				WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(Cart));
				Thread.sleep(4000);
				addcart.click();
				//driver.quit();
			}
		}
		
		 
		 
		 
		 
  }
  //Access models on the left side and click see all?
  /*@Test(priority=2) //--Not running
  private boolean FurtherSearch() throws InterruptedException 
  {
	  
	  try {
	  driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/div/span/button")).click(); //click see all
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"google_ads_top_frame\"]"))); // frame shown after clicking- its xpath
	  
	  WebElement frameDis=driver.findElement(By.xpath("//*[@id=\\\"google_ads_top_frame\\\"]"));
	  
	  if(frameDis.isDisplayed())
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
	  }
	  catch(NoSuchElementException e)
	  {
		  e.printStackTrace();
		  return false;
		}
  }*/
  //selecting low price element from results
  /*@Test(priority=2)
  public void PriceBasedSelection()
  {
	 List<WebElement> prices= driver.findElements(By.xpath("//span[@class='s-item__price']")); 
	 
	 for(int i=0;i<prices.size();i++)
	 {
		  
		 System.out.println(Integer.parseInt(prices.get(i).getText().replaceAll(",", "")));
	 }
  }*/
 
 /* @Test
  public void addToCart()
  {
	  //driver.findElement(By.xpath("//div[@class='s-item__title']")).click();
	 driver.findElement(By.cssSelector("#item57517ae2fe > div > div.s-item__info.clearfix > a > div > span"));
	  
  }
  */
  
  
  
  }

