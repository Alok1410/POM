package testcases;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class executetestday1 {
	
	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		WebElement ab =webdriver.findElementByXPath("//div[@class='page-title']//h2[text()]");
		String title =ab.getText();
		System.out.println(title);
		Assert.assertEquals("THIS IS DEMO SITE FOR   ", title);
		
		WebElement as= webdriver.findElementByXPath("//a[@href='http://live.guru99.com/index.php/mobile.html']");
		as.click();
		
		WebElement aw= webdriver.findElementByXPath("//div[@class='page-title category-title']//h1");
		String title1=aw.getText();
		Assert.assertEquals(title1, "MOBILE");
		
		 Select abc=new Select(webdriver.findElementByXPath("//select[@title='Sort By']"));
		 abc.selectByIndex(1);
		 
		 
		// this will take a screen shot of the manager's page after a successful login
		  
			File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
			String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + ".png");
			FileUtils.copyFile(scrFile, new File(png));
		 Thread.sleep(2000);
		webdriver.close();
		
	

}
	
}
