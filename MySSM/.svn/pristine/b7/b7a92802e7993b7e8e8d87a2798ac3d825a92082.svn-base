package com.org.fsc.ssh.food.service;

import java.util.Map;

public interface FoodService {

	//查询所有食物
	String getAllFood();

	//查询所有食物类型
	String selAllFoodType();

	//查询所有食物类型根据食物类型
	String selAllFoodByFoodType(String foodid);

	//增加一种食物
	String addOneFood(String map);

	//删除恢复一个食物
	String delOrRecoverOneFood(String map);

	//逻辑删除一种食物
	String delOneFood(String map);

	//根据食物id查询多个食物
	String selManyFoodById(String arr);
	
	//后台模糊查询所有食物并分页
	String getAllFoodInfo(Map<String,String> map);
	
	//查询一个食物通过id
	String selOneFoodById(String foodid);

}
