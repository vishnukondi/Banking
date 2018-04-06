package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
	
	public static String getValueForKey(String Key) throws Throwable, Throwable {
	
	Properties propertiesConfiguration = new Properties();
	propertiesConfiguration.load(new FileInputStream(new File("D:\\Testing\\HybridFrameWork_CRM\\Banking\\PropertiesFile\\Properties.properties")));
	return propertiesConfiguration.getProperty(Key);
	

}
}
