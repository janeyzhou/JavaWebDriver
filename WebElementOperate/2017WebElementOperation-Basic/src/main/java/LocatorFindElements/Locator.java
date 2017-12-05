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
	
	

	
	
//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
/*	
//--------------Basic Locator--------------------------
//	driver.get("https://github.com/");

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
*/	
	
//-----------------CSS Selector----------------------	
/*	
  //find element by CSSSELECTOR
	driver.get("https://github.com/marketplace");
	Assert.assertTrue(message, condition);
	Assert.assertTrue("displayed", driver.findElement(By.cssSelector(".site-footer-col.mb-3.pr-3")).isDisplayed());

 
*/	

	
	
//-------------------Xpath----------------------------
	
	/* //find element by XPATH
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
		
		//find element by XPATH, print all nodes on the page
		WebElement rootnode = driver.findElement(By.xpath("//*"));
		System.out.println(rootnode.getText());
	*/
	
//	driver.get("https://github.com/pricing");
/*	java.util.List<WebElement> price;
	
	//print out all the div-node under div[2]
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div")); //  /*   /div   /div/*
	
	//print out all the a-node under div[1], exclude the a-node of the child-node of div[1]
	//  /a means the node of a; /a/* means the child node of a; /a  > /a/*
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/a[1]/*"));  
	
	//print out all the h3-node under div[1]/div
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/h3"));
	
	//print the second li under ul node
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[2]"));
  
  //print the second element
//	WebElement element element = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li")).get(2); 
	System.out.println(element.getText());
 	
	//print the last li under ul node
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[last()]"));
	
	//print the first two li under ul node
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[position()<3]"));
	
	//print the li node which's text contains, not or ture 'Personal'
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[not(contains(text(), 'Personal'))]"));
	
	//print the li node which's text equal 'Personal account'
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[text()='Personal account']"));
	
	//print the li node which's tag contains 'mb'
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[contains(@class, 'mb')]"));
	
	//print the li node which's tag equal 'mb-1'
//	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li[@class='mb-1']"));
	
	//print the a node which has href tag
	price = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/a[@href]"));
	
	
	for(WebElement we: price){
		System.out.println(we.getText());
	}
	
	
*/	
	
/*	
	//Compare the different between div and div[1]
	//When there are multi same tagename, please give the tagename with order
	//otherwise it means all child nodes
	java.util.List<WebElement> elements, elements1;
	WebElement price = driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]"));
	elements = price.findElements(By.xpath("div[1]/div/ul/li[@class]"));
	elements1 = price.findElements(By.xpath("div/div/ul/li[@class]"));
	
	//print the p and h4 node under div[1]/div
//	java.util.List<WebElement> elements = price.findElements(By.xpath("div[1]/div/p|div[1]/div/h4"));
	
	for(WebElement we: elements){
		System.out.println(we.getText());
	}
	
	for(WebElement we: elements1){
		System.out.println(we.getText());
	}
*/
	
	//print the count of the elements
/*		int number;
	number = driver.findElements(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/div[1]/div/ul/li")).size(); 
	System.out.println(number);
*/
	

//	driver.close();
	

	

}
