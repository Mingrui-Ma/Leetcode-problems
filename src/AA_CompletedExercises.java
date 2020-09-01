import java.util.*;
import java.io.*;

public class AA_CompletedExercises {
	
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Input completed problem numbers, input \"-1\" when done:");
		String probs = "";
		int nex;
		while((nex = sc.nextInt()) != -1)	{
			probs += nex;
			probs += " ";
		}
		sc.close();				*/
		
		String source = "C:\\Users\\Mmyro\\eclipse-workspace\\LeetExercises\\bin";
		File src = new File(source);
		String[] files = src.list();
		
		ArrayList<String> fileNums = new ArrayList<>();
		fileNums.ensureCapacity(files.length);
		String num;
		
		for(String s:files)	{
			num = "";
			for(int i=0;i<s.length()-6;i++)	{
				if(s.charAt(i)>=48 & s.charAt(i)<=57)
					num+=s.charAt(i);
			}
			if(num.length()!=0)
				fileNums.add(num);
		}		
		
		String probNumsTxt = "C:\\Users\\Mmyro\\eclipse-workspace\\LeetExercises\\bin\\prob nums.txt";
		num = "";
		
		/*
		try(FileInputStream txt = new FileInputStream(probNumsTxt))	{
			for(int i=0;i<txt.available();i++)	{
				int readChar = txt.read();
				switch(readChar)	{
				case(10):
				case(13):
				case(32):
					fileNums.add(num);
					num = "";
					break;
				default:
					num+=(char) readChar;
					break;
				}
			}
		}	catch(IOException e)	{
			System.out.println("IO error with .txt.");
		}	*/
		
		try(FileOutputStream outTxt = new FileOutputStream(probNumsTxt))	{
			byte[] buf;
			for(String n:fileNums)	{
				buf = n.getBytes();
				outTxt.write(buf);
				outTxt.write(32);
			}
		}	catch(IOException e)	{
			System.out.println("IO error with writing.");
		}
	}
}