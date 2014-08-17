package com.norming.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HttpActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        
    }
	
	
	public void onViewSource(View v) {
		Intent intent = new Intent(this, ViewSourceActivity.class);
    	startActivity(intent);
	}
}
