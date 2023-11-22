package ThePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Accessing {
	WebDriver driver;
 
  @Parameters("browserName")
  @BeforeTest
  public void InSite(String browserName)
  {
  switch(browserName)
  case "chrome":
  {
	  WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.get(browserName);
	FirefoxDriver driver=new FirefoxDriver();
	//driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("https://www.ebay.com/",Keys.ENTER);
	break;
  }
  default:
	  System.out.println("Invalid browser");
	  break;
  }
  }  
}
