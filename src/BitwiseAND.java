public class BitwiseAND {

	static int BitAnd(int m, int n)	{
		int mp1 = m+1;
		int and = m&mp1;
		for(int i=m+2;i<=n;i++)	{
			and &=i;
		}
		return and;
	}

	public static void main(String[] args) {
		System.out.println(BitAnd(5,7));
	}

}