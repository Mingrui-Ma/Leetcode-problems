
public class BuddyStrings859 {

	static boolean isBuddy(String a, String b)	{
		if(a.equals(b))
			return true;
		
		char[] Aar = a.toCharArray();
		char[] Bar = b.toCharArray();
		
		if(Aar.length != Bar.length)
			return false;
		
		boolean swap1 = false, swap2 = false;
		char firstA = 'a', secondA = 'b', firstB = 'c', secondB = 'd';
		for(int i=0;i<Aar.length;i++)	{
			if(Aar[i]!=Bar[i])	{
				if(!swap1)	{		//first occurrence of different characters
					firstA = Aar[i];
					firstB = Bar[i];
					System.out.println(firstA + ", " + firstB);
					swap1 = true;
					continue;
				}
				if(swap1 & !swap2)	{		//second occurrence
					secondA = Aar[i];
					secondB = Bar[i];
					System.out.println(secondA + "; " + secondB);
					swap2 = true;
					continue;
				}
				if(swap2)	{		//third occurrence
					System.out.println("third");
					return false;
				}
			}
		}
		
		if(firstA==secondB & secondA==firstB)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		String s = "astro";
		String s2 = "avdfg";
		
		System.out.print(isBuddy(s,s2));

	}

}
