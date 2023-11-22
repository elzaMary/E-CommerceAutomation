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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSearch {
	
	WebDriver driver;
	
	  @Test(priority=1)
	  public void testSearch() throws InterruptedException 
	  {
		  
		  SoftAssert softassert=new SoftAssert();
		  
		  
		   driver = new ChromeDriver();
			
			driver.get("https://www.ebay.com/");
			driver.manage().window().maximize();
			
			String actualURL=driver.getCurrentUrl();
			String expectedURL="https://www.ebay.com/";
			softassert.assertEquals(actualURL,expectedURL,"mismatched URL");
			
			// click search button
			driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("laptops");
			Thread.sleep(4000);
			//driver.findElement(By.xpath(""));
			driver.findElement(By.id("gh-btn")).click();
			Thread.sleep(4000);
			
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
			
			//Total results shown check
		    WebElement results=driver.findElement(By.xpath("//*[@id=\'mainContent\']/div[1]/div/div[1]/div[1]/div[1]"));
			System.out.println("Text found: "+results.getText());
			Thread.sleep(4000);
			
			By plocator = By.cssSelector("#item4707cfc412 > div > div.s-item__info.clearfix > a > div > span > span");
			WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(plocator));
			
			//To Get Product details which is in new window now
			System.out.println("Product Found: "+product.getText());
			product.click();
	//-----		
			Set<String> windhan=driver.getWindowHandles();//parent as child   2
			Iterator<String>it=windhan.iterator();//for()if
			String mainwindow=it.next();
			String childwindow=it.next();
			driver.switchTo().window(childwindow); 
			              
			              JavascriptExecutor js=(JavascriptExecutor)driver;
			              js.executeScript("window.scrollBy(0,550)", "");
			              
			              By AddCartLocator = By.cssSelector(".x-atc-action > a:nth-child(1)");
			              WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(AddCartLocator));
			              btn.click();
			              Thread.sleep(3000);
			              System.out.println("Successfully added to cart");
			             Thread.sleep(2000);
			             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[2]/div/div[1]")).click(); //checkout
			             Thread.sleep(2000);
			             String hello=driver.findElement(By.xpath("//*[@id=\"greeting-msg\"]")).getText();
			             if(hello.contains("Hello"))
			             {
			             driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys("demoemt23@gmail.com");
			             System.out.println("Successfully enterd userId");
			             driver.findElement(By.xpath("//*[@id=\"signin-continue-btn\"]")).click(); //clicking continue
			             System.out.println("Clicked Continue");
			             Thread.sleep(5000);
			             }
			             String welcome=driver.findElement(By.xpath("//*[@id=\"welcome-msg\"]")).getText();
			             if(welcome.contains("Welcome"))
			             {
			             driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("elzaa123*");//Enter password
			             System.out.println("Entered password");
			             driver.findElement(By.xpath("//*[@id=\"sgnBt\"]")).click(); //click signIn
			             System.out.println("Successfully Logged In");
			             Thread.sleep(10000);
			             }
			            
			      
			             System.out.println(driver.getTitle());
			             System.out.println("Reached the Checkout page");
			             
			             driver.findElement(By.xpath("//*[@id=\"page-form\"]/div/button")).click();
			             String payMode=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div/div[1]/div[1]/div/section")).getText();
			             System.out.println("If payment mode not selected  : "+payMode);
			             Thread.sleep(3000);
			             driver.navigate().back();
			             Thread.sleep(5000);
			             driver.navigate().back();
			             Thread.sleep(5000);
			             
			             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/div[1]/div/ul/li/div[1]/div/div/div[2]/span[2]/button")).click();
			             Thread.sleep(6000);
			             WebElement removed = driver.findElement(By.xpath("//*[@id=\"page-alerts\"]/section/div[2]/h2/span/span"));
			             System.out.println("Message verifying item removal: "+removed.getText());
			             Thread.sleep(5000);
			             driver.quit();		
			        	}

			    
	  }


