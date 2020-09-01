
public class DoubleInArray1346 {

	static boolean hasDouble(int[] nums)	{
		for(int i: nums)	{
			for(int j: nums)	{
				if(i==2*j) {
					System.out.println("Found pair: " + i + " and " + j);
					return true;
				}
			}
		}
		return false;
	}
			
	public static void main(String[] args) {
		int[] arr = {10,2,6};
		System.out.println(hasDouble(arr));

	}

}
