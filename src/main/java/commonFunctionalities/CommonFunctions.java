package commonFunctionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class CommonFunctions 
{

	public static WebDriver startBrowser(WebDriver driver) throws Throwable {
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Testing\\HybridFrameWork_CRM\\Banking\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "D:\\Testing\\HybridFrameWork_CRM\\Banking\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public static void openApplication(WebDriver driver) throws Throwable {
		driver.manage().window().maximize();
		driver.get(PropertyFileUtil.getValueForKey("URL"));
	}
	
	public static void typeAction(WebDriver driver, String locatorType, String locatorValue, String data) {
		
		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(data);
		} else
			if(locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locatorValue)).sendKeys(data);
			} else
				if(locatorType.equalsIgnoreCase("xpath")) {
					driver.findElement(By.xpath(locatorValue)).sendKeys(data);
				}
	}
	
	public static void clickAction(WebDriver driver, String locatorType, String locatorValue) {

		if(locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else
			if(locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locatorValue)).click();
			} else
				if(locatorType.equalsIgnoreCase("xpath")) {
					driver.findElement(By.xpath(locatorValue)).click();
				}
	}
	
	public static void waitForElement(WebDriver driver, String locatorType, String locatorValue, String waitTime) {
		WebDriverWait wait =  new WebDriverWait(driver, Integer.parseInt(waitTime));
		if(locatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		} else
			if(locatorType.equalsIgnoreCase("name")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			} else
				if(locatorType.equalsIgnoreCase("xpath")) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				}
		
	}
}
