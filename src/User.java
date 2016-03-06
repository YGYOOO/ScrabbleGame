public class User 
{
	private String name = new String();
	public int score;
	private Tile tiles[] = new Tile[7];
	
	public User(String name1)
	{
		name=name1;
		score=0;
		for(int i=0;i<7;i++)
		{
			tiles[i]=null;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setScore(int score1)
	{
		score = score+score1;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setTile(Tile tile1,int i)
	{
		tiles[i]=tile1;
	}
	
	public Tile getTile(int i)
	{
		return tiles[i];
	}
}
