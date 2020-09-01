//(not on leet)
import java.util.*;

public class CardShuffle {

	void shuffle(String[] deck, int timesShuffled)	{
		int len = deck.length;				
		Random rdn = new Random();
		int InitPos, ToPos;
		for(int i=0;i<timesShuffled;i++)	{
			InitPos = rdn.nextInt(len);
			String ShuffledCard = deck[InitPos];
			do	{
			ToPos = rdn.nextInt(len);
			} while(ToPos == InitPos);
			
			if(ToPos > InitPos)	{				//shuffle backwards: interim cards move forward 
				//move cards from InitPos+1 to ToPos
				for(int j=InitPos+1;j<=ToPos;j++)	
					deck[j-1] = deck[j];
			}
			else if(ToPos < InitPos)	{		//shuffle forwards: interim cards move backward
				//move cards from ToPos to InitPos-1
				for(int j=InitPos;j>ToPos;j--)	
					deck[j] = deck[j-1];			
			}
			deck[ToPos] = ShuffledCard;
		}
	}
	
	public static void main(String[] args) {
		String[] deck = new String[13];
		for(int i=0;i<13;i++)	{
			deck[i] = String.valueOf(i+1);
		}
		deck[0] = "Ace";
		deck[10] = "Jack";
		deck[11] = "Queen";
		deck[12] = "King";
		
		CardShuffle shuffler = new CardShuffle();
		shuffler.shuffle(deck,1);
		for(int i=0;i<deck.length;i++)	{
			System.out.print(deck[i] + " ");
		}
	}

}
