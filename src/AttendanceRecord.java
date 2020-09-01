//551

public class AttendanceRecord {
	
	static boolean awardWorthy(String att)	{
		char[] array = new char[att.length()];
		for(int i=0;i<att.length();i++)	{
			array[i] = att.charAt(i); 
		}
		int aCount = 0;
		boolean firstL = false;
		boolean consecutiveL = false;
		for(char ch:array)	{
			if(ch=='A')	{
				aCount++;
				if(consecutiveL)
					return false;
				else if(!firstL)
					firstL = true;
				else if(firstL)
					consecutiveL = true;
			}
			if(ch=='L')	{
				if(consecutiveL)
					return false;
				else if(!firstL)
					firstL = true;
				else if(firstL)
					consecutiveL = true;
			}
			if(ch=='P')	{
				firstL = false;
				consecutiveL = false;
			}
		}
		if(aCount>=2)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		String attendance = "PPLLAP";

		System.out.println(awardWorthy(attendance));
	}
}
