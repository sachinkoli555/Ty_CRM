package ty.crm.genricutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist resuable mthod to handle property file
 * 
 * @author sachin
 *
 */
public class FileUtility {
	Properties pro;

	public String getDataFromPropertyFile(String key) {
		return pro.getProperty(key).trim();
	}

	public void initializePropertyFile(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		pro = new Properties();
		pro.load(file);
	}
}
