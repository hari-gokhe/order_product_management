package com.orderproductmanagement;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = { 12, 3, 7, 15, 1, 20, 22, 9 };
		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = 0; j <= a.length - 2; j++) {
				if (a[j] < a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for(int num : a)  
	      {
	         System.out.println(num);
	      }
		
		for(int v=0 ; v< a.length ;v++) {
			System.out.println(a[v]);
		}
		//System.out.println(a);
//select name,salary from employee e1 
//where n-1 = (select count(distinct salary) from employee e2 where e2.salary>e1.salary)
	}
}
