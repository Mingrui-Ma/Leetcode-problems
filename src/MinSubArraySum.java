import java.util.*;
//209

public class MinSubArraySum {

	static int minLen(int s, int[] nums) 	{
		
		ArrayList<Integer> lens = new ArrayList<>();
		
		for(int i=0;i<nums.length;i++)	{			//start counting at index i
			int d = i;
			int sum = 0;
			int len = 0;
			//
			do	{
				sum += nums[d];
				d++;
				len++;
				if(sum>=s)	{
					break;
				}
			}	while(d<nums.length);
			//
			//System.out.println(sum + " " + d + " " + len);
			if(sum>=s)
				lens.add(len);
		}
		return Collections.min(lens);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(minLen(12,nums));

	}

}
