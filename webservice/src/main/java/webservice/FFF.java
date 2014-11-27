package webservice;

import java.security.Security;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class FFF {
	public static void main(String[] args) throws Exception {
		
//		System.setProperty("javax.net.ssl.trustStore", "/home/lihong/.keystore");        
//
//		System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
//
//		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		
//		System.setProperty("javax.net.ssl.trustStore", "/home/lihong/Desktop/jssecacerts");
		
		System.setProperty("javax.net.ssl.keyStore", "/home/lihong/Desktop/client.keystore");
		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
		System.setProperty("javax.net.ssl.trustStore", "/home/lihong/Desktop/client.truststore");
		
		String endpoint = "https://192.168.1.167/axis/TestJws.jws";
//		String endpoint = "http://192.168.1.167:8080/axis/TestJws.jws";
		Service service = new Service();
		Call call = (Call) service.createCall();// 创建call对象
		call.setTargetEndpointAddress(new java.net.URL(endpoint));// 建立连接
		// 调用的方法
		call.setOperationName("getInt");
		// 参数
		Object ret = call.invoke(new Object[] { 1 });
		System.out.println("ret:" + ret);
	}
}
