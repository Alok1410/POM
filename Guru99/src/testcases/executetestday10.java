package testcases;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class executetestday10 {

	@Test
    public void testLogin() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/alok/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		ChromeDriver webdriver = new ChromeDriver();
		webdriver.get("http://live.guru99.com/index.php/backendlogin");
		
		webdriver.manage().window().maximize();
		
		/* login using previous credentials*/
		
		
		webdriver.findElementByXPath("//input[@name='login[username]']").sendKeys("user01");
		
		webdriver.findElementByXPath("//input[@type='password']").sendKeys("guru99com");
		
		webdriver.findElementByXPath("//input[@title='Login']").click();

		/*---------------------------------------------*/
		
		webdriver.findElementByXPath("//a[@title='close']").click();
		
		Actions act = new Actions(webdriver);
		
		Action move=act.moveToElement(webdriver.findElementByXPath("//span[text()='Sales']")).build();
		
		move.perform();
		
		webdriver.findElementByXPath("//span[text()='Orders']").click();
		
		webdriver.findElementByXPath("//span[text()='Export']").click();
		
		
		
		
		
		
		
		
		
	
	
	}	
}
