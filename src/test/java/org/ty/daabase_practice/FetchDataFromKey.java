package org.ty.daabase_practice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.IConstant;

public class FetchDataFromKey {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
//		FileInputStream file = new FileInputStream("./src/test/resources/WorkBook.xlsx");
//		Sheet sheet = WorkbookFactory.create(file).getSheet("form");
//		Map<String, String> map = new HashMap<String, String>();
//		DataFormatter df = new DataFormatter();
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
//		}
//		System.out.println(map);
		Map<String, String> map = excelUtility.getDataFromExcelMap("form");
		System.out.println(map.get("address"));

		List<Map<String, String>> list = excelUtility.getDataFromList("form");
		System.out.println(list.get(1).get("address"));

	}
}
