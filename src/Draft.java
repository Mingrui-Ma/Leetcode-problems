import java.util.*; 
import java.io.*; 
  
class Draft {
	static double trimZeros(double d)	{
		String s = String.valueOf(d);
		while(s.startsWith("0"))
			s.replaceFirst("0*", "");
		if(s.endsWith(".0"))
			s = s.substring(0, s.lastIndexOf('.'));
		double dTrimmed = Double.parseDouble(s);
		return dTrimmed;
	}
	
    public static void main (String[] args) {
    	ArrayList<Integer> al = new ArrayList<>();
    	al.add(1);
    	al.add(2);
    	al.add(4);
    	
    	int s = 123456789123456;
    	System.out.println(s);
    } 
}