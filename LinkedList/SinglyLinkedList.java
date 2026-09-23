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
		this.tail = null;
		this.head = null;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(E[] values) {
		if (values.length < 1) {
			throw new IllegalArgumentException();
		}

		if (values.length == 1) {
			this.head = new ListNode<E>(values[0], null);
		}

		if (values.length == 2) {
			this.tail = new ListNode<E>(values[1], null);
			this.head = new ListNode<E>(values[0], this.tail);
		}
		
		for (int i = values.length - 1; i >= 0; i--) { // backwards through array
			if (i == values.length - 1) {
				this.tail = new ListNode<E>(values[i], null);
			}

			if (i == 0) {
				this.head = new ListNode<E>(values[i], )
			}
			
		}
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		if (this.tail == null && this.head == null) {
			return 0;
		}
		if (this.head != null && this.tail == null) {
			return 1;
		}

		int nodeCount = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion
				.getNext()) {
			nodeCount++;
		} // ts goes through the nodes I think
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		if (this.head == null) {
			return false;
		}
		if (this.head != null && this.tail == null) {
			if (!this.head.getValue().equals(obj)) {
				return false;
			}
			return true;
		}

		if (this.head.getValue().equals(obj)) {
			return true;
		}
		
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion
				.getNext()) {
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
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion
				.getNext()) {
			if (nodeInQuestion.getValue().equals(obj)) {
				return index;
			}
			index++;
		}
		return index;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		if (this.size() < 1) {
			this.head = new ListNode<E>(obj);
			return true;
		}
		if (this.size() == 1) {
			this.tail = new ListNode<E>(obj);
			this.head.setNext(this.tail);
			return true;
		}
		this.tail.setNext(new ListNode<E>(obj, null));
		this.tail = this.tail.getNext();
		return true;

	}
	// [1, __] [2, __] [3, __]

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (this.head == null) {
			return false;
		}

		if (this.head != null && this.tail == null) {
			if (!this.head.equals(obj)) {
				return false;
			}
			this.tail = null;
			return true;
		}

		if (this.head.equals(obj)) {
			this.head = this.head.getNext();
		}
		
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (nodeInQuestion.getNext().getValue().equals(obj)) {
				nodeInQuestion.setNext(nodeInQuestion.getNext().getNext());
				return true;
			}
		}
		return false;

	}

	// Returns the i-th element.
	public E get(int i) {
		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion
				.getNext()) {
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
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion
				.getNext()) {
			if (index == i) { // if we at the index
				E removed = nodeInQuestion.getValue();
				nodeInQuestion.setValue(obj);
				return removed;
			}
			index++;
		}

		throw new IndexOutOfBoundsException(); // must be out of bounds.
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
		if ((i < 0 || i >= this.size()) || (this.head == null) || (this.head != null && this.tail == null && i == 0)) {
			throw new IndexOutOfBoundsException();
		}

		if (i == 0) {
			this.head = new ListNode<E>(obj, this.getHead());
		}

		int index = 1;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (index == i) {
				ListNode<E> newNode = new ListNode<E>(obj, nodeInQuestion.getNext());
				nodeInQuestion.setNext(newNode);
			}
			
			index++;
		}
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if ((i < 0 || i >= this.size()) || (this.head == null) || (this.head != null && this.tail == null && i != 0)) {
			throw new IndexOutOfBoundsException();
		}
		
		/*if (this.head == null) { //if completely empty
			throw new IndexOutOfBoundsException();
		}

		if (this.head != null && this.tail == null && i != 0) { //if size 1
			throw new IndexOutOfBoundsException();
		} */ //These are combined in the first if statement for index out of bounds

		if (i == 0) { //if we want to remove the first one
			E removed = this.head.getValue();
			this.head = this.head.getNext();
			return removed;
		}
		int index = 1;

		E removed = null;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			if (index == i) {
				removed = nodeInQuestion.getNext().getValue();
				nodeInQuestion.setNext(nodeInQuestion.getNext().getNext());
				nodeInQuestion = this.tail; //hitting the skip button
			}
			index++;
		}
		return removed;
	}

	// Returns a string representation of this list exactly like that for
	// MyArrayList.
	public String toString() {
		if (this.head == null) { //if empty list
			return "[]";
		}
		if (this.head != null && this.tail == null) { //basically if there is only one node
			return "[" + this.head.getValue() + "]";
		}

		StringBuilder result = new StringBuilder("[");
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion.getNext()) {
			result.append("" + nodeInQuestion.getValue());
			result.append(", ");
		}

		result.setLength(result.length() - 2);
		result.append("]");
		return result.toString();
	}

}
