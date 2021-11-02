import java.util.*;
import java.io.*;
public class MovieTester
{
    public static void main(String[] args)
    {
       
        String file = "actors8.txt";
        BufferedReader reader;
       
        try
        {
            MyLinkedList<Movie> lstMovies = new MyLinkedList<Movie>();
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int cnt = 1;
            while(cnt <= 10)
            {
                int date = Integer.parseInt(line.substring(0,4));
                String title = line.substring(5,38);
                title = title.trim();
                String strActors = line.substring(38,84);
                strActors = strActors.trim();
                String[] arrActors = strActors.split(",");
                //Build the List of Actors
                MyLinkedList<Actor> lstActors = new MyLinkedList<Actor>();
                for(int i = 0;i < arrActors.length;i++)
                {
                    arrActors[i] = "    " + arrActors[i].trim();
                    Actor actor = new Actor(arrActors[i]);
                    lstActors.addLast(actor);
                }
                //Build the List of Directors
                String strDirectors = line.substring(89);
                strDirectors = strDirectors.trim();
                String[] arrDirectors = strDirectors.split(",");
                MyLinkedList<String> lstDirectors = new MyLinkedList<String>();
                for(int i = 0;i < arrDirectors.length;i++)
                {
                    arrDirectors[i] = "    " + arrDirectors[i].trim();
                    lstDirectors.addLast(arrDirectors[i]);
                }
                Movie movie = null;
                if(cnt <= 5)
                {
                    movie = new Movie();
                    movie.setDate(date);
                    movie.setTitle(title);
                    movie.setActors(lstActors);
                    movie.setDirectors(lstDirectors);
                }
                else
                {
                    movie = new Movie(date, title, lstActors, lstDirectors);
                }
                lstMovies.addFirst(movie);
                line = reader.readLine();              
                cnt++;
           }
            //Size
            System.out.println(lstMovies.getSize());
            //Read two Movie Indexes
            int ind = Integer.parseInt(line);
            Movie movie1 = lstMovies.get(ind);
            System.out.println(movie1.toString());
            line = reader.readLine();
            int ind2 = Integer.parseInt(line);
            Movie movie2 = lstMovies.get(ind2);
            System.out.println(movie2.toString());
           
                System.out.println(lstMovies.get(ind).title + " has " + lstMovies.get(ind).getActors().getSize() + " major actors");
           
               
           
                System.out.println(lstMovies.get(ind2).title + " has " + lstMovies.get(ind2).getDirectors().getSize() + " directors");
           

           
           
        }
        catch(IOException ex)
        {
            System.out.println("");
        }
    }
   
}