package TestNGFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserParallel {
	
	WebDriver driver;
	
	@BeforeClass()
	@Parameters({"browser"})
	public void setBrowser(String browserType){
		if(browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:/autosenium/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	@Test
	public void loginGitHub(){
		driver.get("https://github.com/login");
		driver.findElement(By.name("login")).sendKeys("janeyzhou");
		driver.findElement(By.name("password")).sendKeys("zj19880311");
		driver.findElement(By.name("commit")).click();
		driver.close();
	}

}
