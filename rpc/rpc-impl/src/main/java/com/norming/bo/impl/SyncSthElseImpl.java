package com.norming.bo.impl;

import java.io.Serializable;
import java.rmi.Remote;

import com.norming.bo.ISyncSthElse;

public class SyncSthElseImpl implements ISyncSthElse, Remote, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void syncSthElse1(String args0) {
	}

	@Override
	public int syncSthElse2(int args0) {
		return 0;
	}

}
