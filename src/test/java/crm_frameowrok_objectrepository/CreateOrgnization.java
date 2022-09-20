package crm_frameowrok_objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org_crm_objectrepository.CommonPage;
import org_crm_objectrepository.CreateNewOrganization;
import org_crm_objectrepository.LoginPage;
import org_crm_objectrepository.SubCommonPage;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.FileUtility;
import ty.crm.genricutility.IConstant;
import ty.crm.genricutility.WebDriverUtility;

public class CreateOrgnization {

	public static void main(String[] args) throws IOException {
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		fileUtility.initializePropertyFile(IConstant.PROPERTY_FILE_PATH);
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		String org_name= excelUtility.getDataFromExcel("OgrnizationDetails", 0, 1);
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, (long) 1000, url);
		LoginPage loginPage = new LoginPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		SubCommonPage subCommonPage = new SubCommonPage(driver);
		CreateNewOrganization createNewOrganization =  new CreateNewOrganization(driver);
		loginPage.loginAction(username, password);
		commonPage.clickOnTab(TabName.Organizations,webDriverUtility);
		commonPage.clickCreateInformation();
		createNewOrganization.createNewOrgPage(org_name);	
		subCommonPage.saveInformation();
		commonPage.logout(webDriverUtility, driver);
		commonPage.closeBroswer(driver);
		
		
		
		
		
		
		
		
		
		
		

	}
	

}
