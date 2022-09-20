package org_crm_objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	@FindBy(name = "user_name")
	private WebElement usernameTextFiled;
	@FindBy(name = "user_password")
	private WebElement passwordTextFiled;
//
//	public WebElement getUsernameTextFiled() {
//		return usernameTextFiled;
//	}
//
//	public WebElement getPasswordTextFiled() {
//		return passwordTextFiled;
//	}
	
	public void loginAction(String username,String password) {
		usernameTextFiled.sendKeys(username, Keys.TAB);
		passwordTextFiled.sendKeys(password,Keys.ENTER);
	}

}
