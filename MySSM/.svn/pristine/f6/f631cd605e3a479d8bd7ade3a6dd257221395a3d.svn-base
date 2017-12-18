package com.org.fsc.ssh.food.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.food.dao.FoodDao;
import com.org.fsc.ssh.food.service.FoodService;

@Service("/foodService")
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDao foodDao;

	/**
	 * 查询所有食物
	 * fsc
	 * @return
	 * 2017年12月7日下午1:04:16
	 */
	@Override
	public String getAllFood() {
		List<?> listAllFoodType=foodDao.selAllFoodType();
		//需要返回的结果集
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		for( int i=0;i<listAllFoodType.size();i++ ) {
			Map<String,String> foodListTYpe=(Map<String, String>) listAllFoodType.get(i);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id",foodListTYpe.get("FOODTYPEID"));
			map.put("name",foodListTYpe.get("FOODTYPENAME"));
			List<?> foodListByType=foodDao.selAllFoodByFoodType(foodListTYpe.get("FOODTYPEID"));
			map.put("list",foodListByType);
			listMap.add(map);
		}
		String jstr=JSONObject.toJSONString(listMap);
		return jstr;
	}

	/**
	 * 查询所有食物类型
	 * fsc
	 * @return
	 * 2017年12月5日上午10:20:49
	 */
	@Override
	public String selAllFoodType() {
		List<?> list=foodDao.selAllFoodType();
		String jstr=JSONArray.toJSONString(list);
		return jstr;
	}

	/**
	 * 根据食物类型查询所有食物
	 * fsc
	 * @param foodid
	 * @return
	 * 2017年12月5日上午10:20:22
	 */
	@Override
	public String selAllFoodByFoodType(String foodid) {
		return null;
	}

	/**
	 * 增加一种食物
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午3:32:23
	 */
	@Override
	public String addOneFood(String map) {
		JSONObject jsob=JSONObject.parseObject(map);
		String newMyFoodId=new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		jsob.put("myfoodid", newMyFoodId);
		jsob.put("isdel", "0");
		Map<String,String> resultMap=new HashMap<String,String>();
		if(foodDao.addOneFood(jsob)==1) {
			resultMap.put("resultCode", "200");
		}else {
			resultMap.put("resultCode", "500");
		}
		String resultjsob=JSONObject.toJSONString(resultMap);
		return resultjsob;
	}

	/**
	 * 删除恢复一种食物
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午3:32:38
	 */
	@Override
	public String delOrRecoverOneFood(String map) {
		JSONObject jsob=JSONObject.parseObject(map);
		Map<String,String> resultMap=new HashMap<String,String>();
		if(foodDao.delOrRecoverOneFood(jsob)==1) {
			resultMap.put("Code", "200");
		}else {
			resultMap.put("Code", "500");
		}
		String resultjsob=JSONObject.toJSONString(resultMap);
		return resultjsob;
	}

	/**
	 * 删除一种食物
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午3:32:47
	 */
	@Override
	public String delOneFood(String map) {
		JSONObject jsob=JSONObject.parseObject(map);
		jsob.put("isdel", "1");
		Map<String,String> resultMap=new HashMap<String,String>();
		if(foodDao.delOneFood(jsob)==1) {
			resultMap.put("resultCode", "200");
		}else {
			resultMap.put("resultCode", "500");
		}
		String resultjsob=JSONObject.toJSONString(resultMap);
		return resultjsob;
	}

	/**
	 * 根据食物id查询多个食物
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月6日上午9:47:05
	 */
	@Override
	public String selManyFoodById(String arr) {
		List<?> resultList=foodDao.selManyFoodById(arr.trim().split(","));
		String resultjsar=JSONArray.toJSONString(resultList);
		return resultjsar;
	}

	/**
	 * 后台模糊查询所有食物并分页
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月12日上午10:34:44
	 */
	@Override
	public String getAllFoodInfo(Map<String, String> map) {
		//返回结果的容器
		Map<String,Object> resultMap=new HashMap<String,Object>();
		List<?> resultList=foodDao.getAllFoodInfo(map);
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", selAllFoodCount().intValue());
		resultMap.put("data", resultList);
		return JSONObject.toJSONString(resultMap);
	}
	
	/**
	 * 查询所有食物数量
	 * fsc
	 * @return
	 * 2017年12月12日下午4:22:12
	 */
	private BigDecimal selAllFoodCount() {
		if(foodDao.selAllFoodCount().size()==1) {
			Map<String,Object> resultMap=(Map<String, Object>) foodDao.selAllFoodCount().get(0);
			return (BigDecimal)resultMap.get("R") ;
		}else{
			return  null;
		}
	}

	/**
	 * 查询一个食物通过id
	 * fsc
	 * @return
	 * 2017年12月12日下午3:58:20
	 */
	@Override
	public String selOneFoodById(String foodid) {
		return JSONObject.toJSONString(foodDao.selOneFoodById(foodid).get(0));
	}

}
