
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by LinkedListElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue {

	//TODO:  You need some data to store the queue.  Put the attributes here.
private QueueElement next;
private Object element;
private QueueElement head;
private QueueElement temp;
private QueueElement tail;
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		head = null;
		tail = null;		
	}
	
	/**
	 * Returns true if the queue is empty, false if otherwise
	 */
	public boolean isEmpty () {
		if ((head==null)&&(tail==null)){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Returns the element at the head of the queue
	 */
	public Object peek () throws NoSuchElementException {
		
		try {
			return head.getElement();
		} catch (NullPointerException e) {
			//System.out.println("The list is empty");
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
	    //get front item
		try {
			head = head.getNext();
		} catch (NullPointerException e) {
			throw new NoSuchElementException();
		}
		if (head == null) {
			tail = null; //queue is empty
		}		
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (Object element) {
	    //Add to back of queue
		QueueElement newNode = new QueueElement(element, null); 
		if (head == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		try {
			temp = head;
			while (temp.getNext() != null) {
				System.out.println(temp.getElement().toString());
				temp = temp.getNext();

			}
		}catch (NullPointerException e){
			
		}
	}
}
