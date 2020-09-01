
public class StringToInteger8 {
	static int convert(String str)	{
		char[] strArr = str.toCharArray();
		String obtainedInt = "";
		boolean flag = true;
		for(char ch:strArr)	{
	//		if(ch==' ')
		//		if(flag)
			//		continue;
			if (ch=='+' || ch=='-' || ch>=48 & ch<=57)	{
				flag = false;
				obtainedInt += ch;
			}
			else 	{
				if(!flag)
					break;
			}
		}
		
		if(obtainedInt.equals("-") || obtainedInt.equals("+"))
			return 0;
		
		return Integer.parseInt(obtainedInt);
	}
	public static void main(String[] args) {
		String s = "     -f123asdf1";
		System.out.println(convert(s));
	}
}