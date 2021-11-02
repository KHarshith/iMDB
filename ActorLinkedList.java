import java.util.*;

public class ActorLinkedList {
	private Actor head;
	private int count;
	public ActorLinkedList()
	{
		head = null;
		count = 0;
	}
	public void addFirst(Actor nextActor)
	{
		if(count != 0)
		{
			nextActor.setNextPtr(head);
			
		}
		head = nextActor;
		count++;
	}
	public Actor get(int index)
	{
		if (index > count)
		{
			throw new IndexOutOfBoundsException();
		}
		
		Actor nextVariable = head;
		for(int i = 0; i < index;i++ )
		{
			nextVariable = nextVariable.next;
		}
		
		return nextVariable;
	}
	public int size()
	{
		return count;
	}
	public String toString()
	{
		String actorList = "";
		Actor current = head;
        while (current != null)
        {
            actorList = actorList + " " +current.toString();
            current = current.next;
        }
        return actorList;
	}

}
