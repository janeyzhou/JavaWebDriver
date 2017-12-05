package Locator.GUIWebDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Locator 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.gecko.driver", "C:/autosenium/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		
		//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//---------------------------GitHub Home Page------------------------
		//Open a new page
		driver.get("https://github.com/");
	
		//find element by ID
		driver.findElement(By.id("user[login]")).sendKeys("1");
		
		//find element by NAME
		driver.findElement(By.name("user[email]")).sendKeys("2");
		
		//find element by LINKTEXT
		driver.findElement(By.linkText("terms of service")).click();
		
		//find element by PARTIALLINKTEXT
		driver.findElement(By.partialLinkText("policy")).click();
		
	    //find element by CLASSNAE
		System.out.println(driver.findElement(By.className("js-email-notice")).getText());
		
		//find element by TAGNAME
		WebElement footerTage = driver.findElement(By.xpath("html/body/div[5]/div/div[2]"));
		WebElement tageelement = footerTage.findElement(By.tagName("h4"));
		System.out.println(tageelement.getText());

	    //find element by CSSSELECTOR
		driver.get("https://github.com/marketplace");
		Assert.assertTrue(driver.findElement(By.cssSelector(".site-footer-col.mb-3.pr-3")).isDisplayed());

		
		
		//----------------------GitHub Marketplace page-------------------------
	    //find element by XPATH
		driver.get("https://github.com/marketplace");
		WebElement footerLinks = driver.findElement(By.xpath("html/body/div[5]/div/div[2]"));
		
	    //print all child nodes from a special node
		java.util.List<WebElement> childnode = footerLinks.findElements(By.xpath("ul/*"));
		for(WebElement we: childnode){
			System.out.println(we.getText());
		}
	
		//print current nodes
		WebElement currentnode = footerLinks.findElement(By.xpath("."));
		System.out.println(currentnode.getText());
		
		//print parent nodes of current node
		WebElement parentnode = footerLinks.findElement(By.xpath(".."));
		System.out.println(parentnode.getText());
		
		//print all nodes on the page
		WebElement rootnode = driver.findElement(By.xpath("//*"));
		System.out.println(rootnode.getText());
		
		
		//-------------------------GitHub Price page----------------------------
		//find element by Xpath
		driver.get("https://github.com/pricing");
		java.util.List<WebElement> price;
	    //print the second li under ul node
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[2]"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
	    //print the second element
		WebElement element = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li")).get(2); 
		System.out.println(element.getText());
	 	
		//print the last li under ul node
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[last()]"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
		//print the first two li under ul node
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[position()<3]"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
		//print the li node which's text contains, not or ture 'Personal'
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[not(contains(text(), 'Personal'))]"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
		//print the li node which's text equal 'Personal account'
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[text()='Personal account']"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
		//print the li node which's tag contains 'mb'
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[contains(@class, 'mb')]"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
		//print the li node which's tag equal 'mb-1'
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[@class='mb-1']"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
		//print the a node which has href tag
		price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/a[@href]"));
		for(WebElement we: price){
			System.out.println(we.getText());
		}
		
	
		driver.close();
		

	}

  
}
