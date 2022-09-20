package org.ty.daabase_practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import ty.crm.genricutility.ExcelUtility;
import ty.crm.genricutility.IConstant;

public class Data_from_Excel_File {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.intilaizeExcel(IConstant.EXCE_PATH);
		String url = excelUtility.getDataFromExcel( "CommonData", 0, 1);
		String username = excelUtility.getDataFromExcel("CommonData", 1, 1);
		String password = excelUtility.getDataFromExcel( "CommonData", 2, 1);
//		Sheet sheet = wb.getSheet("CommonData");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String username = cell.getStringCellValue();
		System.out.println("URL  = " + url);
		System.out.println("UserName = " + username);
		System.out.println("Passowrd = " + password);

	}

}

