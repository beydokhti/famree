package com.mano.familytree.data;

public enum ItemType {
	
	FAQ("FAQ"), ANNOUNCEMENT("Announcement"), CUSTOM_EVENT("Custom Event");
	
	private String name;
	
	private ItemType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
