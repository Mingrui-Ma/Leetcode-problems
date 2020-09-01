import java.util.*;

public class MinDiff1200 {

	static ArrayList<ArrayList<Integer>> findMinDiffPairs(int[] source)	{
		ArrayList<Integer> sourceList = new ArrayList<>();		//put source into ascending order
		for(int i:source)								
			sourceList.add(i);
		Collections.sort(sourceList);
		
		Iterator<Integer> itr = sourceList.iterator();			//obtain differences of adjacent elements
		ArrayList<Integer> diffList = new ArrayList<>();		//each element in diffList corresponds to its index in sourceList and the next element
		int prior=itr.next(), aft;
		while(itr.hasNext())	{				
			aft = itr.next();
			diffList.add(aft-prior);
			prior = aft;
		}
		/*
		for(int i:sourceList)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("difflist");
		for(int i:diffList)
			System.out.print(i + " ");
		System.out.println();		
		*/
		
		int min = Collections.min(diffList);
		ArrayList<ArrayList<Integer>> pairList = new ArrayList<>();
		int dif;
		for(int i=0;i<diffList.size();i++)	{	
			ArrayList<Integer> pair = new ArrayList<>();
			dif = diffList.get(i);
			if(dif==min)	{
				pair.clear();
				pair.add(sourceList.get(i));
				pair.add(sourceList.get(i+1));
				pair.trimToSize();
				pairList.add(pair);
			}
		}
		return pairList;
	}
	
	public static void main(String[] args) {
		int[] src = {1,3,5,8,10,12,100,102,50,60};
		ArrayList<ArrayList<Integer>> pairList = findMinDiffPairs(src);
		
		for(ArrayList<Integer> al: pairList)	{
			for(int i:al)	{
				System.out.print(i + " ");
			}
			System.out.println();
		}	
	}

}
