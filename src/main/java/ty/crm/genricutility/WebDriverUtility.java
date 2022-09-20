package ty.crm.genricutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class consist all webdriver common action methods
 * 
 * @author admin
 *
 */
public class WebDriverUtility {

	public WebDriver launchBrowser(String browser) {
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid broswer name");
			break;
		}

		return driver;
	}

	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	public void waitPageTillGetLoad(WebDriver driver, Long longtimeout) {
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}

	public void navigateapplication(WebDriver driver, String url) {
		driver.get(url);
	}

	public WebDriver OpenBrowserWithApplication(String broswer, Long longtimeout, String url) {
		WebDriver driver = launchBrowser(broswer);
		maximizeBrowser(driver);
		waitPageTillGetLoad(driver, longtimeout);
		navigateapplication(driver, url);
		return driver;
	}

	public void mouseHoverAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick().perform();
	}

	public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredPath = String.format(dynamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredPath));
		return element;
	}

	public void closeBroswer(WebDriver driver) {
		driver.quit();
	}

	public void waitTillElement(WebDriver driver, long longTime, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchWindow(WebDriver driver) {
		Set<String> windowsId = driver.getWindowHandles();
		for (String string : windowsId) {
			driver.switchTo().window(string);
			if (string.contains("Accounts"))
				break;
		}
	}

	public void dropDownHandle(WebElement element) {
		Select s1 = new Select(element);
		s1.selectByIndex(1);
	}

	public void screenShot(WebDriver driver) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		 String date_time = LocalDateTime.now().toString().replace(":", "_");
		 String name="screenshot";
		 File destionation = new File("./screenshot/"+date_time+name+".PNG");
		 Files.copy(src, destionation);
	}
}

//webDriver driver = open
