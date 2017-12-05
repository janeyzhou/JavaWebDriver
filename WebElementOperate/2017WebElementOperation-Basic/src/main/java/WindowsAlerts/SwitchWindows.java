package WindowsAlerts;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SwitchWindows {
	public static void main(String argo[]) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:\\autosenium\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		//Please remember to wait the page loading when switch to other pages
						
		driver.findElement(By.cssSelector("[onclick^=newBrwWin]")).click();
		
		Set<String> handlers = driver.getWindowHandles();
		//get a special window handler by array
		String[] str = handlers.toArray(new String[handlers.size()]);
		driver.switchTo().window(str[1]);
		
		ArrayList<String> newWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newWindow.get(1));
		Thread.sleep(5000);
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.cssSelector(".wpb_wrapper>h1>span")).getText());
		/*
		//get a special window handler by iterator
		driver.findElement(By.cssSelector("[onclick^=newMsgWin]")).click();
		String firstHandler = driver.getWindowHandle();
		System.out.println(firstHandler);
		handlers.remove(firstHandler);
		
		String windowHandler = handlers.iterator().next();
		System.out.println(windowHandler);

		driver.switchTo().window(windowHandler);
		System.out.println(driver.getPageSource());

		
		//for遍历所有的window

		for(String windows: handlers){
			System.out.println(windows);
			driver.switchTo().window(windows);
		//	driver.manage().window().setSize(new Dimension(4,5));
		}
		
		//Switch window by window name
		driver.switchTo().window("23");
		driver.manage().window().maximize();
		
		
		//iterator 遍历所有 window
		if(handlers.iterator().hasNext()){
			driver.switchTo().window(handlers.iterator().next());
			driver.manage().window().setPosition(new Point(5,5));
		}
		

		
	
		
		//open page in new tab
		driver.findElement(By.cssSelector("[onclick^=newBrwTab]")).click();
		ArrayList newTab = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) newTab.get(1));
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		
			driver.close();*/
	}

}
