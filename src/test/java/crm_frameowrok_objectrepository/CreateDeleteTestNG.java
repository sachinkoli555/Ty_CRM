package crm_frameowrok_objectrepository;

import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import org_crm_objectrepository.ContactPage;
import org_crm_objectrepository.CreateNewContactPage;
import org_crm_objectrepository.DeleteContactInformation;
import org_crm_objectrepository.Information;
import org_crm_objectrepository.SubCommonPage;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.BaseClass;

public class CreateDeleteTestNG extends BaseClass {
	@Test
	public void createDeleteTestNG() {
		ContactPage contactPage = new ContactPage(driver);
		Information information = new Information(driver);
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		SubCommonPage subCommonPage = new SubCommonPage(driver);
		commonPage.clickOnTab(TabName.Contacts, webDriverUtility);// tab
		contactPage.Contactpage();// plus
		List<Map<String, String>> list = excelUtility.getDataFromList("form");// data
		createNewContactPage.createNewContactPage(list);
		String name = information.getInformation(list);// entry
		subCommonPage.saveInformation();
		DeleteContactInformation deleteContactInformation = new DeleteContactInformation(driver);
		deleteContactInformation.deleteData(driver, name);
	}
}
