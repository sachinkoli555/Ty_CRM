package org.ty.integration_testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.FileUtility;
import ty.crm.genricutility.IConstant;
import ty.crm.genricutility.WebDriverUtility;

public class CRM_TC_FrameWork_contactCreation {

	public static void main(String[] args) throws IOException {
		ExcelUtility excelUtility = new ExcelUtility();
		FileUtility file = new FileUtility();
		
		file.initializePropertyFile(IConstant.PROPERTY_FILE_PATH);
		String username = file.getDataFromPropertyFile("username");
		String password = file.getDataFromPropertyFile("password");
		String browser = file.getDataFromPropertyFile("browser");
		String url = file.getDataFromPropertyFile("url");
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		String firstname = excelUtility.getDataFromExcel("ContactDetails", 0, 1);
		String lastname = excelUtility.getDataFromExcel("ContactDetails", 1, 1);
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, (long) 10000, url);
		driver.findElement(By.name("user_name")).sendKeys(username, Keys.TAB);
		driver.findElement(By.name("user_password")).sendKeys(password, Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("salutationtype")).click();
		webDriverUtility.dropDownHandle(driver.findElement(By.name("salutationtype")));
//		WebElement ele1 = driver.findElement(By.name("salutationtype"));
//		Select s1 = new Select(ele1);
//		s1.selectByIndex(1);
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
		webDriverUtility.mouseHoverAction(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		webDriverUtility.closeBroswer(driver);
		

	}
}
