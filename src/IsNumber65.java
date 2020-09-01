
public class IsNumber65 {

	static boolean isCharNum(char ch)	{
		return ch>47 & ch<58;
	}
	
	static boolean isNum(String str)	{
		char[] strCh = new char[str.length()-1];
		str.getChars(1, str.length(), strCh, 0);
		boolean hasE = false;
		boolean hasPoint = false;
		char c;
		if(str.charAt(0) == '+' || str.charAt(0) == '-' || isCharNum(str.charAt(0)))	{
			for(int i=0;i<strCh.length;i++)	{
				c = strCh[i];
				if(isCharNum(c))
					continue;
				else if(c== '.')	{
					if(!hasPoint & !hasE)		//only one period and it has to come before E
						hasPoint = true;
					else
						return false;
				}
				else if(c=='e' || c=='E')	{		//only one E
					if(!hasE)
						hasE = true;
					else
						return false;
				}
				else if(c=='+' || c=='-')	{		//+- can only appear after E
					if(strCh[i-1]=='e' || strCh[i-1]=='E')
						continue;
					else
						return false;
				}
			}
		}
		else
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		String s = "+123e-4";
		System.out.println(isNum(s));

	}

}
