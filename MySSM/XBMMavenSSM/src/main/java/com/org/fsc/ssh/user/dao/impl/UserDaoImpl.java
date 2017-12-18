package com.org.fsc.ssh.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.fsc.ssh.bean.Page;
import com.org.fsc.ssh.bean.User;
import com.org.fsc.ssh.user.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 处理登录
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月4日下午3:24:22
	 */
	@Override
	public List<?> handleUser(User user) {
		return sqlSessionTemplate.selectList("UserMapper.checkUser", user);
	}
	/**
	 * 查询所有用户
	 * fsc
	 * @return
	 * 2017年12月4日下午3:24:47
	 */
	@Override
	public List<?> selAllUser(Map<String,String> map) {
		return sqlSessionTemplate.selectList("UserMapper.pageUser",map);
	}
	/**
	 * 新增一个用户
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月5日下午9:22:18
	 */
	@Override
	public int addOneUser(Object object) {
		return sqlSessionTemplate.insert("UserMapper.addOneUser",object);
	}
	/**
	 * 修改一个用户
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月5日下午9:22:46
	 */
	@Override
	public int updOneUser(Object object) {
		return sqlSessionTemplate.insert("UserMapper.updOneUser",object);
	}
	/**
	 * 删除一个用户
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月5日下午9:22:58
	 */
	@Override
	public int delOneUser(Object object) {
		return sqlSessionTemplate.insert("UserMapper.delOneUser",object);
	}
	/**
	 * 查询一个用户根据id 
	 * fsc
	 * @param userid
	 * @return
	 * 2017年12月6日下午12:04:41
	 */
	@Override
	public List<?> selOneUserById(String userid) {
		return sqlSessionTemplate.selectList("UserMapper.selOneUserById",userid);
	}
	/**
	 * 新增一个用户角色
	 * fsc
	 * @param role
	 * @return
	 * 2017年12月9日下午3:33:20
	 */
	@Override
	public int addOneUserRole(Map<String,String> map) {
		return sqlSessionTemplate.update("UserMapper.addOneUserRole",map);
	}
	/**
	 * 查询所有未删除用户的数量
	 * fsc
	 * @return
	 * 2017年12月9日下午5:00:14
	 */
	@Override
	public List<?> selAllUserCount() {
		return sqlSessionTemplate.selectList("UserMapper.selAllUserCount");
	}
	/**
	 * 查询所有身份
	 * fsc
	 * @return
	 * 2017年12月9日下午7:06:41
	 */
	@Override
	public List<?> selAllRole() {
		return sqlSessionTemplate.selectList("UserMapper.selAllRole");
	}
	/**
	 * 查询一个角色通过名字
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月9日下午8:15:04
	 */
	@Override
	public List<?> selOneUserByName(User user) {
		return sqlSessionTemplate.selectList("UserMapper.selOneUserByName",user);
	}
	/**
	 * 修改一个用户角色
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月9日下午9:25:15
	 */
	@Override
	public int updOneUserRole(Map<String, String> map) {
		return sqlSessionTemplate.update("UserMapper.updOneUserRole",map);
	}
	/**
	 * excel
	 * fsc
	 * @return
	 * 2017年12月13日上午11:02:04
	 */
	@Override
	public List<?> ouputExcel() {
		return sqlSessionTemplate.selectList("UserMapper.ouputExcel");
	}

}
