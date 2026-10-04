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
		if (values.length < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (values.length == 0) {
			return;
		}

		if (values.length == 1) {
			this.head = new ListNode<E>(values[0], this.tail);
			return;
		}

		if (values.length == 2) {
			this.tail = new ListNode<E>(values[1], null);
			this.head = new ListNode<E>(values[0], this.tail);
			return;
		}
		
		this.tail = new ListNode<E>(values[values.length - 1], null); //tail only
		ListNode<E> prevNode = this.tail;
		for (int i = values.length - 2; i > 0; i--) {
			ListNode<E> newNode = new ListNode<E>(values[i], prevNode);
			prevNode = newNode;
			
		}
		this.head = new ListNode<E>(values[0], prevNode);
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
			if (!(obj == null ? this.head.getValue() == null : obj.equals(this.head.getValue()))) {
				return false;
			}
			return true;
		}

		if (obj == null ? this.head.getValue() == null : obj.equals(this.head.getValue())) { //if the head is the obj
			return true;
		}
		
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion
				.getNext()) {
			if (obj == null ? nodeInQuestion.getValue() == null : obj.equals(nodeInQuestion.getValue())) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		if (this.head == null || (this.head != null && this.tail == null && !(obj == null ? this.head.getValue() == null : obj.equals(this.head.getValue())))) {
			return -1;
		}
		
		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion.getNext()) {
			if (obj == null ? nodeInQuestion.getValue() == null : obj.equals(nodeInQuestion.getValue())) {
				return index;
			}
			index++;
		}
		
		return -1;
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

		if (this.head != null && this.tail == null) { //if there is only one value
			if (!(obj == null ? this.head.getValue() == null : obj.equals(this.head.getValue()))) { //if the only object in the list is not the obj we are looking for
				return false;
			}
			//else / if the only object IS the obj we are looking for...
			this.head = null;
			return true;
		}

		if (obj == null ? this.head.getValue() == null : obj.equals(this.head.getValue())) {
			this.head = this.head.getNext();

			if (this.head == null) {
				this.tail = null;
			}

			return true;
		}
		
		for (ListNode<E> previousNode = this.head; previousNode != this.tail; previousNode = previousNode.getNext()) {
			if ((obj == null ? previousNode.getNext().getValue() == null : obj.equals(previousNode.getNext().getValue()))
        && previousNode.getNext().equals(this.tail)) {
				previousNode.setNext(previousNode.getNext().getNext());
				this.tail = previousNode;
				return true;
			} //does this work?? idk..
			
			if (obj == null ? previousNode.getNext().getValue() == null : obj.equals(previousNode.getNext().getValue())) {
				previousNode.setNext(previousNode.getNext().getNext());
				return true;
			}
		}
		return false;

	}

	// Returns the i-th element.
	public E get(int i) {
		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion
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
		if (this.head == null) {
			throw new IndexOutOfBoundsException();
		}

		if (this.head != null && this.tail == null && i == 0) {
			E removed = this.head.getValue();
			this.head.setValue(obj);
			return removed;
		}

		int index = 0;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != null; nodeInQuestion = nodeInQuestion
				.getNext()) {
			if (index == i) { // if we at the index
				E removed = nodeInQuestion.getValue();
				nodeInQuestion.setValue(obj);
				return removed;
			}
			index++;
		}

		throw new IndexOutOfBoundsException(); // must be out of bounds by this point
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
		if ((i < 0 || i > this.size())) {
			throw new IndexOutOfBoundsException();
		}

		if (this.head == null) { //if empty, i has to be 0
			this.head = new ListNode<E>(obj, tail);
			return;
		}

		if (this.head != null && this.tail == null) { //if only 1, i has to be either 0 or 1
			if (i == 0) {
				this.tail = new ListNode<E>(this.head.getValue(), null);
				this.head.setValue(obj);
				this.head.setNext(this.tail);
				return;
			}
			if (i == 1) {
				this.tail = new ListNode<E>(obj, null);
				this.head.setNext(this.tail);
				return;
			}
		}
		
		if (i == 0) {
			this.head = new ListNode<E>(obj, this.head);
			return;
		}

		if (i == this.size()) {
			this.add(obj);
			return;
		}

		//okay all the "edge" cases kind of out of the way

		int index = 1;
		for (ListNode<E> nodeInQuestion = this.head; nodeInQuestion != this.tail; nodeInQuestion = nodeInQuestion.getNext()) {
			//nodeInQuestion is actually 1 index behind all the time
			if (index == i) {
				ListNode<E> newNode = new ListNode<E>(obj, nodeInQuestion.getNext());
				nodeInQuestion.setNext(newNode);
				return;
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

		if (i == 0) { //if we want to remove the first one
			E removed = this.head.getValue();
			this.head = this.head.getNext();

			if (this.head == null) {
				this.tail = null;
			}

			return removed;
		}

		int index = 1;
		E removed = null;
		boolean foundObject = false;
		for (ListNode<E> previousNode = this.head; previousNode != this.tail && !foundObject; previousNode = previousNode.getNext()) {
			if (index == i && previousNode.getNext().equals(this.tail)) {
			removed = previousNode.getNext().getValue();
			previousNode.setNext(null);
			this.tail = previousNode;
			return removed;
			} //idk if the last line of code does what I want.
			
			if (index == i) {
				removed = previousNode.getNext().getValue();
				previousNode.setNext(previousNode.getNext().getNext());
				foundObject = true;
				return removed;
			}
			index++;
		}
		throw new IllegalArgumentException("No cases in the method code were met.");
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
