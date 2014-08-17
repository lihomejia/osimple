package com.norming.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.norming.util.MessageUtils;
import com.norming.util.ToastUtils;

public class ViewSourceActivity extends Activity {

	private static final int SUCCESS = 1;

	private static final int FAILURE = 0;

	private EditText et_path;
	private TextView et_content;

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SUCCESS:
				et_content.setText((CharSequence) msg.obj);
				break;
			case FAILURE:
				Toast.makeText(ViewSourceActivity.this, (CharSequence) msg.obj,
						Toast.LENGTH_SHORT).show();
				break;
			}
		};
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewsource);

		et_path = (EditText) findViewById(R.id.et_path);
		et_content = (TextView) findViewById(R.id.et_content);
	}

	public void onGo(View v) {

		final String path = et_path.getText().toString().trim();

		if (TextUtils.isEmpty(path)) {
			ToastUtils.show(this, "URL不能为空");
			return;
		}

		new Thread() {
			@Override
			public void run() {
				
				URL url = null;
				
				try {
					url = new URL(path);
				} catch (MalformedURLException e) {
					e.printStackTrace();
					MessageUtils.sendMessage(handler, FAILURE, "解析URL失败:" + e.getMessage());
					return;
				}
				
				try {
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setConnectTimeout(5000);
					conn.setReadTimeout(5000);
					
					int code = conn.getResponseCode();
					
					if (200 == code) {
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						
						StringBuilder sb = new StringBuilder();
		                String s;
		                while ((s = reader.readLine()) != null) {
		                    sb.append(s).append("\n");
		                }
		                MessageUtils.sendMessage(handler, SUCCESS, sb.toString());
					} else {
						MessageUtils.sendMessage(handler, FAILURE, "错误代码:" + code);
					}
				} catch (Exception e) {
					MessageUtils.sendMessage(handler, FAILURE, "错误信息:" + e.getMessage());
				}
				
			}
		}.start();
	}
}
