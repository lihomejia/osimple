package com.norming.num.impl;

import com.norming.as.bo.option.NumConstant;

/**
 * 费用单据编号
 * 
 * @author znlin.zhao
 *
 */
public class ExpenseNumber extends AbstractNumberSingle {

	public ExpenseNumber() {
		super(NumConstant.EXPENSE_REPORT);
	}

	@Override
	public String getField() {
		return "EREXPH_EXPID";
	}

	@Override
	public String getTable() {
		return "EREXPH";
	}
	
}
