// Implements a singly-linked list.
// works if empty?
// works if 1 node?
// works if I mess w/ the beginning?
// works if end is changed
// works in the mid of the list

public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		this.tail = new ListNode<E>(null, null);
		this.head = new ListNode<E>(null, tail);
		//??
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(E[] values) {
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (this.head.equals(this.tail)) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		int nodeCount = 0;

		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			nodeCount++;
		} //ts goes through the nodes I think
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (nodeInQuestion.getValue().equals(obj)) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (nodeInQuestion.getValue().equals(obj)) {
				return index;
			}
			index++;
		}
		return index;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		this.tail.setNext(new ListNode<E>(obj, null));
		this.tail = this.tail.getNext();
		return true;

	}
	// [1, __] [2, __] [3, __]

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		ListNode<E> previousNode = new ListNode<E>(null, null);
		ListNode<E> nodeInQuestion = this.getHead();
		for (int i = 0; i < this.size(); i++) {
			if (nodeInQuestion.getValue().equals(obj)) {
				previousNode//the one before should point to the one ahead
				return true;
			}
			previousNode = nodeInQuestion;
			nodeInQuestion = nodeInQuestion.getNext();
		}
		return false;
	}

	// Returns the i-th element.               
	public E get(int i) {
		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (index == i) {
				return nodeInQuestion.getValue();
			}
			index++;
		}
		throw new IndexOutOfBoundsException();
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, E obj) {
		if (i == this.size() - 1) {
			this.getTail().setValue(obj);
		}
		
		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (index == i) { // if we at the index
				E removed = nodeInQuestion.getValue();
				nodeInQuestion.setValue(obj);
				return removed;
			}
			index++;
		}

		throw new IndexOutOfBoundsException(); //must be out of bounds.
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder result = new StringBuilder("");
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			result.append(nodeInQuestion.getValue());
			result.append(", ");
		}

		result.setLength(result.length() - 2);
		return result.toString();
	}
	

}
