import java.util.*;

public class MapSumPairs677 {
	TreeMap<String, Integer> tm = new TreeMap<>();
	
	void insert(String key, int val)	{
		tm.put(key, val);
	}
	
	int sum(String pre)	{
		int sum = 0;
		TreeSet<String> keyset =(TreeSet<String>) tm.keySet();
		for(String k: keyset)	{
			if(k.startsWith(pre)) 	{
				sum += tm.get(k);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		

	}

}
