import java.util.HashSet;

public class Main 
{
	private HashSet<Tile> tiles;
	
	public Main()
	{
		tiles = new HashSet<Tile>();
		initial();
	}

	public void initial()
	{
		String letter[]=      {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",""};
		int scoreOfLetter[] = { 1 , 3 , 3 , 2 , 1 , 4 , 2 , 4 , 1 , 8 , 5 , 1 , 3 , 1 , 1 , 3 , 10, 1 , 1 , 1 , 1 , 4 , 4 , 8 , 4 , 10, 0};
		int numberOfLetter[] ={ 9 , 2 , 2 , 4 , 12, 2 , 3 , 2 , 9 , 1 , 1 , 4 , 2 , 6 , 8 , 2 , 1 , 6 , 4 , 6 , 4 , 2 , 2 , 1 , 2 , 1 , 1};
		for(int i=0;i<numberOfLetter.length;i++)
		{
			initialALetter(letter[i],scoreOfLetter[i],numberOfLetter[i]);
		}
	}
	
	public void initialALetter(String letter, int score, int count)
	{
		for(int i=0;i<count;i++)
		{
			tiles.add(new Tile(letter,score));
		}
	}
	
	public HashSet<Tile> getAllLetters()
	{
		return tiles;
	}
	
//	public static void main(String args[])
//	{
//		Main m = new Main();
//	}
}
