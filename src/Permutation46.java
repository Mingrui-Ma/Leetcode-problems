import java.util.*;

public class Permutation46 {
	/** 
     * permutation function 
     * @param str string to calculate permutation for 
     * @param l starting index 
     * @param r end index 
     */
    private void permute(String str, int l, int r)	{ 
        if (l == r) 
            System.out.println(str); 
        else
        { 
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                //str = swap(str,l,i); 
            } 
        } 
    } 
  
    /**
     * Swap Characters at position 
     * @param a string value 
     * @param i position 1 
     * @param j position 2 
     * @return swapped string 
     */
    public String swap(String a, int i, int j)	{ 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
		
	public static void main(String[] args) {
        String str = "ABC"; 
        int n = str.length(); 
        Permutation46 permutation = new Permutation46(); 
        permutation.permute(str, 1, 2); 		

	}

	/*
	static ArrayList<ArrayList<Integer>> permute(int[] src, int start, int end)	{
		//number at every index must occupy every index once 
		ArrayList<ArrayList<Integer>> permList = new ArrayList<>();
		
		while(start!=end)	{
			for(int i=start;i<=end;i++)	{
				ArrayList<Integer> perm = new ArrayList<>();
				
				permList.add(perm);
			}
		}
	}		*/
}
