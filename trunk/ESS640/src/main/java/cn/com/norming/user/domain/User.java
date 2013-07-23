package cn.com.norming.user.domain;

public class User {
	private String ssuserUserid;
	private String ssuserUsername;
	private String ssuserPwd;
	
	public String getSsuserUserid() {
		return ssuserUserid;
	}
	public String getSsuserUsername() {
		return ssuserUsername;
	}
	public void setSsuserUsername(String ssuserUsername) {
		this.ssuserUsername = ssuserUsername;
	}
	public void setSsuserUserid(String ssuserUserid) {
		this.ssuserUserid = ssuserUserid;
	}
	public String getSsuserPwd() {
		return ssuserPwd;
	}
	public void setSsuserPwd(String ssuserPwd) {
		this.ssuserPwd = ssuserPwd;
	}
}