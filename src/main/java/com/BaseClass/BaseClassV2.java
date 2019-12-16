package com.BaseClass;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassV2 {

	public static WebDriver driver;
	/*
	 * 1. getBrowser 2. getUrl 3. waitForElementVisibility
	 * 
	 */

	public static WebDriver getBrowser(String browserName) throws Exception {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajith\\eclipse-workspace\\Adactin\\src\\test\\resources\\com\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver(); // user.dir will contain the system path
												// "C:\Users\Ajith\eclipse-workspace\Maven"
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir" + "\\Driver\\geckodriver.exe"));
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("C:\\Users\\Ajith\\eclipse-workspace\\Maven\\Driver\\IEDriverServer.exe"));
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Invalid browser name");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
	}

	public static void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("URL is not valid");
		}
	}

	public static void elementVisibility(WebElement element) {
		WebDriverWait wb = new WebDriverWait(driver, 60);
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean elementDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public static boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public static boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public static void sendKeys(WebElement element, String keys) {
		elementVisibility(element);
		if (elementDisplayed(element) && elementIsEnabled(element)) {
			element.clear();
			element.sendKeys(keys);
		}
	}

	public static void click(WebElement element) {
		elementVisibility(element);
		element.click();
	}

	public static void mouseHover(WebElement element) {
		Actions ac = new Actions(driver);
		elementVisibility(element);
		ac.moveToElement(element).build().perform();
	}

	public static String getElementText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}

	public static String datas(int rownum, int columnnum) throws Throwable {
		File f = new File("C:\\Users\\cbzsr\\OneDrive\\Desktop\\eclipse\\jdk\\mavenproject\\newExcel\\newBook.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("Sheet1");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		// for (int i = 0; i < physicalNumberOfRows; i++) {
		Row row = sheet.getRow(rownum);
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		// for (int j = 0; j < physicalNumberOfCells; j++) {
		Cell cell = row.getCell(columnnum);
		// System.out.println(cell);
		CellType Type = cell.getCellType();
		String cellValue = null;
		if (Type.equals(CellType.STRING)) {
			cellValue = cell.getStringCellValue();
		} else if (Type.equals(CellType.NUMERIC) || Type.equals(CellType.FORMULA)) {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			cellValue = String.valueOf(l);
		}
		// System.out.println(cellValue);
		return cellValue;
	}

	public static void updateValues(int rownum, int columnnum, String value) throws Throwable {
		File f = new File(
				"C:\\Users\\cbzsr\\OneDrive\\Desktop\\eclipse\\jdk\\mavenproject\\ExcelWorkBook\\worked1.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("Sheet1");

		Row row = sheet.getRow(rownum);
		if (row == null) {
			System.out.println("Row created");
			row = sheet.createRow(rownum);
		}
		Cell cell = row.getCell(columnnum);
		if (cell == null) {
			System.out.println("Cell created");

			cell = row.createCell(columnnum);
		}
		cell.setCellValue(value);

		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
		wb.close();
		System.out.println("Completed");

	}
	
	

}
