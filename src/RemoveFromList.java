import java.util.*;

public class RemoveFromList {
	
	public LinkedList<Integer> remover(LinkedList<Integer> ll, int val)	{
		LinkedList<Integer> ll2 = new LinkedList<>();
		for(Integer i: ll)	{
			if(i!=val)
				ll2.add(i);
		}
		return ll2;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(1);
		ll.add(19);
		ll.add(10);
		ll.add(1);
				
		RemoveFromList remove = new RemoveFromList();
		LinkedList<Integer> ll2 = remove.remover(ll, 1);
		
		for(Integer i:ll2)
			System.out.print(i + " ");
	}

}
