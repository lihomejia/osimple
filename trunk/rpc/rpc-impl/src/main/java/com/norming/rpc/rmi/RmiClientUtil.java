package com.norming.rpc.rmi;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class RmiClientUtil {
	
	private static Log log = LogFactory.getLog(RmiClientUtil.class);
	
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getRemoteObjects(String remoteName) {
		List<T> list = new ArrayList<T>();
		
		String hostsStr = "localhost|localhost";
		String portsStr = "1099|1099";
		
		String[] hosts = hostsStr.split("\\|");
		String[] ports = portsStr.split("\\|");
		
		int count = hosts.length > ports.length ? ports.length : hosts.length;
		
		for (int i = 0; i < count; i++) {
			
			T remoteObj = null;
			String host = hosts[i];
			String port = ports[i];
			String name = "rmi://" + host + ":" + port + "/" + remoteName;
			try {
				remoteObj = (T) Naming.lookup(name);
			} catch (Exception e) {
				log.error("getRemoteObject() - " + e);
			}
			if (remoteObj == null) {
			    log.error("remoteObj(" + name + ") is null");
			    continue;
			}
			list.add(remoteObj);
		}
		return list;
	}
	

	public static void main(String[] args) {
	
	}
}
