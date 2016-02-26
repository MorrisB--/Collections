package projects;

import collections.LinkedList;

public class BigInteger {
	LinkedList<Integer> data;
	boolean isNeg;

	public BigInteger() {
		// need to add a linked list constructor that takes a new Integer
		data = new LinkedList<Integer>(new Integer(0));
		isNeg = false;
	}

	// eg "12341293487192857623948756293487562938457236046981406"
	public BigInteger(String num) {
		data = new LinkedList<Integer>();
		if (num.charAt(0) == '-') {
			isNeg = true;
		} else {
			isNeg = false;
		}
		int start = 0;
		/*
		 * while( num.charAt(start) < '1' || num.charAt(start) > '9' )
		 */
		while (num.charAt(start) == '+' || num.charAt(start) == '-' || num.charAt(start) == '0') {
			start++;
		}
		// we are at the start of the number to save
		for (int i = num.length() - 1; i >= start; i--) {
			data.add(num.charAt(i) - '0');
		}
	}

	public String toString() {
		String r = "";
		if (isNeg) {
			r = "-";
		}
		for (int i = 0; i < data.size(); i++) {
			r = r + data.get(i);
		}
		return r;
	}

	public static void main(String[] args) {
		BigInteger myNum = new BigInteger("12345");
		BigInteger myNum2 = new BigInteger("-12345");
		BigInteger myNum3 = new BigInteger("+0000001243523452345234522345");
		System.out.println(myNum);
		System.out.println(myNum2);
		System.out.println(myNum3);
	}
}