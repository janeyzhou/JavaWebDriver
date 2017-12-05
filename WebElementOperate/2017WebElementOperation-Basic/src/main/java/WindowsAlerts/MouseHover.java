package WindowsAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://store.demoqa.com/");
		
		WebElement productCategroy = driver.findElement(By.cssSelector("#menu-item-33>a"));
		WebElement iPads = driver.findElement(By.cssSelector("#menu-item-36>a"));
		Actions action = new Actions(driver);
		action.moveToElement(productCategroy).moveToElement(iPads).click().build().perform();
		
		
	}

}
