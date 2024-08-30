package com.orderproductmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	private Integer empId;
	private String empName;
	private String empDep;
	private double empSalary;
	public Employee(Integer empId, String empName, String empDep, double empSalary) {
		super();
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
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDep=" + empDep + ", empSalary=" + empSalary
				+ "]";
	}
	
	
}
public class StreamSortWithComparable {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(20);
		arrList.add(5);
		arrList.add(24);
		arrList.add(28);
		arrList.add(3);
		arrList.add(4);
//		sortAscWithSortedMethod(arrList);
//		sortAscWithCompareToMethod(arrList);
//		sortDescWithCompareToMethod(arrList);
//		sortDescWithCompareToMethodAndObjOrderChange(arrList);
		sortObjectWithSortedMethod();
	}

	// sorting in ascending order using with sorted() method --> by default it call
	// obj1.compareTo(obj2)
	public static void sortAscWithSortedMethod(List<Integer> list) {
		List<Integer> newSortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("ascending order - " + newSortedList);
	}

	// sorting in ascending order using with sorted(compareTo) method
	public static void sortAscWithCompareToMethod(List<Integer> list) {
		List<Integer> newSortedList = list.stream().sorted((obj1, obj2) -> obj1.compareTo(obj2))
				.collect(Collectors.toList());
		System.out.println("ascending order - " + newSortedList);
	}

	// sorting in descending order using with sorted(compareTo) method
	public static void sortDescWithCompareToMethod(List<Integer> list) {
		List<Integer> newSortedList = list.stream().sorted((obj1, obj2) -> -obj1.compareTo(obj2))
				.collect(Collectors.toList());
		System.out.println("descending order - " + newSortedList);
	}

	// sorting in descending order using with sorted(compareTo) method
	public static void sortDescWithCompareToMethodAndObjOrderChange(List<Integer> list) {
		List<Integer> newSortedList = list.stream().sorted((obj1, obj2) -> obj2.compareTo(obj1))
				.collect(Collectors.toList());
		System.out.println("descending order - " + newSortedList);
	}
	
	// sorted employee object
	public static void sortObjectWithSortedMethod() {
		Employee e1 = new Employee(24, "Kailash", "IT", 25000);
		Employee e2 = new Employee(26, "Harshal", "Finance", 40000);
		Employee e3 = new Employee(5, "Ganesh", "HR", 90000);
		Employee e4 = new Employee(12, "Vijay", "Account", 70000);
		Employee e5 = new Employee(30, "Vishal", "FLM", 50000);
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		//System.out.println(empList);
		System.out.println("Sort employee based on empId");
		List<Employee> newEmpList = empList.stream().sorted((obj1,obj2)-> obj1.getEmpId().compareTo(obj2.getEmpId())).collect(Collectors.toList());
		for(Employee emp : newEmpList) {
			System.out.println(emp);
		}
		System.out.println("Sort employee based on empSalary");
		List<Employee> newEmpList1 = empList.stream().sorted((obj1,obj2)-> obj1.getEmpName().compareTo(obj2.getEmpName())).collect(Collectors.toList());
		for(Employee emp : newEmpList1) {
			System.out.println(emp);
		}
		
		
	}
	
	
}
