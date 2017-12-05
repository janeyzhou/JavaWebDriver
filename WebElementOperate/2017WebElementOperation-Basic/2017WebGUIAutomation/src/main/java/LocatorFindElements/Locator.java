package LocatorFindElements;

import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;

public class Locator {
	
	public static WebDriver driver ;
	
	public Locator(){
		System.setProperty("webdriver.gecko.driver", "C:/autosenium/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver();
	}
	
		
	public void waitTime(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void openPage(String url){
		driver.get(url);
	}
	
	public WebElement findByID(){
		return driver.findElement(By.id("user[login]"));
	}
	
	public WebElement findByName(){
		return driver.findElement(By.name("user[email]"));
		
	}
	
	public WebElement findByLinkTEXT(){
		return driver.findElement(By.linkText("terms of service"));
	}
	
	public WebElement findByPartialLinkText(){
		return driver.findElement(By.partialLinkText("policy"));
	}
	
	public WebElement findByClassName(){
		return driver.findElement(By.className("js-email-notice"));
	}
	
	public WebElement findByTagName(){
		WebElement footer = driver.findElement(By.xpath("html/body/div[5]/div/div[2]"));
		return footer.findElement(By.tagName("h4"));
				
	}
	
	public WebElement findByXpathPredications(){
		return driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[2]"));
	}
	
	public WebElement findByXpathPosition(){
		return driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[position()<2]"));
	}
	
	public WebElement findByXpathText(){
		return driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[text()='Personal account']"));
	}
	
	public WebElement findByXpathContains(){
		return driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[contains(@class, 'mb')]"));
	}
	
	public  java.util.List<WebElement> findByXpathList(){
		java.util.List<WebElement> elementList = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/*"));
		return elementList;
	}
	
	
	public void teardown(){
		driver.close();
	}
	
	


	

	

}
