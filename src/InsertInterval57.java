import java.util.*;

public class InsertInterval57 {
	
	/* 4 possible scenarios:
	 * 1) new interval doesn't intersect with any existing
	 * 2) new interval intersects on the left 
	 * 3) new interval intersects on the right
	 * 4) new interval intersects on the left and right
	 */
	static int[][] mergeInterval(int[][] intervals, int[] newInterval)	{
		int leftInterval = -1, rightInterval = -1;
		for(int i=0;i<intervals.length;i++)	{
			if(intervals[i][0]<newInterval[0] & intervals[i][1]>=newInterval[0])	{		//intersect on the left
				leftInterval = i;		//intervals[i] and newInterval overlap
				}

			if(newInterval[0]<intervals[i][0] & newInterval[1]>=intervals[i][0])	{		//intersect on the right
				rightInterval = i;		//newInterval and intervals[i] overlap
			}
		}
		
		//System.out.println("left: " + leftInterval + "; right: "+ rightInterval);
		Integer[][] INTervals = new Integer[intervals.length][2];		//make Integer version of intervals
		for(int k=0;k<intervals.length;k++)
			for(int j=0;j<2;j++)
				INTervals[k][j] = (Integer) intervals[k][j];
		
		Integer[] combinedInterval = new Integer[2];	
		int caseNum = 0, updatedLength=0;
		if(leftInterval!=-1 & rightInterval==-1)	{		//case 2
			System.out.println("case 2");
			caseNum = 2;
			combinedInterval[0] = (Integer) intervals[leftInterval][0];
			combinedInterval[1] = (Integer) newInterval[1];
		}
		else if(leftInterval==-1 & rightInterval!=-1)	{	//case 3
			System.out.println("case 3");
			caseNum = 3;
			combinedInterval[0] = (Integer) newInterval[0];
			combinedInterval[1] = (Integer) intervals[rightInterval][1];	
		}
		else if(leftInterval!=-1 & rightInterval!=-1)	{	//case 4
			System.out.println("case 4");
			caseNum = 4;
			combinedInterval[0] = (Integer) intervals[leftInterval][0];
			combinedInterval[1] = (Integer) intervals[rightInterval][1];		
		}
		else	{		//case 1
			System.out.println("case 1");
			caseNum = 1;
			combinedInterval[0] = (Integer) newInterval[0];
			combinedInterval[1] = (Integer) newInterval[1];		
		}

		boolean added = false;
		ArrayList<Integer[]> intervalList = new ArrayList<>();
		for(int i=0;i<intervals.length;i++)	{			
			if(i!=leftInterval & i!=rightInterval)	{
				if(INTervals[i][0]<=combinedInterval[0])
					intervalList.add(INTervals[i]);			//add intervals that do not intersect
				else	{
					if(!added)	{
						intervalList.add(combinedInterval);
						added = true;
					}
					intervalList.add(INTervals[i]);
				}
			}
		}
		
		
		switch(caseNum)	{
		case(2):
		case(3):
			updatedLength = intervals.length;
		break;
		case(1):
			updatedLength = intervals.length+1;
		break;
		case(4):
			updatedLength = intervals.length-1;
		break;
		}
		int[][] updatedIntervals = new int[updatedLength][2];
		int idx = 0;
		for(Integer[] intervls : intervalList)	{
			updatedIntervals[idx][0] = intervls[0];
			updatedIntervals[idx][1] = intervls[1];
			idx++;
		}
		return updatedIntervals;	
		
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{1,3}, {6,9}, {11,13}};
		int[] newinterval = {4,5};

		int[][] updatedint = mergeInterval(intervals, newinterval);
		//System.out.println(updatedint.size());
		for(int[] interval: updatedint)	{
			System.out.println("(" + interval[0] + "," + interval[1] + ")");
		}
	}

}
