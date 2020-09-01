import java.util.*;
public class LongestStringChain1048 {

	static String nextString(String[] words, String lastStr)	{
		int len = lastStr.length();
		for(String s:words)	{		
			if(s.length()==len+1)	{
				for(int i=1;i<=s.length();i++)	{
					if(s.substring(0, i).equals(lastStr.substring(0, i)) & s.substring(i).equals(lastStr.substring(i-1)))
						return s;
				}
			}
		}
		return "";
	}
	
	static int longestChain(String[] words)	{
		ArrayList<Integer> counts = new ArrayList<>();
		String nextStr;
		int count;
		for(String s:words)	{
			count = 0;
			nextStr = s;
		while(!nextStr.equalsIgnoreCase(""))	{
			nextStr = nextString(words, nextStr);
			//System.out.println(nextStr);
			count++;
		}
		counts.add(count);
	}
		return Collections.max(counts);
	}
	
	public static void main(String[] args) {
		String[] chain = {"a", "ba", "bca", "bda", "bdca"};
		//System.out.println(longestChain(chain));
		System.out.println(nextString(chain, "a"));
	}
}

/*
static String nextString(String[] words, String lastStr)	{
int len = lastStr.length();
for(String s:words)	{		
	if(s.length()==len+1)	{
		for(int i=1;i<=s.length();i++)	{
			if(s.substring(0, i).equals(lastStr.substring(0, i)) & s.substring(i).equals(lastStr.substring(i-1)))
				return s;
		}
	}
}
return "";
}

static int longestChain(String[] words)	{
ArrayList<Integer> counts = new ArrayList<>();
String nextStr;
int count;
for(String s:words)	{
	count = 0;
	nextStr = s;
while(!nextStr.equalsIgnoreCase(""))	{
	nextStr = nextString(words, nextStr);
	//System.out.println(nextStr);
	count++;
}
counts.add(count);
}
return Collections.max(counts);
}

public static void main(String[] args) {
String[] chain = {"a", "ba", "bca", "bda", "bdca"};
//System.out.println(longestChain(chain));
System.out.println(nextString(chain, "a"));
}	*/