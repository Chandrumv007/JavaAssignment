package com.te.javabasics.assaignment2;

import java.util.Comparator;

public class OrganizationId implements Comparator<Organization> {

	@Override
	public int compare(Organization o1, Organization o2) {
		
		return o1.id-o2.id;
	}

}
