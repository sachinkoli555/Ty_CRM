package org.ty.daabase_practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExtractDataByKeyInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/WorkBook.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet("CommonData");
		DataFormatter df = new DataFormatter();
		String value = null;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (key.equalsIgnoreCase("url")) {
				value = df.formatCellValue(sheet.getRow(i).getCell(1));
				break;
			}
		}

		System.out.println(value);

	}

}
