import java.util.*;
//52
public class NQueensProb {

	static boolean isSafe(String[][] board, int x, int y)	{
		if(board[x][y].equals("."))
			return true;
		else
			return false;
	}
	
	static String[][] pacifist(int q)	{
		String[][] board = new String[8][8];	
		for(int i=0;i<8;i++)	{
			for(int j=0;j<8;j++)	{
				board[i][j] = ".";
			}
		}
		//.  : neutral
		//q  : queen
		//x  : queen attack path
		
		Random rdn = new Random();
		int firstX = rdn.nextInt(8);
		int firstY = rdn.nextInt(8);		//first queen location
		q--;
		
		for(int i=0;i<8;i++)	{			//mark queen attack path
			for(int j=0;j<8;j++)	{
				if(i==firstX || j==firstY)	
					board[i][j] = "x";
				if(Math.abs(firstX-i)==Math.abs(firstY-j))
					board[i][j] = "x";
			}
		}
		board[firstX][firstY] = "q";
		
		int X,Y;
		while(q>0)	{
			do	{
			X = rdn.nextInt(8);
			Y = rdn.nextInt(8);
			}	while(!isSafe(board, X, Y));				
			
			for(int i=0;i<8;i++)	{			
				for(int j=0;j<8;j++)	{
					if(i==X || j==Y)	
						board[i][j] = "x";
					if(Math.abs(X-i)==Math.abs(Y-j))
						board[i][j] = "x";
				}
			}
			board[X][Y] = "q";
			q--;
		}
		
		return board;
	}
			
	public static void main(String[] args) {
		String[][] board = pacifist(4);
		
		for(int i=0;i<8;i++)	{
			for(int j=0;j<8;j++)	{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
