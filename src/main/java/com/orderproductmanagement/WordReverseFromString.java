package com.orderproductmanagement;

public class WordReverseFromString {
	public static void main(String[] args) {
		String txt = "i am hari gokhe";
		String[] strArray = txt.split(" ");
		for (int i = strArray.length - 1; i >= 0; i--) {
			System.out.println(strArray[i]);
		}
	}
}
