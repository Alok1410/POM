package demo;

public class split
{
	public static void main(String args[])
	{
		String sbc = "Alo.k Sharma IT.SSSS";

		String[] ne = sbc.split("\\.");
		String[] nb = sbc.split("\\s+");

		int len = ne.length;
		int len1 = nb.length;

		for (int i = len1 - 1; i >= 0; i--)
		{

			System.out.println(nb[i]);

		}

		for (int i = len - 1; i >= 0; i--)
		{
			System.out.println(ne[i]);

		}
	}
}
