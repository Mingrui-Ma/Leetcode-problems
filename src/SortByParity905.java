import java.util.*;

public class SortByParity905 {

	static Integer[] sort(int[] input)	{
		ArrayList<Integer> evens = new ArrayList<>(), odds = new ArrayList<>();
		evens.ensureCapacity(input.length);
		odds.ensureCapacity(input.length);
		for(int i:input)	{
			switch(i%2)	{
			case(0):
				evens.add(i);
			break;
			case(1):
				odds.add(i);
			break;
			}
		}
		
		Integer[] output = new Integer[input.length];
		int idx = 0;
		for(int i:evens)	{
			output[idx] = i;
			idx++;
		}
		Iterator<Integer> itr = odds.iterator();

		while(itr.hasNext())	{
			output[idx] = itr.next();
			idx++;
		}

		
		return output;
	}
	
	public static void main(String[] args) {
		int[] tri = {1,2,3,4,5,6,7,8,9,4,2,43,5,76,5,23,4,6,45,435,6,34,54,6,7,1,9};
		Integer[] tran = sort(tri);
		for(int i:tran)	
			System.out.println(i + " ");
	}

}
