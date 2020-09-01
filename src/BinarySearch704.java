
public class BinarySearch704 {

	static int[] merge(int[] nums, int start, int end1, int end2)	{
		int[] left = new int[end1-start+2], right = new int[end2-end1+1];
		int l=0, r=0;
		for(int i=start;i<=end1;i++)	{
			left[l] = nums[i];
			l++;
		}
		for(int j=end1+1;j<=end2;j++)	{
			right[r] = nums[j];
			r++;
		}
		left[l] = 2_000_000;
		right[r] = 2_000_000;
			
		l=0;
		r=0;
		for(int i=start;i<=end2;i++)	{
			if(left[l]<right[r])	{
				nums[i] = left[l];
				l++;
			}
			else	{
				nums[i] = right[r];
				r++;
			}
		}
		return nums;
	}
			
	static int[] sort(int[] nums, int start, int end)	{
		int midpt;
		if(start<end)	{
			midpt = (start+end)/2;
			sort(nums, start, midpt);
			sort(nums,midpt+1,end);
			merge(nums,start,midpt,end);
		}
		return nums;
	}
	
	static int search(int[] nums, int target)	{
		nums = sort(nums, 0, nums.length-1);
		for(int i=0;i<nums.length;i++)	{
			if(nums[i]<target)
				continue;
			else if(nums[i]==target)
				return i;
			else	{
				int firstDiff = target - nums[i-1];
				int secondDiff = nums[i] - target;
				return firstDiff<secondDiff ? i-1 : i;
			}		
		}
		return -1;
	}
	
	public static void main(String[] args) {

	}

}
