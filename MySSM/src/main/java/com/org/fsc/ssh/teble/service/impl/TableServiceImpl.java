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
	 * 查询所有桌子信息
	 * fsc
	 * @return
	 * 2017年12月5日上午10:50:29
	 */
	@Override
	public String selAllTable() {
		List<?> list=tableDao.selAllTable();
		String jstr=JSONArray.toJSONString(list);
		return jstr;
	}

	/**
	 * 新增一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日上午11:54:58
	 */
	@Override
	public String addOneTable(Map<String,String> map) {
		String newMyTableId=new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		map.put("mytableid", newMyTableId);
		map.put("isdel", "0");
		map.put("isuse", "未使用");
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
	 * 更新一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日上午11:55:15
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
	 * 逻辑删除一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日上午11:55:25
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
	 * 后台分页模糊查询所有桌子
	 * fsc
	 * @return
	 * 2017年12月9日下午12:27:53
	 */
	@Override
	public String selAllTableInfo(Map<String,String> map) {
		List<?> list=tableDao.selAllTableInfo(map);
		//layui需要数据
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", selAllTableCount());
		resultMap.put("data", list);
		String jsob=JSONObject.toJSONString(resultMap);
		return jsob;
	}

	/**
	 * 查询所有桌子数量
	 * fsc
	 * @return
	 * 2017年12月10日下午3:02:45
	 */
	public int selAllTableCount() {
		return tableDao.selAllTable().size();
	}

	/**
	 * 查询一个桌子根据tableid
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月10日下午3:02:41
	 */
	@Override
	public String selOneTableInfo(Map<String, String> map) {
		//需要返回的容器
		Map<String,String> resultMap=new HashMap<String,String>();
		//查询的一个结果
		List<?> resultList=tableDao.selOneTableInfo(map);
		if( resultList.size()==1 ) {
			return JSONObject.toJSONString(resultList.get(0));
		}else{
			resultMap.put("Code", "500");
			return JSONObject.toJSONString(resultMap);
		}
	}

	/**
	 * 修改一个桌子的状态
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月13日上午10:01:53
	 */
	@Override
	public String updOneTableState(Map<String, String> map) {
		//需要返回的容器
		Map<String,String> resultMap=new HashMap<String,String>();
		if(tableDao.updOneTableState(map)==1) {
			resultMap.put("Code", "200");
		}else{
			resultMap.put("Code", "500");
		};
		return JSONObject.toJSONString(resultMap);
	}

}
