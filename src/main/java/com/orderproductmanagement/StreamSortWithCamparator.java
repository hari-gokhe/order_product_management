package com.orderproductmanagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employees {
	private Integer empId;
	private String empName;
	private String empDep;
	private double empSalary;

	public Employees(Integer empId, String empName, String empDep, double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empDep = empDep;
		this.empSalary = empSalary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpDep() {
		return empDep;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + ", empDep=" + empDep + ", empSalary=" + empSalary
				+ "]";
	}

}

public class StreamSortWithCamparator {
	public static void main(String[] args) {
		Employees e1 = new Employees(24, "Kailash", "IT", 25000);
		Employees e2 = new Employees(26, "Harshal", "Finance", 40000);
		Employees e3 = new Employees(5, "Ganesh", "HR", 90000);
		Employees e4 = new Employees(12, "Vijay", "Account", 70000);
		Employees e5 = new Employees(30, "Vishal", "FLM", 50000);
		ArrayList<Employees> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		// System.out.println(empList);
		// sortObjectWithField(empList);
		// sortObjectWithMultiField(empList);
		otherStreamApiMethod();
	}

	public static void sortObjectWithField(List<Employees> empList) {
		Comparator<Employees> comparatorObj = (obj1, obj2) -> {
			return obj1.getEmpName().compareTo(obj2.getEmpName()); // for string sorting we can use it
			// return obj1.getEmpId() - obj2.getEmpId(); // for number sorting we can use it
		};
		List<Employees> newEmpList = empList.stream().sorted(comparatorObj).collect(Collectors.toList());
		for (Employees emp : newEmpList) {
			System.out.println(emp);
		}
	}

	public static void sortObjectWithMultiField(List<Employees> empList) {
		Comparator<Employees> comparatorObj = (obj1, obj2) -> {
			int flag = obj1.getEmpName().compareTo(obj2.getEmpName()); // for string sorting we can use it
			if (flag == 0) {
				flag = obj1.getEmpId() - obj2.getEmpId(); // for number sorting we can use it
			}
			return flag;
		};
		List<Employees> newEmpList = empList.stream().sorted(comparatorObj).collect(Collectors.toList());
		for (Employees emp : newEmpList) {
			System.out.println(emp);
		}
	}

	// steam api from java 8 feature
	public static void otherStreamApiMethod() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(0);
		list.add(15);
		list.add(5);
		list.add(20);
		// convert collection object to array
		// Integer[]::new creating Integer Array Object
		System.out.println("convert collection object to array");
		Integer[] i = list.stream().toArray(Integer[]::new);
		for (Integer item : i) {
			System.out.println(item);
		}
		System.out.println("=================================");
		// convert Array object to collection
		System.out.println("convert Array object to collection");
		Integer[] marks = { 23, 45, 87, 45, 98 };
		Stream.of(marks).forEach(System.out::println);
		System.out.println("=================================");
		System.out.println("filter element from collection object");
		System.out.println(list.stream().filter(m -> m > 12).collect(Collectors.toList()));
		System.out.println("=================================");
		System.out.println("count of element from collection object");
		System.out.println(list.stream().filter(m -> m < 10).count());
		System.out.println("=================================");
		System.out.println("sort the element of collection object by default natual sorting order");
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		System.out.println("=================================");
		System.out.println("min value element in collection object");
		System.out.println(list.stream().min((num1,num2)->num1.compareTo(num2)).get());
		System.out.println("=================================");
		System.out.println("max value element in collection object");
		System.out.println(list.stream().max((num1,num2)->num1.compareTo(num2)).get());
		System.out.println("=================================");
		System.out.println("stream api can also apply on group on element like collect Object & Array");
		Stream.of(9,23,59,20).forEach(System.out::println);
		System.out.println("=================================");
		//Collectors.
		//Comparator.
		


	}

}
