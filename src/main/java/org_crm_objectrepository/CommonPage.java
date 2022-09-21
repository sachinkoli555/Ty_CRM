package org_crm_objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ty.crm.genricutility.WebDriverUtility;


public class CommonPage {

	private WebDriver driver;
	String dynamicXpath = "//a[.='%s']";
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateInformationBtn;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement singoutBtn;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administator;
	
	//this is COMMON PAGE iiiiiii

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTab(TabName tagName, WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath, tagName.getTabName(), driver).click();
	}

	public void clickCreateInformation() {
		CreateInformationBtn.click();
	}

	public void logout(WebDriverUtility webDriverUtility, WebDriver driver) {
		webDriverUtility.mouseHoverAction(driver, administator);
		singoutBtn.click();
	}

	public void closeBroswer(WebDriver driver) {
		driver.quit();
	}

}
