
public class NumberDistancing1437 {

	static boolean isDistanced(int[] nums, int k)	{
		int counter = k;
		for(int i:nums)	{
			if(i==1)	{
				if(counter<k)
					return false;
				else
					counter = 0;
			}
			else	{		//i==0
				counter++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,0,0,1,0,0,1};
		System.out.println(isDistanced(nums,3));
	}

}
