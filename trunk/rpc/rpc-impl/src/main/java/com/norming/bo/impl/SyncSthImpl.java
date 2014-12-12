package com.norming.bo.impl;

import java.io.Serializable;
import java.rmi.Remote;

import com.norming.bo.ISyncSth;

public class SyncSthImpl implements ISyncSth, Remote, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void syncSth1(String args0) {
	}

	@Override
	public int syncSth2(int args0) {
		System.out.println("called syncSth2, args0:" + args0);
		return 10;
	}

	@Override
	public String syncSth3(int args0, String args1) {
		return null;
	}

}
