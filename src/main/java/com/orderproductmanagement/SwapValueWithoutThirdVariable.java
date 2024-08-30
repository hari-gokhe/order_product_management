package com.orderproductmanagement;

public class SwapValueWithoutThirdVariable {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		a = a+b; // a is now 30
		b = a-b;// b is now 30-20 = 10
		a = a-b;// a is now 30-10 = 20
		System.out.println("value of a "+a);
		System.out.println("value of b "+b);
	}
}
