
public class Relativistic {

	static double relKE(double mass, double vel)	{
		int c = 299_792_458;
		vel = vel*c;
		double gamma = Math.sqrt(1-vel*vel/c/c);
		gamma = 1/gamma;
		return gamma*mass*c*c;
	}
	
	public static void main(String[] args) {
		System.out.println(relKE(1.6726219E-27, .2));

	}

}
