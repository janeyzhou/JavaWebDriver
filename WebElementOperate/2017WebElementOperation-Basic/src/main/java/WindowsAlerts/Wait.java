package WindowsAlerts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;



public class Wait {
	public static void main(String args[]) throws InterruptedException{
		/*System.setProperty("webdriver.gecko.driver", "C:/autosenium/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
/*		System.out.println("---implicitlywait---");
	 	//如果没有找到元素，implicitlyWait会在每一行命令上都wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
/*		
		//fluent wait with Function
		System.out.println("---Get button color---");
		FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
		wait1.pollingEvery(2, TimeUnit.SECONDS);
		wait1.withTimeout(20, TimeUnit.SECONDS);
		Function<WebDriver, Boolean> function1 = new Function<WebDriver, Boolean>()
			{
				public Boolean apply(WebDriver arg0){
				WebElement colorButton = arg0.findElement(By.id("colorVar"));
				String color = colorButton.getAttribute("style");
				System.out.println(color);
				if(color.equals("color: red;"))
				{
					return true;
				}
				return false;
				
				}
			};
			
		wait1.until(function1);*/
		
		System.out.println("---Double click button---");
		WebElement doubleClick = driver.findElement(By.id("doubleClick"));
		Actions action = new Actions(driver);
		//需要先move到元素再操作
		action.moveToElement(doubleClick).doubleClick().build().perform();;
		Thread.sleep(5000);
		System.out.println(doubleClick.getAttribute("style"));

		/*
		System.out.println("---Check the button text---");
		FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver);
		wait2.pollingEvery(2, TimeUnit.SECONDS);
		wait2.withTimeout(20, TimeUnit.SECONDS);
		Function<WebDriver, Boolean> function2 = new Function<WebDriver, Boolean>(){
			public Boolean apply(WebDriver input) {
				WebElement buttonText = input.findElement(By.id("disabledElement"));
				System.out.println(buttonText.getText());
				if(buttonText.getText().equals("enabled")){
					return true;
				}
				return false;
			}
			
		};
		wait2.until(function2);
		
		
		//Expected wait
		System.out.println("---get invisibility button---");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("invisibility"))));
		System.out.println("---"+driver.findElement(By.id("invisibility")).getText());
		
		
		System.out.println("---Check the exist text---");
		Assert.assertEquals(driver.findElement(By.id("Deattach")).isDisplayed(), true, "the text is not displayed");
		
		*/
	}

}
