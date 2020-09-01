import java.util.*;

public class ServerConnections1192 {
	static ArrayList<int[]> findCrits(int[][] connections)	{
		//find servers that occur once in connection list
		TreeMap<Integer, Integer> occurrences = new TreeMap<>();
		for(int[] connection : connections)	{
			for(int s : connection)	{
				//Integer server = s;
				Object get = occurrences.get(s);
				if(get==null)	{				//no mapping exists; create mapping
					occurrences.put(s, 1);
				}
				else	{
					occurrences.put(s, occurrences.get(s)+1);
				}
			}
		}
		
		ArrayList<int[]> critConnections  = new ArrayList<>();	
		critConnections.ensureCapacity(connections.length);
		
		for(int server : occurrences.keySet())	{
			if(occurrences.get(server)==1)	{			//server is critical
				for(int[] connection : connections)	{
					for(int s: connection)	{
						if(s==server)
							critConnections.add(connection);
					}
				}
			}
		}
		
		return critConnections;
	}
	
	public static void main(String[] args) {
		int[][] connections = {	{0,1},{1,2},{2,0},{1,3}	};
		ArrayList<int[]> critConnections = findCrits(connections);
		
		for(int[] critCon: critConnections)	{
			System.out.print("[ ");
			for(int conServer : critCon)	{
				System.out.print(conServer + ", ");
			}
			System.out.println("]");
		}
	}

}
