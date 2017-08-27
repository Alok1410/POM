package testcases;

import org.junit.Assert;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class executetestday5 {
	
	public String firstName = "aBiY";    // Firstname and Lastname will be placed    
	public String lastName = "BRYO";
	
	
	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/");
		
		webdriver.findElementByXPath("//span[@class='label'][text()='Account']").click();
	
		webdriver.findElementByXPath("//div[@id='header-account']//li[@class='first']//a[@title='My Account']").click();
		
		webdriver.findElementByXPath("//a[@title='Create an Account']").click();
		
		webdriver.findElementByXPath("//input[@id='firstname']").sendKeys(firstName);
		webdriver.findElementByXPath("//input[@id='lastname']").sendKeys(lastName);
		webdriver.findElementByXPath("//input[@type='email']").sendKeys("alok69@gmail.com");
		
		webdriver.findElementByXPath("//input[@type='password']").sendKeys("Terminator2");
		webdriver.findElementByXPath("//input[@title='Confirm Password']").sendKeys("Terminator2");
		
		webdriver.findElementByXPath("//button[@title='Register']").click();
		
		/* verification of registration*/
		String user_actual="Hello, " + firstName + " " + lastName + "!";
		String user_expectd=webdriver.findElementByXPath("//p[@class='hello']").getText();
		
		System.out.println(user_actual);
		System.out.println(user_expectd);
		Assert.assertEquals(user_actual, user_expectd);
		
		webdriver.findElementByXPath("//a[@href='http://live.guru99.com/index.php/tv.html']").click();
		
		webdriver.findElementByXPath("//span[@id='product-price-4']//following::a[contains(@class,'link-wishlist')][1]").click();
		
		webdriver.findElementByXPath("//button[@title='Share Wishlist']").click();
		
		webdriver.findElementByXPath("//textarea[@name='emails']").sendKeys("alok2taluented@gmail.com");
		
		webdriver.findElementByXPath("//textarea[@name='message']").sendKeys("Enjoy Alok");
		
		Thread.sleep(2000);
		webdriver.findElementByXPath("//button[@title='Share Wishlist']").click();
		
		String wish_expected= "Your Wishlist has been shared.";
		String wish_actual=webdriver.findElementByXPath("//span[text()='Your Wishlist has been shared.']").getText();
		
		
		System.out.println(wish_expected);
		System.out.println(wish_actual);
		
		
		Assert.assertEquals(wish_expected, wish_actual);
		
		
		webdriver.close();
		
		
		
	}
	}
