package demo;

// A class that implements interface.
class Te implements Inter, Inter1
{
	// Implementing the capabilities of
	// interface.

	@Override
	public void display()
	{
		System.out.println("Geek");
	}

	// Driver Code
	public static void main(String[] args)
	{
		Te t = new Te();
		t.display();
		t.alok();
		t.display1();
		Inter1.demo();
		Inter.demo();

	}

	@Override
	public void alok()
	{
		System.out.println("Hi Its Alok");
	}

	@Override
	public void display1()
	{
		System.out.println("class method interface");
	}

}
