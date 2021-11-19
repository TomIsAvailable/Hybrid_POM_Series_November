package com.qa.opencart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public List<String> readDataFromExcel(String sheetName) {

		List<String> excelData = new ArrayList<>();

		File excelLoc = new File("./src/test/resources/testData/ExcelData.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelLoc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook workbook = null;

		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheet(sheetName);

		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < physicalNumberOfRows; i++) {

			Row row = sheet.getRow(i);

			int physicalNumberOfCells = row.getPhysicalNumberOfCells();

			for (int j = 0; j < physicalNumberOfCells; j++) {

				excelData.add(row.getCell(j).getStringCellValue());

			}

		}

		return excelData;

	}

}
