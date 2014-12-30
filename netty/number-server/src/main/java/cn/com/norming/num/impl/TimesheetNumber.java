package cn.com.norming.num.impl;

import cn.com.norming.as.bo.option.NumConstant;

public class TimesheetNumber extends AbstractNumberSingle {
	
	public TimesheetNumber() {
		super(NumConstant.TIMESHEET);
	}

	@Override
	public String getTable() {
		return "TSWSH";
	}
	
	@Override
	public String getField() {
		return "TSWSH_IDWS";
	}
}