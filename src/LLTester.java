import collections.LinkedList;

public class LLTester {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		System.out.println(list1);

		list1.add(10);
		list1.add(14);
		list1.add(18);
		list1.add(22);
		System.out.println(list1);
		list1.add(21);
		list1.add(24, 2);
		list1.add(26, 3);
		System.out.println(list1);
		list1.remove();
		list1.remove(1);
		list1.remove(0);
		System.out.println(list1);
		checkContains(list1, 10);
		checkContains(list1, 14);
		checkContains(list1, 18);
		checkContains(list1, 26);
		checkContains(list1, 24);
		checkContains(list1, 21);
		list1.clear();
		System.out.println(list1);
	}

	//This will only work with LinkedLists, need to mage more generic
	public static void checkContains(LinkedList<Integer> list, int v) {
		if (list.contains(v)) {
			System.out.println("List contains " + v + "!");
		} else {
			System.out.println("List does not contain " + v + "!");
		}
	}
}