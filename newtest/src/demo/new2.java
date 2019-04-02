package demo;

public class new2 extends new123
{

	@Override
	void test(String bbb)
	{
		System.out.println("HI alok");
		System.out.println(bbb);
		//System.out.println(v);
	}

	void est()
	{
		System.out.println("oooo");
	}

	public static void main(String[] args)
	{
		new123 s = new new123();
		s.test("normal");
		new123 d = new new2();
		d.test("over riding");

	}

}
