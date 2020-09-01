import java.util.*;

public class CombinationSum39 {

	static void addResult(ArrayList<Integer> res, ArrayList<ArrayList<Integer>> resList)	{
		resList.add(res);
		res.clear();
	}
	
	static public ArrayList<ArrayList<Integer>> findComb(int[] candidates, int target)	{
		Comparator<Integer> revComp = Comparator.reverseOrder();
		TreeSet<Integer> candidateSet = new TreeSet<>(revComp);
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
		int tgt;
		for(int c : candidates)				//put candidates into a reverse order treeset
			candidateSet.add(c);			//also gets rid of duplicate candidates
		
		ArrayList<Integer> candidateComb = new ArrayList<>();
		candidateComb.ensureCapacity(candidates.length*(candidates.length+1));
		for(int i=0;i<candidateSet.size()-1;i++)	{
			for(int j=i+1;j<candidateSet.size();j++)	{
				candidateComb.add(candidates[i] + candidates[j]);			//candidateComb contains the sums of every combination of two candidates
			}
		}
		for(int i:candidates)	
			for(int j=0;j<candidateComb.size();j++)
			candidateComb.add(i + candidateComb.get(j));
			

		for(int c: candidateSet)	{	
			tgt = target;
			if(tgt%c==0)	{				//test if target is a multiple of any candidate
				int multiple = tgt/c;
				for(int i=0;i<multiple;i++)	
					result.add(c);
				addResult(result, resultList);
			}
			else	{
				tgt -= c;
				for(int c1: candidateSet)	{	//test if target is a multiple of any candidate after subtracting a candidate	
					if(tgt%c1==0)	{
						result.add(c);
						int multiple = tgt/c;
						for(int i=0;i<multiple;i++)
							result.add(c);
						addResult(result, resultList);
					}
					
				}
			}
			
		}
		return resultList;	
		
		
	}
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		ArrayList<ArrayList<Integer>> resultList = findComb(candidates, 7);
		
		System.out.println("[");
		for(ArrayList<Integer> ll: resultList)	{
			System.out.print("[");
			for(int i: ll)	{
				System.out.print(i + ", ");
			}
			System.out.println("]");
		}
			System.out.println("]");
				

	}

}


//max number of times each candidate number can be used
/*ArrayList<Integer> maxTimes = new ArrayList<>();
for(int c : candidates)	{
	maxTimes.add(target/c);
}	*/


/*
TreeSet<Integer> candidateComb = new TreeSet<>();
for(int i=0;i<candidateSet.size()-1;i++)	{
	for(int j=i+1;j<candidateSet.size();j++)	{
		candidateComb.add(candidates[i] + candidates[j]);			//candidateComb contains the sums of every combination of two candidates
	}
}
*/
