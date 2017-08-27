package testcases;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class executetestday8 {
	
	

	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		webdriver.manage().window().maximize();
		
		
		
		webdriver.findElementByXPath("//span[@class='label'][text()='Account']").click();
		
		webdriver.findElementByXPath("//div[@id='header-account']//li[@class='first']//a[@title='My Account']").click();
		
		/* login using previous credentials*/
		
		
		webdriver.findElementByXPath("//input[@name='login[username]']").sendKeys("alok69@gmail.com");
		
		webdriver.findElementByXPath("//input[@type='password']").sendKeys("Terminator2");
		
		webdriver.findElementByXPath("//button[@title='Login']").click();

		/*---------------------------------------------*/
		
		
		webdriver.findElementByXPath("(//td[@class='a-center view last']//a[text()='Reorder'])[1]").click();
		
		webdriver.findElementByXPath("//input[@title='Qty' and @type='text']").clear();
		webdriver.findElementByXPath("//input[@title='Qty' and @type='text']").sendKeys("10");
		
		
		webdriver.findElementByXPath("//button[@type='submit' and @title='Update']").click();
		
		Thread.sleep(3000);
	//String atotal =	webdriver.findElementByXPath("(//span[@class='price'])[6]").getText();
		
	Thread.sleep(3000);
	String ac_grandtotal=webdriver.findElementByXPath("(//span[@class='price'])[6]").getText();
	String ex_grandtotal="$6,150.00";
	
	Assert.assertEquals(ex_grandtotal, ac_grandtotal);
	
	
	webdriver.findElementByXPath("(//button[@title='Proceed to Checkout'])[1]").click();
	
	webdriver.findElementByXPath("//button[@onclick='billing.save()']").click();
	
	Thread.sleep(3000);
	webdriver.findElementByXPath("//button[@onclick='shippingMethod.save()']").click();
	
	Thread.sleep(3000);
	webdriver.findElementByXPath("//label[@for='p_method_checkmo']").click();
	Thread.sleep(3000);
	webdriver.findElementByXPath("//button[@onclick='payment.save()']").click();
	Thread.sleep(3000);
	webdriver.findElementByXPath("//button[@title='Place Order']").click();
	
	Thread.sleep(5000);
	String order =webdriver.findElementByXPath("//p[text()='Your order # is: ']/a").getText();
	Thread.sleep(3000);
	System.out.println("Order No."+order);
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
}
