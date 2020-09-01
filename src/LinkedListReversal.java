import java.util.*;

public class LinkedListReversal {

	static LinkedList<Integer> LLRev(LinkedList<Integer> ll)	{
		LinkedList<Integer> newll = new LinkedList<>();
		for(Integer i: ll)	{
			newll.addFirst(i);
		}
		return newll;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		
		LinkedList<Integer> newll = LLRev(ll);
		for(Integer i: newll)	
			System.out.print(i + " ");
	}
}
