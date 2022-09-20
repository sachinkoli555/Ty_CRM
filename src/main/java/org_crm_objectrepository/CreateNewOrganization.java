package org_crm_objectrepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {

	@FindBy(xpath = "//input[@name='accountname']") private WebElement orgName;
	@FindBy(xpath = "//input[@class='crmbutton small save']") private WebElement saveBtn;
	
	
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void createNewOrgPage(String orgname) {
		orgName.sendKeys(orgname);
	}
	public void createNewOrgnizationPage(List<Map<String, String>> keyValuePairInMap) {
		orgName.sendKeys(keyValuePairInMap.get(2).get("firstname"));
//		lastName.sendKeys(keyValuePairInMap.get(2).get("lastname"));
//		emailId.sendKeys(keyValuePairInMap.get(2).get("mail"));
	}
	
}
