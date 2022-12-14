package org_crm_objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCommonPage {
	@SuppressWarnings("unused")
	private WebDriver driver;
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateInformationBtn;
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public SubCommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCreateInformation() {
		CreateInformationBtn.click();
	}

	public void saveInformation() {
		saveBtn.click();
	}

}
