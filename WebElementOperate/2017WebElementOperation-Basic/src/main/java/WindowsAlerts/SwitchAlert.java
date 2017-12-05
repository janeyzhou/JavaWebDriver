package WindowsAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SwitchAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\autosenium\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();
		org.openqa.selenium.Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(5000);
		simpleAlert.accept();
		
		driver.findElement(By.xpath("//*[@id='content']/p[8]/button")).click();
		org.openqa.selenium.Alert confirmAlert = driver.switchTo().alert();
		System.out.println(confirmAlert.getText());
		Thread.sleep(5000);
		confirmAlert.dismiss();
		
		driver.findElement(By.xpath("//*[@id='content']/p[11]/button")).click();
		org.openqa.selenium.Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("Yes");
		Thread.sleep(5000);
		promptAlert.accept();
		

	}

}
