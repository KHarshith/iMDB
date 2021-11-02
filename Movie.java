

public class Movie {
	int date;
    String title;
    MyLinkedList<Actor> listOfActors;
    MyLinkedList<String> listOfDirectors;
    public Movie()
    {
        date = 0;
        title = "";
        listOfActors = null;
        listOfDirectors = null;
    }
    public Movie(int date, String title, MyLinkedList actors, MyLinkedList directors)
    {
        this.date = date;
        this.title = title;
        this.listOfActors = actors;
        this.listOfDirectors = directors;
    }
    public int getDate()
    {
        return this.date;
    }
    public void setDate(int date)
    {
        this.date = date;
    }
    public String getTitle()
    {
        return this.title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public MyLinkedList getActors()
    {
        return this.listOfActors;
    }
    public void setActors(MyLinkedList<Actor> actors)
    {
        this.listOfActors = actors;
    }
    public MyLinkedList getDirectors()
    {
        return this.listOfDirectors;
    }
    public void setDirectors(MyLinkedList<String> directors)
    {
        this.listOfDirectors = directors;
    }
    public String toString()
    {
        String s = date + " " + title + "\n" + "  Actors:" + "\n" + listOfActors.toString() + "  Directors: " + "\n" + listOfDirectors.toString();
        return s;
    }
   

}
