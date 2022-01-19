package com.te.javabasics.assaignment2;

import java.util.Comparator;

public class Organization {
	int id;
	String name;
	double salary;
	int deptno;
	public Organization(int id, String name, double salary, int deptno) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deptno = deptno;
	}
	public Organization() {
		
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", salary=" + salary + ", deptno=" + deptno + "]";
	}
	
	

}
