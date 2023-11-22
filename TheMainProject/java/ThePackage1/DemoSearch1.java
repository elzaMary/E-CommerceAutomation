package ThePackage1;
import java.time.Duration;
import java.util.Iterator;
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

public class DemoSearch1 

{
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
			//Thread.sleep(4000);
			
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(7));
			
			//Total results shown check
		    WebElement results=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
			System.out.println("Text found: "+results.getText());
			
			By plocator = By.cssSelector("#item1f616e529c > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1)");
			WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(plocator));
			
			//To Get Product details which is in new window now
			System.out.println("Product Found: "+product.getText());
			product.click();
			
//result upto here-clicking on the product and it automatically goes to that specific tab
			
			Set <String> hand = driver.getWindowHandles();
			Iterator<String> i = hand.iterator();
			String mainWin = i.next(); 
			String newWin = i.next();
			driver.switchTo().window(newWin); 
			driver.findElement(By.cssSelector("#mainContent > div.vim.d-vi-region.x-atf-center-river--buybox > div > div:nth-child(1) > div.x-buybox__cta-section > ul > li:nth-child(2) > div > a > span"));
	  }
	
}
