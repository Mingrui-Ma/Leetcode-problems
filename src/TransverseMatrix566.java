
public class TransverseMatrix566 {
		
	static int nextElement(int[][] mtx, int count)	{
		int row = mtx.length;
		int col = mtx[0].length;
		int r =  count/col;
		int c = count%col ;
		//System.out.println("r = " + r + "; c = " + c + "; row = "+ row + "; col = " + col);
		if(col-1==c)		{
			if(r!=row-1)
				return mtx[r+1][0];
			else
				return mtx[0][0];
		}
		else 
			return mtx[r][c+1];
	}
	
	static int[][] reshape(int[][] mtx, int r, int c)	{
		int row = mtx.length;
		int col = mtx[0].length;
		if(row*col != r*c)	{
			System.out.println("Impossible to reshape into given shape.");
			return mtx;
		}
		int[][] returnMtx = new int[r][c];
		int count = 0;
		for(int i=0;i<r;i++)	{
			for(int j=0;j<c;j++)	{
				if(i==0 & j==0)
					returnMtx[0][0] = mtx[0][0];
				else	{
				returnMtx[i][j] = nextElement(mtx, count);
				count++;
				}
			}
		}
		return returnMtx;
	}
		
	public static void main(String[] args) {
		int[][] nums = 	{	{1,2},
							{3,4},
							{5,6}	};
		
				
		//System.out.println(nextElement(nums, 5));
		
		int[][] nums2 = reshape(nums, 3,2);
		for(int i=0;i<3;i++)	{
			for(int j=0;j<2;j++)	{
				System.out.print(nums2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
