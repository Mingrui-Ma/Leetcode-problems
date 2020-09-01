import java.util.*;
//905
public class SortByParity {

	static int[] sort(int[] vals)	{
		int[] sorted = new int[vals.length];
		LinkedList<Integer> evens = new LinkedList<>();		
		LinkedList<Integer> odds = new LinkedList<>();
		for(int i : vals)	{
			if(i%2==0)
				evens.add(i);
			else
				odds.add(i);
		}
		for(int j=0;j<evens.size();j++)	{
			sorted[j] = evens.get(j);
		}
		for(int k=evens.size();k<evens.size()+odds.size();k++)	{
			sorted[k] = odds.get(k-evens.size());
		}
		return sorted;
	}
	
	public static void main(String[] args) {
		int[] i = {1,2,3,4,5,6,7,8,9,100};
		int[] i2 = sort(i);
		
		for(int k:i2)	{

			System.out.print(k+ " ");
		}
	}

}
