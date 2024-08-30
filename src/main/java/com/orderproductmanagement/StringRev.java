package com.orderproductmanagement;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringRev {
	public static void main(String[] args) {
		String s = "hello";
		String revString = reverseStringFromStringBuffer(s);
		System.out.println(revString);
		reverseStringFromJava8(s);
	}

	public static String reverseWithForLoop(String inpuStr) {
		System.out.println("reverse from for loop");
		char[] strArray = inpuStr.toCharArray(); // convert string to array
		String revStr = ""; // declare null string variable
		int StringLength = strArray.length; // get string array length

		for (int i = StringLength - 1; i >= 0; i--) { // use for loop in descending order
			// revStr += inpuStr.charAt(i);
			revStr += strArray[i];
		}
		return revStr;
	}

	public static String reverseWithWhileLoop(String inputStr) {
		System.out.println("reverse from while loop");
		char[] strArray = inputStr.toCharArray();
		String revStr = "";
		int strLength = strArray.length;
		// according to array length it exist one less index from its size
		int strArrayLastIndex = strLength - 1;
		while (strArrayLastIndex >= 0) {
			revStr += strArray[strArrayLastIndex];
			strArrayLastIndex--;
		}
		return revStr;
	}

	// it is non-synchronized, so it is not thread safe
	public static String reverseStringFromStringBuilder(String inputStr) {
		System.out.println("reverse from StringBuilder");
		StringBuilder str = new StringBuilder(inputStr);
		String revStr = str.reverse().toString();
		return revStr;
	}

	// it is synchronized, so it is thread safe
	public static String reverseStringFromStringBuffer(String inputStr) {
		System.out.println("reverse from StringBuffer");
		StringBuffer str = new StringBuffer(inputStr);
		String revStr = str.reverse().toString();
		return revStr;
	}

	public static void reverseStringFromJava8(String inputStr) {
		System.out.println("reverse from java 8");
		String revstr = Stream.of(inputStr).map(str -> new StringBuilder(str).reverse()).collect(Collectors.joining());
		System.out.println(revstr);
		
	}

}
