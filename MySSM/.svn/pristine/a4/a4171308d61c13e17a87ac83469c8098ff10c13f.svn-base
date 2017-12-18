package com.org.fsc.ssh.food.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.fsc.ssh.food.dao.FoodDao;

@Repository("foodDao")
public class FoodDaoImpl implements FoodDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询所有食物
	 * fsc
	 * @return
	 * 2017年12月5日上午8:48:25
	 */
	@Override
	public List<?> selAllFood() {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFood");
	}

	/**
	 * 查询所有食物类型
	 * fsc
	 * @return
	 * 2017年12月5日上午9:11:55
	 */
	@Override
	public List<?> selAllFoodType() {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFoodType");
	}

	/**
	 * 查询所有食物类型
	 * fsc
	 * @param foodid
	 * @return
	 * 2017年12月5日下午3:14:29
	 */
	@Override
	public List<?> selAllFoodByFoodType(String foodid) {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFoodByType",foodid);
	}

	/**
	 * 增加一个食物
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月5日下午3:14:48
	 */
	@Override
	public int addOneFood(Object object) {
		return sqlSessionTemplate.insert("FoodMapper.addOneFood",object);
	}

	/**
	 * 删除恢复一种食物
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月5日下午3:14:57
	 */
	@Override
	public int delOrRecoverOneFood(Object object) {
		return sqlSessionTemplate.update("FoodMapper.updOneFood",object);
	}

	/**
	 * 删除一种食物
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月5日下午3:15:12
	 */
	@Override
	public int delOneFood(Object object) {
		return sqlSessionTemplate.update("FoodMapper.delOneFood",object);
	}

	/**
	 * 根据食物id查询多个食物
	 * Administrator
	 * @param object
	 * @return
	 * 2017年12月6日上午9:44:12
	 */
	@Override
	public List<?> selManyFoodById(Object object) {
		return sqlSessionTemplate.selectList("FoodMapper.selManyFoodById",object);
	}

	/**
	 * 根据食物名字查询多个食物
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月8日下午5:06:19
	 */
	@Override
	public List<?> selManyFoodByName(String[] object) {
		return sqlSessionTemplate.selectList("FoodMapper.selManyFoodByName",object);
	}

	/**
	 * 后台模糊查询所有食物并分页
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月12日上午10:35:32
	 */
	@Override
	public List<?> getAllFoodInfo(Map<String, String> map) {
		return sqlSessionTemplate.selectList("FoodMapper.getAllFoodInfo",map);
	}

	/**
	 * 查询所有食物数量
	 * fsc
	 * @return
	 * 2017年12月12日上午11:21:23
	 */
	@Override
	public List<?> selAllFoodCount() {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFoodCount");
	}

	/**
	 * 查询一个食物通过id
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月12日下午3:59:07
	 */
	@Override
	public List<?> selOneFoodById(Object object) {
		return sqlSessionTemplate.selectList("FoodMapper.selOneFoodById",object);
	}

}
