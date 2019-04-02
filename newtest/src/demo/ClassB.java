package demo;

public class ClassB extends ClassA
{

	void med2()
	{
		System.out.println("ClassB->med");
	}

	void med3()
	{
		System.out.println("ClassB->med1");
	}
	public static void main(String[] args)
	{
		ClassA s = new ClassB();

		s.med();
		s.med1();

	}

}
