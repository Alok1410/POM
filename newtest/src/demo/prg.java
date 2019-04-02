package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class prg
{
	WebDriver driver;
	String driverPath = "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe";

	@BeforeTest
	public void setup()
	{

		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get("https://money.rediff.com/gainers/bse");

		List<WebElement> col = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));

		System.out.println(col.size());
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println(row.size());

		WebElement ele = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[2]/td[3]"));
		System.out.println(ele.getText());

		List<WebElement> ee2 = new ArrayList<WebElement>();

		ee2.add(driver.findElement(By.xpath("(//a[@href])[1]")));
		ee2.add(driver.findElement(By.xpath("(//a[@href])[5]")));
		ee2.add(driver.findElement(By.xpath("(//a[@href])[3]")));

		System.out.println(ee2.get(0).getText());
		System.out.println(ee2.get(1).getText());
		System.out.println(ee2.get(2).getText());

		ee2.get(2).click();

		Set<String> ee1 = new HashSet<String>();
		ee1.add(driver.findElement(By.xpath("(//a[@href])[1]")).getText());
		ee1.add(driver.findElement(By.xpath("(//a[@href])[2]")).getText());
		ee1.add(driver.findElement(By.xpath("(//a[@href])[3]")).getText());

		System.out.println(ee1);

		Set<WebElement> ee3 = new HashSet<WebElement>();
		ee3.add(driver.findElement(By.xpath("(//a[@href])[1]")));
		ee3.add(driver.findElement(By.xpath("(//a[@href])[1]")));
		ee3.add(driver.findElement(By.xpath("(//a[@href])[3]")));

		System.out.println(ee3.toString());

		List<WebElement> ee = driver.findElements(By.xpath("(//a[@href])"));
		System.out.println(ee.size());

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		for (int i = 1; i < ee.size(); i++)
		{

			hmap.put(i, ee.get(i).getAttribute("href"));

			if (i == 789)
			{
				System.out.println(hmap.get(789).toString());
			}

			//System.out.println(hmap.keySet());

			/* if (i == 3) { System.out.println(hmap.get(3).toString()); }
			 * //hmap.put(2, ee.get(i).getAttribute("href"));
			 *
			 * System.out.println(hmap.get(i).toString()); */

		}
		System.out.println(hmap.size());
		//System.out.println(hmap.values());
		//	hmap.get(key)
	}

}
