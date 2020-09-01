import java.util.*;

public class CandyChildren135 {
	
	static int distribute(int[] ratings)	{
		int sum = 0, len = ratings.length;
		int[] candies = new int[len];
		for(int i=0;i<len;i++)	
			candies[i] = 1;
		
		ArrayList<Integer> ratingsAL = new ArrayList<>();
		ratingsAL.ensureCapacity(len);
		for(int r:ratings)
			ratingsAL.add(r);	
		int minIdx = ratingsAL.indexOf(Collections.min(ratingsAL));		//find index of minimal rating
		//candies[minIdx] = 1;		(already 1)
		
		if(minIdx!=0 & minIdx!=len-1) {
			for(int i=minIdx;i>0;i--)	{		//on the left of the minimum index		
				if(ratings[i] > ratings[i-1] & ratings[i] > ratings[i+1])
					candies[i] = Math.max(candies[i+1], candies[i-1]) + 1;
			}		
			if(ratings[0] > ratings[1])		//do 0 index separately
				candies[0] = candies[1] + 1;
			
			for(int i=minIdx;i<len-1;i++)	{		//on the right of the minimum index		
				if(ratings[i] > ratings[i-1] & ratings[i] > ratings[i+1])
					candies[i] = Math.max(candies[i+1], candies[i-1]) + 1;
			}		
			if(ratings[len-1] > ratings[len-2])		//do last index separately
				candies[len-1] = candies[len-2] + 1;
		}
		
		if(minIdx == 0)	{
			for(int i=1;i<len-1;i++)	{		//on the right of the minimum index		
				if(ratings[i] > ratings[i-1] & ratings[i] > ratings[i+1])
					candies[i] = Math.max(candies[i+1], candies[i-1]) + 1;
			}		
			if(ratings[len-1] > ratings[len-2])		//do last index separately
				candies[len-1] = candies[len-2] + 1;
		}
		
		if(minIdx == len-1)	{
			for(int i=minIdx-1;i>0;i--)	{		//on the left of the minimum index		
				if(ratings[i] > ratings[i-1] & ratings[i] > ratings[i+1])
					candies[i] = Math.max(candies[i+1], candies[i-1]) + 1;
			}		
			if(ratings[0] > ratings[1])		//do 0 index separately
				candies[0] = candies[1] + 1;
		}
		
		for(int c:candies)	{
			System.out.print(c + " ");
			sum+=c;
		}
		System.out.println();
		return sum;
	}
	
	public static void main(String[] args) {
		int[] rating = {1,2,3,1};
		System.out.println(distribute(rating));

	}

}
