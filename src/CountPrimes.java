//204

public class CountPrimes {

	boolean isPrime(int n)	{
		int factor=0;
		for(int i=1;i<=n;i++)	{
			if(n%i==0)
				factor++;
		}
		if(factor==2)
			return true;
		else
			return false;
	}
	
	int count(int n)	{
		int count=0;
		for(int i=1;i<n;i++)	{
			if(isPrime(i))
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.count(100000));

	}

}