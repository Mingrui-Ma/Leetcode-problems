import java.util.*;

public class ArrayRange228 {

	static String CtsRange(int[] input)	{
		TreeSet<Integer> ts = new TreeSet<>();
		LinkedList<String> ranges = new LinkedList<>();
		for(int i:input)
			ts.add(i);
		
		Iterator<Integer> itr = ts.iterator();
		int prev = itr.next(), next, rngStart = prev, rngEnd;
		String aRange = "";
		while(itr.hasNext())	{
			next = itr.next();
			System.out.println(next);
			if(prev+1 == next || prev==next)
				prev = next;
			
			else	{
				rngEnd = prev;
				if(rngStart != rngEnd)
					aRange = rngStart + "-" + rngEnd + ", ";
				else
					aRange = rngStart + ", ";
				ranges.add(aRange);
				rngStart = next;
				prev = next;
				aRange = "";
			}
		}
		rngEnd = prev;
		if(rngStart != rngEnd)
			aRange = rngStart + "-" + rngEnd + ", ";
		else
			aRange = rngStart + ", ";
		ranges.add(aRange);
		
		String output = "[";
		for(String r:ranges)	
			output += r;
		
		output = output.substring(0, output.lastIndexOf(','));
		output += "]";
		return output;
	}
	
	public static void main(String[] args) {
		int[] in = {1,5,6,7,10};
		System.out.println(CtsRange(in));

	}

}
