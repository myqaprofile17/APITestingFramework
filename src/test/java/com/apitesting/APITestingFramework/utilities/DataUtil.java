package com.apitesting.APITestingFramework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.apitesting.APITestingFramework.setUp.BaseTest;


public class DataUtil extends BaseTest {
	
	public Properties config = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");

@DataProvider(name="data", parallel=true)
public Object[][] getData(Method m) {
	try {
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		config.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(config);
	System.out.println(config.getProperty("testSheetName"));
	int rows = excel.getRowCount(config.getProperty("testSheetName"));
	System.out.println("Total Rows are : " + rows);

	// Find the test case start row
	String testName = m.getName();
	System.out.println("Test Name is  " + testName);
	int testCaseRowNum = 1;

	for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

		String testCaseName = excel.getCellData(config.getProperty("testSheetName"), 0, testCaseRowNum);

		if (testCaseName.equalsIgnoreCase(testName))
			break;

	}

	System.out.println("TestCase starts from row: " + testCaseRowNum);

	int dataStartRowNum = testCaseRowNum + 2;

	int testRows = 0;
	while (!excel.getCellData(config.getProperty("testSheetName"), 0, dataStartRowNum + testRows).equals("")) {

		testRows++;
	}

	System.out.println("Total rows of data are : " + testRows);

	// Checking total cols in test case

	int colStartColNum = testCaseRowNum + 1;
	int testCols = 0;

	while (!excel.getCellData(config.getProperty("testSheetName"), testCols, colStartColNum).equals("")) {

		testCols++;

	}

	System.out.println("Total cols are : " + testCols);

	// Printing data

	Object[][] data = new Object[testRows][1];

	int i = 0;
	for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

		Hashtable<String, String> table = new Hashtable<String, String>();

		for (int cNum = 0; cNum < testCols; cNum++) {

			// System.out.println(excel.getCellData(config.getProperty("testSheetName"),
			// cNum, rNum));
			String testData = excel.getCellData(config.getProperty("testSheetName"), cNum, rNum);
			String colName = excel.getCellData(config.getProperty("testSheetName"), cNum, colStartColNum);

			table.put(colName, testData);

		}

		data[i][0] = table;
		i++;

	}

	return data;
}
}

//		@DataProvider(name="data")
//		public Object[][] getData(Method m) {	
//			System.out.println(m.getName());
//			String sheetName = m.getName();
//			int rows = excel.getRowCount(sheetName);
//			System.out.println(rows);
//			int cols = excel.getColumnCount(sheetName);
//			System.out.println(cols);
//			System.out.println(rows-1);
//			Object[][] data = new Object[rows - 1][cols];
//			for (int rownum = 2; rownum <= rows; rownum++) {
//				for (int colnum = 0; colnum < cols; colnum++) {
//					data[rownum - 2][colnum] = excel.getCellData(sheetName, colnum, rownum);
//				}
//			}
//			return data;
//
//		}


