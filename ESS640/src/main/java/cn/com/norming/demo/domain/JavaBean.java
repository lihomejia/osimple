package cn.com.norming.demo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class JavaBean {

	private String name;
	
	private Date birth;
	
	private Timestamp ldt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
			.append("name:").append(this.name)
			.append(",birth:").append(this.birth)
			.append(",ldt:").append(ldt)
			.append("}")
		.toString();
	}
}
