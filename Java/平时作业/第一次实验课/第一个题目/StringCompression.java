import java.util.Scanner;
public class StringCompression {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String str2 = getStr(str);
		String ans = compress(str2);
		int len = ans.length();
		System.out.println(len+","+"\""+ans+"\"");
		s.close();
	}
	public static String getStr(String str)
	{
		String res = new String();
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) != ' ' &&str.charAt(i) != '[' && str.charAt(i) != ']' && str.charAt(i) != '"' && str.charAt(i) != ',')
			{
				res = res + str.charAt(i);
			}
		}
		return res;
	}
	public static String compress(String str)
	{
		String ans =  new String();
		for(int i = 0; i < str.length(); i++)
		{
			int subLen = 0;
			char temp = str.charAt(i);
			int j = 0;
			for(j = i; j < str.length(); j++)
			{
				if(temp == str.charAt(j))
				{
					subLen++;
				}
				else
				{
					break;
				}
			}
			i = j - 1;
			ans += temp;
			String temp2 = String.valueOf(subLen);
			ans += temp2;
		}
		return ans;
	}
	
}
