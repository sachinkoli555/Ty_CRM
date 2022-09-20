package crm_frameowrok_objectrepository;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import org_crm_objectrepository.ContactPage;
import org_crm_objectrepository.TabName;
import org_crm_objectrepository.UpdateContactInfo;
import ty.crm.genricutility.BaseClass;

public class UpdateContactInfroTestNG extends BaseClass {

	@Test
	public void updateContactInfroTestNG() {
		ContactPage contactPage = new ContactPage(driver);
		UpdateContactInfo updateContactInfo = new UpdateContactInfo(driver);
		commonPage.clickOnTab(TabName.Contacts, webDriverUtility);
		contactPage.Contactpage();
		List<Map<String, String>> list = excelUtility.getDataFromList("updatedDetails");
		updateContactInfo.UpdateDetailsMap(list);
	}
}
