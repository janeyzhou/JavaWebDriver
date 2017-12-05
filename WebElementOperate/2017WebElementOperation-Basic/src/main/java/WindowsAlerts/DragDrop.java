package WindowsAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DragDrop {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:\\autosenium\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement from = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 
		WebElement to = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 

		/*Actions builder = new Actions(driver);
		builder.clickAndHold(from).build().perform();
		Thread.sleep(3000);

		builder.clickAndHold(from).moveToElement(to).release(to).build().perform();
		Thread.sleep(3000);
*/
	
		
		
		Actions dragDrop = new Actions(driver).dragAndDrop(from, to);
		dragDrop.perform();
	}

}
