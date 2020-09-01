import java.util.*;
public class DayOfWeek1185 {

	static String getDay(int day, int month, int year)	{
		if(year<1970)	{
			System.out.println("Error: must input time later than Jan 1 1970.");
			return "error";
		}
		return "1";
	}
	
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar(2020,7,22);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayofweek);
		System.out.println(cal.getFirstDayOfWeek());
	}
}