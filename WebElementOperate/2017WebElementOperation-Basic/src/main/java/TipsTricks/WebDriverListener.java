package TipsTricks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverListener {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		EventHandler eventHandler = new EventHandler();
		eventDriver.register(eventHandler);
		eventDriver.get("https://github.com");

	}

}
