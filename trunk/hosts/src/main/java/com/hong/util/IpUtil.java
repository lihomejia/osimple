package com.hong.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtil {
	
	public static String getIpByHost(String host) {
		try {
			return InetAddress.getByName(host).getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
