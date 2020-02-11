/**class LinkedList - resembles the java API linked list
 * 
 * @author Jorden Hodges
 *
 */
import java.util.*;

public class LinkedList {
	public ListIterator listIterator()
	{
		return new LinkedListIterator();
	}
	
	class LinkedListIterator implements ListIterator
	{
		private Node position;
		private Node previous;
		private boolean isAfterNext;
		
		public LinkedListIterator()
		{
			position = null;
			previous = null;
			isAfterNext = false;
		}
		
		public Object next()
		{
			if (!hasNext()) {throw new NoSuchElementException();}
			previous = position;
			isAfterNext = true;
			if(position == null)
				position = first;
			else
				position = position.next;
			return position.data;
		}
		
		public boolean hasNext()
		{
			if(position == null)
				return first != null;
			else
				return position.next != null;
		}
		
		public void remove()
		{
			if (!isAfterNext) {throw new IllegalStateException();}
			
			if(position == first)
				removeFirst();
			else
				previous.next = position.next;
			
			position = previous;
			isAfterNext = false;
			size--;
		}
		
		public void add(Object element)
		{
			if(position == null)
			{
				addFirst(element);
				position = first;
			}
			else
			{
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			isAfterNext = false;
			size++;
		}
		
		public Object previous()
		{
			return new Object();
		}
		
		public boolean hasPrevious() //abstract method that needs to be implemented according to eclipse 
		{
			return true;
		}
		public void set(Object o)//abstract method that needs to be implemented according to eclipse
		{
			
		}
		
		public int previousIndex() //abstract method that needs to be implemented according to eclipse
		{
			return 0;
		}
		
		public int nextIndex() //abstract method that needs to be implemented according to eclipse
		{
			return 0;
		}
	}
	
	private class Node
	{
		public Object data;
		public Node next;
	}
	private Node first;
	private int size;
	public LinkedList()
	{
		first = null;
		size = 0;
	}
	
	/**
	 * getFirst - gets the first node unless it is empty
	 * @return first node
	 */
	public Object getFirst()
	{
		if (first==null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	/**
	 * add - adds a node to a specific position
	 * @param element - data for the new node
	 * @param position - position of where it is being added
	 */
	public void add(Object element)
	{
		
		Node previous = new Node();
		Node next = new Node();
		if(first == null)
			addFirst(element);
		else if(first.next == null)
		{
			first.next = new Node();
			first.next.data = element;
		}
		previous = first;
		next = previous.next;
		else
		{
			while(next != null)
			{
				if(previous.data.compareTo(element) > 0)
				previous = previous.next;
				next = next.next;
			}
			size++;
		}
		
	}
	

	
	/**
	 * addFirst - adds a node as the first element
	 * @param obj - data for the node
	 */
	public void addFirst(Object obj)
	{
		Node newNode = new Node();
		newNode.data = obj;
		newNode.next = first;
		first = newNode;
		size++;
	}
	
	/**
	 * removeFirst - removes the first node
	 * @return data from the node
	 */
	public Object removeFirst()
	{
		if(first==null)
			throw new NoSuchElementException();
		Object obj = first.data;
		first = first.next;
		size--;
		return obj;
	}
	
	/**
	 * findNode - finds node based on its object
	 * @param position - position the node is in
	 * @return node
	 */
	public Object findNode(Object data)
	{
		Node current = first;
		for(int i = 1; i < size; i ++)
		{
			current = current.next;
			if(current.data == data)
				break;
		}
		return current.data;
	}
	
	/**
	 * removeLast - removes the last node
	 * @return data from the last node
	 */
	public Object removeLast()
	{
		Node last = new Node();
		boolean found = false;
		Node previous = new Node();
		while (last.next != null)
		{
			last = last.next;
		}
		while (!found)
		{
			if (previous.next == last)
			{
				found = true;
				previous.next = null;
			}
		}
		size--;
		return last.data;
	}
	
	/**
	 * addLast - adds the last Node
	 * @param data - data to go into the node
	 * @return none
	 */
	public void addLast(Object element)
	{
		Node temp = new Node();
		Node newNode = new Node();
		newNode.next = null;
		newNode.data = element;
		temp = first;
		boolean done = false;
		while(!done)
		{
			if(temp.next == null)
			{
				done = true;
				temp.next = newNode;
				size++;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * remove - removes a node from the list
	 * @param position - position of node being removed
	 * @return data - data of the Node
	 */
	public Object remove (Object data)
	{
		Node current = new Node();
		Node previous = new Node();
		Node temp = new Node();
		if(first == null)
			throw new NoSuchElementException();
		current = findNode(data);
		temp = first;
		while(temp.next != null)
		{
			if(temp.next == current)
				previous = temp;
			temp = temp.next;
		}
		previous.next = current.next;
		size--;
		return current.data;
	}
	
	/**
	 * toString - returns data of list in a String
	 * @param none
	 * @return String of data
	 */
	public String toString()
	{
		String s = "";
		Node currentNode = first;
		while(currentNode != null)
		{
			s = s + " " + "Data: " + currentNode.data + "\n";
			currentNode = currentNode.next;
		}
		return s;
	}
	
	/**
	 * reverse - reverses the Linked List
	 * @pram none
	 * @return reversed linked list
	 */
	public Object reverse()
	{
		LinkedList reverse = new LinkedList();
		Node current = new Node();
		current = first;
		if(first == null || first.next == null)
		{
			return first;
		}
		
		while(current != null)
		{
			Node temp = current;
			current = current.next;
			
			temp.next = reverse.first;
			reverse.first = temp;
		}
		return reverse;
	}
	
	/**
	 * size - returns size of list
	 * @param none
	 * @return number of elements
	 */
	public int size()
	{
		return size;
	}
	
	
	
}
