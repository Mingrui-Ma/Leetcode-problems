import java.util.*;
//130

public class Surrounded {

	String[][] solve(String[][] board)	{
		LinkedList<Integer> x = new LinkedList<>();
		LinkedList<Integer> y = new LinkedList<>();
		LinkedList<Integer> freeX = new LinkedList<>();
		LinkedList<Integer> freeY = new LinkedList<>();
		int height = board.length;
		int len = board[0].length;
		for(int i=0;i<height;i++)	{
			if(board[i].length != len)	{
				System.out.println("Board must be rectangular.");
				return new String[1][1];
			}
			
		for(int j=0;j<len;j++)	{
			for(int k=0;k<height;k++)	{
				if(board[j][k].equals("O"))	{
					x.add(j+1);
					y.add(k+1);
					if(j+1==len || k+1==height)	{
						freeX.add(j+1);
						freeY.add(k+1);
					}
				}
			}
		}
		//x, y contains the coordinates of the o's
		//freeX, freeY contains the coordinates of the o's on the border
		
		for(int o_x : x)	{
			for(int o_y : y)	{
				for(int f_x: freeX)	{
					for(int f_y: freeY)	{
						
					}
				}
			}
		}
		}
	}
	
	public static void main(String[] args) {
		

	}

}
