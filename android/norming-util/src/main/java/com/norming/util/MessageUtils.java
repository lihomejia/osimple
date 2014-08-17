package com.norming.util;

import android.os.Handler;
import android.os.Message;

public class MessageUtils {

	
	public static void sendMessage(Handler handler, int what, Object obj) {
		Message msg = new Message();
		msg.obj = obj;
		msg.what = what;
		handler.sendMessage(msg);
	}
}
