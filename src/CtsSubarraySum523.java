import java.util.*;

public class CtsSubarraySum523 {

	static ArrayList<Integer> getSubarray(int[] nums, int start, int end)	{
		ArrayList<Integer> subarr = new ArrayList<>();
		for(int i=start;i<=end;i++)	{
			subarr.add(nums[i]);
		}
		return subarr;
	}
	
	static ArrayList<Integer> checkOneSub(int[] nums, int start, int tgt)	{	//use dynamic programming
		int sum = 0, idx = start;
		do	{
			sum += nums[idx];
			if(sum%tgt==0)
				return getSubarray(nums, start, idx);
			idx++;
		}	while(idx<nums.length);
		
		ArrayList<Integer> bad = new ArrayList<>();
		bad.add(-1);
		return bad;
	}	
	
	static boolean checkSub(int[] nums, int tgt)	{
		for(int n=0;n<nums.length;n++)	{
			ArrayList<Integer> subarr = checkOneSub(nums, n, tgt);
			if(subarr.get(0) == -1)
				continue;
			else	{
				System.out.print("[ ");
				for(int in:subarr)
					System.out.print(in + " ");
				System.out.println("]");
				return true;
			}
		}
		return false;	
	}
	
	public static void main(String[] args) {
		int[] nums = {23,2,6,4,7};
		checkSub(nums, 6);
	}
}