package crm_frameowrok_objectrepository;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import org_crm_objectrepository.CreateNewOrganization;
import org_crm_objectrepository.SubCommonPage;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.BaseClass;

public class CreateOrgnaizationTestNG extends BaseClass {

	@Test
	public void createOrgnaizationTestNG() {
		SubCommonPage subCommonPage = new SubCommonPage(driver);
		CreateNewOrganization createNewOrganization = new CreateNewOrganization(driver);
		commonPage.clickOnTab(TabName.Organizations, webDriverUtility);// tab
		subCommonPage.clickCreateInformation();
		List<Map<String, String>> list = excelUtility.getDataFromList("form");// data
		createNewOrganization.createNewOrgnizationPage(list);

	}

}
