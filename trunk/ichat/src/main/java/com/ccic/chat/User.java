package com.ccic.chat;

/**
 * 用户
 * 
 * 
 * 
 */
public class User {

	private String password;

	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	

}
