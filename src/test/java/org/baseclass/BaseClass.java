package org.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class BaseClass {
	
	public static WebDriver driver;
	public static Actions action;
	public static Robot robot;
	public static TakesScreenshot scrnShot;
//chromeDriver
	public static void chromeBrowser() {
		 driver = new ChromeDriver();

	}
//fireFoxDriver
	public static void fireFoxBrowser() {
		driver = new FirefoxDriver();

	}
//edgeDriver
	public static void edgeBrowser() {
		driver = new EdgeDriver();

	}
//newTab
	public static void newTab() {
		driver.switchTo().newWindow(WindowType.TAB);

	}
//implicityWait
	public static void waitSomeTime() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
//get()
	public static void launchUrl(String url) {
		driver.get(url);

	}
//sendKeys()
	public static void passValue(WebElement element,String value) {
		element.sendKeys(value);

	}
//getText()
	public static void printText(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}
//click()
	public static void clickItem(WebElement refname) {
		refname.click();

	}
//getSize()
	public static void elementSize(WebElement element) {
		Dimension size = element.getSize();
		System.out.println(size);
		
	}
//getAttribute()
	public static void getValue(WebElement element) {
		String value = element.getAttribute("value");
		System.out.println(value);
		
	}
//getTitle()
	public static void webPageTitle() {
		String title = driver.getTitle();
		System.out.println("webpage title : "+title);
		
	}
//getCurrentUrl()
	public static void currentWebPageUrl() {
		String crnttUrl = driver.getCurrentUrl();
		System.out.println("current WebPage Url :"+crnttUrl);

	}
//maximize()
	public static void maximizePage() {
		driver.manage().window().maximize();

	}
//minimize()
	public static void minimizePage() {
		driver.manage().window().minimize();

	}
//close()
	public static void closeCurrentPage() {
		driver.close();

	}
//quit()
	public static void closeBrowser() {
		driver.quit();

	}
//moveToElement()
	public static void tuchWebElement(WebElement elementName) {
		action.moveToElement(elementName);
	
	}
//action.click()
	public static void clickAction(WebElement elementName) {
		action.click(elementName);
	
	}
//action.contextClick()
	public static void rightClickAction(WebElement elementName) {
		action.contextClick(elementName);

	}
//action.dragAndDrop()
	public static void dragAndDropAction(WebElement from,WebElement to) {
		action.dragAndDrop(from, to).perform();
		
	}
//action.doubleClick()
	private void doubleClickAction(WebElement element) {
		action.doubleClick(element).perform();

	}
//switchToframe
	public static void switchFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}
//swichToAlert
	public static void switchAlert() {
		Alert alert = driver.switchTo().alert();
	}

//TakesScreenShot
	public static void screenShot(String path) throws IOException {
		scrnShot = (TakesScreenshot)driver;
		File file1 = scrnShot.getScreenshotAs(OutputType.FILE);
		File file2 = new File(path);
		FileUtils.copyFile(file1, file2);
	}
	public static void robotPressKey(int keycode) throws AWTException {
		robot = new Robot();
		robot.keyPress(keycode);
		
	}
	public static void robotReleaseKey(int keycode) {
		robot.keyRelease(keycode);
		
	}
	public static String getFromExcel(String pathname, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(pathname);
		FileInputStream readFile = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(readFile);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int type = cell.getCellType();
		String value ="";
		if (type == 1) {
			 value = cell.getStringCellValue();
//			System.out.println(value);
		}
		else if (DateUtil.isCellInternalDateFormatted(cell)) {
			Date dateValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			 value = dateFormat.format(dateValue);
//			 System.out.println(value);
		}
		else {
			double numValue = cell.getNumericCellValue();
			long longValue = (long)numValue;
			 value = String.valueOf(longValue);
//			 System.out.println(value);	
		}
		return value;
	}
	public static void readAllFromExcel(String pathname, String sheetName) throws IOException {
		File file = new File(pathname);
		FileInputStream readFile = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(readFile);
		Sheet sheet = book.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			int type = cell.getCellType();
			String value ="";
			if (type == 1) {
				 value = cell.getStringCellValue();
				System.out.println(value);
			}
			else if (DateUtil.isCellInternalDateFormatted(cell)) {
				Date dateValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
				 value = dateFormat.format(dateValue);
				 System.out.println(value);
			}
			else {
				double numValue = cell.getNumericCellValue();
				long longValue = (long)numValue;
				 value = String.valueOf(longValue);
				 System.out.println(value);	
			}		
			
		}
			
		}
		
		
		
	}

}

