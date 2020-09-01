import java.util.*;
//766
public class ToeplitzMatrix {

	static boolean isToeplitz(int[][] matrix)	{
		int row = matrix.length;
		LinkedList<Integer> diagonal = new LinkedList<>();
		for(int i=0;i<row;i++)	{
			if(matrix[i].length < i+1)
				return false;
			else
				diagonal.add(matrix[i][i]);
		}
		int firstDiag = diagonal.get(0);
		for(Integer d : diagonal)	{
			if(d != firstDiag)
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		int i[][] = {
				{1, 2,3,4},
				{5,1,3,2},
				{1,4,1,2},};
	
		System.out.println(isToeplitz(i));
		
	}

}
