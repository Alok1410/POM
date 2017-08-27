package testcases;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class executetestday9 {
	
	
	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		webdriver.manage().window().maximize();
		
		webdriver.findElementByXPath("//li[@class='level0 nav-1 first']").click();
		
		webdriver.findElementByXPath("(//span[text()='Add to Cart'])[3]").click();
		
		webdriver.findElementByXPath("//input[@name='coupon_code']").sendKeys("GURU50");
		
		
		webdriver.findElementByXPath("//span[text()='Apply']").click();
		
		String a_dis=webdriver.findElementByXPath("(//tr/td[@class='a-right']//span[@class='price'])[3]").getText();
		
		String e_dis="-$25.00";
		
		Assert.assertEquals(e_dis, a_dis);
		
		
		System.out.println("Price is Discounted by:"+ a_dis);
		
	}		
}
