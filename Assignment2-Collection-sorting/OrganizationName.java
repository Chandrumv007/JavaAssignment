package com.te.javabasics.assaignment2;

import java.util.Comparator;

public class OrganizationName implements Comparator<Organization> {

	@Override
	public int compare(Organization o1, Organization o2) {
				return o1.name.compareTo(o2.name);
	}

}
