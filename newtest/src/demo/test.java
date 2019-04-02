package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class test
{
	String[][] readexcel(String filename, String sheetname) throws IOException
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

	public static void main(String[] args) throws IOException
	{
		test a = new test();
		a.readexcel("C:\\Users\\Administrator\\workspace\\newtest\\test(2).xls", "Sheet1");
	}

}
