package com.mano.familytree.data;

public enum Gender {
	
	MALE("Male"), FEMALE("Female");
	
	private Gender(String name) {
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return this.name;
	}
}
