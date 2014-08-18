package com.norming.tutorial;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.norming.util.FileUtil;

public class RwFileActivity extends Activity {
private static final String FILE_NAME = "file.txt";
	
	private EditText et_text, et_user, et_pass;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rwfile);
		
		et_text = (EditText) findViewById(R.id.et_text);
		et_user = (EditText) findViewById(R.id.et_user);
		et_pass = (EditText) findViewById(R.id.et_pass);
		
		
		
		
	}
	
	
	/**
	 * 读取已保存的文件内容 
	 * @param v
	 */
	public void read(View v) {
		String str = FileUtil.readFile(this.getFile());
		
		if (TextUtils.isEmpty(str)) {
			Toast.makeText(this, "没有读取到内容", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "读取到内容:" + str, Toast.LENGTH_SHORT).show();
		}
		
	}
	
	
	/**
	 * 将文本框中的内容保存到文件 
	 * @param v
	 */
	public void write(View v) {
		
		String text = et_text.getText().toString().trim();
		
		if (TextUtils.isEmpty(text)) {
			Toast.makeText(this, "没有需要保存的内容", Toast.LENGTH_SHORT).show();
			return;
		}
		
		FileUtil.writeFile(this.getFile(), text, false);
		
		Toast.makeText(this, "数据保存成功", Toast.LENGTH_SHORT).show();
		
	}
	
	/**
	 * 获取要操作的文件
	 * @return
	 */
	private File getFile() {
		/**
		 * Returns the absolute path to the directory on the filesystem.
		 * /data/data/com.norming.rwfile/files
		 */
		File dir = getFilesDir();
		
		File file = new File(dir, FILE_NAME);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	
	/**
	 * 读取已保存的文件内容2，采用SharedPreferences的方式，而不是直接操作文件.
	 * 好处：1. 它提供的api更方便使用
	 * 		2. 采用key-value的方式，规范化数据的存储
	 * 		3. 屏蔽了xml中的关键字,如 "<"、">"等
	 * @param v
	 */
	public void read2(View v) {
		SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		
		String show = "用户名:" + preferences.getString("u", "") + "\n密码:" + preferences.getString("p", "");
		
		Toast.makeText(this, show, Toast.LENGTH_SHORT).show();
	}
	
	
	
	/**
	 * 将文本框中的内容保存到文件2，采用SharedPreferences的方式，而不是直接操作文件.
	 * 好处：1. 它提供的api更方便使用
	 * 		2. 采用key-value的方式，规范化数据的存储
	 * 		3. 屏蔽了xml中的关键字,如 "<"、">"等
	 * @param v
	 */
	public void write2(View v) {
		String u = et_user.getText().toString().trim();
		String p = et_pass.getText().toString().trim();
		
		if (TextUtils.isEmpty(u) || TextUtils.isEmpty(p)) {
			Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		
		SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		
		Editor editor = preferences.edit();
		editor.putString("u", u);
		editor.putString("p", p);
		
		editor.commit();
		
		Toast.makeText(this, "数据保存成功", Toast.LENGTH_SHORT).show();
	}
}
