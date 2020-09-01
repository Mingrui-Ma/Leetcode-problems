import java.util.*;

public class MaxDotProduct1458 {
	static int findMaxDotProd(int[] nums1, int[] nums2)	{
		ArrayList<Integer> nums1List = new ArrayList<>(), nums2List = new ArrayList<>();
		
		for(int i:nums1)	
			nums1List.add(i);
		for(int i:nums2)
			nums2List.add(i);
		Comparator<Integer> rev = Collections.reverseOrder();
		Collections.sort(nums1List, rev);
		Collections.sort(nums2List, rev);
		
		int maxDotProd = 0, minSize = Math.min(nums1List.size(), nums2List.size()), num1, num2, firstNonnegIdx = -1;
		for(int i=0;i<minSize;i++)	{
			num1 = nums1List.get(i);
			num2 = nums2List.get(i);
			if(num1>0 & num2>0)	{
				System.out.println(num1 + "*" + num2);
				maxDotProd += num1*num2;
			}
			else	{
				firstNonnegIdx = i;
				break;
			}
		}
		
		if(firstNonnegIdx!=-1)	{
			//add if both negative
			for(int i=0;i<minSize-firstNonnegIdx;i++)	{
				num1 = nums1List.get(nums1List.size()-1-i);
				num2 = nums2List.get(nums2List.size()-1-i);
				if(num1<0 & num2<0)	{
					System.out.println(num1 + "*" + num2);
					maxDotProd += num1*num2;
				}
				else
					break;
			}
		}
		
		return maxDotProd;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {2,1,-2,5}, nums2 = {3,0,-6};
		
		System.out.println(findMaxDotProd(nums1,nums2));
	}

}
