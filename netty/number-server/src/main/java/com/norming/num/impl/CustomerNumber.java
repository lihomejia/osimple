package com.norming.num.impl;

import com.norming.as.bo.option.NumConstant;

/**
 * 客户代码
 *
 */
public class CustomerNumber extends AbstractMainNumberCustom {

	public CustomerNumber() {
		super(NumConstant.BUSINESSPARTNER);
	}

	@Override
	public String getField() {
		return "CMCUST2_CODE";
	}

	@Override
	public String getTable() {
		return "CMCUST2";
	}
	
}
