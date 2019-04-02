package demo;

import java.util.HashMap;
import java.util.Map;

public class characterrepeatcount
{
	public static void charactercount(String abc)
	{
		HashMap<Character, Integer> asd = new HashMap<Character, Integer>();

		char[] as = abc.toCharArray();

		for (char s : as)
		{
			if (asd.containsKey(s))
			{

				asd.put(s, asd.get(s) + 1);

			}
			else
			{
				asd.put(s, 1);
			}
		}

		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : asd.entrySet())
		{
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
	public static void main(String[] args)
	{
		charactercount("asdaaaqqqqertfds");

	}

}
