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

public class test1
{
	static WebDriver driver;
	public void testMethod(String arrayExcelData) throws InterruptedException

	{
		//	System.out.println(arrayExcelData);
		WebElement searchText = driver.findElement(By.id("email"));
		searchText.sendKeys(arrayExcelData);
		//WebElement searchText2 = driver.findElement(By.id("email"));
		//searchText2.sendKeys(arrayExcelData);

	}

	public static void main(String[] args) throws IOException, InterruptedException
	{

		String driverPath = "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();

		driver.get("http://rhlah.demoyourprojects.com/public/control-panel");
		String[][] arrayExcelData = null;
		FileInputStream fs = new FileInputStream("C:\\Users\\Administrator\\workspace\\newtest\\test(2).xls");
		@SuppressWarnings("resource")
		Workbook wb = new HSSFWorkbook(fs);

		Sheet sh = wb.getSheet("Sheet1");

		int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println(totalNoOfCols); //3   ( will return total physical columns but indexing starts from 0 always)
		int totalNoOfRows = sh.getLastRowNum();
		System.out.println(totalNoOfRows); //11

		arrayExcelData = new String[totalNoOfRows + 1][totalNoOfCols];

		for (int i = 0; i < (totalNoOfRows + 1); i++)
		{
			System.out.println("Current iteration number " + i);
			for (int j = 0; j < (totalNoOfCols - 1); j++)
			{
				arrayExcelData[i][j] = sh.getRow(i).getCell(j).getStringCellValue();

				//System.out.println(arrayExcelData[i][j]);

				if (j == 1)
				{
					test1 ab = new test1();
					ab.testMethod1(arrayExcelData[i][j]);
				}
				else
				{
					test1 a = new test1();
					a.testMethod(arrayExcelData[i][j]);
				}

			}

		}

	}

	private void testMethod1(String arrayExcelData) throws InterruptedException
	{
		WebElement searchText1 = driver.findElement(By.id("password"));
		searchText1.sendKeys(arrayExcelData);
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[2]/input")).click();

	}

}
