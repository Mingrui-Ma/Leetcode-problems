import java.util.*;

public class RegexMatch10 {
	static boolean isMatch(String s, String p)	{
		//s is the goal. match p with s
		if(s.equals(p))
			return true;
		
		char[] pAr = p.toCharArray(), sAr = s.toCharArray();
		ArrayList<Integer> dotList = new ArrayList<>(), starList = new ArrayList<>();	
		//dotList will contain indices of dots (.)
		//starList will contain indices of asterisks (*)
		int idx = 0;		
		for(char ch:pAr)	{
			if(ch=='.')
				dotList.add(idx);
			if(ch=='*')
				starList.add(idx);
			idx++;
		}
		
		ArrayList<Character> pList = new ArrayList<>();
		pList.ensureCapacity(s.length());
		for(char ch:pAr)
			pList.add(ch);
		char lastChar = '0';				 
		boolean lastDot = false;		//indicates the last character is a dot. Used for regexs containing ".*"
		for(int i=0;i<s.length();i++)	{
			if(pList.size()<i+1)
				break;
			else	{
				if(sAr[i]==pList.get(i))	
					continue;
				
				if(pList.get(i)=='.' || (lastDot&pList.get(i)=='*'))	{		//second condition for '*' in ".*"
					if(!lastDot)
						lastDot = true;
					pList.add(i, sAr[i]);		//replaces '.' with the character at the same index in s
					pList.remove(i+1);			//(removes '.')
				}
				
				if(pList.get(i)=='*' & !lastDot)	{					
					if(i!=0)
						lastChar = pList.get(i-1);		//lastChar is the preceding element
					
					if(lastChar==sAr[i])	{
						pList.add(i, sAr[i]);			//adds a single previous element; '*' shifts up to next index
					}
					else
						pList.remove(i);				//removes '*' 
				}

				if(!lastDot)
					lastDot = false;		//resets lastDot to false
			}
		}
		
		if(pList.size()>s.length())	{			//if p ends with '*', the above loop ends before '*' is removed. Remove it here.
			pList.remove(pList.size()-1);
		}
		
		String p2 = "";
		for(char ch:pList)
			p2 += ch;
		
		System.out.println(p2);
		return p2.equals(s);
	}
	
	public static void main(String[] args) {
		String s = "aba";
		String p = ".*a";
		
		System.out.println(isMatch(s,p));

	}

}
