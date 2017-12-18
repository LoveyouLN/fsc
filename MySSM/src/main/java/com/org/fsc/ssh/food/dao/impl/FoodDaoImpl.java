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
	 * ��ѯ����ʳ��
	 * fsc
	 * @return
	 * 2017��12��5������8:48:25
	 */
	@Override
	public List<?> selAllFood() {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFood");
	}

	/**
	 * ��ѯ����ʳ������
	 * fsc
	 * @return
	 * 2017��12��5������9:11:55
	 */
	@Override
	public List<?> selAllFoodType() {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFoodType");
	}

	/**
	 * ��ѯ����ʳ������
	 * fsc
	 * @param foodid
	 * @return
	 * 2017��12��5������3:14:29
	 */
	@Override
	public List<?> selAllFoodByFoodType(String foodid) {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFoodByType",foodid);
	}

	/**
	 * ����һ��ʳ��
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��5������3:14:48
	 */
	@Override
	public int addOneFood(Object object) {
		return sqlSessionTemplate.insert("FoodMapper.addOneFood",object);
	}

	/**
	 * ɾ���ָ�һ��ʳ��
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��5������3:14:57
	 */
	@Override
	public int delOrRecoverOneFood(Object object) {
		return sqlSessionTemplate.update("FoodMapper.updOneFood",object);
	}

	/**
	 * ɾ��һ��ʳ��
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��5������3:15:12
	 */
	@Override
	public int delOneFood(Object object) {
		return sqlSessionTemplate.update("FoodMapper.delOneFood",object);
	}

	/**
	 * ����ʳ��id��ѯ���ʳ��
	 * Administrator
	 * @param object
	 * @return
	 * 2017��12��6������9:44:12
	 */
	@Override
	public List<?> selManyFoodById(Object object) {
		return sqlSessionTemplate.selectList("FoodMapper.selManyFoodById",object);
	}

	/**
	 * ����ʳ�����ֲ�ѯ���ʳ��
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��8������5:06:19
	 */
	@Override
	public List<?> selManyFoodByName(String[] object) {
		return sqlSessionTemplate.selectList("FoodMapper.selManyFoodByName",object);
	}

	/**
	 * ��̨ģ����ѯ����ʳ�ﲢ��ҳ
	 * fsc
	 * @param map
	 * @return
	 * 2017��12��12������10:35:32
	 */
	@Override
	public List<?> getAllFoodInfo(Map<String, String> map) {
		return sqlSessionTemplate.selectList("FoodMapper.getAllFoodInfo",map);
	}

	/**
	 * ��ѯ����ʳ������
	 * fsc
	 * @return
	 * 2017��12��12������11:21:23
	 */
	@Override
	public List<?> selAllFoodCount() {
		return sqlSessionTemplate.selectList("FoodMapper.selAllFoodCount");
	}

	/**
	 * ��ѯһ��ʳ��ͨ��id
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��12������3:59:07
	 */
	@Override
	public List<?> selOneFoodById(Object object) {
		return sqlSessionTemplate.selectList("FoodMapper.selOneFoodById",object);
	}

}
