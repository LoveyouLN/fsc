package com.org.fsc.ssh.food.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {

	//查询所有食物
	List<?> selAllFood();

	//查询所有食物类型
	List<?> selAllFoodType();

	//查询所有食物类型根据食物类型
	List<?> selAllFoodByFoodType(String foodid);

	//增加一种食物
	int addOneFood(Object object);

	//删除恢复一种食物
	int delOrRecoverOneFood(Object object);

	//逻辑删除一种食物
	int delOneFood(Object object);

	//根据食物id查询多个食物
	List<?> selManyFoodById(Object object);

	//根据食物名字查询多个食物
	List<?> selManyFoodByName(String[] object);

	//后台模糊查询所有食物并分页
	List<?> getAllFoodInfo(Map<String,String> map);
	
	//查询所有食物数量
	List<?> selAllFoodCount();
	
	//查询一个食物通过id
	List<?> selOneFoodById(Object object);

}
