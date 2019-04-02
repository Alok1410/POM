package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class redbusdemo
{

	@Test
	public void testLogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.navigate().to("http://facebook.com");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		/* FirefoxProfile myprofile = new FirefoxProfile();
		 * myprofile.setPreference("dom.webnotifications.enabled", false); WebDriver
		 * d = new FirefoxDriver(myprofile); */
		WebDriver d = new FirefoxDriver();

		d.get("https://www.redbus.in/");
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[@id='signin-block']")).click();
		d.findElement(By.xpath("//*[@id='signInLink']")).click();

		int size = d.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		if (size == 5)
		{
			d.switchTo().frame(4);
		}
		if (size == 6)
		{
			d.switchTo().frame(5);
		}
		else if (size == 7)
		{
			d.switchTo().frame(6);
		}
		else if (size == 8)
		{
			d.switchTo().frame(7);
		}
		//Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) d;
		Thread.sleep(9000);
		//Perform Click on LOGIN button using JavascriptExecutor
		js.executeScript("arguments[0].click();", d.findElement(By.xpath("(//a[@class='signin-screen'])[1]")));

		d.findElement(By.xpath(".//*[@id='email-mobile']")).sendKeys("alok@yopmail.com");
		d.findElement(By.xpath(".//*[@id='password']")).sendKeys("a@123456");
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='doSignin']")).click();
		d.switchTo().defaultContent();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//i[@class='icon-close'])[2]")).click();

		// code for finding out frame index number under which signin is to be clicked
		/* for (int i = 0; i <= size; i++) { d.switchTo().frame(i); int total =
		 * d.findElements(By.
		 * xpath("(.//*[@id='signInView']//div[@class='W260 M24A']//a)[2]")).size();
		 * System.out.println(total); d.switchTo().defaultContent(); } */

		d.findElement(By.xpath(".//*[@id='src']")).sendKeys("Chennai");
		Thread.sleep(1000);
		//	d.findElement(By.xpath("//li[@data-id='202294']")).click();
		d.findElement(By.xpath(".//*[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(1000);
		d.findElement(By.xpath("//li[@data-id='122']")).click();
		Thread.sleep(1000);

		js.executeScript("arguments[0].click();", d.findElement(By.xpath(".//*[@id='onward_cal']")));

		d.findElement(By.xpath("(//td[@class='next']/button)[2]")).click();
		d.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[6]/td[6]")).click();
		System.out.println("Alok is cool");

		//d.findElement(By.xpath("html/body/div[1]/div[1]")).click();

		Thread.sleep(2000);
		WebElement s = d.findElement(By.xpath(".//*[@id='search']/div/div[4]/span"));
		js.executeScript("arguments[0].click();", s);

		d.findElement(By.xpath("(//td[@class='next']/button)[2]")).click();
		d.findElement(By.xpath(".//*[@id='rb-calendar_return_cal']/table/tbody/tr[7]/td[4]")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//span[@id='togglebtn']")).click();
		d.findElement(By.xpath(".//*[@id='search_btn']")).click();

		Thread.sleep(3000);
		d.findElement(By.xpath("(//div[@class='button view-seats fr'])[1]")).click();
		Thread.sleep(7000);
		Actions clickAt = new Actions(d);

		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='lower']")), 60, 30).click();
		/* clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='lower']")), 90, 30).click();
		 * clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='lower']")), -5, -30).click();
		 * clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='lower']")), 25, 35).click();
		 * clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='lower']")), -50, -20).click(); */
		clickAt.build().perform();
		WebElement element = d.findElement(By.xpath("//canvas[@data-type='lower']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);

		d.findElement(By.xpath("//span[@title='Bommasandra']")).click();

		d.findElement(By.xpath("//span[@title='Poonamalle Bypass']")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//button[@class='button continue inactive']")).click();
		Thread.sleep(3000);

		d.findElement(By.xpath("//div[@class='button view-seats fr']")).click();
		Thread.sleep(5000);

		clickAt.moveToElement(d.findElement(By.xpath("//canvas[@data-type='upper']")), 25, 35).click();
		/* clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='upper']")), 60, 30).click();
		 * clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='upper']")), 50, 30).click();
		 * clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='upper']")), 5, 30).click();
		 * //clickAt.moveToElement(d.findElement(By.xpath(
		 * "//canvas[@data-type='upper']")), -50, -20).click(); */ clickAt.build().perform();

		d.findElement(By.xpath("//span[@title='T nagar']")).click();

		d.findElement(By.xpath("//span[@title='madiwala']")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//button[@class='button continue inactive']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//*[@id='seatno-04']")).sendKeys("John SNow");
		d.findElement(By.xpath(".//*[@id='22_0']")).click();
		d.findElement(By.xpath(".//*[@id='seatno-01']")).sendKeys("28");
		d.findElement(By.xpath("//input[@value='Proceed to pay']")).click();
		Thread.sleep(5000);

		List<WebElement> alllinks = d.findElements(By.tagName("a"));
		/* for (WebElement s1 : alllinks) { //WebElement s2 = s1;
		 * System.out.println(s1.getAttribute("href"));
		 *
		 * s1.click(); Thread.sleep(2000); d.navigate().back();
		 *
		 * } */
		for (int i = 0; i < alllinks.size(); i++)
		{
			Thread.sleep(4000);
			System.out.println(alllinks.get(i).getText());

			/* WebDriverWait w = new WebDriverWait(d, 5000);
			 * w.until(ExpectedConditions.elementToBeClickable(alllinks.get(i)));
			 * js.executeScript("arguments[0].click();", alllinks.get(i));
			 * Thread.sleep(6000); d.navigate().back(); Thread.sleep(6000); */
		}

	}
}
