package com.bms.resource.enumeration;


public enum DictType {
	
	CATEGORY("分类"),
	
	PRESS("出版社");
	
	private String desc;
	
	DictType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}