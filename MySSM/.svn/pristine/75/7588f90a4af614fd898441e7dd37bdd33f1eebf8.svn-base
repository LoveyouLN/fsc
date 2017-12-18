package com.org.fsc.ssh.user.dao;

import java.util.List;
import java.util.Map;

import com.org.fsc.ssh.bean.Page;
import com.org.fsc.ssh.bean.User;

public interface UserDao {
	//处理登录
	List<?> handleUser(User user);

	//查询一个角色通过name
	List<?> selOneUserByName(User user);

	//查询所有用户
	List<?> selAllUser(Map<String,String> map);

	//新增一个用户
	int addOneUser(Object object);

	//修改一个用户
	int updOneUser(Object object);

	//删除一个用户
	int delOneUser(Object object);

	//查询一个用户的身份根据id 
	List<?> selOneUserById(String userid);

	//新增一个用户角色
	int addOneUserRole(Map<String,String> map);

	//修改一个用户角色
	int updOneUserRole(Map<String,String> map);

	//查询所有未删除用户的数量
	List<?> selAllUserCount();

	//查询所有身份
	List<?> selAllRole();
	
	//excel
	List<?> ouputExcel();

}
