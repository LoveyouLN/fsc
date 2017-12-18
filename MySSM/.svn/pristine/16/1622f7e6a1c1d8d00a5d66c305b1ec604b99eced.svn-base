package com.org.fsc.wx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.fsc.wx.dao.WXDao;
import com.org.fsc.wx.service.WXService;

@Service("wXService")
public class WXServiceImpl implements WXService{

	@Autowired
	private WXDao WxDao;
	//处理微信端请求
	@Override
	public String handleWX(String inputContent) {
		List<?> resultList=WxDao.handleWX(inputContent);
		if(resultList.size()==1) {
			Map<String,String> resultMap=(Map<String, String>) resultList.get(0);
			return resultMap.get("OUTPUTVALUE");
		}else {
			return "请输入正确的指令!";
		}
		
	}

}
