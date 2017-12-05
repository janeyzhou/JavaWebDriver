package LocatorFindElements;

import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRunner {
	private Locator locator = new Locator();

	@BeforeTest
	public void setUp() throws Exception {
		locator.waitTime();
	}
	
	
	
	@Test(groups = {"HomePage"})
	public void openHomePage(){
		locator.openPage("https://github.com/");
	}
	
	@Test(groups = {"PricePage"})
	public void openPricePage(){
		locator.openPage("https://github.com/pricing");
	}
	
/*	@Test
	@Parameters("url")
	public void testOpenPage(String url){
		locator.openPage(url);
	}*/
	
	@Test(description = "ByID", groups = {"HomePage"})
	public void testFindByID() {
		boolean b = locator.findByID().isDisplayed();
		Assert.assertTrue(b, "Can't find the element by ID");
	}
	
	@Test(description = "ByName", groups = {"HomePage"})
	public void testFindByName(){
		boolean b = locator.findByName().isDisplayed();
		Assert.assertTrue(b, "Can't find the element by Name");
	}
	
	@Test(description = "ByLinkText", groups = {"HomePage"})
	public void testFindByLinkText(){
		Assert.assertEquals(locator.findByLinkTEXT().getText(), "terms of service", "Can't find the element by LinkText");		
	}
	
	@Test(description = "ByParticalLinkText", groups = {"HomePage"})
	public void testFindByPartialLinkText(){
		Assert.assertEquals(locator.findByPartialLinkText().getText(), "privacy policy", "Can't find the element by PartialLinkText");	
	}
	
	@Test(description = "ByClassName", groups = {"HomePage"})
	public void testFindByClassName(){
		Assert.assertEquals(locator.findByClassName().getText(), "We’ll occasionally send you account related emails.", "Can't find the element by ClassName");	
	}
	
	@Test(description = "ByTageName", groups = {"HomePage"})
	public void testFindByTagName(){
		Assert.assertEquals(locator.findByTagName().getText(), "Features", "Can't find the element by TagName");	
	}
	
	@Test(description = "ByXpathPredications", groups = {"PricePage"})
	public void testFindByXpathPredications(){
		Assert.assertEquals(locator.findByXpathPredications().getText(), "Unlimited public repositories", "Can't find the element by Xpath Predications");
	}
	@Test(description = "ByXpathPosition", groups = {"PricePage"})
	public void testFindByXpathPosition(){
		Assert.assertEquals(locator.findByXpathPosition().getText(), "Personal account", "Can't find the element by Xpath Position");
	}
	@Test(description = "ByXpathText", groups = {"PricePage"})
	public void testFindByXpathText(){
		Assert.assertEquals(locator.findByXpathText().getText(), "Personal account", "Can't find the element by Xpath Text");		
	}
	@Test(description = "ByXpathContains", groups = {"PricePage"})
	public void testFindByXpathContains(){
		Assert.assertTrue(locator.findByXpathContains().isDisplayed(), "Can't find the element by Xpath Contains");		
	}
	
	@Test(description = "ByXpathList", groups = {"PricePage"})
	public void testFindByXpathList(){
		java.util.List<WebElement> list = locator.findByXpathList();
		Iterator<WebElement> i = list.listIterator();
		while(i.hasNext()){
			System.out.println(i.next().getText());
		}
	}
	

	
	@AfterTest
	public void testTeardown() {
		locator.teardown();
	}


}
