package cn.com.norming.user.domain;

public class Ssuser {
	private String ssuserUserid;
	private String ssuserUsername;
	private String ssuserPwd;
	private String ssuserEntityid;
	
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
	public String getSsuserEntityid() {
		return ssuserEntityid;
	}
	public void setSsuserEntityid(String ssuserEntityid) {
		this.ssuserEntityid = ssuserEntityid;
	}
}