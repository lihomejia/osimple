package com.bms.resource.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.base.util.BaseDto;
import com.bms.base.util.Dto;
import com.bms.resource.enumeration.DictType;
import com.util.New;

@Controller
@RequestMapping(value="/resource/dictType")
public class DictTypeController {

	@ResponseBody
	@RequestMapping(value="/list")
	public List<Dto> list() {
		List<Dto> list = New.arrayList();
		for (DictType dictType : DictType.values()) {
			Dto dto = new BaseDto();
			dto.put("type", dictType.toString());
			dto.put("desc", dictType.getDesc());
			
			list.add(dto);
		}
		return list;
	}

}
