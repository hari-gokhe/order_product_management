package com.orderproductmanagement;

public class FibonacciSeries {
	public static void main(String[] args) {
		//Fibonacci Series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
		int firstTerm = 0;
		int secondTerm = 1;
		int n = 10;
		
		 while (firstTerm <= n) {
			System.out.print(firstTerm + ", ");
			int nextTerm = firstTerm + secondTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
		
	}
}
