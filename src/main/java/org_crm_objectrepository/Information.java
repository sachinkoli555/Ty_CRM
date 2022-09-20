package org_crm_objectrepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Information {

	public Information(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String  getInformation(List<Map<String, String>> keyValuePairInMap) {
		return  keyValuePairInMap.get(2).get("firstname");
	}
}
