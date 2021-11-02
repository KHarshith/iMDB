import java.util.*;
import java.io.*;
public class MyLinkedList<T> implements Iterable
{
    private Node<T> head;
    private int count;
    private Node<T> tail;
   
    public MyLinkedList()
    {
        head = null;
        count = 0;
        tail = null;
    }
    public void addFirst(T obj)
    {
        Node<T> node = new Node(obj);
        if(count == 0)
        {
            tail = node;
        }
        node.next = head;
        head = node;
        count++;
    }
    public void addLast(T obj)
    {
        Node<T> node = new Node(obj);
        if (count == 0)
        {
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        node.next = null;
        count++;
       
    }
       
    public void add(int index, T data)
    {
        if(index > this.count || index < 0)
        {
            throw new IndexOutOfBoundsException("You cannot insert here");
        }
        else
        {
            Node node = new Node(data);
            int cnt = 0;
            Node currPoint = head;
            while(cnt < index - 1)
            {
                currPoint = currPoint.next;
                cnt++;
            }
          
        
            
            
            if(index == 0)
            {
            	node.next = currPoint;
                //node.next = head;
                head = node;
            }else if(index == count)
            {
            	currPoint.next = node;
                //node.next = null;
                //tail.next = node;
                tail = node;
            }
            else
            {
            	node.next = currPoint.next;
            	currPoint.next = node;
            }
            
            count++;
        }
    }
    public T remove(int index)
    {
        if(index >= count || index < 0)
        {
            throw new IndexOutOfBoundsException("You cannot insert here");
        }
       
        Node<T> removed = null;
        if(index == 0)
        {
            removed = head;
            Node n = head.next;
            head = n;          
        }
        else
        {
            Node currPoint = head;
            int cnt = 0;
            while(cnt < index - 1)
            {
                currPoint = currPoint.next;
                cnt++;
            }
            removed = currPoint.next;
           // System.out.println("The elemnt removed is " + removed);
           // System.out.println("The indeex is " + index);
            currPoint.next = removed.next;
            //currPoint.next = currPoint.next.next;
        }
        count--;
        return removed.data;
     
    }
   
    public T removeFirst()
    {
 
        if (head == null)
        {
            throw new NoSuchElementException();
        }
        Node<T> firstNode = head;
       
        if (head.next != null)
        {
            head = head.next;
        }
        count--;
        return firstNode.data;
       
    }
   
    public void clear()
    {
        head = null;
        tail = null;
        count = 0;
    }
   
    public T get(int ind)
    {

        if(ind < 0 || ind >= count)
        {
            throw new IndexOutOfBoundsException();
        }
       
        Node<T> currPoint = head;
        int i = 1;
        while(currPoint != null && i <= ind)
        {
            currPoint = currPoint.next;
            i++;
        }
        return currPoint.data;
    }
    public int getSize()
    {
        return count;
    }
    public String toString()
    {
      Node<T> currPntr = head;
      String s = "";
      while (currPntr != null)
      {
           s =  s + currPntr.toString() + "\n";
           currPntr = currPntr.next;
      }
      return s;
    }
    private class Node<T>
    {
       public T data;
       public Node<T> next;
       public Node()
       {
            this.next = null;
            this.data = null;
       }
       public Node(T data)
       {
           this.data = data;
           this.next = null;
       }
       public String toString()
       {
           String s = this.data.toString() + "";
           return s;
       }
       
    }
    private class MyIterator implements Iterator<T>
    {
    	private Node<T> nextItem;
    	private Node<T> previousItem;
    	private Node<T> itemBeforePrevious ;
    	public MyIterator()
    	{
    		
    		nextItem = head;
    		previousItem = null;
    	}

		@Override
		public boolean hasNext() {
			if(nextItem != null)
			{
				return true;
			}
			
			return false;
		}


		@Override
		public T next() {
			T returnValue = nextItem.data;
			itemBeforePrevious = previousItem;
			previousItem = nextItem;
			nextItem = nextItem.next;
			return returnValue;
		}
		public void remove()
		{
			//Removing the first item
			if(itemBeforePrevious == null)
			{
				head = nextItem;
				count--;
			}
			//removing the last item
			else if (nextItem == null)
			{
				previousItem.next = null;
				count--;
			}
			//Removing the middle items
			else
			{
				itemBeforePrevious.next = nextItem;
				count--;
			}
				
			
			
		}
		
    }
	
	public Iterator<T> iterator() {
		MyIterator iterator = new MyIterator();
		return iterator;
	}
}