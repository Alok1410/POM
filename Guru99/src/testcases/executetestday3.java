package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class executetestday3 {

	

	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		WebElement as= webdriver.findElementByXPath("//a[@href='http://live.guru99.com/index.php/mobile.html']");
		as.click();
		
		WebElement button= webdriver.findElementByXPath("//span[@id='product-price-1']//following::button[@type='button']");
		
		button.click();
		
        webdriver.findElementByXPath("//input[@title='Qty' and @type='text']").clear();
        
        webdriver.findElementByXPath("//input[@title='Qty' and @type='text']").sendKeys(String.valueOf(1000));
        
        webdriver.findElementByXPath("//button[@title='Update'  and @type='submit']").click();

        String error= webdriver.findElementByXPath("//p[@class='item-msg error']").getText();
        
        String exp_error="* The maximum quantity allowed for purchase is 500.";
        
        Assert.assertEquals(exp_error, error);
        
        webdriver.findElementByXPath("//span[text()='Empty Cart']").click();
        
        String empty_cart=webdriver.findElementByXPath("//div[@class='page-title']//h1").getText();
        String expected= "SHOPPING CART IS EMPTY";
        
        Assert.assertEquals(expected, empty_cart);
        
        
        webdriver.close();
        
        
        		
		
	}		
}
