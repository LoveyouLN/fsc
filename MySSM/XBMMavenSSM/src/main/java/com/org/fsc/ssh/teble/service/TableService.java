package com.org.fsc.ssh.teble.service;

import java.util.Map;

public interface TableService {

	//查询所有桌子信息
	String selAllTable();

	//查询所有桌子信息
	String selAllTableInfo(Map<String,String> map);

	//新增一个桌子
	String addOneTable(Map<String,String> map);
	
	//查询一个桌子根据tableid
	String selOneTableInfo(Map<String,String> map);

	//修改一个桌子
	String updOneTable(Map<String,String> map);

	//逻辑删除一个桌子
	String delOneTable(Map<String,String> map);
	
	//修改一个桌子的状态
	String updOneTableState(Map<String,String> map);

}
