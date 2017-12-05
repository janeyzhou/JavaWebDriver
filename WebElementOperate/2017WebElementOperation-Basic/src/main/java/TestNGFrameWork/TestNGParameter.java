package TestNGFrameWork;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNGFrameWork.ReadExcel;

public class TestNGParameter {
	//Use DataProvider to transmit parameter
	/*@DataProvider(name = "Anthentication")
	public Object[][] credenticals(){
		return new Object[][] {{"janeyzhou", "zj19880311"},{"janeyzhou", "zj19880311"}};
	}
	@Test(dataProvider = "Anthentication")  */
	
	//Use DataProvider to read parameter from excel
	@DataProvider(name = "Anthentication")
	public Object[][] credenticals() throws IOException{
		Object[][] testArray = ReadExcel.getAccountArray("C:/Users/Janey_Zhou/Desktop/Training/auto/2017Automation/TestData.xlsx", "GitHubAccount");
		return testArray;
	}
	@Test(dataProvider = "Anthentication")
	
	
	//Parameter methond, we can set parameter to xml file
	/*@Test
	@Parameters({"sUsername", "sPassword"})*/
	public void test(String sUsername, String sPassword){
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/login");
		driver.findElement(By.name("login")).sendKeys(sUsername);
		driver.findElement(By.name("password")).sendKeys(sPassword);
		driver.findElement(By.name("commit")).click();
		driver.close();
		
	}

}
