package com.norming.ess.base.web.custom;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.norming.ess.base.util.DateUtil;


/**
 * 配置前后台类型转换策略.
 * @author lh.jia
 * @date ..
 */
public class CustomWebBinding implements WebBindingInitializer {
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 1. 使用spring自带的CustomDateEditor
		binder.registerCustomEditor(Date.class, new CustomDateEditor(DateUtil.TRANS_FORMAT_DATE, true));

		
		// 2. 自定义的PropertyEditorSupport
		binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(DateUtil.TRANS_FORMAT_STAMP, true));
	}
}