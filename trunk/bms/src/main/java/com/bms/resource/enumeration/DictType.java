package com.bms.resource.enumeration;


public enum DictType {
	
	CATEGORY("分类"),
	
	PRESS("出版社");
	
	private String name;
	
	DictType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}