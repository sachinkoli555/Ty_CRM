package crm_frameowrok_objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org_crm_objectrepository.CommonPage;
import org_crm_objectrepository.EditLink;
import org_crm_objectrepository.LoginPage;
import org_crm_objectrepository.SubCommonPage;
import org_crm_objectrepository.TabName;
import org_crm_objectrepository.UpdateContactInfo;
import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.FileUtility;
import ty.crm.genricutility.IConstant;
import ty.crm.genricutility.WebDriverUtility;

public class UpdateContactInformation {

	public static void main(String[] args) throws IOException {
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		fileUtility.initializePropertyFile(IConstant.PROPERTY_FILE_PATH);
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		String url = fileUtility.getDataFromPropertyFile("url");
		//String firstname = excelUtility.getDataFromExcel("ContactDetails", 6, 1);
		String lastname = excelUtility.getDataFromExcel("ContactDetails", 7, 1);
		
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, (long)1000, url);
		LoginPage loginPage = new LoginPage(driver);
		CommonPage commPage = new CommonPage(driver);
		SubCommonPage subCommonPage = new SubCommonPage(driver);
		UpdateContactInfo updateContactInfo = new UpdateContactInfo(driver);
		EditLink editLink = new EditLink(driver);
		loginPage.loginAction(username, password);
		commPage.clickOnTab(TabName.Contacts,webDriverUtility);
		editLink.clickEdit();
		updateContactInfo.UpdateDetails(lastname);
		subCommonPage.saveInformation();
		
		
		
		
	
		
	}
}
