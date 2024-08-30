package com.orderproductmanagement;

import java.io.IOException;
import java.sql.SQLException;

class A {
	public void show() throws  SQLException {
		System.out.println("A show");
	}
}

class B extends A {
	public void show() {
		System.out.println("B show");
	}
}

public class TestExeption {
	public static void main(String[] args) {
		B obj = new B();
		obj.show();
	}
	
	
}
