package com.org.fsc.wx.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.fsc.wx.dao.WXDao;

@Repository("wXDao")
public class WXDaoImpl implements WXDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<?> handleWX(String inputvalue) {
		return sqlSessionTemplate.selectList("MyWxMapper.handleWX", inputvalue);
	}

}
