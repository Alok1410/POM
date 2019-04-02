package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class xlsxdata
{
	WebDriver driver;
	String driverPath = "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe";

	@BeforeTest
	public void setup()
	{

		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();

		driver.get("http://rhlah.demoyourprojects.com/public/control-panel");
	}

	@Test(dataProvider = "SearchProvider")
	public void testMethod(String username, String password, String value) throws InterruptedException
	{
		{
			WebElement searchText = driver.findElement(By.id("email"));
			searchText.sendKeys(username);
			WebElement searchText1 = driver.findElement(By.id("password"));
			searchText1.sendKeys(password);
			WebElement searchText2 = driver.findElement(By.id("email"));
			searchText2.sendKeys(value);
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[2]/input")).click();

		}
	}

	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataprovider() throws IOException
	{
		Object[][] arrayObject = getExcelData("C:\\Users\\Administrator\\workspace\\newtest\\test(2).xls", "Sheet1"); // here u can use .xls and .xlsx both accordingly by just changing the Workbook class-> hssf/xssf

		return arrayObject;
		//return new Object[][]{{"Guru99", "India"}, {"Krishna", "UK"}, {"Bhupesh", "USA"}};

	}

	public String[][] getExcelData(String filename, String sheetname) throws IOException

	{
		String[][] arrayExcelData = null;
		FileInputStream fs = new FileInputStream(filename);
		@SuppressWarnings("resource")
		Workbook wb = new HSSFWorkbook(fs);

		Sheet sh = wb.getSheet(sheetname);

		int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println(totalNoOfCols); //3   ( will return total physical columns but indexing starts from 0 always)
		int totalNoOfRows = sh.getLastRowNum();
		System.out.println(totalNoOfRows); //11

		arrayExcelData = new String[totalNoOfRows + 1][totalNoOfCols];

		for (int i = 0; i < (totalNoOfRows + 1); i++)
		{
			System.out.println(i);
			for (int j = 0; j < totalNoOfCols; j++)
			{
				arrayExcelData[i][j] = sh.getRow(i).getCell(j).getStringCellValue();

				if ((i == 10) && (j == 0))
				{
					System.out.println("Hey Alok ---->  " + arrayExcelData[i][j]);
				}

				System.out.println(arrayExcelData[i][j]);

			}

		}
		return arrayExcelData;

	}
}
