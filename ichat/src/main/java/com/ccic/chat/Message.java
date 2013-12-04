package com.ccic.chat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.directwebremoting.Security;
public class Message {
	DateFormat df = new SimpleDateFormat("HH:mm:ss");    
	private String serverTime = df.format(new Date());
    private String text;
    private String online;
    public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	public Message(String sender,String newtext) {
        text = newtext;
        if (text.length() > 256) {
            text = text.substring(0, 256);
        }
        text = sender+" ˵ "+"("+serverTime+"):<br/>"+text;
    }
    public String getText() {
        return text;
    }
    
    
}
