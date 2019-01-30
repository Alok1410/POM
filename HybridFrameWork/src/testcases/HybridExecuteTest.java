package testcases;
import java.io.IOException;
import java.util.Properties;

import operation.readobject;
import operation.UIoperation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelexportandfileio.Readexcelfile;

public class HybridExecuteTest {
    WebDriver webdriver = null;
    
    int num=0;
@Test(dataProvider="hybridData")
    public void testLogin(String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception {
        
      
	if(testcaseName!=null&&testcaseName.length()==3){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alok\\Downloads\\Compressed\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	    webdriver=new FirefoxDriver();
	    }
	
readobject object = new readobject();
Properties allObjects = object.getObjectRepository();
UIoperation operation = new UIoperation(webdriver);

    //Call perform function to perform operation on UI

            operation.perform(allObjects, keyword, objectName,
                objectType, value);
       //for closing browser on row 5
            num++;
            System.out.println(num);
            if(num==5){webdriver.close();}

    }
@DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException{
    Object[][] object = null;
    
//here created object of class file= Readexcelfile.java    to call its methods.    
    Readexcelfile file = new Readexcelfile();
    
    
//Read keyword sheet
    
    
    
// here calling method of Readexcelfile.java--->  public Sheet readExcel(String filePath,String fileName,String sheetName)
    
    
Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\src\\DataEngine\\","TestCase.xlsx" , "KeywordFramework");



//Find number of rows in excel file
    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    System.out.println(rowCount);
    object = new Object[rowCount][5];
    for (int i = 0; i < rowCount; i++) {
        //Loop over all the rows
        Row row = guru99Sheet.getRow(i+1);
        //Create a loop to print cell values in a row
        for (int j = 0; j < row.getLastCellNum(); j++) {
            //Print excel data in console
        	object[i][j] = row.getCell(j).toString();
        	System.out.println(object[i][j]);
            
        }
    }
    System.out.println("");
     return object;    
    }
}