import java.util.*;

class Time	{
	int hour;
	int minute;
	
	Time(int h, int m)	{
		this.hour = h;
		this.minute = m;
	}
}

public class MinTimeDiff539 {
	static boolean isDigit(char c)	{
		return (c>=48 & c<=57);
	}
	
	static Time convertToTime(String s)	{
		char[] sAr = s.toCharArray();
		boolean hasColon = false;
		String h = "", m = "";
		
		for(char ch:sAr)	{
			if(hasColon & !isDigit(ch))
				return new Time(-1,-1);
			else	{
				 if(ch==':')
					 hasColon = true;
				 if(isDigit(ch) & !hasColon)
					 h += ch;
				 if(isDigit(ch) & hasColon)
				 	m += ch;
			}
		}
		if(!hasColon)
			return new Time(-1,-1);
		
		int hr =  Integer.parseInt(h), min = Integer.parseInt(m);
		if(hr<0 || hr>23 || min<0 || min>59)
			return new Time(-1,-1);
		
		System.out.println(hr + ":" + min);
		return new Time(hr,min);
	}
	
	static int calcDelta(Time time1, Time time2)	{		//return time difference in minutes
		int hrDelta = Math.abs(time1.hour - time2.hour);
		int minDelta = time1.hour>time2.hour ? time1.minute-time2.minute : time2.minute-time1.minute;
		if(minDelta<0)	{
			hrDelta--;
			minDelta+=60;
		}
		//System.out.println(hrDelta + ":" + minDelta);
		return hrDelta*60 + minDelta;
	}
	
	
	static int minTimeDiff(ArrayList<String> times)	{
		ArrayList<Time> timeList = new ArrayList<>();
		timeList.ensureCapacity(times.size());
		ArrayList<Integer> deltaList = new ArrayList<>();
		deltaList.ensureCapacity(times.size()*(times.size()-1));
		
		for(String t:times)	{
			Time oneT = convertToTime(t);
			if(oneT.hour!=-1)
				timeList.add(oneT);
		}
		
		for(int i=0;i<timeList.size()-1;i++)	{
			for(int j=i+1;j<timeList.size();j++)	{
				int deltaT = calcDelta(timeList.get(i), timeList.get(j));
				deltaList.add(deltaT);
			}	
		}
		
		return Collections.min(deltaList);
	}
	
	public static void main(String[] args) {
		ArrayList<String> someTimes = new ArrayList<>();
		someTimes.add("20:00");
		someTimes.add("22:51");
		someTimes.add("8:18");
		someTimes.add("24:00");
		someTimes.add("23:59");
		someTimes.add("20:20");
		someTimes.add("1:40");
		someTimes.add("9:00");
		
		System.out.println(minTimeDiff(someTimes));		
		//String s1 = "21:00", s2 = "20:30";
		//System.out.println(calcDelta(convertToTime(s1), convertToTime(s2)));

	}

}
