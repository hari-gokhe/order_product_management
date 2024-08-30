package com.orderproductmanagement;

import java.util.HashMap;
import java.util.Map;

public class CountEachCharFromString {
	public static void main(String[] args) {
		String str = "aabbc";
		char[] charArray = str.toCharArray();
		Map<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (mp.containsKey(charArray[i])) {
				mp.put(charArray[i], mp.get(charArray[i]) + 1);
			} else {
				mp.put(charArray[i], 1);
			}
		}
		
		System.out.println(mp);
	}
}
