package ThePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class RandL {
	WebDriver driver;
  @Test(priority=1)
  public void register() 
  {
	  driver=new ChromeDriver();
	  driver.get("https://www.ebay.com/");
	  driver.manage().window().maximize();
	  
	  WebElement regLink = driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a"));
	  regLink.click();
	  String receivedUrl=driver.getCurrentUrl();
	  String expectedUrl="https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F";
	  Assert.assertEquals(receivedUrl, expectedUrl,"URL mismatched");
	  	  
  }
  
  //personal acc
  @Test(priority=2)
  public void personal() throws InterruptedException 
  {
	  try
	  {
 //driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"tmx_tags_iframe\"]")));
  WebElement personalacc = driver.findElement(By.cssSelector("#personalaccount-radio"));
  personalacc.click();
  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Elza");
  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Thomas");
  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demoemt23@gmail.com");
  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("elzaa123*");
 Thread.sleep(2000);
  //To click the register button
 WebElement registerBtn=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div/div/div/form/div[6]/div/span/button"));

  System.out.println("Register button Text: "+registerBtn.getText());
  System.out.println("Register Button Enabled: "+registerBtn.isEnabled());
  Thread.sleep(8000);
  
  registerBtn.click();
  Thread.sleep(12000);
	  }
	  catch(NoSuchElementException e)
	  {
		  e.printStackTrace();
	  }
	 
	  System.out.println("Login successfull");
	  Thread.sleep(5000);
	  driver.quit();
	  }
  
}
