package business;

public class Stack02 {
	private Object[] a;
	private int size;
	private int idx;

	/**
	 * initializes the array size to 5 elements
	 */
	public Stack02() {
		size = 5;
		idx = 0;
		a = new Object[size];
	}

	/**
	 * initializes the array to size elements
	 * 
	 * @param size
	 *            the internal array will be constructed with size elements
	 */
	public Stack02(int size) {
		if (size > 0)
			this.size = size;
		else
			size = 5;
		idx = 0;
		a = new Object[this.size];
	}

	/**
	 * asks how many elements are stored in stack
	 * 
	 * @return the amount of elements left in the stack
	 */
	public int getAmount() {
		return idx;
	}

	/**
	 * asks for the value at idx, but without removing the element
	 * 
	 * @param idx
	 *            the index of the internal array
	 * @return the element at the index idx
	 */
	public Object getValue(int idx) {
		try {
		    return a[idx];
		} catch (ArrayIndexOutOfBoundsException e ) {
			return null;
		}
	}

	/**
	 * put an element into the stack
	 * 
	 * @param value
	 */
	public boolean push(Object o) {
		try {
		   a[idx] = o;
		   ++idx;
		   return true;
		} catch (ArrayIndexOutOfBoundsException e ) {
		   return false;
		}
	}

	/**
	 * returns and removes it from the element
	 * 
	 * @return the last filled in element
	 */
	public Object pop() {
		try {
		   return a[--idx];
		} catch (ArrayIndexOutOfBoundsException e) {
		   return null;
		}
		
	}
}
