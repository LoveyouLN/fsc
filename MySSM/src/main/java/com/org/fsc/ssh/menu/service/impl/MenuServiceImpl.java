package com.org.fsc.ssh.menu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.org.fsc.ssh.menu.dao.MenuDao;
import com.org.fsc.ssh.menu.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 第一 查询所有菜单
	 * fsc
	 * @return
	 * 2017年12月7日上午9:41:13
	 */
	@Override
	public String selAllMenu() {
		List<?> list=menuDao.selAllMenu();
		String jstr=JSONArray.toJSONString(list);
		return jstr;
	}
	
	/**
	 * 第二 查询所有菜单
	 * fsc
	 * @return
	 * 2017年12月7日上午9:41:13
	 */
	@Override
	public String getAllMenu() {
		List<?> list=menuDao.selAllMenu();
		//储存返回的需要的数据
		List<Map<String,String>> resultListMap=new ArrayList<Map<String,String>>();
		//储存主菜单
		List<Map<String,Object>> mainListMap=new ArrayList<Map<String,Object>>();
		//储存子菜单
		List<Map<String,Object>> sonListMap=new ArrayList<Map<String,Object>>();
		//循环区分主菜单子菜单
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> map=(Map<String, Object>) list.get(i);
			//如果描述为空，则是主菜单
			if( null==map.get("TMENUDESC") ) {
				mainListMap.add(map);
			}else{
				sonListMap.add(map);
			};
		}
		
		//循环主菜单
		for (int i = 0; i < mainListMap.size(); i++) {
			Map<String,Object> mainMap=mainListMap.get(i);
			String mainMenuId=(String) mainMap.get("TMENUID");
			//一次性用来储存即将加到该主菜单的子菜单
			List<Map<String,Object>> tempListMap=new ArrayList<Map<String,Object>>();
			//循环子菜单
			for (int j = 0; j < sonListMap.size(); j++) {
				Map<String,Object> map=sonListMap.get(j);
				if( map.get("FID").equals(mainMenuId) ) {
					tempListMap.add(map);
					map.remove("");
				}
			}
			if(tempListMap!=null) {
				mainMap.put("list", tempListMap);
			}
		}
		String jstr=JSONArray.toJSONString(mainListMap);
		return jstr;
	}

}
