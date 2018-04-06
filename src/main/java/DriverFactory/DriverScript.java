package DriverFactory;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilities.ExcelFileUtil;
import commonFunctionalities.CommonFunctions;

public class DriverScript {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	public void startTest() throws Throwable {
		ExcelFileUtil excel = new ExcelFileUtil();
		
		for(int i=1;i<=excel.rowCount("Modules");i++) {
			
			if(excel.getData("Modules", i, 2).equalsIgnoreCase("Y")){
				String TCModule = excel.getData("Modules", i, 1);
				for(int j=1;j<excel.rowCount(TCModule);j++) {
					String Description = excel.getData(TCModule, j, 0);
					String Method = excel.getData(TCModule, j,1);
					String locator_Type = excel.getData(TCModule, j, 2);
					String locator_Value = excel.getData(TCModule, j, 3);
					String data = excel.getData(TCModule, j, 4);
					
					try {
						if(Method.equalsIgnoreCase("startBrowser")) {
							driver = CommonFunctions.startBrowser(driver);
						}
						if(Method.equalsIgnoreCase("openApplication")) {
							 CommonFunctions.openApplication(driver);
						}
						if(Method.equalsIgnoreCase("clickAction")) {
							 CommonFunctions.clickAction(driver, locator_Type, locator_Value);
						}
						if(Method.equalsIgnoreCase("typeAction")) {
							 CommonFunctions.typeAction(driver, locator_Type, locator_Value, data);
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
	}

}
