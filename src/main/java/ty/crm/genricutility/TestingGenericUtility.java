package ty.crm.genricutility;

import java.io.IOException;

public class TestingGenericUtility {

	public static void main(String[] args) throws IOException {
		new ExcelUtility().intilaizeExcel(IConstant.EXCE_PATH);
		String data = new ExcelUtility().getDataFromExcel("CommonData", 1, 1);
		System.out.println(data);

		new FileUtility().initializePropertyFile(IConstant.PROPERTY_FILE_PATH);
		String browser = new FileUtility().getDataFromPropertyFile("browser");
		System.out.println(browser);

		int randomNumber = new javaUtility().getRandomNumber(1000);
		System.out.println(randomNumber);
		
		long res = (long) new javaUtility().convertToAnyDataType("10", DataType.LONG);
		System.out.println(res);

	}
}
