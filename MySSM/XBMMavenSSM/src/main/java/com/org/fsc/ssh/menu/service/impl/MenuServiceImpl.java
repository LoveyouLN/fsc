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
	 * ��һ ��ѯ���в˵�
	 * fsc
	 * @return
	 * 2017��12��7������9:41:13
	 */
	@Override
	public String selAllMenu() {
		List<?> list=menuDao.selAllMenu();
		String jstr=JSONArray.toJSONString(list);
		return jstr;
	}
	
	/**
	 * �ڶ� ��ѯ���в˵�
	 * fsc
	 * @return
	 * 2017��12��7������9:41:13
	 */
	@Override
	public String getAllMenu() {
		List<?> list=menuDao.selAllMenu();
		//���淵�ص���Ҫ������
		List<Map<String,String>> resultListMap=new ArrayList<Map<String,String>>();
		//�������˵�
		List<Map<String,Object>> mainListMap=new ArrayList<Map<String,Object>>();
		//�����Ӳ˵�
		List<Map<String,Object>> sonListMap=new ArrayList<Map<String,Object>>();
		//ѭ���������˵��Ӳ˵�
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> map=(Map<String, Object>) list.get(i);
			//�������Ϊ�գ��������˵�
			if( null==map.get("TMENUDESC") ) {
				mainListMap.add(map);
			}else{
				sonListMap.add(map);
			};
		}
		
		//ѭ�����˵�
		for (int i = 0; i < mainListMap.size(); i++) {
			Map<String,Object> mainMap=mainListMap.get(i);
			String mainMenuId=(String) mainMap.get("TMENUID");
			//һ�����������漴���ӵ������˵����Ӳ˵�
			List<Map<String,Object>> tempListMap=new ArrayList<Map<String,Object>>();
			//ѭ���Ӳ˵�
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
