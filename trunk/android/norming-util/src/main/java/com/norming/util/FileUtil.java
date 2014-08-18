package com.norming.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	
	/**
	 * 读取一个文件内容.
	 * @param file
	 * @return 内容字符串.
	 * 
	 */
	public static String readFile(File file) {
		BufferedReader br = null;
		try {
			StringBuffer sb = new StringBuffer();
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 写入一个文件.
	 * @param file the file to be opened for writing.
	 * @param str 
	 * @param append if <code>true</code>, then bytes will be written
     *                   to the end of the file rather than the beginning
	 * 
	 */
	public static void writeFile(File file, String str, boolean append) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file, append));
			bos.write(str.getBytes());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
