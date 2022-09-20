package org.ty.integration_testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRM_Delete_Operation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB);
		driver.findElement(By.name("user_password")).sendKeys("root", Keys.ENTER);
		String ComName = "shubham";
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		List<WebElement> ele = driver
				.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td/a[@title='Contacts']"));
		for (WebElement org : ele) {
			String orgName = org.getText();
			if (orgName.equals(ComName)) {
				driver.findElement(
						By.xpath("//a[text()='"+ComName+"']/parent::td/preceding-sibling::td/input[@name='selected_id']"))
						.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		// driver.switchTo().alert().accept();
	}

}
