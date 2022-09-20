package crm_frameowrok_objectrepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org_crm_objectrepository.CommonPage;
import org_crm_objectrepository.ContactPage;
import org_crm_objectrepository.CreateNewContactPage;
import org_crm_objectrepository.DeleteContactInformation;
import org_crm_objectrepository.Information;
import org_crm_objectrepository.LoginPage;
import org_crm_objectrepository.SubCommonPage;
import org_crm_objectrepository.TabName;
import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.FileUtility;
import ty.crm.genricutility.IConstant;
import ty.crm.genricutility.WebDriverUtility;

public class CreateContactInfromationObjectRepository {

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

//		String rename = excelUtility.getDataFromExcel("ContactDetails", "first name");
//		System.out.println(rename);
//		String firstname = excelUtility.getDataFromExcel("ContactDetails", 0, 1);
//		String lastname = excelUtility.getDataFromExcel("ContactDetails", 1, 1);
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, (long) 10000, url);
		LoginPage loginpage = new LoginPage(driver);
		Information information = new Information(driver);
		String name = information.getInformation(list);
		ContactPage contactPage = new ContactPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		loginpage.loginAction(username, password);
		commonPage.clickOnTab(TabName.Contacts, webDriverUtility);
		contactPage.Contactpage();
		createNewContactPage.createNewContactPage(list);
		String orgName = null;
		SubCommonPage subCommonPage = new SubCommonPage(driver);
		subCommonPage.saveInformation();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		List<WebElement> ele = driver
				.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td/a[@title='Contacts']"));
		for (WebElement org : ele) {
			orgName = org.getText();
			if (orgName.contains(name)) {
				System.out.println("pass");
				orgName = org.getText();
				break;
			}
		}
		DeleteContactInformation deleteContactInformation = new DeleteContactInformation(driver);
		deleteContactInformation.deleteData(driver, orgName);
		
	}
}
