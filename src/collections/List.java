package collections;

public interface List<T> {
	/* add element to the end of list */
	void add(T info);

	/* add element to pos in list, after add, pos is index of element */
	void add(T info, int pos);

	/* delete and return the last element */
	T remove();

	/* delete and return the element at pos */
	T remove(int pos);

	/* get contents of last element */
	T get();

	/* get contents of element at pos */
	T get(int pos);

	/* clear the list */
	void clear();

	/* return true if list contains val, false otherwise */
	boolean contains(T val);

	/* number of elements in list */
	int size();

	/* return String representing contents of list */
	String toString();
}