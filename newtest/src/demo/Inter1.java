package demo;

public interface Inter1 extends Inter, Inter2
{
	default void display1()
	{
		System.out.println("default method interface");
	}

	static int demo()
	{
		int s = 10;
		System.out.println(s);
		return s;
	}

}
