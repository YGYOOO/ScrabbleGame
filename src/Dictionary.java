import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;


public class Dictionary 
{
	private ArrayList<String> words = new ArrayList<String>();
	public Dictionary() throws FileNotFoundException
	{
		FileReader reader2 = new FileReader("wordList");
		Scanner in2 = new Scanner(reader2);
		
		while(in2.hasNextLine())
		{
		    words.add(in2.nextLine());
		}
			
		in2.close();
	}
	
	public boolean confirm(String word)
	   {
		  word = word.toLowerCase();
	      int index = 0, maximum = words.size(), first = 0;
	      
		  index = (words.size())/2;
		  
	      while(true)
	      {
			if(words.get(index).compareTo(word)>0)
			  {
				  maximum = index;
			      index = index/2;  
			  }
			else
			   if(words.get(index).compareTo(word)<0)
				 {
					first = index+1;
					index = ((index+maximum)/2);
				 }
			  else
				if(words.get(index).equals(word))
			       return true;
			if(first>=maximum)
			{
			   return false;
			}
		  }
	   }
	   
	   public ArrayList<String> getWords()
	   {
			return words;
	   }
}