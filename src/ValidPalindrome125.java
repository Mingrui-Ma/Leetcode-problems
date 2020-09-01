import java.util.*;

public class ValidPalindrome125 {

	static boolean isAlphaNumeric(char c)	{
		return (c>=48 & c<=57) || (c>=65 & c<=90) || (c>=97 & c<=122);
	}
	
	static boolean isPalin(String s)	{
		char[] sArr = s.toCharArray();
		ArrayList<Character> s2 = new ArrayList<>();
		for(char ch:sArr)
			if(isAlphaNumeric(ch))
				s2.add(ch);
		int size = s2.size();
		
		for(int i=0;i<size;i++)	{
			if(s2.get(i)==s2.get(size-1-i))
				//System.out.println(ch2 + " & " + s2Arr[i]);
				continue;
			else	{
				//System.out.println(ch2 + " & " + s2Arr[i]);
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "a man, a plan. alpa; nam\na";
		System.out.println(isPalin(s));

	}

}
