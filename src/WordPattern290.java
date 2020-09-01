import java.util.*;

public class WordPattern290 {

	static boolean hasPattern(String words, String ptn)	{
		char[] wordCh;
		words.getChars(0, words.length(), (wordCh = new char[words.length()]), 0);
		ArrayList<Integer> spaceLoc = new ArrayList<>();
		//ArrayList<String> indWords =  new ArrayList<>();
		TreeMap<String, Character> patternMap = new TreeMap<>();
		int spaceCount = 0;
		char ch;
		for(int i=0;i<words.length();i++)	{
			ch = wordCh[i];	
			if(ch==' ')	{
				spaceCount++;
				spaceLoc.add(i);
			}
		}
		
		if(spaceCount+1 != ptn.length())		//tests if number of words match with number of letters in ptn
			return false;
		
		int wordStart = 0, nextBuf, j=0;
		String aWord;
		Iterator<Integer> itr = spaceLoc.iterator();
		while(itr.hasNext())	{
			nextBuf  = itr.next();
			aWord = words.substring(wordStart, nextBuf);
			//System.out.println("|" + aWord + "|");

			if(!patternMap.containsKey(aWord))			//adds map if map doesn't contain the key
				patternMap.put(aWord, ptn.charAt(j));
0
					/*
			Object get = patternMap.get(aWord);
				if(get==null)
					patternMap.put(aWord, ptn.charAt(j));
				else if((char) get!=ptn.charAt(j))
					return false;
				*/
			wordStart = nextBuf + 1;
			j++;		
		}
		aWord = words.substring(wordStart, words.length());			//add last word
		//System.out.println(aWord);
		Object get = patternMap.get(aWord);
		if(get==null)
			patternMap.put(aWord, ptn.charAt(j));
		else if((char) get!=ptn.charAt(j))
			return false;
		
		//System.out.println();
		System.out.println(patternMap);
		return true;
	}
	
	public static void main(String[] args) {
		String words = "recycle singlespace";
		String ptn = "aa";
		
		System.out.println(hasPattern(words,ptn));

	}

}
