
/**
 * You must use this class when constructing your Queue.  This class represents a link of the
 * linked list.  Your queue will be composed of these links.
 * @author archam
 *
 */
public class QueueElement {
	private Object element; //the element contained in this linked list
	private QueueElement next; //the next element of the linked list
	
	/**
	 * 
	 * @param e is the shape object in the queue
	 * @param n is the pointer to the next element in the queue
	 */
	public QueueElement (Object e, QueueElement n) {
		this.element = e;
		this.next = n;
	}
	
	/**
	 * Method to set the element
	 */
	public void setElement (Object element) {
		this.element = element;
	}
	
	/**
	 * Method to set the next linked list element
	 */
	public void setNext (QueueElement e) {
		this.next = e;
	}
	
	/**
	 * Method to get the element.
	 */
	public Object getElement () {
		return element;
	}
	
	/**
	 * Method to get the next linked list element
	 */
	public QueueElement getNext () {
		return next;
	}
	
}
