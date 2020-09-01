import java.util.*;
//516
public class PalindromicSequence {
	static boolean isPS(String s)	{
		int len = s.length();
		iterate: for(int i=0;i<len;i++)	{
			if(s.charAt(i)==s.charAt(len-1-i))
				continue iterate;
			else
				return false;
		}
		return true;
	}
	
	static boolean isSubPS(String s, int start, int end)	{
		String subStr = s.substring(start, end);
		//System.out.println(subStr);
		return isPS(subStr);
	}
	
	static int LongestPS(String s)	{
		LinkedList<Integer> PSlen = new LinkedList<>();
		int len = s.length();
		for(int i=0;i<len;i++)	{
			for(int j=i;j<=len;j++)	{
				if(isSubPS(s, i, j))
					PSlen.add(j-i);
			}
		}
		return Collections.max(PSlen);
	}
	
	public static void main(String[] args) {
		

		System.out.println(LongestPS("abadrbreerb"));
		//System.out.println(isPS(str2));
	}

}
