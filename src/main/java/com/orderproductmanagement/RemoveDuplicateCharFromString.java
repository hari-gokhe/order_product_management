package com.orderproductmanagement;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharFromString {
	public static void main(String[] args) {
		String inputStr = "aabccdde";
		
		removeDuplicateChar(inputStr);
	}

	public static void removeDuplicateChar(String inputStr) {
		Set<Character> set = new HashSet<>();
		StringBuffer sf = new StringBuffer();

		for (int i = 0; i < inputStr.length(); i++) {
			if (!set.contains(inputStr.charAt(i))) {
				set.add(inputStr.charAt(i));
				sf.append(inputStr.charAt(i));
			}
		}
		System.out.println(sf.toString());
	}
}
