package com.orderproductmanagement;

public class NumberRev {
	public static void main(String[] args) {
		int inputNum = 123;
		int revNum =0;
		while(inputNum!=0 ) {
			int remainder = inputNum%10;
			revNum = revNum * 10 + remainder;
			inputNum = inputNum/10;
		}
		System.out.println(revNum);
	}
}
