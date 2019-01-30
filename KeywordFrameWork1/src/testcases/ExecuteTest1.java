package testcases;

import java.util.Properties;

import operation.readobject;
import operation.UIoperation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import excelexportandfileio.Readexcelfile;


public class ExecuteTest1 {

	@Test
    public void testLogin() throws Exception {
        // TODO Auto-generated method stub
System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alok\\Downloads\\Compressed\\geckodriver-v0.20.1-win64\\geckodriver.exe");
WebDriver webdriver = new FirefoxDriver();
Readexcelfile file = new Readexcelfile();
readobject object = new readobject();
Properties allObjects = object.getObjectRepository();
UIoperation operation = new UIoperation(webdriver);
//Read keyword sheet
Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\src\\DataEngine\\","TestCase.xlsx" , "KeywordFramework");
//Find number of rows in excel file
    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    System.out.println("Total number of rows:" +rowCount);
    
    //Create a loop over all the rows of excel file to read it
    
    for (int i = 1; i < rowCount+1; i++) {
        //Loop over all the rows
        Row row = guru99Sheet.getRow(i);
        
        
        
        //Check whether the first cell of a row is blank, if it is not blank, That means it is the new testcase name
        if(row.getCell(0) == null || row.getCell(0).toString().length()==0){
        	
        
        //Print testcase detail on console
            System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
            row.getCell(3).toString()+"----"+ row.getCell(4).toString());
            
        //Call perform function to perform operation on UI
            operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
                row.getCell(3).toString(), row.getCell(4).toString());
     }
        else{
            //Print the new testcase name when it started
                System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
            }
        }
    
    webdriver.quit();
    }
}