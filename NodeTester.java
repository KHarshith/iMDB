
import java.util.*;

import java.io.*;
public class NodeTester
{
    public static void main(String[] args)
    {
       
        String fileName = "/Users/harshith/eclipse-workspace/iMDB/data/actors.txt";
        BufferedReader reader;
        Actor headPntr = null;
        Actor currPntr = null;
        Actor actor = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while(line != null)
            {
                actor = new Actor(line);
                actor.next = headPntr;
                headPntr = actor;
                line = reader.readLine();
               
            }
            currPntr = headPntr;
            while (currPntr != null)
            {
                System.out.println(currPntr.toString());
                currPntr = currPntr.next;
            }
        }
        catch(IOException ex)
        {
        	ex.printStackTrace();
            System.out.println("Error");
        }
       
    }
}            
