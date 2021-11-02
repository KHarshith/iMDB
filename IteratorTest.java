
import java.util.*;

public class IteratorTest {
	public static void main(String [] Agrs)
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Harshith");
		names.add("Raju");
		names.add("John");
		names.add("Josh");
		names.add("Anish");
		for(int i =0; i< names.size(); i++)
		{
			System.out.println(names.get(i));
		}
		
		System.out.println ("Through iterator");
		java.util.Iterator<String> iter = names.iterator();
		while (iter.hasNext())
		{
			String name = iter.next();
			System.out.println(name);
			if (name.equals("John"))
				iter.remove();
		}
		
		System.out.println(names);
		
	}

}
