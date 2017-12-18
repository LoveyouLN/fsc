package com.org.fsc.ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.fsc.ssh.common.CommonController;

@Controller
@RequestMapping("/Menu")
public class MenuController extends CommonController {
	
	/**
	 * ��һ
	 * fsc
	 * @return
	 * 2017��12��7������9:40:45
	 */
	@RequestMapping(value="/getMenu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMenu() {
		return menuService.selAllMenu();
	}
	
	/**
	 * �ڶ�
	 * fsc
	 * @return
	 * 2017��12��7������9:40:54
	 */
	@RequestMapping(value="/getAllMenu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAllMenu() {
		return menuService.getAllMenu();
	}

}
