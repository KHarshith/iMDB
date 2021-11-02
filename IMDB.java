
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class IMDB {
	public static void main(String [] Agrs) throws FileNotFoundException
	{
		//Actors liked list
		MyLinkedList<Actor> myList = new MyLinkedList<Actor>();
		File file = new File("/Users/harshith/eclipse-workspace/iMDB/data/actors10.txt");
		Scanner console = new Scanner(file);
		for (int i = 0; i < 13; i++)
		{
			String actorName = console.nextLine();
			Actor actor = new Actor(actorName.trim());
			myList.addLast(actor);
			//System.out.println ("Created actor: " + actor);
		}
		// movies linked list
		MyLinkedList<Movie> movieList = new MyLinkedList<Movie>();
		 file = new File("/Users/harshith/eclipse-workspace/iMDB/data/movies10.txt");
	     console = new Scanner(file);
		for (int i = 0; i < 49; i++)
		{
			String movieLine = console.nextLine();
			String movieYear = movieLine.substring(0, 4);
			String movieName = movieLine.substring(5, 36);
			String movieActors = movieLine.substring(38, 84);
			String movieDirector = movieLine.substring(89);
			
			String [] actorNames = movieActors.split(", ");
			
			String [] directorNames = movieDirector.split(", ");
			MyLinkedList<Actor> movieActorList = new MyLinkedList<Actor>();
			for(int j = 0; j < actorNames.length; j++)
			{
				String movieActorName = actorNames[j];
				Actor movieActor = new Actor(movieActorName.trim());
				movieActorList.addLast(movieActor);
			}
			MyLinkedList<String> movieDirectors = new MyLinkedList<String>();
			for(int j = 0; j < directorNames.length; j++)
			{
				String movieDirectorName = directorNames[j];
				movieDirectors.addLast(movieDirectorName.trim());
			}
			int year = Integer.parseInt(movieYear);
			Movie movie = new Movie(year, movieName, movieActorList, movieDirectors);
			movieList.addLast(movie);
			//System.out.println("Created movie: " + movie);
		}
		
		//Actor itertor
		Iterator<Actor> it = myList.iterator();
		while(it.hasNext())
		{
			Actor actor = it.next();
			 System.out.println(actor);
			 Iterator<Movie> movieIterator = movieList.iterator();
			 while(movieIterator.hasNext())
			 {
				 Movie movie = movieIterator.next();
				 MyLinkedList<Actor> movieActorList = movie.getActors();
				 Iterator<Actor> movieActorIterator = movieActorList.iterator();
				 //System.out.println(movie);
				 while(movieActorIterator.hasNext())
				 {
					 Actor movieActor = movieActorIterator.next();
					 if(actor.getName().equals(movieActor.getName()))
					 {
						 System.out.println(movie.getDate() + " " + movie.getTitle());
					 }
					 
				 }
			 }
		}
		
		
		
	}
	

}
