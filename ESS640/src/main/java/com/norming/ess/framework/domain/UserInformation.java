package com.norming.ess.framework.domain;

import java.io.Serializable;

public class UserInformation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String			language	= "";
	private String			userId		= "";
	private String			userName	= "";
	private String			userPwd		= "";
	private String			empId		= "";
	private String			empName		= "";
	private String			homepage	= "";
	
	/** Page Count */
	private Integer			pageCount;
	/** Date Format */
	private Integer			dateFormat;
	/** Decimal Places */
	private int 			decimalPlaces;
	
	private String[]		rsNames;
	
	/** 登录的entity */
	private String 			entityId;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(Integer dateFormat) {
		this.dateFormat = dateFormat;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String[] getRsNames() {
		return rsNames;
	}

	public void setRsNames(String[] rsNames) {
		this.rsNames = rsNames;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
