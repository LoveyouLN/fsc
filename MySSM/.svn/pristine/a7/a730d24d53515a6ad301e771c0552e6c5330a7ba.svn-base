package com.org.fsc.ssh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.fsc.ssh.common.CommonController;


@Controller
@RequestMapping("/Table")
public class TableController extends CommonController {
	
	/**
	 * 查询所有桌子信息
	 * fsc
	 * @return
	 * 2017年12月5日上午11:56:06
	 */
	@RequestMapping(value="/getAllTable",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAllTable() {
		return tableService.selAllTable();
	}
	
	
	
	/**
	 * 后台分页模糊查询桌子信息
	 * fsc
	 * @return
	 * 2017年12月9日下午12:23:25
	 */
	@RequestMapping(value="/selAllTableInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllTableInfo(HttpServletRequest request) {
		String page=request.getParameter("page");
		String limit=request.getParameter("limit");
		String tableid=request.getParameter("tableid");
		String tablename=request.getParameter("tablename");
		String tablesta=request.getParameter("tablesta");
		Map<String,String> map=new HashMap<String,String>();
		map.put("page", page);
		map.put("limit", limit);
		map.put("tableid", "%"+tableid+"%");
		map.put("tablename", "%"+tablename+"%");
		map.put("tablesta", "%"+tablesta+"%");
		return tableService.selAllTableInfo(map);
	}
	
	@RequestMapping(value="/selOneTableInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selOneTableInfo(HttpServletRequest request) {
		//创建传入的容器
		Map<String,String> map=new HashMap<String,String>();
		String mytableid=request.getParameter("tableid");
		String mytablename=request.getParameter("tablename");
		String isuse=request.getParameter("isuse");
		String howmoney=request.getParameter("howmoney");
		if(mytableid==null || mytableid.equals("")) {
			
		}else {
			map.put("mytableid", mytableid);
		}
//		if( mytablename.equals("") || mytablename==null ) {
//			
//		}else {
//			map.put("mytablename", mytablename);
//		}
//		if( isuse.equals("") || isuse==null ) {
//			
//		}else {
//			map.put("isuse", isuse);
//		}
//		if( howmoney.equals("")|| howmoney==null ) {
//			
//		}else{
//			map.put("howmoney", howmoney);
//		}
		return tableService.selOneTableInfo(map);
	}
	
	/**
	 * 新增或修改一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午4:05:36
	 */
	@RequestMapping(value="/addOrUpdOneTable",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addOrUpdOneTable(HttpServletRequest request) {
		Map<String,String> map=new HashMap<String,String>();
		String tableid=request.getParameter("id");
		String tablename=request.getParameter("name");
		String isuse=request.getParameter("isuse");
		String howmoney=request.getParameter("howmoney");
		if(tableid==null || tableid.equals("")) {
			map.put("mytablename", tablename);
			return tableService.addOneTable(map);
		}else {
			map.put("mytableid", tableid);
			map.put("mytablename", tablename);
			map.put("isuse", isuse);
			map.put("howmoney", howmoney);
			return tableService.updOneTable(map);
		}
		
	}
	
	/**
	 * 修改一个桌子状态
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午4:05:54
	 */
	@RequestMapping(value="/updOneTableState",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updOneTableState(HttpServletRequest request) {
		String mytableid=request.getParameter("mytableid");
		String howmoney=request.getParameter("howmoney");
		String isuse=request.getParameter("isuse");
		Map<String,String> map=new HashMap<String,String>();
		map.put("mytableid", mytableid);
		map.put("howmoney", howmoney);
		map.put("isuse", isuse);
		return tableService.updOneTableState(map);
	}
	
	/**
	 * 逻辑删除一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午4:06:23
	 */
	@RequestMapping(value="/delOneTable",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOneTable(HttpServletRequest request) {
		String tableid=request.getParameter("id");
		String isdel=request.getParameter("isdel");
		Map<String,String> map=new HashMap<String,String>();
		map.put("mytableid", tableid);
		map.put("isdel", isdel);
		return tableService.delOneTable(map);
	}

}
