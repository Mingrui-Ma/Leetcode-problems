//342

public class PowerOfN {
	
	static boolean isPower(int num, int root)	{
		int pwr = 1, i=1;
		while(pwr<num)	{
			Double pwrDouble = Math.pow(root, i);
			pwr = pwrDouble.intValue();
			i++;
		}
		return num==pwr;
	}
	
	public static void main(String[] args) {
		System.out.println(isPower(1024, 4));

	}

}
