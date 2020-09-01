import java.util.*;
//258
public class AddDigits {


	
	static LinkedList<Integer> getDigits(int num)	{
		int places = 0;
		int clone = num;
		while(clone !=0)	{
			clone/=10;
			places++;
		}
		
		LinkedList<Integer> ll = new LinkedList<>();
		int placeBuf =  1;
		while(placeBuf != places+1)	{
			Double divisor = Math.pow(10, placeBuf);
			int divisorInt = divisor.intValue();
			int digit = num%divisorInt;
			while(digit>10)	{
				digit/=10;
			}
			ll.addFirst(digit);
			placeBuf++;
		}	
		return ll;
	}
	
	static int addDigits(LinkedList<Integer> digits)	{
		int sum = 0;
		LinkedList<Integer> secondll = new LinkedList<>();
		for(int i: digits)	{
			sum += i;
		}
		while(sum >= 10)	{
			secondll = getDigits(sum);
			sum=0;
			for(int j : secondll)
				sum+=j;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer>  ll = getDigits(13423);
		//for(int i:ll)
		//	System.out.println(i);
		System.out.println(addDigits(ll));
	}

}
