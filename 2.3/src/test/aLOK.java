package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class aLOK
{

	@Test
	public void test()
	{
		String url = "http://api.ytzi.co/t/clk?id=7YUOCBQT82s2=41414141";
		System.out.println(url.substring(url.lastIndexOf("=") - 2));
	}

	@Test
	public void test1()
	{
		Assert.assertTrue(false);
	}
}
