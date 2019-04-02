package demo;

public class reversestring
{
	public static void main(String args[])
	{
		String sbc = "Alok Sharma";

		int len = sbc.length();

		String rev = "";

		for (int i = len - 1; i >= 0; i--)
		{
			rev = rev + sbc.charAt(i);

		}
		System.out.println(rev);
	}
}
