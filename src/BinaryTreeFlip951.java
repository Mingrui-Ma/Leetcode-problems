import java.util.*;

public class BinaryTreeFlip951 {

	static int findNumOfNodes(int lv)	{
		int currentLv = 0, num = 0;
		while(currentLv < lv)	{
			num += Math.pow(2, currentLv);
			
			currentLv++;
		}
		return num;
	}
	
	static ArrayList<ArrayList<Integer>> divideLevels(int[] binTree)	{
		ArrayList<ArrayList<Integer>> TieredTree = new ArrayList<>();
		ArrayList<Integer> oneTree = new ArrayList<>();
		int NumOfLvs = 1, pastLv = 1, currentLv = findNumOfNodes(NumOfLvs);
		while(currentLv <= binTree.length)	{
			//oneTree.ensureCapacity((int) Math.pow(2, NumOfLvs));
			for(int i=pastLv-1;i<currentLv;i++)	{
				//System.out.println("pastLv = " + pastLv + "; currentLv = " + currentLv + "; i = " + i);
				oneTree.add(binTree[i]);
			}
			for(Integer in:oneTree)	
				System.out.print(in + " ");
			System.out.println();
			pastLv = currentLv;		
			NumOfLvs++;
			currentLv = findNumOfNodes(NumOfLvs);
			TieredTree.add(oneTree);
			//System.out.println(oneTree.size());
			oneTree.clear();
		}
		int lastTreeSize = TieredTree.get(TieredTree.size()-1).size(), diff;
		if(lastTreeSize < (int) Math.pow(2, currentLv))	{
			diff = (int) Math.pow(2, currentLv) - lastTreeSize;
			while(diff>0)	{
				TieredTree.get(TieredTree.size()-1).add(-1);
				diff--;
			}
		}
		return TieredTree;
	}
			
	
	public static void main(String[] args) {
		int[] tree = {1,2,3,4};//,5,6,-1,-1,-1,7,8};

		ArrayList<ArrayList<Integer>> tieredTree = divideLevels(tree);
		
		for(ArrayList<Integer> al : tieredTree)	{
			//System.out.println(al.size());
		//	for(Integer i : al)	
		//		System.out.print(i + " ");
		//	System.out.println();	
		}	
		
		//for(int i=0;i<8;i++)
			//System.out.println(findNumOfNodes(i));
	}
}
