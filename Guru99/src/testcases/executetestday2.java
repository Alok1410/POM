package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class executetestday2 {
	
	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		WebElement as= webdriver.findElementByXPath("//a[@href='http://live.guru99.com/index.php/mobile.html']");
		as.click();
		
		WebElement price=webdriver.findElementByXPath("//div[@class='price-box']//span[@id='product-price-1']//span[text()]");
		
		String price1 = price.getText();
		System.out.println(price1);
		
		
		WebElement a= webdriver.findElementByXPath("//a[@title='Xperia']");
		a.click();
		
WebElement price2=webdriver.findElementByXPath("//div[@class='price-box']//span[@id='product-price-1']//span[text()]");
		
		String price3 = price2.getText();
		System.out.println(price3);
		
		Assert.assertEquals(price1, price3);
		
		webdriver.close();
		

}

	
}
