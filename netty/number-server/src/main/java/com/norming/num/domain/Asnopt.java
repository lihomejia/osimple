package com.norming.num.domain;

public class Asnopt {
	private String  prefix;
	private boolean usedate;
	private String 	datefmt;
	private int	 	numlength;
	private String 	separator;
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public boolean isUsedate() {
		return usedate;
	}
	public void setUsedate(boolean usedate) {
		this.usedate = usedate;
	}
	public String getDatefmt() {
		return datefmt;
	}
	public void setDatefmt(String datefmt) {
		this.datefmt = datefmt;
	}
	public int getNumlength() {
		return numlength;
	}
	public void setNumlength(int numlength) {
		this.numlength = numlength;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
}