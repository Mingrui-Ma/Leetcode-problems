import java.util.*;

public class ReorderList143 {
	static <T> ArrayList<T> reorder(ArrayList<T> list)	{
		ArrayList<T> reorderedList = new ArrayList<>();
		int len = list.size(), i;
		for(i=0;i<len/2;i++)	{
			reorderedList.add(list.get(i));
			reorderedList.add(list.get(len-1-i));
		}
		
		float midpt =(float) len/2;
		if(midpt % 1 !=0)
			reorderedList.add(list.get(i));
		return reorderedList;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=1;i<=5;i++)
			al.add(i);

		al = reorder(al);
		
		for(int i:al)
			System.out.print(i + " ");

	}
}
