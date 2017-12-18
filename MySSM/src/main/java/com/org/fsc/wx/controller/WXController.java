package com.org.fsc.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.fsc.wx.service.WXService;


@Controller
@RequestMapping("/WX")
public class WXController {
	
	@Autowired
	private WXService wXService;
	
	/**
	 * ����΢�Ŷ˴������źŷ�����Ӧ��url
	 * fsc
	 * @param inputContent
	 * @return
	 * 2017��12��10������9:52:40
	 */
	@RequestMapping(value="/handleWX",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String handleWX(String inputContent) {
		return wXService.handleWX(inputContent);
	}
	
	@RequestMapping(value="/Welcome",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Welcome() {
		
		return "Welecome ����";
	}

}
