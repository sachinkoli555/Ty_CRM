package org_crm_objectrepository;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.IConstant;

public class DeleteContactInformation {
	public void getName() throws EncryptedDocumentException, IOException {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		excelUtility.getDataFromExcel("ContactDetails", "first name");
	}

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr/td/a[@title='Contacts']")
	private List<WebElement> listOfNames;
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	public DeleteContactInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void deleteData(WebDriver driver, String ComName) {
		for (WebElement org : listOfNames) {
			String orgName = org.getText();
			if (orgName.equals(ComName)) {
				driver.findElement(By.xpath(
						"//a[text()='" + ComName + "']/parent::td/preceding-sibling::td/input[@name='selected_id']"))
						.click();
				break;
			}
		}
		deleteBtn.click();
		driver.switchTo().alert().accept();
	}
}
