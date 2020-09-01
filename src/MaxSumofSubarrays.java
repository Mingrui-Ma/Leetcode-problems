import java.util.*;
//1031
public class MaxSumofSubarrays {
	static int maxSum(int[] vals, int m, int n)	{
		int len = vals.length;
		//int[] sub1 = new int[m];
		int sum1,sum2,count;
		//int[] sub2 = new int[n];
		ArrayList<Integer> sum = new ArrayList<>();
		sum.ensureCapacity(len*len); 
		
		for(int i=0;i<len;i++)	{			//m length subarray
			//i to i+m
			for(int j=0;j<len;j++)	{		//n length subarray
			//j to j+n
				sum1 = 0;
				sum2 = 0;
				count=0;
				boolean overlap1 = i+m>=j & i<=j;
				boolean overlap2 = j+n>=i & j<=i;
				if(overlap1||overlap2)	{
					sum.add(-1);
					continue;
				}
				else	{
					int end1 = Math.min(len, i+m);		//shortens subarray if vals not long enough
					int end2 = Math.min(len, j+n);
					for(int m1=i;m1<end1;m1++)	{
						//sub1[m1] = vals[i+m1];
						sum1 += vals[m1];
					}
					for(int n1=j;n1<end2;n1++)	{
						//sub2[n1] = vals[j+n1];
						sum2 += vals[n1];
					}
				}
				if(sum1+sum2==22)	
					System.out.println("sum1: " + sum1 + "; sum2: " + sum2);
				sum.add(sum1+sum2);
				//System.out.println("Count: " + count);
			}	
			
		}
		//System.out.println(sum.size());
		return Collections.max(sum);		
	}
	
	public static void main(String[] args) {
		int[] A = {0,6,5,2,2,5,1,9,4};
		System.out.println(maxSum(A, 1, 2));

	}

}
