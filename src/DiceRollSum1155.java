import java.util.*;



public class DiceRollSum1155 {

	static boolean canProceed(ArrayList<Integer> dl, int idx, int face)	{
		return(dl.get(idx)==face);
	}
	
	static boolean rightSum(ArrayList<Integer> dl, int tgt)	{
		int sum=0;
		for(int d:dl)
			sum+=d;
		return(sum==tgt);
	}
	
	
	static int rollTarget(int dice, int face, int tgt)	{
		if(face<4)	{
			System.out.println("impossible dice");
			return -1;
		}
		
		if(tgt<dice || tgt>dice*face)
			return 0;
		else	{
			ArrayList<Integer> diceList = new ArrayList<>();
			diceList.ensureCapacity(dice);
			for(int i=0;i<dice;i++)
				diceList.add(1);
			int count = 0;
			
			Iterator<Integer> itr = diceList.iterator();
			int idx=0;
			String comb;
			while(itr.hasNext())	{
				comb = "";
				diceList.set(idx, diceList.get(idx)+1);
				if(rightSum(diceList,tgt))	{
					for(int d:diceList)
						comb += d + "+";
					comb = comb.substring(0, comb.lastIndexOf('+'));
					System.out.println(comb);
					comb=
					count++;
				}
				if(canProceed(diceList, idx, face))	{
					itr.next();
					idx++;
				}		
			}
			return count;
		}
	}			
	
	
	
	
	static String makeLoopParam(int r)	{
		return "i"+r;
	}
	
	static boolean rightSum(int[] dl, int tgt)	{
		int sum=0;
		for(int d:dl)
			sum+=d;
		return(sum==tgt);
	}
	
	static int roll(int dice, int face, int tgt)	{
		int[] diceList = new int[dice];
		for(int i=0;i<dice;i++)	{
			diceList[i] = 1;
		}
		String comb = "";
		int d = 1, count=0;
		for(diceList[0]=1;diceList[0]<=face;diceList[0]++)	{
			while(d<dice)	{
				for(diceList[d]=1;diceList[d]<=face;diceList[d]++)	{
					if(rightSum(diceList, tgt))	{
						for(int die:diceList)
							comb += die + "+";
						comb = comb.substring(0, comb.lastIndexOf('+'));
						System.out.println(comb);
						count++;
					}
					d++;
					}
				}
			}
	return count;	
	}
	
	
	
	public static void main(String[] args) {
		rollTarget(2,6,10);

	}

}


/*
/* The main function that returns the number of ways to get sum 'x' with 'n' dice and 'm' with m faces. */
public static long findWays(int m, int n, int x){ 
      
/* Create a table to store the results of subproblems.  
One extra row and column are used for simplicity  
(Number of dice is directly used as row index and sum is directly used as column index).  
The entries in 0th row and 0th column are never used. */
long[][] table = new long[n+1][x+1]; 
      
/* Table entries for only one dice */
for(int j = 1; j <= m && j <= x; j++) 
            table[1][j] = 1; 
          
/* Fill rest of the entries in table using recursive relation  
i: number of dice, j: sum */
for(int i = 2; i <= n;i ++){  
            for(int j = 1; j <= x; j++){ 
                for(int k = 1; k < j && k <= m; k++) 
                    table[i][j] += table[i-1][j-k]; 
            } 
    } 
      
    /*
    for(int i = 0; i< n+1; i++){ 
        for(int j = 0; j< x+1; j++) 
            System.out.print(table[i][j] + " "); 
        System.out.println(); 
    } 	*/
      
    return table[n][x]; 
} 
  
// Driver Code 
public static void main (String[] args) { 
    System.out.println(findWays(4, 2, 8));  
   // System.out.println(findWays(2, 2, 3));  
   // System.out.println(findWays(6, 3, 8));  
   // System.out.println(findWays(4, 2, 5));  
   // System.out.println(findWays(4, 3, 5));  
} 
} */