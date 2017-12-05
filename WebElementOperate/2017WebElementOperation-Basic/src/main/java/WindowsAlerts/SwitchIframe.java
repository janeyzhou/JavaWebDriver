package WindowsAlerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SwitchIframe {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
		//Find out all Iframes by javascripte
		
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);
		
		//Find out all Iframes by tag name
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		System.out.println("---"+iframe.size());
		
		//Switch between iframe by index
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.name("firstname")).sendKeys("janey");
		
			
		//Switch between iframe by name
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe2");
		System.out.println(driver.findElement(By.cssSelector("#ui-id-3")).getText());
		driver.findElement(By.cssSelector("#ui-id-3"));
		
			
		//Switch between iframe by ID
		driver.switchTo().defaultContent();
		driver.switchTo().frame("IF1");
		driver.findElement(By.name("lastname")).sendKeys("zhou");
		


		//Switch between iframe by webelement
		driver.switchTo().defaultContent();
		WebElement iframeElement = driver.findElement(By.id("IF2"));
		driver.switchTo().frame(iframeElement);
		driver.findElement(By.cssSelector("#ui-id-2")).click();
		
		//Switch back to Main page
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.cssSelector("#content>h1")).getText());

	}

}
