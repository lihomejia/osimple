package com.norming.num.domain;

import java.io.Serializable;

/***
 * 
 * @author lh.jia
 *
 */
public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	private String docid;
	private String exception;
	
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
}