package com.crm.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	public void setData(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
		workbook.write(fos);
		workbook.close();
	}

}
