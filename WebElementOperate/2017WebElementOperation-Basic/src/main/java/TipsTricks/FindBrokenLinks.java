package TipsTricks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {
	
	public static List<WebElement> findAllLinks(WebDriver driver){
				
		List<WebElement> aList = driver.findElements(By.tagName("a"));
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		aList.addAll(imgList);
		List<WebElement> finalList = new ArrayList<WebElement>();
		for(WebElement el : aList){
			if(el.getAttribute("href") != null){
				finalList.add(el);
			}
		}
		return finalList;
		
	}
	
	public static String isLinkBroken(URL url) throws Exception{
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		response = connection.getResponseMessage();
		connection.disconnect();
		return response;
	}

	public static void main(String[] args) throws MalformedURLException, Exception  {
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		
		List<WebElement> allLinks = findAllLinks(driver);
		System.out.println("There are " + allLinks.size() + " links on this page");
		
		for(WebElement we: allLinks){
			
				System.out.println("URL: " + we.getAttribute("href") + " returned " + isLinkBroken(new URL(we.getAttribute("href"))));
			
		}

	}

}
