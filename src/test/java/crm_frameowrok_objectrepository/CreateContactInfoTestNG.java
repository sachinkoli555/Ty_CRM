package crm_frameowrok_objectrepository;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import org_crm_objectrepository.ContactPage;
import org_crm_objectrepository.CreateNewContactPage;
import org_crm_objectrepository.SubCommonPage;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.BaseClass;

public class CreateContactInfoTestNG extends BaseClass{
	@Test
	public void createContactInfoTestNG() {
		ContactPage contactPage = new ContactPage(driver);
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver); 
		SubCommonPage subCommonPage = new SubCommonPage(driver);
		commonPage.clickOnTab(TabName.Contacts, webDriverUtility);//tab 
		contactPage.Contactpage();//plus
		List<Map<String, String>> list = excelUtility.getDataFromList("form");//data
		createNewContactPage.createNewContactPage(list);//entry
		subCommonPage.saveInformation();
	}
}
