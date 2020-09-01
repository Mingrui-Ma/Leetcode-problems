import java.util.*;
//764
public class LargestPlusSign {

	static int LargestPlus(int n, int[][] ones)	{
		int[][] board = new int[n][n];
		for(int[] coord: ones)	{
			board[coord[0]][coord[1]] = 1;
		}
		/*
		for(int i=0;i<n;i++)	{
			for(int j=0;j<n;j++)	{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		*/
		LinkedList<Integer> magnitude = new LinkedList<>();
		
		
		for(int x=0;x<n;x++)	{
			for(int y=0;y<n;y++)	{
				int[] armSizes = new int[4];
				LinkedList<Integer> arms = new LinkedList<>();
				
				left: 	for(int x1=x;x1>=0;x1--)	{		//left arm
					switch(board[x1][y])	{
					case(0):
						armSizes[0]++;
					break;
					case(1):
						break left;
					}
				}
			
				right: for(int x2=x;x2<n;x2++)	{
					switch(board[x2][y])	{
					case(0):
						armSizes[1]++;
					break;
					case(1):
						break right;
					}		
				}
				
				down: for(int y1=y;y1>=0;y1--)	{
					switch(board[x][y1])	{
					case(0):
						armSizes[2]++;
					break;
					case(1):
						break down;
					}
				}
				
				up: for(int y2=y;y2<n;y2++)	{
					switch(board[x][y2])	{
					case(0):
						armSizes[3]++;
					break;
					case(1):
						break up;
					}
				}				

				arms.add(armSizes[0]);
				arms.add(armSizes[1]);
				arms.add(armSizes[2]);
				arms.add(armSizes[3]);
				magnitude.add(Collections.min(arms));
			}			
		}
		
		return Collections.max(magnitude);
	}
	
	public static void main(String[] args) {
		int[][] ex = {{0,0}};
		System.out.print(LargestPlus(5, ex));

	}

}
