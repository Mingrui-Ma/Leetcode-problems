import java.util.*;

public class HeightChecker1051 {
	//arrange heights from lowest to highest in fewest steps
	static int arrangeHeight(int[] heights)	{
		ArrayList<Integer> hList = new ArrayList<>();
		hList.ensureCapacity(heights.length);
		for(int h:heights)
			hList.add(h);
		Collections.sort(hList, Collections.reverseOrder());
		
		int count = 0;
		for(int i=0;i<heights.length;i++)
			if(heights[i]!=hList.get(i))
				count++;
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] heights = {5,1,2,3,4};
		
		System.out.println(arrangeHeight(heights));
	}

}