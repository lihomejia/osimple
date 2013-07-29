package com.norming.ess.demo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class JavaBean {

	private String name1;
	
	private Date birth;
	
	private Timestamp ldt;

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Timestamp getLdt() {
		return ldt;
	}

	public void setLdt(Timestamp ldt) {
		this.ldt = ldt;
	}

	@Override
	public String toString() {
		return new StringBuffer()
			.append("{")
			.append("name:").append(this.name1)
			.append(",birth:").append(this.birth)
			.append(",ldt:").append(ldt)
			.append("}")
		.toString();
	}
}
