import java.util.*;

public class SimplifiedFractions1447 {

	static String[] listFractions(int n)	{
		ArrayList<String> fractionList = new ArrayList<>();
		fractionList.ensureCapacity(n*n);
		String f = "";
		
		for(int denom=2;denom<=n;denom++)	{
			for(int nom=1;nom<denom;nom++)	{
				f += String.valueOf(nom);
				f += "/";
				f += String.valueOf(denom);
				fractionList.add(f);
				f = "";
			}
		}
		
		String[] fractionArr = new String[fractionList.size()];
		int i = 0;
		for(String s: fractionList)	{
			fractionArr[i++] = s; 
		}
		return fractionArr;
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] fractionAr = listFractions(4);
		
		for(String s:fractionAr)	{
			System.out.print(s + " ");
		}
	}
}
