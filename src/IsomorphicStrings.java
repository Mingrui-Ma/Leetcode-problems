import java.util.*;
//205

public class IsomorphicStrings {

	boolean isIsomorphic(String str1, String str2)	{
		LinkedHashMap<Character,Character> lhm = new LinkedHashMap<>();
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1!=len2)
			return false;
		for(int i=0;i<len1;i++)	{
			lhm.put(str1.charAt(i), str2.charAt(i));
		}
		
		String RecreatedStr2 = "";
		for(int i=0;i<len1;i++)	{
			RecreatedStr2 += lhm.get(str1.charAt(i));
		}
		
		System.out.println(RecreatedStr2);
		if(RecreatedStr2.equals(str2))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic("foo", "bar"));
		
	}
}
