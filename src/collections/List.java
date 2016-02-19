package collections;

public interface List {
	/* add element to the end of list */
	void add(int info);

	/* add element to pos in list, after add, pos is index of element */
	void add(int info, int pos);

	/* delete and return the last element */
	int remove();

	/* delete and return the element at pos */
	int remove(int pos);

	/* get contents of last element */
	int get();

	/* get contents of element at pos */
	int get(int pos);

	/* clear the list */
	void clear();

	/* return true if list contains val, false otherwise */
	boolean contains(int val);

	/* number of elements in list */
	int size();

	/* return String representing contents of list */
	String toString();
}