import java.util.*;

public class MinRefuelingStops871 {
	/* finish conditions:
	 * 	start + (sum)stations[stop][1]>=tgt
	 *  start + (sum)stations[stop][1]>=stations[nextStop][0]
	 */
	
	/* need:
	 * method to calculate if a route is viable
	 * method to permute all routes and find best one
	 */
	
	/* finding best route:
	 * stop at all stops
	 * if fuel left when arriving at stop is greater than fuel gained at stop with the least fuel, remove said stop
	 * if unable to reach next stop/destination, add removed stop with the most fuel
	 * 
	 * also make sure the car can reach each stop
	 */
	
	
	static int minStops(int destDist, int start, int[][] stations)	{
		int currentFuel = start, stopped = 0;			//stopped is the number of stops made
		ArrayList<Integer> skipped = new ArrayList<>(), fuelSkipped = new ArrayList<>();		
				//skipped lists the index of skipped stops; fuelSkipped lists the fuel at these stops
		
		for(int i=0;i<stations.length-1;i++)	{		//skip the last stop to avoid exception
			if(currentFuel>=stations[i][0])	{		
				if(currentFuel>=stations[i+1][0])	{		//can make next stop; skip current stop
					skipped.add(i);
					fuelSkipped.add(stations[i][1]);
				}
			}
			else	{		//unable to reach next stop; retroactively refuel at skipped stop with the most fuel
				Collections.sort(fuelSkipped);
				int refuelIdx = fuelSkipped.size()-1;
				while(currentFuel<stations[i][0] & fuelSkipped.size()>0)	{
					currentFuel += fuelSkipped.get(refuelIdx);
					fuelSkipped.remove(refuelIdx);
					refuelIdx--;
					stopped++;
				}
				
				if(currentFuel<stations[i][0])	{
					System.out.println("Impossible to reach station " + i + ".");
					return -1;
				}
			}
		}
		
		//look at last stop and destination
		skipped.add(stations.length-1);
		fuelSkipped.add(stations[stations.length-1][1]);
		if(currentFuel>=destDist)	{		//enough fuel. done.
		}
		else	{		//unable to reach next stop; retroactively refuel at skipped stop with the most fuel
			Collections.sort(fuelSkipped);
			int refuelIdx = fuelSkipped.size()-1;
			while(currentFuel<destDist & fuelSkipped.size()>0)	{
				currentFuel += fuelSkipped.get(refuelIdx);
				fuelSkipped.remove(refuelIdx);
				refuelIdx--;
				stopped++;
			}
			
			if(currentFuel<destDist)	{
				System.out.println("Impossible to reach destination.");
				return -1;
			}
		}
		
		return stopped;
	}
	
	public static void main(String[] args) {
		int[][] stations = {{10,10}};
		
		System.out.println(minStops(100,1,stations));
	}
}






	/**
 * Determines if the car can reach the stop indicated by stopIdx, if it stops at all stops along the way.
 * @param stopIdx target stop to reach.
 * @param fuel starting fuel.
 * @param stations list of all stations and fuel at each station.
 * @return true if the car can reach the stop, false if not.
 */
/*
static boolean canReach(int stopIdx, int start, int[][] stations)	{
	int fuel = start;
	for(int i=0;i<stopIdx;i++)	{
		fuel += stations[i][1];
	}
	return fuel>=stations[stopIdx][0];	
}

static boolean canReachDest(int destDist, int fuel, int[][] stations)	{
	for(int i=0;i<stations.length;i++)	{
		fuel += stations[i][1];
	}
	return fuel>=destDist;	
}	*/