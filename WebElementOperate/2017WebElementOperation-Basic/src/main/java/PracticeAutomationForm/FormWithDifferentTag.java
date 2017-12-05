package PracticeAutomationForm;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import LocatorFindElements.Locator;

public class FormWithDifferentTag {

	public static void main(String[] args) {
				
		System.setProperty("webdriver.gecko.driver", "C:/autosenium/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		System.out.println("---Click 'Partical Link Text' link---");
		driver.findElement(By.partialLinkText("Partial")).click();
		
		System.out.println("---Back to previous page");
		driver.navigate().back();
		
		System.out.println("---Click 'Link Text' link---");
		driver.findElement(By.linkText("Link Test"));
		
		System.out.println("---Refresh the current page---");
		driver.navigate().refresh();
		
		System.out.println("---Input values for firstname and lastname");
		driver.findElement(By.name("firstname")).sendKeys("janey");
		driver.findElement(By.name("lastname")).sendKeys("zhou");
		
		System.out.println("---Set sex radio button to Male---");
		java.util.List<WebElement> sexRadioButtons = driver.findElements(By.name("sex"));
		int sexSize = sexRadioButtons.size();
		for(int i=0; i<sexSize; i++){
			String sexValue = sexRadioButtons.get(i).getAttribute("value");
			System.out.println(sexValue);
			if (sexValue.equalsIgnoreCase("MALE")){
				sexRadioButtons.get(i).click();
				break;
			}
		}
		
		System.out.println("---Set Year radio button to 4");
		java.util.List<WebElement> yearRadioButtons = driver.findElements(By.name("exp"));
		System.out.println(yearRadioButtons.size());
		if(yearRadioButtons.get(3).isSelected() == false){
			System.out.println(yearRadioButtons.get(3).getAttribute("value"));
			yearRadioButtons.get(3).click();
		}
		
		System.out.println("---Set Date---");
		driver.findElement(By.cssSelector("#datepicker")).sendKeys("20160614");
		
		System.out.println("---Check all profession checkbox---");
		java.util.List<WebElement> professionCheckbox = driver.findElements(By.name("profession"));
		int professionSize = professionCheckbox.size();
		System.out.println(professionSize);
		for(int i=0; i<professionSize; i++){
			if(professionCheckbox.get(i).isSelected() == false){
				System.out.println(professionCheckbox.get(i).getAttribute("value"));
				professionCheckbox.get(i).click();
			}
		}
		
		System.out.println("---upload fields--");
		WebElement uploadButton = driver.findElement(By.id("photo"));
		uploadButton.sendKeys("C:\\Test\\1.txt");
		
		System.out.println("---download fields--");
		
		System.out.println("---Set checkbox with value---");
		java.util.List<WebElement> toolCheckbox = driver.findElements(By.name("tool"));
		int toolSize = toolCheckbox.size();
		System.out.println(toolSize);
		for(int i=0; i<toolSize; i++){
			String toolValue = toolCheckbox.get(i).getAttribute("value");
			System.out.println(toolValue);
			if(toolValue.equalsIgnoreCase("qtp")){
				toolCheckbox.get(i).click();
			}
		}
		
		System.out.println("---Set dropdown---");
		WebElement element = driver.findElement(By.id("continents"));
		Select continentSelect = new Select(element);
		if(continentSelect.isMultiple() == false){
			continentSelect.selectByIndex(1);
			
		}
		
		System.out.println("---Set multi selection---");
		WebElement element1 = driver.findElement(By.id("selenium_commands"));
		Select commentsSelect = new Select(element1);
		java.util.List<WebElement> commentsOptions = commentsSelect.getOptions();
		commentsOptions.get(0).click();
		commentsSelect.getOptions().get(1).click();
		System.out.println(commentsSelect.getOptions().get(1).getText());
		commentsSelect.selectByVisibleText("Switch Commands");
		commentsSelect.deselectByIndex(1);
		commentsSelect.deselectAll();
			
		System.out.println("---Click button to submit form---");
		driver.findElement(By.id("submit")).click();
		
		driver.close();
	}

}
