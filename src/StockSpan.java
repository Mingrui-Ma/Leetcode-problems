import java.util.*;
//#901
public class StockSpan {

	public int stockSpan(LinkedList<Integer> prices, int index)	{
		int len = prices.size();
		int[] span = new int[len];
		for(int i=0;i<len;i++)	{
			span[i] = 1;
		}
		int currentIdx;
		for(int i=0;i<len;i++)	{
			currentIdx = i;
			counter: while(currentIdx > 0)	{
				if(prices.get(currentIdx-1) <= prices.get(i))	{
					span[i]++;
					currentIdx--;
				}
				else
					break counter;
			}
		}
		return span[index];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);					/*
		System.out.println("Input the stock prices each day. Input \"done\" when done.");
		String next;
		Integer price;
		LinkedList<Integer> ll = new LinkedList<>();
		while(!(next = sc.next()).equals("done"))	{
			if(!next.equals("done"))	{
			price = Integer.parseInt(next);		
			ll.add(price);
			}
			}
									(preset stock prices)	*/
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(100);
		ll.add(80);
		ll.add(50);
		ll.add(70);
		ll.add(60);
		ll.add(75);
		ll.add(85);					
		
		StockSpan sp = new StockSpan();
		System.out.println("Would you like to display the stock span of every day or one particular day? (Input \"everyday\" or a day number)");
		String response = sc.next();
		if(response.length()==8)	{
			System.out.print("{ ");
			for(int i=0;i<ll.size();i++)	{
				System.out.print(sp.stockSpan(ll, i) + " ");
			}
			System.out.print("}");
		}
		else if(response.length()==1)	{
		Integer dayToCalc = Integer.parseInt(response) -1;
		
		int spanResult = sp.stockSpan(ll, dayToCalc);
		System.out.println("The stock span of day " + dayToCalc + " is " + spanResult  + ".");
		}
		else
			System.out.println("Unsupported operation.");
		sc.close();
	}

}
