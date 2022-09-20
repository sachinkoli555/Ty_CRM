package crm_frameowrok_objectrepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org_crm_objectrepository.CommonPage;
import org_crm_objectrepository.DeleteContactInformation;
import org_crm_objectrepository.Information;
import org_crm_objectrepository.LoginPage;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.FileUtility;
import ty.crm.genricutility.IConstant;
import ty.crm.genricutility.WebDriverUtility;

public class DeleteContactInfo {

	public static void main(String[] args) throws IOException {
		ExcelUtility excelUtility = new ExcelUtility();
		FileUtility file = new FileUtility();
		file.initializePropertyFile(IConstant.PROPERTY_FILE_PATH);
		String username = file.getDataFromPropertyFile("username");
		String password = file.getDataFromPropertyFile("password");
		String browser = file.getDataFromPropertyFile("browser");
		String url = file.getDataFromPropertyFile("url");
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		List<Map<String, String>> list = excelUtility.getDataFromList("form");

//		String firstname = excelUtility.getDataFromExcel("ContactDetails", 0, 1);
//		String lastname = excelUtility.getDataFromExcel("ContactDetails", 1, 1);
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, (long) 10000, url);
		LoginPage loginpage = new LoginPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		Information information = new Information(driver);
		String name = information.getInformation(list);
		DeleteContactInformation deleteContactInformation = new DeleteContactInformation(driver);
		loginpage.loginAction(username, password);
		commonPage.clickOnTab(TabName.Contacts, webDriverUtility);
		deleteContactInformation.deleteData(driver, name);
		driver.switchTo().alert().accept();

	}
}
