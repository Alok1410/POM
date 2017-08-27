package testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class executetestday6 {
	
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
		
		
		/*------------*/
		
		Thread.sleep(2000);
		
		webdriver.findElementByXPath("(//a[@href='http://live.guru99.com/index.php/wishlist/'])[2]").click();
		
		
		Thread.sleep(2000);
		webdriver.findElementByXPath("//button[@title='Add to Cart']").click();
		
		/*---------------*/
        Select country= new Select(webdriver.findElementByXPath("//select[@title='Country' and @id='country']"));
		
		country.selectByValue("US");
		
        Select state= new Select(webdriver.findElementByXPath("//select[@title='State/Province' and @id='region_id']"));
		
		state.selectByValue("43");
		
		webdriver.findElementByXPath("//input[@type='text' and @id='postcode']").sendKeys("542896");
		
		
		webdriver.findElementByXPath("//button[@title='Estimate']/span").click();
		
		
		
		String afixedprice= webdriver.findElementByXPath("//label//span[@class='price' and text()='$5.00']").getText();
		
		String efixedprice="$5.00";
		
		Assert.assertEquals(efixedprice, afixedprice);
		
		System.out.println("Flat Rate of Shipping of"  + afixedprice+   "is generated.");
		
		Thread.sleep(2000);
		
		webdriver.findElementByXPath("//input[@name='estimate_method' and @type='radio']").click();
		
		
		/* Grand total before adding shipping price*/
		
		String  total1= webdriver.findElementByXPath("(//span[@class='price'])[7]").getText();
		System.out.println(total1);
		
		
		Thread.sleep(2000);
		
		/* Grand total after adding shipping price*/
		webdriver.findElementByXPath("//button[@title='Update Total']").click();
		
		
		
		
		
		Integer eGrandtotal= 615 + 5;
		System.out.println("$"+eGrandtotal+".00");
		
		
		
		String aGrandtotal= webdriver.findElementByXPath("(//span[@class='price'])[6]").getText();
		
		System.out.println(aGrandtotal);
		
		
		Thread.sleep(2000);
		
		
		
		
		webdriver.findElementByXPath("(//button[@title='Proceed to Checkout'])[2]").click();
		
		
		
		/* enter shipping address page */
		// Check if Select element is present. If not present, it is the first time a customer has logged back in, to process what is in his/her wishlist
	    
		try {
	    	Select bAddr = new Select(webdriver.findElement(By.name("billing_address_id")));
	    	int bAddrSize = bAddr.getOptions().size();
	    	bAddr.selectByIndex(bAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("No dropdown element present");
		    }
		
		webdriver.findElementByXPath("//input[@title='Street Address' and @id='billing:street1']").clear();
		webdriver.findElementByXPath("//input[@title='Street Address' and @id='billing:street1']").sendKeys("ABC");
		
		webdriver.findElementByXPath("//input[@title='City' and @id='billing:city']").clear();
		webdriver.findElementByXPath("//input[@title='City' and @id='billing:city']").sendKeys("New York");
		
		
		
		Select state1= new Select(webdriver.findElementByXPath("//select[@title='State/Province' and @id='billing:region_id']"));
		
		state1.selectByValue("43");
		
		
		webdriver.findElementByXPath("//input[@title='Zip' and @id='billing:postcode']").clear();
		webdriver.findElementByXPath("//input[@title='Zip' and @id='billing:postcode']").sendKeys("542896");
		
		
		Select country1= new Select(webdriver.findElementByXPath("//select[@title='Country' and @id='billing:country_id']"));
		
		country1.selectByValue("US");
		
		webdriver.findElementByXPath("//input[@type='tel' and @id='billing:telephone']").clear();
		webdriver.findElementByXPath("//input[@type='tel' and @id='billing:telephone']").sendKeys("12345678");
		
		/*------------------------*/
		
		Thread.sleep(1000);
		webdriver.findElementByXPath("//button[@onclick='billing.save()']").click();
		
		Thread.sleep(3000);
		
		webdriver.findElementByXPath("//button[@onclick='shippingMethod.save()']").click();
		Thread.sleep(3000);
		
		webdriver.findElementByXPath("//label[@for='p_method_checkmo']").click();
		Thread.sleep(2000);
		
		webdriver.findElementByXPath("//button[@onclick='payment.save()']").click();
		Thread.sleep(2000);
		
		webdriver.findElementByXPath("//button[@title='Place Order']").click();
		
		Thread.sleep(3000);
		
		
		String orderdone=webdriver.findElementByXPath("//h2[@class='sub-title']").getText();
		System.out.println(orderdone);
		
		Thread.sleep(3000);
		
		
		
		// 16. Verify Oder is generated. Note the order number 
	    String orderNum = webdriver.findElement(By.xpath("//p[text()='Your order # is: ']/a")).getText();	
	    System.out.println("*** Your order number for your record = " + orderNum);
		
		webdriver.close();
		
		
		
	}

	
}
