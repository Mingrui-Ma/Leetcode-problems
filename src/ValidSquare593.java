import java.util.*;

public class ValidSquare593 {

	static double getSide(int[] p1, int[] p2)	{
		return Math.sqrt(Math.pow(p1[0]-p2[0],2) + Math.pow(p1[1]-p2[1],2));
	}

	static boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4)	{
		if(p1.length!=2 || p2.length!=2 || p3.length!=2 || p4.length!=2)	{
			System.out.println("Invalid coordinates (must be 2D cartesian).");
			return false;
		}
		
		int[][] parallelogram = {p1, p2, p3, p4};
		ArrayList<Double> sides = new ArrayList<>();
		for(int[] point1 : parallelogram)	{
			sides.clear();
			for(int[] point2 : parallelogram)	{
				sides.add(getSide(point1,point2));
			}
			Collections.sort(sides);
			if(Math.abs(sides.get(1)-sides.get(2))<.000001 && Math.abs(sides.get(1)*Math.sqrt(2)-sides.get(3))<.000001)
				continue;
			else	{

					System.out.println(Math.abs(sides.get(1)*Math.sqrt(2)-sides.get(3))<.001);
				return false;
			}
		}
		return true;
	}	
	
	public static void main(String[] args) {
		int[] p1 = {-1,-1}, p2 = {1,1}, p3 = {1,-1}, p4 = {-1, 1};
		System.out.println(isSquare(p1,p2,p3,p4));			

	}

}
