package business;

/**
 * @author ks this is a stack für double values
 */

public class Stack01 {

	private double[] a;
	private int size;
	private int idx;

	/**
	 * initializes the array size to 5 elements
	 */
	public Stack01() {
		size = 5;
		idx = 0;
		a = new double[size];
	}

	/**
	 * initializes the array to size elements
	 * 
	 * @param size
	 *            the internal array will be constructed with size elements
	 */
	public Stack01(int size) {
		if (size > 0)
			this.size = size;
		else
			size = 5;
		idx = 0;
		a = new double[this.size];
	}

	/**
	 * asks if the Stack01 is full
	 * 
	 * @return true, if the Stack01 is full, else false
	 */
	public boolean isFull() {
		if (idx < size)
			return false;
		else
			return true;
	}

	/**
	 * asks if the Stack01 is empty
	 * 
	 * @return true, if the Stack01 is empty, else false
	 */
	public boolean isEmpty() {
		if (idx > 0)
			return false;
		else
			return true;
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
	public double getValue(int idx) {
		return a[idx];
	}

	/**
	 * put an element into the stack
	 * 
	 * @param value
	 */
	public void push(double value) {
		a[idx++] = value;
	}

	/**
	 * returns and removes it from the element
	 * 
	 * @return the last filled in element
	 */
	public double pop() {
		return a[--idx];
	}

}
