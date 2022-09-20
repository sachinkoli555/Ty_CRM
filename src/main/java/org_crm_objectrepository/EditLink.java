package org_crm_objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditLink {

	@FindBy(xpath = "//a[text()='edit']") private WebElement editLink;
	
	public EditLink(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickEdit() {
		editLink.click();
	}
}
