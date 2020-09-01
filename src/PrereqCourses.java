import java.util.*;
//207
public class PrereqCourses {
	/*
	boolean PrereqHasPrereq(LinkedList<Integer> ll1, LinkedList<Integer> ll2)	{
		boolean outcome = false;
		for(Integer i: ll1)	{
			if(ll2.contains(i))
				outcome = true;
		}
		return outcome;
	}
	*/
	
	static boolean prereqTest(int[][] courses)	{			//prereq, req
		LinkedList<Integer> req = new LinkedList<>();
		LinkedList<Integer> prereq = new LinkedList<>();
		for(int i=0;i<courses.length;i++)	{
			req.add(courses[i][1]);			//list of requisites in order
			prereq.add(courses[i][0]);		//list of prerequisites in order
		}
		
		 LinkedList<Integer> both = new LinkedList<>();
			for(Integer i: req)	{
				if(prereq.contains(i))
					both.add(i);
			}
		 
			boolean outcome = true;
		for(Integer i: both)	{
			int idx = req.indexOf(i);	//index of course # in req
			int correspondingPrereq = prereq.get(idx);		//find corresponding prereq
			
			int idx2 = prereq.indexOf(i);	//index of course# in prereq
			int correspondingReq = req.get(idx2);
			
			if(correspondingPrereq==correspondingReq)	{
				outcome = false;
				return outcome;
			}
		}
		return outcome;
	}
	
	public static void main(String[] args) {
		int[][] courses = { {0, 1}, {0, 2}, {1, 0} };
		System.out.println(prereqTest(courses));
	}

}
