package com.orderproductmanagement;

public class factorialWithForLoop {
	public static void main(String[] args) {
		int num = 5;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
			System.out.println(i);
		}
		System.out.println("factorial of 5 is : " + fact);

	}

}
