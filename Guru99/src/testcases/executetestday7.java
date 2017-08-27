package testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class executetestday7 {
	
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
		
		/*--------------------------------------------------*/
		Thread.sleep(2000);
		
		//webdriver.findElementByXPath("//li/a[@href='http://live.guru99.com/index.php/sales/order/history/']").click();
		
		
		webdriver.findElementByXPath("(//table[@class='data-table orders']//td[@class='number'])[1]").getText();
		
		String e_orderno = "100004881"; String e_status="Pending";
		
		String a_orderno= webdriver.findElementByXPath("//tr[@class='first odd']/td[@class='number']").getText();
		
		
		String a_status= webdriver.findElementByXPath("//tr[@class='first odd']/td[@class='status']").getText();
		
		Assert.assertEquals(e_orderno, a_orderno);
		Assert.assertEquals(e_status, a_status);
		
		System.out.println("Order No.= " + a_orderno +   " Status= " + a_status);
		
		
		
		
		webdriver.findElementByXPath("(//span[@class='nobr']/a)[1]").click();
		
		
		webdriver.findElementByXPath("//a[@class='link-print']").click();
		
		
		/*now switch to new pop up window*/
		
		for (String handle : webdriver.getWindowHandles()) {
			webdriver.switchTo().window(handle);
			}
		
		
		
		
		Thread.sleep(9000);
		
		
		/*  print page not working use auto it*/
		
		// open print dropdown
        WebDriverWait wait = new WebDriverWait(webdriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("button[@class='print default']"))).click();
		
		
		//webdriver.findElementByXPath("button[@class='destination-settings-change-button' and text()='Change…']").click();
		
		Thread.sleep(5000);
		
		//webdriver.findElementByXPath("//span[@class='destination-list-item-name' and @title='Save as PDF']").click();
		
		
		Thread.sleep(4000);
		
		webdriver.findElementByXPath("//button[@class='print default']").click();
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		
		
		
	}
}
