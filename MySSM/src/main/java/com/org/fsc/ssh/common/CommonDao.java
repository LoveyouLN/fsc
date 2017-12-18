package com.org.fsc.ssh.common;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<?>  selManyDate(String mapper){
		return sqlSessionTemplate.selectList(mapper);
	}

}
