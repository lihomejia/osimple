package com.ccic.chat;

import javax.servlet.http.HttpSessionEvent;   
import javax.servlet.http.HttpSessionListener;   
/**
 * 统计在线用户数量  
 * 
 */
public class OnlineCounterListener implements HttpSessionListener{   
	/**
	 * 当SESSION创建时，自动增加
	 */
    public void sessionCreated(HttpSessionEvent hse) {    
        OnlineCounter.raise();     
    }    
    /**
	 * 当SESSION销毁时，自动减少
	 */
   public void sessionDestroyed(HttpSessionEvent hse){     
        OnlineCounter.reduce();   
    }    
}    