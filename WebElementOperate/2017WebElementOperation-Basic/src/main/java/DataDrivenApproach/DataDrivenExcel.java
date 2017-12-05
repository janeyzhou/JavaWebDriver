package DataDrivenApproach;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenExcel {



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = "C:/Users/Janey_Zhou/Desktop/Training/auto/2017Automation/TestData.xlsx";
		String sheetNmae = "GitHubAccount";
		
		System.setProperty("webdriver.chrome.driver", "C:\\autosenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		ExcelUtils excelUtils = new ExcelUtils();
		excelUtils.setExcelFile(filePath, sheetNmae);
		String userAccount = excelUtils.readExcelCell(1, 0);
		String userPassword = excelUtils.readExcelCell(1, 1);
		
		driver.get("https://github.com/login");
		
		driver.findElement(By.id("login_field")).sendKeys(userAccount);
		driver.findElement(By.id("password")).sendKeys(userPassword);
		driver.findElement(By.name("commit")).click();
		
		excelUtils.setExcelCell(1,	2, "pass", filePath);
		
		
		
		
		

	}

}
