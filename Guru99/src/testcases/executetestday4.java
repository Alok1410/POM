package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class executetestday4 {
	

	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		WebElement as= webdriver.findElementByXPath("//a[@href='http://live.guru99.com/index.php/mobile.html']");
		as.click();
		
webdriver.findElementByXPath("//span[@id='product-price-1']//following::a[text()='Add to Compare'][1]").click();
		
		
webdriver.findElementByXPath("//span[@id='product-price-1']//following::a[text()='Add to Compare'][2]").click();



/*selected products*/

String mobile1=webdriver.findElementByXPath("//li[@class='item odd']//a[text()='Sony Xperia']").getText();

String mobile2=webdriver.findElementByXPath("//li[@class='item last even']//a[text()='IPhone']").getText();

System.out.println(mobile1);
System.out.println(mobile2);


webdriver.findElementByXPath("//button[@title='Compare']").click();

/*now switch to new pop up window*/

for (String handle : webdriver.getWindowHandles()) {
	webdriver.switchTo().window(handle);
	}

/*now verification*/

String exp1= "COMPARE PRODUCTS";
String act1= webdriver.findElementByXPath("//div[@class='page-title title-buttons']//h1").getText();

String exptmob1=webdriver.findElementByXPath("//h2/a[@title='Sony Xperia']").getText();
String exptmob2=webdriver.findElementByXPath("//h2/a[@title='IPhone']").getText();

Assert.assertEquals(exp1, act1);


Assert.assertEquals(mobile1, exptmob1);

Assert.assertEquals(mobile2, exptmob2);



webdriver.findElementByXPath("//button[@type='button' and @title='Close Window']").click();

for (String handle : webdriver.getWindowHandles()) {
	webdriver.switchTo().window(handle);
	}

webdriver.close();



	
	}
}
