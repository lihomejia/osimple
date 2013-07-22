package cn.com.norming.base.web.bind;

import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import cn.com.norming.base.util.DateUtil;

public class SimpleWebBinding implements WebBindingInitializer {
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 1. 使用spring自带的CustomDateEditor
		binder.registerCustomEditor(Date.class, new CustomDateEditor(DateUtil.DEF_SDF, true));

		// 2. 自定义的PropertyEditorSupport
		// binder.registerCustomEditor(Date.class, new DateConvertEditor());

	}

}
