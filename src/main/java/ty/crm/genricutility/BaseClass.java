package ty.crm.genricutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org_crm_objectrepository.CommonPage;
import org_crm_objectrepository.LoginPage;

public class BaseClass {
	private LoginPage loginPage;
	private String userName;
	private String Password;
	protected CommonPage commonPage;
	protected WebDriverUtility webDriverUtility;
	protected ExcelUtility excelUtility;
	protected FileUtility fileUtility;
	protected WebDriver driver;
	public static WebDriver sdriver;

	@BeforeClass
	public void classSetup() throws EncryptedDocumentException, IOException {
		excelUtility = new ExcelUtility();
		fileUtility = new FileUtility();
		webDriverUtility = new WebDriverUtility();
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		fileUtility.initializePropertyFile(IConstant.PROPERTY_FILE_PATH);
		userName = fileUtility.getDataFromPropertyFile("username");
		Password = fileUtility.getDataFromPropertyFile("password");
		String browser = fileUtility.getDataFromPropertyFile("browser");
		String url = fileUtility.getDataFromPropertyFile("url");
		driver = webDriverUtility.OpenBrowserWithApplication(browser, (long) 10000, url);
		sdriver=driver;
		loginPage = new LoginPage(driver);
		commonPage = new CommonPage(driver);

	}

	@BeforeMethod
	public void methodSetup() {
		loginPage.loginAction(userName, Password);
	}

	@AfterMethod
	public void methodTearDown() {
		commonPage.logout(webDriverUtility, driver);
	}

	@AfterClass
	public void classtearDown() {
		webDriverUtility.closeBroswer(driver);
	}
}
