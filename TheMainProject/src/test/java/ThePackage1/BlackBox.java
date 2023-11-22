package ThePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Test
@Listeners (ListenerCommands.class)

public class BlackBox {

	WebDriver driver;
	public void ExpFailTest() throws InterruptedException
	{
	 driver=new ChromeDriver();
	  driver.get("https://www.ebay.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  
	 /* String ActUrl1=driver.getCurrentUrl();
	  String ExpUrl1="https://www.ebay.com/";
	  Assert.assertEquals(ActUrl1, ExpUrl1,"Link Mismatch");
	  System.out.println("On correct Ebay site");*/
	  
	  WebElement SignIn1=driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a"));
	  SignIn1.click();
	  Thread.sleep(6000);
	   System.out.println(driver.getCurrentUrl()); 
	 String actulaSignInUrl=driver.getCurrentUrl();
	 String ExpSignInUrl="https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F";
	 Assert.assertEquals(actulaSignInUrl, ExpSignInUrl,"Link Mismatch for Sign In");
		  System.out.println("Reached the sign in page\n");
		  driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys("demoemt23gmail.com");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"signin-continue-btn\"]")).click();
		  Thread.sleep(3000);
		  String errormsg =driver.findElement(By.xpath("//*[@id=\"errormsg\"]")).getText();
		  System.out.println(errormsg);
		  /*driver.findElement(By.xpath("//*[@id=\"signin-continue-btn\"]")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("elzaa123*");*/
		  Thread.sleep(4000);
		  driver.quit();
	
	  }
	  }

