package org_crm_objectrepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfo {

	@FindBy(name = "firstname")
	private WebElement firstName;
	@FindBy(name = "lastname")
	private WebElement lastName;
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public UpdateContactInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void UpdateDetails(String updatedLastName) {
		lastName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		lastName.sendKeys(updatedLastName);
	}

	public void UpdateDetailsMap(List<Map<String, String>> keyValuePairInMap) {
		firstName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		firstName.sendKeys(keyValuePairInMap.get(2).get("firstname"));
		lastName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		lastName.sendKeys(keyValuePairInMap.get(2).get("lastname"));
	}

}
