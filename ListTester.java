
import java.io.*;
import java.util.*;
public class ListTester {
	public static void main(String [] agrs) throws FileNotFoundException
	{
		
		/*//Part 1
		File file = new File("/Users/harshith/eclipse-workspace/iMDB/data/actors3.txt");
		Scanner console = new Scanner(file);
		int noOfActors = console.nextInt();;
		ActorLinkedList actorNames = new ActorLinkedList();
		console.nextLine();
		for(int i = 0; i < noOfActors; i++)
		{
			String name = console.nextLine();
			//System.out.println ("Name: " +name);
			Actor actor = new Actor(name);
			actorNames.addFirst(actor);
		}
		
		//Part 2
		System.out.println( actorNames.size());
		System.out.println(actorNames.toString());
		System.out.println("");
		
		//Part3
		for(int j = 0; j < 3; j++)
		{
			int actorNumber = console.nextInt();
			Actor currentActor = actorNames.get(actorNumber);
			System.out.println(currentActor.toString());
			
		}*/
		
		//Actor 7 
		//Part 1
		File file = new File("/Users/harshith/eclipse-workspace/iMDB/data/actors7.txt");
		Scanner console = new Scanner(file);
		MyLinkedList actorList = new MyLinkedList();
		for (int i =0; i < 4; i++)
		{
			String actorName = console.nextLine();
			Actor actor = new Actor( actorName);
			actorList.addFirst(actor);
			actorName = console.nextLine();
			actor = new Actor (actorName);
			actorList.addLast(actor);
			
			
		}
		//System.out.println(" All actors are added to the linked list" +" " + actorList);
		//Part2
		System.out.println( actorList.getSize());
		System.out.println(actorList.toString());
		
		//part3
		for(int j = 0; j< 2; j++)
		{	
			int indexToAdd = console.nextInt();
			console.nextLine();
			String actorName = console.nextLine();
			//System.out.println("The index to add is " + indexToAdd);
			//System.out.println("The actor's name is : " + actorName);
			
			Actor actor = new Actor(actorName);
			actorList.add(indexToAdd,actorName);
			
		//	System.out.println(actorList.toString());
			int indexToRemove = console.nextInt();
			
			//System.out.println("The index to remove is: " + indexToRemove);
			actorList.remove(indexToRemove);
			//System.out.println(actorList.toString());
			
		}	
		System.out.println(  actorList.getSize());
		System.out.println(actorList.toString());
	}

}
