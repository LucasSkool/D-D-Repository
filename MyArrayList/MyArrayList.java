/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E[] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	public int size() {
		return internalArray.length;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i] != null) {
				return false;
			}
		}
		return true;
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		if (index > internalArray.length - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		return internalArray[index];
	}

	/* Replace the object at index with obj. returns object that was replaced. */
	public E set(int index, E obj) {
		if (index > internalArray.length - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		internalArray[index] = obj;
		return obj;
	}

	/*
	 * Returns true if this list contains an element equal to obj;
	 * otherwise returns false.
	 */
	public boolean contains(E obj) {
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		if (index > internalArray.length - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Cannot add obj to index not in list.");
		}

		E[] newArray = (E[]) new Object[internalArray.length + 1];
		int newArrayPos = 0;
		boolean added = false;
		for (int internalArrayPos = 0; internalArrayPos < internalArray.length; internalArrayPos++) { // goes through
			if (added == false && internalArrayPos == index) {
				newArray[index] = obj;
				newArrayPos++;
				added = true;
			} else {
				newArray[newArrayPos] = internalArray[internalArrayPos];
				newArrayPos++;
			}
		}
		internalArray = newArray;
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		E[] newArray = (E[]) new Object[internalArray.length + 1];
		for (int i = 0; i < internalArray.length; i++) {
			newArray[i] = internalArray[i];
		}
		newArray[newArray.length - 2] = obj;
		internalArray = newArray;
		return true;
	}

	/* Remove the object at index and shift. Returns removed object. */
	public E remove(int index) {
		E[] newArray = (E[]) new Object[internalArray.length - 1];
		E obj = null;
		int newArrayPos = 0;
		for (int internalArrayPos = 0; internalArrayPos < internalArray.length; internalArrayPos++) {
			if (internalArrayPos != index) {
				newArray[newArrayPos] = internalArray[internalArrayPos];
				newArrayPos++;
			}
		}
		internalArray = newArray;
		return obj;
	}

	/*
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present. If the list does not contain the element, it is unchanged.
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	 * Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 */
	public boolean remove(E obj) {
		E[] newArray = (E[]) new Object[internalArray.length - 1];
		int newArrayPos = 0;
		boolean removed = false;
		for (int internalArrayPos = 0; internalArrayPos < internalArray.length; internalArrayPos++) { // go through
			if (internalArray[internalArrayPos] != null && !internalArray[internalArrayPos].equals(obj)) {
				newArray[newArrayPos] = internalArray[internalArrayPos];
				newArrayPos++;
				removed = true;
			}
		}
		internalArray = newArray;
		return removed;
	}

	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X,
	 * X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]". If there is one element, "[X]",
	 * etc.
	 * Elements are separated by a comma and a space.
	 */
	public String toString() {
		String result = "[";
		if (internalArray.length > 0) {
			for (int i = 0; i < internalArray.length; i++) {
				result += internalArray[i] + ", ";
			}
			result = result.substring(0, result.length() - 2) + "]";
		} else {
			result = "[]";
		}
		return result;
	}

}