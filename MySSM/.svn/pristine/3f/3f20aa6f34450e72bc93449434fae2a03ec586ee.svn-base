package com.org.fsc.ssh.teble.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.fsc.ssh.teble.dao.TableDao;

@Repository("tableDao")
public class TableDaoImpl implements TableDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 查询所有桌子信息
	 * fsc
	 * @return
	 * 2017年12月5日上午11:17:40
	 */
	@Override
	public List<?> selAllTable() {
		return sqlSessionTemplate.selectList("TableMapper.selAllTable");
	}
	/**
	 * 新增一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日上午11:20:21
	 */
	@Override
	public int addOneTable(Map<String, String> map) {
		return sqlSessionTemplate.insert("TableMapper.addOneTable",map);
	}
	/**
	 * 修改一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日上午11:20:36
	 */
	@Override
	public int updOneTable(Map<String, String> map) {
		return sqlSessionTemplate.update("TableMapper.updOneTable",map);
	}
	/**
	 * 逻辑删除一个桌子
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日上午11:20:47
	 */
	@Override
	public int delOneTable(Map<String, String> map) {
		return sqlSessionTemplate.update("TableMapper.delOneTable",map);
	}
	/**
	 * 后台分页查询所有桌子信息
	 * fsc
	 * @return
	 * 2017年12月9日下午4:39:47
	 */
	@Override
	public List<?> selAllTableInfo(Map<String,String> map) {
		return sqlSessionTemplate.selectList("TableMapper.selAllTableInfo",map);
	}
	/**
	 * 查询一个桌子信息
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月10日下午3:03:50
	 */
	@Override
	public List<?> selOneTableInfo(Map<String, String> map) {
		return sqlSessionTemplate.selectList("TableMapper.selOneTableInfo",map);
	}
	
	/**
	 * 修改一个桌子的状态
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月13日上午10:02:21
	 */
	@Override
	public int updOneTableState(Map<String, String> map) {
		return sqlSessionTemplate.update("TableMapper.updOneTableState",map);
	}

}
