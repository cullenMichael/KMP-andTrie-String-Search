import java.util.Iterator;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Michael Cullen
 *  @version 13/10/16 18:15
 */

class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T>
{
	int counter = 0;
    public class DLLNode
    {
        public T data; 
        public DLLNode next;
        public DLLNode prev;
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }
    public DLLNode head, tail;
    DLLNode t1;
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }
    
    public boolean isEmpty()
    {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	public void push(T item) {
		t1 = new DLLNode(item, null, head);
		head = t1;
		counter++;
	}

	public void enqueue(T item) {
		t1 = new DLLNode(item, null, head);
		if (head != null) {
			head.prev = t1;
		} else {
			tail = t1;
		}
		head = t1;
	}

	public T dequeue() {
		if (tail.prev == null) {
			head = null;
			return tail.data;
		}
		tail = tail.prev;
		return tail.next.data;
	}
    
	 public Iterator<T> iterator()  { return new DoublyLinkedListIterator(); }
	    private class DoublyLinkedListIterator implements Iterator<T> {
    	T item;
        private DLLNode current = head;  
        private int index = 0;
        public boolean hasNext()      { return index < counter; }
        public T next() {
            item = current.data;
            current = current.next; 
            index++;
            return item;	
        }
        public void remove(){	
        }
	
    }
}