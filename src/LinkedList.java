import java.util.NoSuchElementException;

public class LinkedList {

	private Node head;
	int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(Node node) {
		node.setNext(head); 
		head = node;
		size++;
	}

	public void removeFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node temp = head;
		head = head.getNext();
		temp.setNext(null);
		size--;
	}

	/* Adds new data to head of the list */
	public void add(Object item) {
		addFirst(new Node(item, null)); 
	}

	/* Finds if a element is in list */
	public boolean contains(Object item) {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.getElement().equals(item)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	/* Removes element from list, indexed from 0 */
	public void remove(int i) {
		if (i < 0 || i > size-1 || size == 0) {
			throw new NoSuchElementException();
		} else if (i == 0) {
			removeFirst();
		} else {
			Node temp = head;
			for (int j = 0; j < i - 1; j++) {
				temp = temp.getNext(); 
			}
			Node nodeToDelete = temp.getNext();
			temp.setNext(nodeToDelete.getNext());
			nodeToDelete.setNext(null);
			size--;
		}
	}
	
	/* adds a new element at index i */
	public void addAt(int i , Object item)
	{
		if(i < 0 || i > size-1) {
			throw new IndexOutOfBoundsException();
		}
		else if(i == 0) {
			add(item);
		}
		else {
				Node temp = head;
				for(int j = 0; j < i-1; j++)
				{
					temp = temp.getNext();
				}
				Node newNode = new Node(item, temp.getNext());
				temp.setNext(newNode);
				size++;
		}
	}
	
	public LinkedList reverse()
	{
		LinkedList reversed = new LinkedList();
		Node temp = head;
		for(int i = 0; i < size; i++)
		{
			reversed.addFirst(new Node(temp.getElement(), temp.getNext()));
			temp = temp.getNext();
		}
		return reversed;
	}
}