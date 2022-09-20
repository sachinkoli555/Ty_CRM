package org_crm_objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectRepository {
	

	@FindBy(name = "user_name") private WebElement usernameTextFiled;
	@FindBy(name = "user_password") private WebElement passwordTextFiled;
	@FindBy(xpath  = "//a[text()='Contacts']") private WebElement contactTab;
	@FindBy(xpath  = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createContactBtn;
	@FindBy(name = "firstname") private WebElement firstName;
	@FindBy(name = "lastname") private WebElement lastName;
	@FindBy(xpath  = "//input[@class='crmButton small save']") private WebElement saveBtn;
	
	
	
}
