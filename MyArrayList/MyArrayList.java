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
		objectCount = 0;
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
		objectCount = 0;
	}

	/* Return the number of active slots in the array list */
	public int size() {
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		return (objectCount <= 0);
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
    if (index < 0 || index >= objectCount) {
        throw new IndexOutOfBoundsException();
    }

    return internalArray[index];
}

	/* Replace the object at index with obj. returns object that was replaced. */
	public E set(int index, E obj) {
		if (index > objectCount - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		E oldObj = internalArray[index];
		internalArray[index] = obj;
		return oldObj;
	}

	/*
	 * Returns true if this list contains an element equal to obj;
	 * otherwise returns false.
	 */
	public boolean contains(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		if (index > objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if (objectCount == internalArray.length) {
			E[] newArray = (E[]) new Object[internalArray.length * 2];
			int internalArrayPos = 0;
			boolean added = false;
			for (int newArrayPos = 0; newArrayPos <= objectCount; newArrayPos++) { // goes through newArray
				if (added == false && newArrayPos == index) {
					newArray[index] = obj;
					added = true;
				} else {
					newArray[newArrayPos] = internalArray[internalArrayPos];
					internalArrayPos++;
				}
			}
			internalArray = newArray;

		} else {
			//go backwards through internalArray, once you reach the desired index, set it to obj
			boolean added = false;

			for (int internalArrayPos = objectCount; !added; internalArrayPos--) {
				if (internalArrayPos == index) {
					internalArray[internalArrayPos] = obj;
					added = true;
				} else {
					internalArray[internalArrayPos] = internalArray[internalArrayPos - 1];
				}
			}
		}

		objectCount++;


	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		if (objectCount == internalArray.length) {
			E[] newArray = (E[]) new Object[internalArray.length * 2];
			for (int i = 0; i < internalArray.length; i++) {
				newArray[i] = internalArray[i];
			}
			newArray[objectCount] = obj;
			internalArray = newArray;
			
		} else {
			internalArray[objectCount] = obj;
		}
		objectCount++;
		return true;
	}

	/* Remove the object at index and shift. Returns removed object. */
	public E remove(int index) {
		if (index >= objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		E obj = internalArray[index];
		for (int i = index; i < objectCount - 1; i++) {
			internalArray[i] = internalArray[i + 1];
		}
		internalArray[objectCount - 1] = null;
		objectCount--;
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
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i].equals(obj)) { //if we at the object, shift everything past to the left
				for (int j = i; j < objectCount - 1; j++) {
					internalArray[j] = internalArray[j + 1];
				}
				internalArray[objectCount - 1] = null;
				objectCount--;
				return true;
			}
		}

		return false;
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
		if (objectCount > 0) {
			for (int i = 0; i < objectCount; i++) {
				result += internalArray[i] + ", ";
			}
			result = result.substring(0, result.length() - 2) + "]";
		} else {
			result = "[]";
		}
		return result;
	}

}