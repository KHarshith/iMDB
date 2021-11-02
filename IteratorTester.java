import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class IteratorTester {
	public static void main(String []Agrs) throws FileNotFoundException
	{
		MyLinkedList<Actor> myList = new MyLinkedList<Actor>();
		File file = new File("/Users/harshith/eclipse-workspace/iMDB/data/actors9.txt");
		Scanner console = new Scanner(file);
		for (int i = 0; i < 10; i++)
		{
			String actorName = console.nextLine();
			Actor actor = new Actor(actorName);
			myList.addLast(actor);
		}
		
		//Part 2
		System.out.println(myList.getSize());
		Iterator<Actor> it = myList.iterator();
		while(it.hasNext())
		 System.out.println(it.next());
		
		//Part 3
		
		String actorName = console.nextLine();
		Actor actor = new Actor(actorName);
		it = myList.iterator();
		while(it.hasNext())
		{
			Actor actorFromList = (Actor)it.next();
			if(actorFromList.getName().contentEquals(actor.getName()))
			{
				it.remove();
			}
			
		}
		//Part4
		System.out.println(myList.getSize());
		for(Object a : myList)
			 System.out.println(a);
	}

}
