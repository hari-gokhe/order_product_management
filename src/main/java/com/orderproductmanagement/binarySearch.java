package com.orderproductmanagement;

public class binarySearch {
	public static void main(String[] args) {
		int[] arry = {1,2,3,4,5};
		int low = 0;
		int high = arry.length-1;
		int searchItem = 10;
		boolean found = false;
		while(low <=high) {
			found = false;
			int mid = (low+high)/2;
			if(searchItem == arry[mid]) {
				found = true;
				break;
			} else if(searchItem > mid ) {
				low = mid+1;
			} else if(searchItem < mid) {
				high = mid -1;
			}
		}
		if(found) {
			System.out.println("SearchItem found");
		} else {
			System.out.println("SearchItem not found");
		}
	}
}
