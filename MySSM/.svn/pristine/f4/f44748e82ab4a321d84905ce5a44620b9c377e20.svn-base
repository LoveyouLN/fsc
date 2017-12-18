package com.org.fsc.ssh.menu.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.fsc.ssh.menu.dao.MenuDao;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<?> selAllMenu() {
		List<Object> list=sqlSessionTemplate.selectList("MenuMapper.selAllMenu");
		return list;
	}

}
