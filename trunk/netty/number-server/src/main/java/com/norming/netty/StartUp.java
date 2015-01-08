package com.norming.netty;

import org.tanukisoftware.wrapper.WrapperListener;

import com.norming.netty.bootstrap.ServerStartup;

public class StartUp implements WrapperListener {
	
	public static void main(String[] args) throws Exception {
		new ServerStartup().startup();
	}

	@Override
	public void controlEvent(int arg0) {
	}

	@Override
	public Integer start(String[] arg0) {
		try {
			main(arg0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int stop(int arg0) {
		return 0;
	}
}