package org_crm_objectrepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	@FindBy(name = "firstname")
	private WebElement firstName;
	@FindBy(name = "lastname")
	private WebElement lastName;
	@FindBy(name = "email")
	private WebElement emailId;
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createNewContactPage(List<Map<String, String>> keyValuePairInMap) {
		firstName.sendKeys(keyValuePairInMap.get(2).get("firstname"));
		lastName.sendKeys(keyValuePairInMap.get(2).get("lastname"));
		emailId.sendKeys(keyValuePairInMap.get(2).get("mail"));
	}

	public void createNewContactPage(String firstname, String lastname) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
	}

	public void UpdateDetails(String updatedLastName) {
		lastName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		lastName.sendKeys(updatedLastName);
	}

}
