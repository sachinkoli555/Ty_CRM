
package ty.crm.genricutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * this class contains all common excel methods
 * 
 * @author sachin
 *
 */
public class ExcelUtility {
	Workbook wb;

	/**
	 * this method is used fetch the data from excel
	 * 
	 * @param excelPath
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */

	public void intilaizeExcel(String excelPath) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(excelPath);
		wb = WorkbookFactory.create(file);
	}

	public String getDataFromExcel(String sheetName, int row, int cell) {
		Sheet sheet = wb.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(row).getCell(cell));
		return data;
	}

	@SuppressWarnings("unused")
	public String getDataFromExcel(String sheetName, String requiredKey)
			throws EncryptedDocumentException, IOException {
		Sheet sheet = wb.getSheet(sheetName);
		String value = null;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			if (key.equalsIgnoreCase(requiredKey))
				value = sheet.getRow(i).getCell(1).getStringCellValue();
			break;
		}
		return value;

	}

	public Map<String, String> getDataFromExcelMap(String sheetName) throws EncryptedDocumentException, IOException {
		Sheet sheet = wb.getSheet(sheetName);
		Map<String, String> map = new HashMap<String, String>();
		DataFormatter df = new DataFormatter();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
	}

	public List<Map<String, String>> getDataFromList(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<>();
		DataFormatter df = new DataFormatter();
		for (int i = 1; i < sheet.getRow(0).getLastCellNum(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j <= sheet.getLastRowNum(); j++) {
				map.put(df.formatCellValue(sheet.getRow(j).getCell(0)), df.formatCellValue(sheet.getRow(j).getCell(i)));
			}
			list.add(map);
		}
		return list;
	}

	public void closeExcel() throws IOException {
		wb.close();
	}

	public void setDataInExcel(String sheetName, int row, int cell, String text) {
		Sheet sheet = wb.getSheet(sheetName);
		sheet.getRow(row).createCell(cell).setCellValue(text);
	}

	public void saveDataInToExcel(String outputPath) throws FileNotFoundException, IOException {
		wb.write(new FileOutputStream(outputPath));

	}

}
