package cn.com.norming.num.impl;

import cn.com.norming.as.bo.option.NumConstant;

/**
 * 客户代码
 * 
 * @author znlin.zhao
 *
 */
public class CustomerNumber extends AbstractMainNumberCustom {

	public CustomerNumber() {
		super(NumConstant.CM_BP);
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
