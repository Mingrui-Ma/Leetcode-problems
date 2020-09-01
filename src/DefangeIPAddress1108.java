import java.util.*;

public class DefangeIPAddress1108 {
	static String addBrackets(String in, char ch)	{
		in += "[";
		in += ch;
		in += "]";
		return in;
	}
	
	static String defange(String IP)	{
		String out = "";
		char[] IParr = IP.toCharArray();
		for(char ch : IParr)	{
			if(ch!='.')
				out += ch;
			else
				out = addBrackets(out, ch);
		}
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(defange("192.168.2.1"));

	}

}
