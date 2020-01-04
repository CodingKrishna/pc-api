package org.pioneercoders.utils;

public enum UserRoles {

	ANONYMOUS(1), 
	CAMPUS(2), 
	INTERN(3), 
	CLASSROOM_TRAINING(4),
	ONLINE_TRAINING(5), 
	INTERVIEW(6), 
	HR(7),
	PO(8);

	private int value;

	private UserRoles(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
