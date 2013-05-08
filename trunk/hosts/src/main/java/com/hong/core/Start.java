package com.hong.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

import com.hong.util.ConfigUtil;
import com.hong.util.IpUtil;

public class Start {
	public static void main(String[] args) throws IOException {
		String host = ConfigUtil.get(ConfigUtil.HOST);
		
		String ip = IpUtil.getIpByHost(ConfigUtil.get(ConfigUtil.HOST));
		
		if (ip == null) {
			System.out.println("Can't Find Host: " + host);
			return;
		}
		System.out.println(host + " ip :" + ip);
		
		String mappingHost = ConfigUtil.get(ConfigUtil.MAPPINGHOST);
		String mappingHostStr = ip + " " + mappingHost;
		
		String filePath = ConfigUtil.get(ConfigUtil.FILEPATH);
		
		File file = new File(filePath);
		
		LineNumberReader reader = new  LineNumberReader(new InputStreamReader(new FileInputStream(file)));
		String crlf = "\r\n";
		StringBuilder buf = new StringBuilder();
		String str;
		boolean containMappingHost = false;
		while ((str = reader.readLine()) != null) {
			if (str.contains(mappingHost)) {
				containMappingHost = true;
				str = mappingHostStr;
			}
			buf.append(crlf).append(str);
		}
		if (buf.length() > 0) {
			buf.delete(0, 2);
		} else {
			InputStream hostsIs = Thread.currentThread().getContextClassLoader().getResourceAsStream("hosts");
			LineNumberReader hostsReader = new LineNumberReader(new InputStreamReader(hostsIs));
			while ((str = hostsReader.readLine()) != null) {
				buf.append(crlf).append(str);
			}
			if (buf.length() > 0) {
				buf.delete(0, 2);
			}
			hostsIs.close();
			hostsReader.close();
		}
		
		if (!containMappingHost) {
			buf.append(crlf).append(mappingHostStr);
		}
		reader.close();
	
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath));
		osw.write(buf.toString());
		osw.flush();
		
		osw.close();
	}
}
