package com.norming.num;

import com.norming.as.bo.option.NumConstant;
import com.norming.netty.adapter.NumberClinetAdapter;
import com.norming.netty.adapter.NumberRefreshClinetAdapter;
import com.norming.netty.config.NettyConfig;
import com.norming.num.impl.CustomerNumber;
import com.norming.num.impl.ExpenseNumber;
import com.norming.num.impl.TimesheetNumber;

public class NumberFactory {
	
	public static INumber getNumberSingle(String type) {
		if (NumConstant.TIMESHEET.equals(type)) {
			return new TimesheetNumber();
		}
		if (NumConstant.EXPENSE_REPORT.equals(type)) {
			return new ExpenseNumber();
		}
		//add condition here.
		return null;
	}
	
	public static INumber getNumberCustom(String type) {
		if(NumConstant.BUSINESSPARTNER.equals(type)){
			return new CustomerNumber();
		}
		//add condition here.
		return null;
	}
	
	public static INumber getBatchNumber(String type){
		//add condition here.
		return null;
	}
	
	public static INumber getDocNumber(){
		//add condition here.
		return null;
	}
	
	public static NumberClinetAdapter getNumberClinetAdapter(String type) {
		NumberClinetAdapter adapter = new NumberClinetAdapter();
		adapter.setHost(NettyConfig.get(NettyConfig.NETTY_HOST));
		
		if (NumConstant.TIMESHEET.equals(type)) {
			adapter.setPort(NettyConfig.getInt("netty.timesheet.port"));
		} else if (NumConstant.LEAVE.equals(type)) {
			adapter.setPort(NettyConfig.getInt("netty.leave.port"));
			adapter.setPort(NettyConfig.getInt("netty.cashAdvance.port"));
		} else if (NumConstant.EXPENSE_REPORT.equals(type)) {
			adapter.setPort(NettyConfig.getInt("netty.expense.port"));
			adapter.setPort(NettyConfig.getInt("netty.anyRequest.port"));
		} else if (NumConstant.BUSINESSPARTNER.equals(type)) {
			adapter.setPort(NettyConfig.getInt("netty.customer.port"));
		} else if ("ARCHIVE".equals(type)) {
			adapter.setPort(NettyConfig.getInt("netty.archiveBatch.port"));
		} else if ("DOCUMENT".equals(type)) {
			adapter.setPort(NettyConfig.getInt("netty.document.port"));
		} else {
			return null;
		}
		
		return adapter;
	}
	
	public static NumberRefreshClinetAdapter getNumberRefreshClinetAdapter() {
		NumberRefreshClinetAdapter adapter = new NumberRefreshClinetAdapter();
		adapter.setHost(NettyConfig.get(NettyConfig.NETTY_HOST));
		adapter.setPort(NettyConfig.getInt("netty.refresh.port"));
		
		return adapter;
	}
}