package demo;

public class countwords
{
	public static void main(String[] args)
	{
		String line = "Hi this is hacker pro 212.3";

		//Create a string array
		String[] newline = line.split("\\s+");
		//	String[] newline1 = line.split("\\.");

		//total words in the string
		int len = newline.length;
		System.out.println("Total words in the string-->" + len);
		for (int i = 0; i < len; i++)
		{
			int d = newline[i].length();

			System.out.println("Word-->" + newline[i] + "             Number of characters->" + d);
		}
	}
}
