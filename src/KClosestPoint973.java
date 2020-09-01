import java.util.*;

public class KClosestPoint973 {
	static int[][] kClosest(int[][] points, int k)	{
		//ArrayList<Double> distList = new ArrayList<>();
		TreeMap<Double, int[]> distMap = new TreeMap<>();
		for(int[] point : points)	
			distMap.put((Double) Math.sqrt(point[0]*point[0]+point[1]*point[1]), point);
		
		Set<Double> distSet = new TreeSet<>(); 
		distSet = distMap.keySet();
		ArrayList<int[]> pointList = new ArrayList<>();
		int counter = 0;
		for(double dist: distSet)	{
			if(counter<k)	{
				counter++;
				pointList.add(distMap.get(dist));
			}
			else
				break;
		}
		
		int[][] pointAr = new int[pointList.size()][2];
		int idx = 0;
		for(int[] pt:pointList)	{
			pointAr[idx] = pt;
			idx++;
		}
		return pointAr;
	}
	
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4},{4,4}};
		int[][] closestPts = kClosest(points, 2);
		for(int[] pt:closestPts)	{
			System.out.println("[" + pt[0] + "," + pt[1] + "]");
		}
	}

}
