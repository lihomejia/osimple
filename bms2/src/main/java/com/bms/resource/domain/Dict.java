package com.bms.resource.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.bms.base.domain.BaseDomain;
import com.bms.resource.enumeration.DictType;

@Entity(name="t_dict")
public class Dict extends BaseDomain {
	
	@Column(length=20, columnDefinition="varchar(20)")
	private DictType type;
	
	@Column(length=100)
	private String name;


	public DictType getType() {
		return type;
	}

	public void setType(DictType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
}
