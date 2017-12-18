package com.org.fsc.ssh.teble.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.teble.dao.TableDao;
import com.org.fsc.ssh.teble.service.TableService;

@Service("tableService")
public class TableServiceImpl implements TableService {
	@Autowired
	private TableDao tableDao;

	/**
	 * ��ѯ����������Ϣ
	 * fsc
	 * @return
	 * 2017��12��5������10:50:29
	 */
	@Override
	public String selAllTable() {
		List<?> list=tableDao.selAllTable();
		String jstr=JSONArray.toJSONString(list);
		return jstr;
	}

	/**
	 * ����һ������
	 * fsc
	 * @param map
	 * @return
	 * 2017��12��5������11:54:58
	 */
	@Override
	public String addOneTable(Map<String,String> map) {
		String newMyTableId=new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		map.put("mytableid", newMyTableId);
		map.put("isdel", "0");
		map.put("isuse", "δʹ��");
		map.put("howmoney", "0");
		Map<String,String> resultMap=new HashMap<String,String>();
		if(tableDao.addOneTable(map)==1) {
			resultMap.put("resultCode", "200");
		}else {
			resultMap.put("resultCode", "500");
		}
		String resultJsob=JSONObject.toJSONString(resultMap);
		return resultJsob;
	}

	/**
	 * ����һ������
	 * fsc
	 * @param map
	 * @return
	 * 2017��12��5������11:55:15
	 */
	@Override
	public String updOneTable(Map<String,String> map) {
		Map<String,String> resultMap=new HashMap<String,String>();
		map.put("isdel", "0");
		if(tableDao.updOneTable(map)==1) {
			resultMap.put("resultCode", "200");
		}else {
			resultMap.put("resultCode", "500");
		}
		String resultJsob=JSONObject.toJSONString(resultMap);
		return resultJsob;
	}

	/**
	 * �߼�ɾ��һ������
	 * fsc
	 * @param map
	 * @return
	 * 2017��12��5������11:55:25
	 */
	@Override
	public String delOneTable(Map<String,String> map) {
		Map<String,String> resultMap=new HashMap<String,String>();
		if(tableDao.delOneTable(map)==1) {
			resultMap.put("Code", "200");
		}else {
			resultMap.put("Code", "500");
		}
		String resultJsob=JSONObject.toJSONString(resultMap);
		return resultJsob;
	}

	/**
	 * ��̨��ҳģ����ѯ��������
	 * fsc
	 * @return
	 * 2017��12��9������12:27:53
	 */
	@Override
	public String selAllTableInfo(Map<String,String> map) {
		List<?> list=tableDao.selAllTableInfo(map);
		//layui��Ҫ����
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", selAllTableCount());
		resultMap.put("data", list);
		String jsob=JSONObject.toJSONString(resultMap);
		return jsob;
	}

	/**
	 * ��ѯ������������
	 * fsc
	 * @return
	 * 2017��12��10������3:02:45
	 */
	public int selAllTableCount() {
		return tableDao.selAllTable().size();
	}

	/**
	 * ��ѯһ�����Ӹ���tableid
	 * fsc
	 * @param map
	 * @return
	 * 2017��12��10������3:02:41
	 */
	@Override
	public String selOneTableInfo(Map<String, String> map) {
		//��Ҫ���ص�����
		Map<String,String> resultMap=new HashMap<String,String>();
		//��ѯ��һ�����
		List<?> resultList=tableDao.selOneTableInfo(map);
		if( resultList.size()==1 ) {
			return JSONObject.toJSONString(resultList.get(0));
		}else{
			resultMap.put("Code", "500");
			return JSONObject.toJSONString(resultMap);
		}
	}

	/**
	 * �޸�һ�����ӵ�״̬
	 * fsc
	 * @param map
	 * @return
	 * 2017��12��13������10:01:53
	 */
	@Override
	public String updOneTableState(Map<String, String> map) {
		//��Ҫ���ص�����
		Map<String,String> resultMap=new HashMap<String,String>();
		if(tableDao.updOneTableState(map)==1) {
			resultMap.put("Code", "200");
		}else{
			resultMap.put("Code", "500");
		};
		return JSONObject.toJSONString(resultMap);
	}

}
