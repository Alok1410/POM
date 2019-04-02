package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class canvas
{

	@SuppressWarnings("deprecation")

	@Test
	public void testLogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.navigate().to("http://yatra.com");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		FirefoxProfile myprofile = new FirefoxProfile();
		myprofile.setPreference("dom.webnotifications.enabled", false);
		WebDriver d = new FirefoxDriver(myprofile);
		JavascriptExecutor js = (JavascriptExecutor) d;
		d.get("https://www.redbus.in/search?fromCityName=Bangalore&fromCityId=122&toCityName=Chennai&toCityId=123&onward=25-Aug-2018&return=27-Sep-2018&opId=0&busType=Any");
		Thread.sleep(5000);
		d.findElement(By.xpath("(//div[@class='button view-seats fr'])[1]")).click();
		Thread.sleep(7000);
		Actions clickAt = new Actions(d);
		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='lower']")), 60, 30).click();
		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='lower']")), 90, 30).click();
		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='lower']")), -5, -30).click();
		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='lower']")), 25, 35).click();
		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='lower']")), -50, -20).click();
		clickAt.build().perform();
		WebElement element = d.findElement(By.xpath("//canvas[@data-type='lower']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		//Thread.sleep(4000);

		d.findElement(By.xpath("//span[@title='Bommasandra']")).click();

		d.findElement(By.xpath("//span[@title='Poonamalle Bypass']")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//button[@class='button continue inactive']")).click();
		Thread.sleep(3000);

		d.findElement(By.xpath("//div[@class='button view-seats fr']")).click();
		Thread.sleep(5000);

		/* WebElement element1 =
		 * d.findElement(By.xpath("//canvas[@data-type='upper']"));
		 * js.executeScript("arguments[0].scrollIntoView(true);", element1); */
		Thread.sleep(3000);

		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='upper']")), 25, 35).click();
		//clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='upper']")), -50, -20).click();
		Thread.sleep(2000);
		//	clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='upper']")), 20, 30).click();
		//clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='upper']")), 1, 1).click();
		//clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='upper']")), -1, 2).click();

		System.out.println("test1 complete");

		clickAt.build().perform();

	}
}