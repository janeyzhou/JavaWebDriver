package TipsTricks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ScrollElement {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('user[login]-footer').scrollIntoView(true);");
		//Thread.sleep(100);
		

	}

}
