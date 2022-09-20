package crm_frameowrok_objectrepository;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import org_crm_objectrepository.DeleteContactInformation;
import org_crm_objectrepository.Information;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.BaseClass;

public class DeleteContactInfoTestNG extends BaseClass {

	@Test
	public void deleteContactInfoTestNG() {
		Information information = new Information(driver);
		List<Map<String, String>> list = excelUtility.getDataFromList("form");
		String name = information.getInformation(list);
		commonPage.clickOnTab(TabName.Contacts, webDriverUtility);
		DeleteContactInformation deleteContactInformation = new DeleteContactInformation(driver);
		deleteContactInformation.deleteData(driver, name);
	}

}
