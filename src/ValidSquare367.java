
public class ValidSquare367 {
	static boolean isSquare(int num)	{
		int root = 1, square = 1;
		while(square<=num)	{
			if(num==square) 
				return true;
			else	{
				root++;
				square = root*root;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isSquare(122));

	}

}
