package com.apitesting.APITestingFramework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName) {
	
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	htmlReporter.config().setEncoding("utf-8");
	htmlReporter.config().setDocumentTitle(fileName);
	htmlReporter.config().setReportName(fileName);
	htmlReporter.config().setTheme(Theme.STANDARD);

	/*
	 * Create an object of extent report attach the html reporter set sys info with
	 * author name, org, build no
	 */
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("tester", "m1");
	extent.setSystemInfo("Organizatio", "o1");
	extent.setSystemInfo("build no", "v1");
return extent;
}
	
	/*  public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() {

		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}*/
}
