import java.util.*;

class Dictionary	{
	TreeSet<String> dict = new TreeSet<>();
	String buf;
	
	void addWord(String word)	{
		dict.add(word);
	}
	
	Dictionary(String ...str)	{
		for(String word:str)
			dict.add(word);
	}
	
	boolean containsChars(String fragment)	{
		for(String word:dict)	{
			if(word.contains((CharSequence) fragment))	{
				buf = word;
				return true;
			}
		}
		return false;
	}
	
	boolean searchWord(String word)	{
		if(dict.contains(word))
			return true;
		else if(word.contains((CharSequence) "*"))	{
			//remove *'s from argument
			String newWord = "";
			int asterikCount = 0;
			for(int i=0;i<word.length();i++)	{
				if(word.charAt(i) != '*')
					newWord += word.charAt(i);
				else
					asterikCount++;
			}
			//doesn't work if *'s in the middle of word
			return (containsChars(newWord) & (newWord.length()+asterikCount==buf.length()));
		}
		else
			return false;
	}
}

public class DictionarySearch {
	
	public static void main(String[] args) {
		Dictionary myDict = new Dictionary("bad", "sad", "apple","adventure","subset");
		
		System.out.println(myDict.searchWord("*a"));

	}

}
