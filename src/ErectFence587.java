import java.util.*;

public class ErectFence587 {

	static ArrayList<Integer[]> erect(int[][] trees)	{
		
		ArrayList<int[]> treesList = new ArrayList<>(), fenceList = new ArrayList<>(), 
				         minXList = new ArrayList<>(), maxXList = new ArrayList<>(), minYList = new ArrayList<>(), maxYList = new ArrayList<>();
		for(int[] tree:trees)
			treesList.add(tree);
		
		int minX = trees[0][0], minY = trees[0][1], maxX = trees[0][0], maxY = trees[0][1];
			//minXIdx = 0, minYIdx = 0, maxXIdx = 0, maxYIdx = 0;
		for(int i=0;i<trees.length;i++)	{
			if(trees[i][0]>maxX)	{
				//maxXIdx = i;
				maxX = trees[i][0];
			}
			if(trees[i][0]<minX)	{
				//minXIdx = i;
				minX = trees[i][0];
			}
			if(trees[i][1]>maxY)	{
				//maxYIdx = i;
				maxY = trees[i][1];
			}
			if(trees[i][1]<minY)	{
				//minYIdx = i;
				minY = trees[i][1];
			}
		}
		
		//add all points with max-x, max-y, min-x, min-y
		for(int[] tree:trees)	{
			if(tree[0]==minX)
				fenceList.add(tree);
			if(tree[0]==maxX)
				fenceList.add(tree);
			if(tree[1]==minY)
				fenceList.add(tree);
			if(tree[1]==maxY)
				fenceList.add(tree);
		}
		
		//find (if any) points lie outside the line between two max points
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
