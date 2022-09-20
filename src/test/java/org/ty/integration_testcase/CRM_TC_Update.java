
package org.ty.integration_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRM_TC_Update {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB);
		driver.findElement(By.name("user_password")).sendKeys("root", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='edit']")).click();
		driver.findElement(By.name("lastname")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		driver.findElement(By.name("lastname")).sendKeys("koli");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	}
}
