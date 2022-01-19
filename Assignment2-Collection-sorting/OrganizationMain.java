package com.te.javabasics.assaignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrganizationMain  {

	public static void main(String[] args) {
		ArrayList<Organization> arrayList = new ArrayList<Organization>();
		arrayList.add(new Organization(2, "Manu", 23450.4, 10));
		arrayList.add(new Organization(4, "Danu", 45678.3, 20));
		arrayList.add(new Organization(3, "Anu", 34562.2, 40));
		arrayList.add(new Organization(1, "Sathish", 15000, 30));
		
		Scanner scanner = new Scanner(System.in);
		
	    System.out.println("enter 1 to display according to id\nenter 2 to display by name\nenter 3 to display by deptno");	       	   
	    int userInput = scanner.nextInt();
	   
	    	     
	switch (userInput) {
	case 1:	
		System.out.println("sorted by id");
		Collections.sort(arrayList, new OrganizationId());
		for (Organization organization : arrayList) {
			System.out.println(organization);
		}
		break;
	case 2:
		System.out.println("sorted by name");
		Collections.sort(arrayList, new OrganizationName());
		for (Organization organization : arrayList) {
			System.out.println(organization);
		}
		break;
	case 3:
		System.out.println("sorted by deptno");
		Collections.sort(arrayList, new OrganizationDeptno());
		for (Organization organization : arrayList) {
			System.out.println(organization);
		}
		break;
	default:
		System.out.println("-----------invalid input---------------");
		System.out.println("-----please enter only above input-----");
        System.exit(0);		
	}		
	}

}
